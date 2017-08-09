package com.bbd.wtyh.service.impl;

import com.bbd.higgs.utils.ListUtil;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.vo.NewsVO;
import com.bbd.wtyh.mapper.*;
import com.bbd.wtyh.service.CompanyNewsService;
import com.bbd.wtyh.service.DataomApiBbdservice;
import com.bbd.wtyh.service.ParkService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author Ian.Su
 * @since 2016年8月5日 下午5:45:41
 */
@Service
public class ParkServiceImpl extends BaseServiceImpl implements ParkService {

	private static Logger log = LoggerFactory.getLogger(ParkServiceImpl.class);

	@Value("${api.baidu.batch.news.url}")
	private String batchNewsUrl;

	@Value("${api.baidu.batch.news.ktype}")
	private int ktype;

	@Value("${api.baidu.batch.news.ak}")
	private String ak;

	@Autowired
	private DataomApiBbdservice dataomApiBbdservice;

	@Autowired
	private StaticRiskMapper staticRiskMapper;

	@Autowired
	private BuildingMapper buildingMapper;

	@Autowired
	private CompanyMapper companyMapper;

	@Autowired
	private ParkMapper parkMapper;

	@Autowired
	private CompanyNewsService cns;

	@Autowired
	private CompanyAnalysisResultMapper carMapper;

	@Override
	public List<BuildingDO> queryBuildings(Integer areaId,String parkName) {

		return buildingMapper.queryBuildings(areaId,parkName);

	}

	@Override
	public List<InBusinessDO> inBusiness(Integer areaId,String parkName) {

		List<InBusinessDO> list = new ArrayList<>();

		Date now = new Date();

		Date year10 = DateUtils.addYears(now, -10);
		Date year5 = DateUtils.addYears(now, -5);
		Date year3 = DateUtils.addYears(now, -3);
		Date year1 = DateUtils.addYears(now, -1);

		list.add(inBusiness("10年以上", areaId, null, DateFormatUtils.format(year10, "yyyy-MM-dd"),parkName));
		list.add(inBusiness("5-10年", areaId, DateFormatUtils.format(year10, "yyyy-MM-dd"), DateFormatUtils.format(year5, "yyyy-MM-dd"),parkName));
		list.add(inBusiness("3-5年", areaId, DateFormatUtils.format(year5, "yyyy-MM-dd"), DateFormatUtils.format(year3, "yyyy-MM-dd"),parkName));
		list.add(inBusiness("1-3年", areaId, DateFormatUtils.format(year3, "yyyy-MM-dd"), DateFormatUtils.format(year1, "yyyy-MM-dd"),parkName));
		list.add(inBusiness("1年以下", areaId, DateFormatUtils.format(year1, "yyyy-MM-dd"), DateFormatUtils.format(now, "yyyy-MM-dd"),parkName));

		return list;
	}

	/**
	 * 根据时间段获取统计信息
	 *
	 * @param dateRange
	 *            时间范围
	 * @param areaId
	 *            区域id
	 * @param start
	 *            时间年限起
	 * @param end
	 *            时间年限止
	 * @return InBusiness
	 */
	public InBusinessDO inBusiness(String dateRange, Integer areaId, String start, String end,String parkName) {

		InBusinessDO bean = companyMapper.countByDate(areaId, start, end, parkName);

		bean.setDate(dateRange);

		return bean;
	}

	@Override
	public String queryParkNews(Integer areaId, Integer pageSize, Integer pageNum, String parkName) {

		List<String> names = companyMapper.queryCompanyNames(areaId, null, parkName);
		NewsVO newsvo = getnews(names);
		return new Gson().toJson(newsvo);
	}

