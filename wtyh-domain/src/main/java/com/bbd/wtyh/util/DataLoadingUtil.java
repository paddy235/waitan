package com.bbd.wtyh.util;

import com.alibaba.fastjson.JSONArray;
import com.bbd.wtyh.core.utils.ReflectUtil;
import com.bbd.wtyh.domain.dataLoading.*;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 文件拉取
 *
 * @author Created by zhaohongwen on 2017-07-12 11:43.
 */
public class DataLoadingUtil {

    private static final String DISHONESTY = "dishonesty";
    private static final String KTGG = "ktgg";
    private static final String QYXG_YUQING = "qyxg_yuqing";
    private static final String QYXX__BASIC = "qyxx_basic";
    private static final String QYXX_BAXX = "qyxx_baxx";
    private static final String QYXX_GDXX = "qyxx_gdxx";
    private static final String QYXX_ZHUANLI = "qyxx_wanfang_zhuanli";
    private static final String RMFYGG = "rmfygg";
    private static final String ZGCPWSW = "zgcpwsw";
    private static final String ZHIXING = "zhixing";

    // 文件转化为string集合
    public static List<String> txt2String(File file) {
        return txt2String(file, null);
    }
    // 文件转化为string集合
    public static List<String> txt2String(File file, Integer maxGetNum) {
        List<String> list = new LinkedList<>();
        if (null == file || !file.exists()) {
            return null;
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String s;
            while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
                list.add(s);
                if ( null !=maxGetNum ) {
                    maxGetNum--;
                    if (maxGetNum <=0) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static void addJsonDataToList(String tn, String dataStr, Integer taskId, String qyxxId, String companyName,
            List<DishonestyDO> disList, List<KtggDO> ktggList, List<QyxgYuqingDO> yuQingList, List<QyxxBasicDO> basicList,
            List<QyxxBaxxDO> baxxList, List<QyxxGdxxDO> gdxxList, List<QyxxZhuanliDO> zhuanliList, List<RmfyggDO> rmfyggList,
            List<ZgcpwswDO> zgcpwswList, List<ZhixingDO> zhixingList) {
        switch (tn) {
        case DISHONESTY:
            List<DishonestyDO> dataList1 = JSONArray.parseArray(dataStr, DishonestyDO.class);

            DataLoadingUtil.batchSetField(taskId, qyxxId, companyName, dataList1);

            disList.addAll(dataList1);
            break;
        case KTGG:
            List<KtggDO> dataList2 = JSONArray.parseArray(dataStr, KtggDO.class);
            DataLoadingUtil.batchSetField(taskId, qyxxId, companyName, dataList2);
            ktggList.addAll(dataList2);
            break;
        case QYXG_YUQING:
            dataStr = dataStr.replaceAll("abstract", "articleAbstract");
            List<QyxgYuqingDO> dataList3 = JSONArray.parseArray(dataStr, QyxgYuqingDO.class);
            DataLoadingUtil.batchSetField(taskId, qyxxId, companyName, dataList3);

            yuQingList.addAll(dataList3);
            break;
        case QYXX__BASIC:
            List<QyxxBasicDO> dataList4 = JSONArray.parseArray(dataStr, QyxxBasicDO.class);
            DataLoadingUtil.batchSetField(taskId, qyxxId, companyName, dataList4);

            basicList.addAll(dataList4);
            break;
        case QYXX_BAXX:
            List<QyxxBaxxDO> dataList5 = JSONArray.parseArray(dataStr, QyxxBaxxDO.class);
            DataLoadingUtil.batchSetField(taskId, qyxxId, companyName, dataList5);

            baxxList.addAll(dataList5);
            break;
        case QYXX_GDXX:
            List<QyxxGdxxDO> dataList6 = JSONArray.parseArray(dataStr, QyxxGdxxDO.class);
            DataLoadingUtil.batchSetField(taskId, qyxxId, companyName, dataList6);

            gdxxList.addAll(dataList6);
            break;
        case QYXX_ZHUANLI:
            List<QyxxZhuanliDO> dataList7 = JSONArray.parseArray(dataStr, QyxxZhuanliDO.class);
            DataLoadingUtil.batchSetField(taskId, qyxxId, companyName, dataList7);

            zhuanliList.addAll(dataList7);
            break;
        case RMFYGG:
            List<RmfyggDO> dataList8 = JSONArray.parseArray(dataStr, RmfyggDO.class);
            DataLoadingUtil.batchSetField(taskId, qyxxId, companyName, dataList8);

            rmfyggList.addAll(dataList8);
            break;
        case ZGCPWSW:
            List<ZgcpwswDO> dataList9 = JSONArray.parseArray(dataStr, ZgcpwswDO.class);
            DataLoadingUtil.batchSetField(taskId, qyxxId, companyName, dataList9);
            zgcpwswList.addAll(dataList9);
            break;
        case ZHIXING:
            List<ZhixingDO> dataList10 = JSONArray.parseArray(dataStr, ZhixingDO.class);
            DataLoadingUtil.batchSetField(taskId, qyxxId, companyName, dataList10);

            zhixingList.addAll(dataList10);
            break;
        }
    }

    public static void batchSetField(Integer taskId, String bbdId, String companyName, List<?> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Object obj : list) {
            if (obj == null) {
                continue;
            }
            ReflectUtil.setFieldValue(obj, "task_id", taskId);
            ReflectUtil.setFieldValue(obj, "bbd_qyxx_id", bbdId);
            ReflectUtil.setFieldValue(obj, "company_name", companyName);
        }
    }
}
