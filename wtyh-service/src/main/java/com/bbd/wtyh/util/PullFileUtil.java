package com.bbd.wtyh.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.TaskFailInfoDO;
import com.bbd.wtyh.domain.TaskResultDO;
import com.bbd.wtyh.domain.dataLoading.DatasharePullFileDO;
import com.bbd.wtyh.mapper.DataLoadingMapper;
import com.bbd.wtyh.mapper.UserInfoMapper;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.xpath.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;

/**
 * 文件拉取
 *
 * @author Created by LiYao on 2017-07-12 11:43.
 */
public class PullFileUtil {

    private static final String PATH;

    private static final String DATA_SHARE_URL;
    private static final String BROKER_IP;
    private static final String FILE_NAME_LIST_URI;

    static {
        PATH = WtyhHelper.pathWrap(WtyhHelper.fileRootPath + "/datashare");
        DATA_SHARE_URL = WtyhHelper.datashateIp + "/client/files?file=";
        BROKER_IP = WtyhHelper.brokerIp;
        FILE_NAME_LIST_URI = "/syncFile/pull-file-list.do?dataType=";
    }

    private static Logger logger = LoggerFactory.getLogger(PullFileUtil.class);

    public static File pullFile(String fileName) {
        logger.debug("--------- pull data file start :{}--------", fileName);
        String url = DATA_SHARE_URL + fileName;
        File file = new File(PATH + fileName);
        if ( file.exists() ) { //todo 我在此加上个分支条件，若本地有就不下载了，您看妥不妥@liyao？
            logger.debug("--------- pull data file is exists:{}--------", fileName);
            return file;
        }

        try {
            InputStream inputStream = HttpUtil.get(url, InputStream.class);
            FileUtils.forceMkdirParent(file);
            IOUtils.copyLarge(inputStream, new FileOutputStream(file));
        } catch (Exception e) {
            logger.error("--------- pull data file have error ：", e);
            return null;
        }

        logger.debug("--------- pull data file end :{}--------", fileName);
        return file;
    }

