package com.bbd.bgo.service.task;

import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.QyxxTagDO;
import com.bbd.wtyh.domain.TaskFailInfoDO;
import com.bbd.wtyh.domain.dataLoading.DatasharePullFileDO;
import com.bbd.wtyh.mapper.DataLoadingMapper;
import com.bbd.wtyh.mapper.QyxxTagMapper;
import com.bbd.wtyh.service.CompanyTagService;
import com.bbd.wtyh.util.DataLoadingUtil;
import com.bbd.wtyh.util.DateUtils;
import com.bbd.wtyh.util.PullFileUtil;
import com.google.common.collect.ListMultimap;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

/**
 * Created by cgj on 2017-09-05.
 */
@Service
public class TagUpdateServiceImpl implements TagUpdateService {
    private static final Logger logger = LoggerFactory.getLogger(DataLoadingServiceImpl.class);

    @Autowired
    @Qualifier(value = "baseServiceImpl")
    private BaseService baseService;

    @Autowired
    private DataLoadingMapper dataLoadingMapper;

    @Autowired
    private QyxxTagMapper qyxxTagMapper;

    @Autowired
    private CompanyTagService companyTagService;

    @Override
    public void operateData() {
        Integer [] dataTotal =new Integer[1];
        Integer maxDataVersion =qyxxTagMapper.maxDataVersion();
        if ( 0 == maxDataVersion ) {
            maxDataVersion = dataLoadingMapper.maxDataVersion();
        }
        ListMultimap<String,File> fileMap =PullFileUtil.getFileListByKeyword("qyxx_tag__ripe", null,
                    maxDataVersion, 0, dataTotal, null );

        //查找出多批数据中最大的那一批（且比本地库中的版本新）
        Integer biggerVer =qyxxTagMapper.maxDataVersion();
        String maxVerKey =null;
        for ( String key: fileMap.keySet() ) {
            List<File> files =fileMap.get(key);
            List<String> lineListPart = DataLoadingUtil.txt2String(files.get(0), 1);
            if ( ! lineListPart.isEmpty() ) {
                QyxxTagDO qyxxTagDO= stringToQyxxTagDO(lineListPart.get(0));
                if( null !=qyxxTagDO ) {
                    if( qyxxTagDO.getDt() >biggerVer ) {
                        biggerVer = qyxxTagDO.getDt();
                        maxVerKey =key;
                    }
                }
            }
        }

        //如果找到了，解析最大版本号的那批数据文件
        if ( null != maxVerKey ) {
            List<File> files =fileMap.get(maxVerKey);
            List<String> lineList =new LinkedList<>();
            for( File file: files ) {
                List<String> lineListPart = DataLoadingUtil.txt2String(file);
                // 文件解析出错
                if (null == lineList) {
                    logger.warn("File parsing failed：{}", file.getAbsolutePath() );
                    continue;
                }
                lineList.addAll(lineListPart);
            }
            List<QyxxTagDO> tagList =new LinkedList<>();
            for (String line: lineList) {
                QyxxTagDO qyxxTagDO= stringToQyxxTagDO(line);
                if( null ==qyxxTagDO ) {
                    continue;
                }
                tagList.add(qyxxTagDO);
            }
            qyxxTagMapper.clearTable("qyxx_tag"); //先清空原表中的数据
            final int insSize =5000; //一次批量插入的数量
            for (int i =0; i <tagList.size(); i +=insSize ) {
                int toIndex =i +insSize;
                if (toIndex >tagList.size()) {
                    toIndex =tagList.size();
                }
                baseService.insertList(tagList.subList(i, toIndex));
                logger.info("Ins [{}~{}] is finish !", i, toIndex -1 );
            }

            //更新company_tag表
            try{
                logger.info("begin insert company_tag ");
                companyTagService.saveCompanyTag();
                logger.info("end  insert company_tag ");
            }catch (Exception e){
                logger.error("insert company_tag error : ",e );
            }
        }
    }


    private QyxxTagDO stringToQyxxTagDO(String line) {
        String[] columns = line.split("\\u0001");
        if( columns.length <5 ) {
            logger.warn("Line parsing failed：“", line +"”" );
            return null;
        }
        QyxxTagDO qyxxTagDO= new QyxxTagDO();
        qyxxTagDO.setBbdQyxxId(columns[0]);
        qyxxTagDO.setTag(columns[1]);
        qyxxTagDO.setCompanyName(columns[2]);
        qyxxTagDO.setUptime( DateUtils.stringToDate(columns[3]) );
        Integer dt;
        try {
            dt =Integer.decode(columns[4]);
        } catch (Exception e) {
            return null;
        }
        qyxxTagDO.setDt( dt );

        return qyxxTagDO;
    }
}
