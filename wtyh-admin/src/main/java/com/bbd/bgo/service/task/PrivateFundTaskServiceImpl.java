package com.bbd.bgo.service.task;


import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.core.base.BaseServiceImpl;

import com.bbd.wtyh.domain.dto.PrivateFundCompanyDTO;
import com.bbd.wtyh.domain.vo.FundVO;
import com.bbd.wtyh.mapper.PrivateFundExtraMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/3/20 0020.
 */
@Service
public class PrivateFundTaskServiceImpl extends BaseServiceImpl implements PrivateFundTaskService {

	private Logger logger = LoggerFactory.getLogger(PrivateFundTaskServiceImpl.class);
	@Autowired
	private PrivateFundExtraMapper privateFundExtraMapper;
	@Value("${api.bbd_xgxx_relation.url}")
	private String	url;
	@Value("${api.appkey}")
	private String	appkey;

	private static long ccc=0l;
	private static long bbb=0l;

	/**
	 * 每月1日晚上10点，私募企业列表的“备案状态”根据私募证券业协会官网上的状态更新
	 */
	@Override
	@Scheduled(cron = "0 0 22 1 * ?")
	public void updateCompanyStatus() {
		try {
			int totalCount = privateFundExtraMapper.countAllCompany();
			Pagination pagination = new Pagination();
			pagination.setPageSize(1000);
			pagination.setCount(totalCount);
			int total = pagination.getLastPageNumber();
			Map<String, Object> params = new HashMap<>();

			ExecutorService dataExecutorService = Executors.newFixedThreadPool(20);
			logger.info("start update private fund company status");
			for (int i = 1; i <= total; i++) {
				pagination.setPageNumber(i);
				params.put("pagination", pagination);
				List<PrivateFundCompanyDTO> list = privateFundExtraMapper.findByPage(params);
                List<Map> tempList=new ArrayList<>();
				Map<String,Object> dtoMap=new HashMap<>();
				List<PrivateFundCompanyDTO> dtoList=new ArrayList<>();
				int count=0;
                int isEnd=0;
				StringBuffer sb=new StringBuffer();
				for(PrivateFundCompanyDTO privateFundCompanyDTO:list){
					count++;
                    isEnd++;
                    if(count!=1){
                        sb.append(",");
                    }
                    sb.append(privateFundCompanyDTO.getName());
                    dtoList.add(privateFundCompanyDTO);

					if(count==20 || isEnd==list.size()){
						count=0;
						dtoMap.put("name",sb.toString());
						dtoMap.put("list",dtoList);
                        tempList.add(dtoMap);
						dtoMap=new HashMap<>();
                        sb=new StringBuffer();
                        dtoList=new ArrayList<>();
					}

				}

				if (!CollectionUtils.isEmpty(tempList)) {

					for (final Object obj : tempList) {


						dataExecutorService.submit(new Runnable() {

							@Override
							public void run() {
								updatePrivateFundCompanyStatus((Map<String,Object>)obj);
							}
						});
					}
				}
			}
			logger.info("end update private fund company status");
			dataExecutorService.shutdown();

			dataExecutorService.awaitTermination(1, TimeUnit.DAYS);

			System.out.println(bbb);
			System.out.println(ccc);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	private void updatePrivateFundCompanyStatus(Map<String,Object> map) {
        String name=(String)map.get("name");

		//根据公司名称查询企业是否已备案
        FundVO vo=this.getPrivateFundCompanyData(name);
        Map<String,String> nameMap=new HashMap<>();
		for(FundVO.Result obj:vo.getResults()){
            nameMap.put(obj.getCompany_name(),obj.getCompany_name());
		}

        List<PrivateFundCompanyDTO> list=(List)map.get("list");
		for(PrivateFundCompanyDTO privateFundCompanyDTO:list){
		    String key=privateFundCompanyDTO.getName();
            if(StringUtils.isNotBlank(key)){
                if(nameMap.containsKey(key)){

                    this.executeCUD("UPDATE  private_fund_extra SET record_status=1 ,update_by='SLM',update_date=NOW() WHERE company_id="+privateFundCompanyDTO.getCompanyId());

					ccc++;
                }else{

                    this.executeCUD("UPDATE  private_fund_extra SET record_status=2 ,update_by='SLM',update_date=NOW() WHERE company_id=",privateFundCompanyDTO.getCompanyId());
					bbb++;
                }
            }
        }

	}


	public FundVO getPrivateFundCompanyData(String name) {
		long start = System.currentTimeMillis();
		String httpUrl = url + "?appkey="+appkey+"&ktype=0" + "&keys=" + name;
		try {
			String result = new HttpTemplate().get(httpUrl);
			Gson gson = new Gson();
            FundVO vo = gson.fromJson(result,new TypeToken<FundVO>(){}.getType());
			//logger.info("私募基金备案状态请求耗时：{}ms,url地址为：{}",System.currentTimeMillis()-start,url);

			return vo;
		} catch (Exception e) {
			logger.error("Method getPrivateFundCompanyData get Exception." + e.getMessage());
			return null;
		}
	}
}