    public static List<Map<String, String>> getFileList(Integer dataType, Integer dataVersion) {
        logger.info("--------- pull data file list start ,dataVersion:{}", dataVersion);
        String url = BROKER_IP + FILE_NAME_LIST_URI + dataType + "&dataVersion=" + dataVersion;

        String result;
        try {
            result = HttpUtil.get(url);
        } catch (Exception e) {
            logger.error("--------- pull data file list have error:", e);
            return null;
        }
        if (StringUtils.isBlank(result)) {
            logger.error("--------- pull data file list result is blank. result:{}", result);
            return null;
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        JSONArray content = jsonObject.getJSONArray("content");

        List<Map<String, String>> fileNameList = new ArrayList<>();

        for (int i = 0; i < content.size(); i++) {
            Map<String, String> map = content.getObject(i, Map.class);
            fileNameList.add(map);
        }
        logger.info("--------- pull data file list end, total:{} ,dataVersion:{}", fileNameList.size(), dataVersion);
        return fileNameList;
    }

    public static Boolean strContainsByKeywords ( String srcStr, String [] keywords) {
        if ( null ==keywords || keywords.length <=0) {
            return null;
        }
        Boolean contains =false;
        for ( String keyword :keywords ) {
            if ( StringUtils.isEmpty(keyword) ) {
                continue;
            }
            if ( srcStr.contains(keyword) ) {
                contains =true;
                break;
            }
        }
        return contains;
    }

    /**
     * 获取路径中包含指定关键字的文件对象列表，并将所有文件信息入库
     * @param keywords       指定路径中必须包含的关键字，可以为空
     * @param antiKeywords  指定路径中不能包含的关键字，可以为空
     * @param maxDataVersion 指定数据版本下限（取数据时不包含此下限）
     * @param taskId 任务ID
     * @param dataTotal 若不需要则传入null， 传入“Integer [] dataTotal =new Integer[1]”，则返回取到的总数dataTotal[0]
     * @param failList 失败文件列表，不使用请传入null
     * @param logCaption 日志标题
     * @return 文件对象列表
     */
    public static ListMultimap<String,File> getFileListByKeyword ( String [] keywords, String [] antiKeywords, int maxDataVersion, int taskId,
                Integer [] dataTotal, List<TaskFailInfoDO> failList, String logCaption ) {
        Logger logger = LoggerFactory.getLogger(PullFileUtil.class);
        TaskResultDO taskResultDO = new TaskResultDO();
        // 自动执行，先拉取数据，有数据执行插入，并记录成功失败情况
        List<Map<String, String>> fileNameList = getFileList(1, maxDataVersion);
        DataLoadingMapper dataLoadingMapper =ApplicationContextUtil.getBean(DataLoadingMapper.class);
        List<Map<String, String>> historyFileNameList  = dataLoadingMapper.noPullFileNameList();
        if (CollectionUtils.isNotEmpty(fileNameList)) {
            historyFileNameList.addAll(fileNameList);
        }
        ListMultimap<String,File> fileMap = ArrayListMultimap.create();
        if ( CollectionUtils.isNotEmpty(historyFileNameList) ) {
            if ( null !=dataTotal && dataTotal.length >0 ) {
                dataTotal[0] = historyFileNameList.size();
            }
            if ( null ==failList ) {
                failList = new ArrayList<>();
            }
            //对同名文件去重
            Map< String, Map<String, String> > noRepetition =new LinkedHashMap<>();
            for (Map<String, String> map : historyFileNameList) {
                noRepetition.put(map.get("fileName"), map);
            }
            historyFileNameList = new LinkedList<>( noRepetition.values() );
            logger.info("拉取{}数据文件开始, total：{}", logCaption, fileNameList.size());
            List<DatasharePullFileDO> insPullFileList = new ArrayList<>(); //用于新增的
            List<DatasharePullFileDO> updPullFileList = new ArrayList<>(); //用于更新的
            for (Map<String, String> map : historyFileNameList) {
                String fileName = map.get("fileName");
                Integer dataVersion =0;
                Object obDataVersion =map.get("dataVersion");
                if ( null !=obDataVersion ) {
                    if ( obDataVersion instanceof Integer ) {
                        dataVersion =(Integer) obDataVersion;
                    } else if (  obDataVersion instanceof String ) {
                        dataVersion = Integer.parseInt( (String) obDataVersion);
                    }

                }
                DatasharePullFileDO pullFile = new DatasharePullFileDO();
                pullFile.setTask_id(taskId);
                pullFile.setFile_name(fileName);
                pullFile.setData_version(dataVersion);
                pullFile.setPull(false);
                //仅选出文件路径中含有或排除指定关键字的文件
                Boolean kwContains =strContainsByKeywords(fileName, keywords);
                boolean isKw = null !=kwContains;
                Boolean anKwContains =strContainsByKeywords(fileName, antiKeywords);
                boolean isAnKw = null !=anKwContains;
                if ( isAnKw ) {
                    anKwContains = !anKwContains;
                }
                if( ( isKw &&isAnKw &&kwContains &&anKwContains ) ||( isKw &&(!isAnKw) &&kwContains )
                            ||(isAnKw &&(!isKw) &&anKwContains) ) {
                    File file = pullFile(fileName);
                    if (file == null) {
                        TaskFailInfoDO fail = new TaskFailInfoDO();
                        fail.setFailReason("拉取文件错误");
                        fail.setFailName(fileName);
                        fail.setTaskId(taskId);
                        fail.setCreateBy("system");
                        fail.setCreateDate(new Date());
                        fail.setSourceTaskId(taskId);
                        failList.add(fail);
                    } else {
                        int idx =fileName.lastIndexOf('/');
                        String filePath = fileName;
                        if( idx >40 ) {
                            filePath =fileName.substring(0, idx +1);
                        }
                        fileMap.put(filePath, file);
                        pullFile.setPull(true);
                        pullFile.setFile_url(file.getAbsolutePath());
                    }
                }
                String fileId =map.get("fileId");
                if ( StringUtils.isEmpty( fileId ) ) {
                    pullFile.setCreate_by("system");
                    pullFile.setCreate_date(new Date());
                    insPullFileList.add(pullFile);
                } else {
                    pullFile.setUpdate_by("system");
                    pullFile.setUpdate_date(new Date());
                    pullFile.setFile_id(Integer.parseInt(fileId));
                }
            }
            logger.info("拉取{}数据文件结束, total：{},success：{}", logCaption, fileNameList.size(), insPullFileList.size());
            BaseService baseService = (BaseService) ApplicationContextUtil.getBean("baseServiceImpl");
            List<DatasharePullFileDO> realInsPullFileList =new LinkedList<>();
            //检查insPullFileList中的数据是否在本地库中已存在
            for( DatasharePullFileDO dpf : insPullFileList ) {
                String strWhere =" `file_name` = '" +dpf.getFile_name() +"'";
                DatasharePullFileDO exists =baseService.selectOne(DatasharePullFileDO.class, strWhere);
                if ( null ==exists ) {
                    realInsPullFileList.add(dpf);
                } else {
                    //当isPull ==true时，才去更新，否则丢弃此记录，不做进一步操作。
                    if( ! exists.isPull() ) {
                        updPullFileList.add(dpf);
                    }
                }
            }
            baseService.insertList(realInsPullFileList);
            baseService.updateList(updPullFileList);
        }
        return fileMap;
    }

}
