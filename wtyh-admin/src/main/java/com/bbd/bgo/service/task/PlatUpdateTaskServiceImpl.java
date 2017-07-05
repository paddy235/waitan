package com.bbd.bgo.service.task;


import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.PlatformNameInformationDO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatListDO;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.PlatformNameInformationMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.poi.ss.formula.functions.T;
import org.apache.shiro.crypto.hash.Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * Created by Administrator on 2017/3/20 0020.
 */
@Service
public class PlatUpdateTaskServiceImpl extends BaseServiceImpl implements PlatUpdateTaskService {

	private Logger logger = LoggerFactory.getLogger(PlatUpdateTaskServiceImpl.class);
	@Autowired
	private PlatformNameInformationMapper platformNameInformationMapper;
	@Autowired
	private CompanyMapper companyMapper;
	/**
	 * 每月1日晚上8点，更新网贷平台与企业对照关系
	 */
	@Override
	@Scheduled(cron = "0 0 20 1 * ?")
	public void updatePlat() {
		try {
			//网贷平台拉取企业数据
			List<PlatListDO> platList= getPlatList();
			if(platList.size()>0){
				//根据企业名称获取公司id
				List<String> names = new ArrayList<String>();
				List<PlatformNameInformationDO> platInfoList = new ArrayList<PlatformNameInformationDO>();
				PlatformNameInformationDO platInfo=null;
				for(PlatListDO plat:platList){
					platInfo=new PlatformNameInformationDO();
					platInfo.setName(plat.getCompany_name());
					platInfo.setPlatformName(plat.getPlat_name());
					platInfoList.add(platInfo);
					names.add(plat.getCompany_name());
				}
				List<CompanyDO> comList = companyMapper.findCompanyByName(names);
				Map<String,CompanyDO> map=new HashMap<String,CompanyDO>();
				for(CompanyDO com:comList){
					map.put(com.getName(),com);
				}
				Iterator<PlatformNameInformationDO> it = platInfoList.iterator();
				while(it.hasNext()){
					PlatformNameInformationDO plat = it.next();
					if(null==map.get(plat.getName())){
						it.remove();
					}else{
						plat.setCompanyId(map.get(plat.getName()).getCompanyId());
					}
				}
				logger.info("start update plat");
				int delNum = this.executeCUD("delete from platform_name_information");
				logger.info("delete plat number:"+delNum);
				int num = platformNameInformationMapper.addPlat(platInfoList);
				logger.info("end update plat,update number:"+num);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	public  List<PlatListDO> getPlatList() {
		String url="http://121.40.187.134:5002/financial_services?dataType=plat_list";
		try {
			String result = new HttpTemplate().get(url);
			Gson gson = new Gson();
			List<PlatListDO> platList = gson.fromJson(result, new TypeToken<List<PlatListDO>>() {}.getType());
			return platList;
		} catch (Exception e) {
			logger.error("Method getPrivateFundCompanyData get Exception." + e.getMessage());
			return null;
		}
	}
}
