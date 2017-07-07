package com.bbd.bgo.service.task;

import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.dataLoading.DishonestyDO;
import com.bbd.wtyh.mapper.DataLoadingMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-05-18 9:53.
 */
@Service
public class DataLoadingServiceImpl extends BaseServiceImpl implements DataLoadingTaskService {

	private static final Logger logger = LoggerFactory.getLogger(DataLoadingServiceImpl.class);

	private static final String FILE_PATH = "C:\\\\Users\\\\ibm\\\\Desktop\\\\changjiang_20170704_test.test";

    @Autowired
    private DataLoadingMapper dataLoadingMapper;


	@Override
	public void dataLoading() {
		List<String> list = txt2String(new File(FILE_PATH));
		JSONObject jsonObject = JSONObject.fromObject(list.get(0));
		Object data = jsonObject.get("data");
		String tn = String.valueOf(jsonObject.get("tn"));
		JSONObject jsonData = JSONObject.fromObject(String.valueOf(data));
		Object dishonesty = jsonData.get(tn);
		Gson gson = new Gson();
		List<DishonestyDO> dishonestyList = gson.fromJson(String.valueOf(dishonesty), new TypeToken<List<DishonestyDO>>() {}.getType());
        dataLoadingMapper.saveDishonestyDO(dishonestyList);
	}

	public List<String> txt2String(File file){
		if(null == file || !file.exists()){
			return null;
		}
		List<String> list=new ArrayList<String>();
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
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
		return list;
	}
}
