package com.bbd.wtyh.util;

import com.alibaba.fastjson.JSONArray;
import com.bbd.wtyh.domain.dataLoading.*;

import java.io.*;
import java.util.ArrayList;
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
	private static final String QYXX_ZHUANLI = "qyxx_zhuanli";
	private static final String RMFYGG = "rmfygg";
	private static final String ZGCPWSW = "zgcpwsw";
	private static final String ZHIXING = "zhixing";

	//文件转化为sring集合
	public static List<String> txt2String(List<File> fileList){
		List<String> list=new ArrayList<String>();
		for(File file:fileList){
			if(null == file || !file.exists()){
				continue;
			}
			BufferedReader br = null;
			try{
				br = new BufferedReader(new FileReader(file));
				String s = null;
				while((s = br.readLine())!=null){//使用readLine方法，一次读一行
					list.add(s);
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				try{
					br.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public static void addDataToList(List<String> failTableList, String tn, String dataStr, List<DishonestyDO> disList, List<KtggDO> ktggList,
							  List<QyxgYuqingDO> yuQingList, List<QyxxBasicDO> basicList, List<QyxxBaxxDO> baxxList, List<QyxxGdxxDO> gdxxList,
							  List<QyxxZhuanliDO> zhuanliList, List<RmfyggDO> rmfyggList, List<ZgcpwswDO> zgcpwswList, List<ZhixingDO> zhixingList){

		if(null!=failTableList&&!failTableList.contains(tn)){
			return;
		}
		switch (tn){
			case DISHONESTY :
				List<DishonestyDO> dataList1 = JSONArray.parseArray(dataStr, DishonestyDO.class);
				disList.addAll(dataList1);
				break;
			case KTGG :
				List<KtggDO> dataList2 = JSONArray.parseArray(dataStr, KtggDO.class);
				ktggList.addAll(dataList2);
				break;
			case QYXG_YUQING:
				List<QyxgYuqingDO> dataList3 = JSONArray.parseArray(dataStr, QyxgYuqingDO.class);
				yuQingList.addAll(dataList3);
				break;
			case QYXX__BASIC :
				List<QyxxBasicDO> dataList4 = JSONArray.parseArray(dataStr, QyxxBasicDO.class);
				basicList.addAll(dataList4);
				break;
			case QYXX_BAXX :
				List<QyxxBaxxDO> dataList5 = JSONArray.parseArray(dataStr, QyxxBaxxDO.class);
				baxxList.addAll(dataList5);
				break;
			case QYXX_GDXX:
				List<QyxxGdxxDO> dataList6 = JSONArray.parseArray(dataStr, QyxxGdxxDO.class);
				gdxxList.addAll(dataList6);
				break;
			case QYXX_ZHUANLI :
				List<QyxxZhuanliDO> dataList7 = JSONArray.parseArray(dataStr, QyxxZhuanliDO.class);
				zhuanliList.addAll(dataList7);
				break;
			case RMFYGG :
				List<RmfyggDO> dataList8 = JSONArray.parseArray(dataStr, RmfyggDO.class);
				rmfyggList.addAll(dataList8);
				break;
			case ZGCPWSW :
				List<ZgcpwswDO> dataList9 = JSONArray.parseArray(dataStr, ZgcpwswDO.class);
				for(ZgcpwswDO zg:dataList9){
					List<String> types = zg.getLitigant_type();
					StringBuffer sb = new StringBuffer();
					for(String type:types){
						sb.append(type);
					}
					zg.setLitigant_types(sb.toString());
				}
				zgcpwswList.addAll(dataList9);
				break;
			case ZHIXING :
				List<ZhixingDO> dataList10 = JSONArray.parseArray(dataStr, ZhixingDO.class);
				zhixingList.addAll(dataList10);
				break;
		}
	}
}