	private NewsVO getnews(List<String> names) {

		String result = null;
		Gson gson = new Gson();
		NewsVO newsvo = new NewsVO();
		int size = names.size();
		for (int k = 0; k < size;) {
			StringBuilder ns = new StringBuilder();

			List<String> subNames = names.subList(k, (k += 100) < size ? k : size);
			for (String name : subNames) {
				ns.append(ns.length() > 0 ? "," : "").append(name);
			}

			log.info("園區舆情公司爲：" + ns.toString());
			if (!StringUtils.isEmpty(names)) {
				List<NameValuePair> list = new ArrayList<>();
				list.add(new BasicNameValuePair("keys", ns.toString()));
				list.add(new BasicNameValuePair("ktype", "" + ktype));
				list.add(new BasicNameValuePair("page", "1"));
				list.add(new BasicNameValuePair("pageSize", "20"));
				list.add(new BasicNameValuePair("ak", ak));
				try {
					result = new HttpTemplate().post(batchNewsUrl, list);
					log.info("舆情：" + batchNewsUrl + " 返回值为:" + result);

					NewsVO vo = gson.fromJson(result, new TypeToken<NewsVO>() {
					}.getType());
					newsvo.addNewsVO(vo);
					if (newsvo.getResults().size() >= 20) {
						newsvo.setResults(newsvo.getResults().subList(0, 20));
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		return newsvo;

	}

	@Override
	public String buildingNews(Integer buildingId) {

		List<String> names = companyMapper.queryCompanyNames(null, buildingId,null);

		NewsVO newsvo = getnews(names);

		if (newsvo.getResults().size() == 0) {
			newsvo = cns.findNews();
		}

		return new Gson().toJson(newsvo);

	}

	@Override
	public List<CompanyTypeCountDO> businessDistribute(Integer areaId,String parkName) {

		List<CompanyTypeCountDO> ljr = new ArrayList<>();

		countType(ljr, areaId, CompanyDO.TYPE_P2P_1, "网络借贷",parkName);
		countType(ljr, areaId, CompanyDO.TYPE_XD_2, "小额贷款",parkName);
		countType(ljr, areaId, CompanyDO.TYPE_RZDB_3, "融资担保",parkName);
		countType(ljr, areaId, CompanyDO.TYPE_XXLC_4, "线下理财",parkName);
		countType(ljr, areaId, CompanyDO.TYPE_SMJJ_5, "私募基金",parkName);
		countType(ljr, areaId, CompanyDO.TYPE_ZC_6, "众筹",parkName);
		countType(ljr, areaId, CompanyDO.TYPE_JYS_9, "交易所",parkName);
		countType(ljr, areaId, CompanyDO.TYPE_SYBL_10, "商业保理",parkName);
		countType(ljr, areaId, CompanyDO.TYPE_YFK_11, "预付卡",parkName);
		countType(ljr, areaId, CompanyDO.TYPE_DD_12, "典当",parkName);
		countType(ljr, areaId, CompanyDO.TYPE_RZZL_13, "融资租赁",parkName);
		// 公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:金融 8:其他 9:交易所 10:商业保理
		// 11.预付卡 12.典当 13融资租赁

		List<CompanyTypeCountDO> bigType = new ArrayList<>();

		CompanyTypeCountDO ljrCount = new CompanyTypeCountDO();

		for (CompanyTypeCountDO ctc : ljr) {
			ljrCount.setCount(ljrCount.getCount() + ctc.getCount());
		}
		ljrCount.setChildren(ljr);
		bigType.add(ljrCount.setType("新型金融"));

		countType(bigType, areaId, CompanyDO.TYPE_JR_7, "金融",parkName);
		countType(bigType, areaId, CompanyDO.TYPE_QT_8, "其他",parkName);

		return bigType;
	}

	private void countType(List<CompanyTypeCountDO> list, Integer areaId, Byte type, String name,String parkName) {
		CompanyTypeCountDO b = companyMapper.countByType(areaId, type,parkName);
		list.add(b.setType(name));

	}

	public String parkImg(Integer areaId,String parkName) {

		return parkMapper.parkImg(areaId,parkName);

	}

	@Override
	public List<CompanyDO> buildingCompany(Integer buildingId, Integer orderField, String descAsc) {

		List<CompanyDO> list = companyMapper.buildingCompany(buildingId, orderField, descAsc);

		return list;

	}

	@Override
	public List<CompanyTypeCountDO> buildingBusinessDistribute(Integer buildingId) {

		List<CompanyTypeCountDO> ljr = new ArrayList<>();
		countTypeByBuild(ljr, buildingId, CompanyDO.TYPE_P2P_1, "P2P");
		countTypeByBuild(ljr, buildingId, CompanyDO.TYPE_XD_2, "小额贷款");
		countTypeByBuild(ljr, buildingId, CompanyDO.TYPE_RZDB_3, "融资担保");
		countTypeByBuild(ljr, buildingId, CompanyDO.TYPE_XXLC_4, "线下理财");
		countTypeByBuild(ljr, buildingId, CompanyDO.TYPE_SMJJ_5, "私募基金");
		countTypeByBuild(ljr, buildingId, CompanyDO.TYPE_ZC_6, "众筹");
		countTypeByBuild(ljr, buildingId, CompanyDO.TYPE_JYS_9, "交易所");
		countTypeByBuild(ljr, buildingId, CompanyDO.TYPE_SYBL_10, "商业保理");
		countTypeByBuild(ljr, buildingId, CompanyDO.TYPE_YFK_11, "预付卡");
		countTypeByBuild(ljr, buildingId, CompanyDO.TYPE_DD_12, "典当");
		countTypeByBuild(ljr, buildingId, CompanyDO.TYPE_RZZL_13, "融资租赁");

		List<CompanyTypeCountDO> bigType = new ArrayList<>();

		CompanyTypeCountDO ljrCount = new CompanyTypeCountDO();

		for (CompanyTypeCountDO ctc : ljr) {
			ljrCount.setCount(ljrCount.getCount() + ctc.getCount());
		}
		ljrCount.setChildren(ljr);

		bigType.add(ljrCount.setType("新型金融"));

		countTypeByBuild(bigType, buildingId, CompanyDO.TYPE_JR_7, "金融");
		countTypeByBuild(bigType, buildingId, CompanyDO.TYPE_QT_8, "其他");

		return bigType;

	}

	private void countTypeByBuild(List<CompanyTypeCountDO> list, Integer buildingId, Byte type, String name) {
		CompanyTypeCountDO b = companyMapper.countTypeByBuild(buildingId, type);
		list.add(b.setType(name));

	}

	@Override
	public List<CompanyTypeCountDO> buildingBackground(Integer buildingId) {

		List<CompanyDO> data = buildingCompany(buildingId, null, "asc");

		List<CompanyTypeCountDO> list = new ArrayList<>();
		CompanyTypeCountDO gq = new CompanyTypeCountDO();
		gq.setType(CompanyBackgroundDO.Bg.Gq.CN);
		list.add(gq);
		CompanyTypeCountDO myqy = new CompanyTypeCountDO();
		myqy.setType(CompanyBackgroundDO.Bg.Myqy.CN);
		list.add(myqy);

		CompanyTypeCountDO wzqy = new CompanyTypeCountDO();
		wzqy.setType(CompanyBackgroundDO.Bg.Wzqy.CN);
		list.add(wzqy);

		for (CompanyDO cdo : data) {
			if (cdo.getBackground() == 3) {
				gq.setCount(gq.getCount() + 1);
			} else if (cdo.getBackground() == 5) {
				wzqy.setCount(wzqy.getCount() + 1);
			} else {
				myqy.setCount(myqy.getCount() + 1);
			}
		}

		return list;
	}

	@Override
	public List<CompanyAnalysisResultDO> queryRiskByBuilding(Integer buildingId) {

		List<CompanyAnalysisResultDO> list = carMapper.queryRiskByBuilding(buildingId);
		List<CompanyAnalysisResultDO> black_1 = new ArrayList();
		List<CompanyAnalysisResultDO> other_234 = new ArrayList();

		for (CompanyAnalysisResultDO car : list) {
			log.info("企业名称：" + car.getName());
			if (car.getAnalysisResult() != null && car.getAnalysisResult() == 1) {
				black_1.add(car);
			} /*else {
				Float staticsRiskIndex = staticRiskMapper.queryStaticsRiskIndex(car.getName());
				staticsRiskIndex = staticsRiskIndex == null ? 0 : staticsRiskIndex;
				car.setStaticRiskIndex(staticsRiskIndex + "");
				car.setAnalysisResult(getIndex(staticsRiskIndex));
				other_234.add(car);
			}*/else{
                other_234.add(car);
            }
		}
		sortByDate(black_1);
		sortByIndex(other_234);

		black_1.addAll(other_234);

		return black_1;
	}

	@Override
	public Map<String, Object> queryParkCompany(Integer areaId,Integer isNew,Integer riskLevel,
												String backgroundName,String companyTypeName,String buildingName,
												String companyName,Integer pageSize,Integer pageNumber,String parkName) {
		Map<String, Object> result=new HashMap<>();
		result.put("total",0);
		result.put("list",new ArrayList<>());

		Map<String, Object> params=new HashMap<>();

		// 分页信息
		if(pageSize!=null && pageNumber != null && pageSize > 0 && pageNumber >0){
			params.put("pageSize", pageSize);
			Integer beginNumber = (pageNumber - 1) * pageSize;
			params.put("beginNumber", beginNumber);
		}
		//地区编号
        params.put("areaId",areaId);
		//园区名称
		params.put("parkName",parkName);
		//背景名称--背景代码
        if(org.apache.commons.lang3.StringUtils.isNotBlank(backgroundName)){
			CompanyBackgroundDO.Bg bg=CompanyBackgroundDO.Bg.getBgByName(backgroundName);
			if(null!=bg){
            	params.put("background",bg.val);
			}else{
				params.put("background","-1");
			}
        }
        //行业类型名称--行业类型代码
        if(org.apache.commons.lang3.StringUtils.isNotBlank(companyTypeName)){
			byte companyType=CompanyDO.companyType(companyTypeName);
            params.put("companyType",companyType);
        }
        //楼宇名称
        if(org.apache.commons.lang3.StringUtils.isNotBlank(buildingName)){
            params.put("buildingName",buildingName);
        }

        //风险等级代码
        if(null!=riskLevel){
            params.put("riskLevel",riskLevel);
        }

		//是否新增
		if(null!=isNew){
			params.put("isNew",isNew);
		}
		//企业名称
		if(null!=companyName){
			params.put("companyName",companyName);
		}
		int total=this.parkMapper.qeuryParkCompanyCount(params);
		result.put("total",total);
		result.put("list",this.parkMapper.qeuryParkCompany(params));
		return result;
	}

	private void sortByIndex(List<CompanyAnalysisResultDO> list) {
		Collections.sort(list, new Comparator<CompanyAnalysisResultDO>() {

			@Override
			public int compare(CompanyAnalysisResultDO o1, CompanyAnalysisResultDO o2) {
				if (o1.getStaticRiskIndex() == null) {
					return -1;
				}
				if (o2.getStaticRiskIndex() == null) {
					return 1;
				}
				return new Float(o1.getStaticRiskIndex()).compareTo(new Float(o2.getStaticRiskIndex()));
			}
		});
	}

	private void sortByDate(List<CompanyAnalysisResultDO> black_1) {
		Collections.sort(black_1, new Comparator<CompanyAnalysisResultDO>() {

			@Override
			public int compare(CompanyAnalysisResultDO o1, CompanyAnalysisResultDO o2) {
				if (o1.getExposureDate() == null) {
					return -1;
				}
				if (o2.getExposureDate() == null) {
					return 1;
				}

				return o1.getExposureDate().compareTo(o2.getExposureDate());
			}
		});
	}

	// 颜色 1:已曝光(黑) 2:高危(红) 3:关注(黄) 4:正常(绿)
	private byte getIndex(float index) {
		if (index > 70) {
			return 2;// 2:高危(红)
		} else if (index >= 60 && index < 70) {
			return 3; // 3:关注(黄)
		} else {
			return 4; // 4:正常(绿)
		}
	}

}
