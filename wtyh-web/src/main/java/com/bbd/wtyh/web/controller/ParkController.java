package com.bbd.wtyh.web.controller;

import java.io.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.bbd.data.service.PABPublicSentimentService;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.vo.NewsVO;
import com.bbd.wtyh.excel.ExportExcel;
import com.bbd.wtyh.exception.ExceptionHandler;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.UserLogRecord;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.service.ImgService;
import com.bbd.wtyh.util.WtyhHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.service.CompanyNewsService;
import com.bbd.wtyh.service.ParkService;
import com.bbd.wtyh.web.ResponseBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 园区相关接口
 * 
 * @author Ian.Su
 * @since 2016年8月5日 上午11:55:20
 */
@Controller
@RequestMapping("/park")
public class ParkController {

	@Autowired
	private AreaService areaService;

	@Autowired
	private ParkService parkService;

	@Autowired
	private CompanyNewsService newsSer;

	@Autowired
	private ImgService imgService;
	@Autowired
	private PABPublicSentimentService pabPublicSentimentService;

	private String PARK_DIR1 = WtyhHelper.webImgPath;//开发环境
	private static final String PARK_DIR = "data/img/park/";
	private static final String BUILDING_DIR = "data/img/building/";

	/**
	 *
	 * 获取区域信息
	 * 
	 * @return ResponseBean
	 */
	@RequestMapping("/areaList")
	@ResponseBody
	public ResponseBean areaList(HttpSession session) {

		List<AreaDO> data = areaService.areaList(areaService.getAreaId(session));

		return ResponseBean.successResponse(data);
	}

	/**
	 *
	 * 获取区域信息
	 * 
	 * @return ResponseBean
	 */
	@RequestMapping("/areaListAll")
	@ResponseBody
	public ResponseBean areaListAll(HttpSession session) {
		Integer it = areaService.getAreaId(session);
		List<AreaDO> data = null;
		if (null == it) {
			data = areaService.areaListAll(Constants.SH_AREAID);
		} else {
			data = new ArrayList();
			data.add(areaService.getAreaByAreaId(it));

		}

		return ResponseBean.successResponse(data);
	}

	/**
	 * 根据园区查询新型金融企业集中度 与 楼宇列表 共用接口
	 * 
	 * @param areaId
	 *            区域id,必传
	 * @return ResponseBean
	 */
	@RequestMapping("/companyConcentration")
	@ResponseBody
	public ResponseBean oncentration(@RequestParam(required = true) Integer areaId,String parkName) {

		List<BuildingDO> data = parkService.queryBuildings(areaId,parkName);

		return ResponseBean.successResponse(data);
	}

	/**
	 * 在营时间分布
	 *
	 * @param areaId
	 *            区域id,必传
	 * @return ResponseBean
	 */
	@RequestMapping("/inBusiness")
	@ResponseBody
	public ResponseBean inBusiness(@RequestParam Integer areaId,String parkName) {
		List<InBusinessDO> data = parkService.inBusiness(areaId,parkName);
		return ResponseBean.successResponse(data);
	}

	/**
	 * 园区舆情查询
	 * 
	 * @param areaId
	 *            区域id,必传
	 * @return ResponseBean
	 */
	@RequestMapping("/news")
	@ResponseBody
	public ResponseBean news(@RequestParam(required = true) Integer areaId, String parkName) {
//		NewsVO newsVO = pabPublicSentimentService.queryParkPublicSentiment(areaId, parkName);
//		return ResponseBean.successResponse(new Gson().toJson(newsVO));
		Gson gson = new Gson();
		String data = parkService.queryParkNews(areaId, 20, 1,parkName);
		NewsVO vo = gson.fromJson(data, new TypeToken<NewsVO>() {
		}.getType());
		if (vo == null || vo.getRsize() == 0) {
			vo = newsSer.mutilTypeNews("qyxg_shanghai_fta,qyxg_national_economy", 20);
			data = gson.toJson(vo);
		}
		return ResponseBean.successResponse(new Gson().toJson(vo));
	}

	/**
	 * 园区行业分布
	 * 
	 * @param areaId
	 *            区域id,必传
	 * @return ResponseBean
	 */
	@RequestMapping("/businessDistribute")
	@ResponseBody
	public ResponseBean businessDistribute(@RequestParam(required = true) Integer areaId,String parkName) {

		List<CompanyTypeCountDO> data = parkService.businessDistribute(areaId,parkName);
		return ResponseBean.successResponse(data);
	}

	/**
	 * 园区图片
	 * 
	 * @param areaId
	 *            区域id,必传
	 * @return ResponseBean
	 */
	@RequestMapping("/parkImg")
	@ResponseBody
	@LogRecord(logMsg = "浏览【%s】园区监测页面", params = { "areaName" }, page = Operation.Page.park, after = true, before = false)
	public ResponseBean parkImg(Integer areaId, String parkName, HttpServletRequest request) {

		Object data = parkService.parkImg(areaId,parkName);

		AreaDO area = this.parkService.selectById(AreaDO.class, areaId);
		if (area != null) {
			request.setAttribute("areaName", area.getName());
		}

		return ResponseBean.successResponse(data);
	}

	/**
	 * 楼宇企业列表
	 * 
	 * @param buildingId
	 *            楼宇id,必传
	 * @param orderField
	 *            排序字段，非必须，默认按行业，值范围[1 ,2，3，4，5]： 1：行业 2：注册资本 3：企业背景 4：注册时间
	 *            5：企业类型
	 * @param descAsc
	 *            排序方式：desc:降序，asc:升序
	 * @return ResponseBean
	 */
	@RequestMapping("/buildingCompany")
	@ResponseBody
	public ResponseBean buildingCompany(@RequestParam(required = true) Integer buildingId, Integer orderField, String descAsc) {

		List<CompanyDO> data = parkService.buildingCompany(buildingId, orderField, descAsc);

		return ResponseBean.successResponse(data);
	}

	/**
	 * 楼宇行业分布
	 * 
	 * @param buildingId
	 *            楼宇id,必传
	 * @return ResponseBean
	 */
	@RequestMapping("/buildingBusinessDistribute")
	@ResponseBody
	@LogRecord(logMsg = "浏览【%s】楼宇页面", params = { "buildingName" }, page = Operation.Page.building, after = true, before = false)
	public ResponseBean buildingBusinessDistribute(@RequestParam(required = true) Integer buildingId, HttpServletRequest request) {

		List<CompanyTypeCountDO> data = parkService.buildingBusinessDistribute(buildingId);

		BuildingDO bd = this.parkService.selectById(BuildingDO.class, buildingId);
		if (bd != null) {
			request.setAttribute("buildingName", bd.getName());
		}

		return ResponseBean.successResponse(data);
	}

	/**
	 * 企业背景情况
	 * 
	 * @param buildingId
	 *            楼宇id,必传
	 * @return ResponseBean
	 */
	@RequestMapping("/buildingBackground")
	@ResponseBody
	public ResponseBean buildingBackground(@RequestParam(required = true) Integer buildingId) {

		List<CompanyTypeCountDO> data = parkService.buildingBackground(buildingId);

		return ResponseBean.successResponse(data);
	}

	/**
	 * 楼宇舆情
	 * 
	 * @param buildingId
	 *            楼宇id,必传
	 * @return ResponseBean
	 */
	@RequestMapping("/buildingNews")
	@ResponseBody
	public ResponseBean buildingNews(@RequestParam Integer buildingId) {
		String data = parkService.buildingNews(buildingId);
		return ResponseBean.successResponse(data);
//		NewsVO newsVO = pabPublicSentimentService.queryBuildingPublicSentiment(buildingId);
//		return ResponseBean.successResponse(new Gson().toJson(newsVO));
	}

	/**
	 * 已出风险企业
	 * 
	 * @param buildingId
	 *            楼宇id,必传
	 * @return ResponseBean
	 */
	@RequestMapping("/buildingRisk")
	@ResponseBody
	public ResponseBean buildingRisk(@RequestParam Integer buildingId) {

		List<CompanyAnalysisResultDO> data = parkService.queryRiskByBuilding(buildingId);
		return ResponseBean.successResponse(data);
	}

	/**
	 * 查询园区楼宇公司列表
	 *
	 * @param areaId
	 *            园区id,必传
	 * @return ResponseBean
	 */
	@RequestMapping("/parkCompanyList")
	@ResponseBody
	public ResponseBean parkCompanyList(@RequestParam Integer areaId, @RequestParam Integer isNew, @RequestParam Integer riskLevel,
			@RequestParam String backgroundName, @RequestParam String companyTypeName, @RequestParam String buildingName,
										@RequestParam String companyName,@RequestParam Integer pageSize,@RequestParam Integer pageNumber,@RequestParam String parkName) {
		//分页
		if(null==pageSize || pageSize<1){
			pageSize=20;
		}
		if(null==pageNumber || pageNumber<1){
			pageNumber=1;
		}

		Map<String ,Object> data = parkService.queryParkCompany(areaId, isNew, riskLevel, backgroundName, companyTypeName, buildingName,companyName,pageSize,pageNumber,parkName);
		return ResponseBean.successResponse(data);
	}

	/**
	 * 下载园区楼宇公司列表
	 *
	 * @param areaId
	 *            园区id,必传
	 * @return ResponseBean
	 */
	@RequestMapping("/downloadParkCompanyList")
	@ResponseBody
	public ResponseBean downloadParkCompanyList(@RequestParam Integer areaId, Integer isNew, Integer riskLevel, String backgroundName,
			String companyTypeName, String buildingName,String companyName, HttpServletRequest request,String parkName) {

		String loginName = request.getSession().getAttribute(Constants.SESSION.loginName) + "";
		String nowDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));

		String excelName = "";

		AreaDO area = this.parkService.selectById(AreaDO.class, areaId);
		if (area != null) {
			excelName = area.getName();
		}
		excelName = loginName + "-" + excelName + "-" + nowDateTime;

		ExportExcel exportExcel = new ExportExcel(excelName);
		try {

			// 按查询条件下载企业

			Map<String,Object> map = parkService.queryParkCompany(areaId,
			 isNew, riskLevel, backgroundName, companyTypeName, buildingName,companyName,null,null,parkName);

			// 下载改园区全部企业
			//Map<String,Object> map = parkService.queryParkCompany(areaId, null, null, null, null, null,null,null);
			List<ParkCompanyDo> list=(List<ParkCompanyDo>)map.get("list");
			exportExcel.createSheet(list);
			exportExcel.exportExcel();

            String areaName=area==null?"":area.getName();
			UserLogRecord.record("导出【"+areaName+"】园区企业列表", Operation.Type.DATA_EXPORT, Operation.Page.park,
					Operation.System.front, request);
			return ResponseBean.successResponse(exportExcel.getDownloadURL());
		} catch (Exception e) {
			return ExceptionHandler.handlerException(e);
		}

	}

	/**
	 * 更新前台园区和楼宇的图片
	 * @return
	 */
	@RequestMapping("/updImgForParkAndBuilding")
	@ResponseBody
	public ResponseBean updImgForParkAndBuilding(HttpServletRequest request){

		try {
			String loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
			if( null ==loginName ) {
				loginName ="loginName";
			}

			String macId = getMacId();
			Integer port = request.getLocalPort();
			String ipServer = macId + ":" + port;//MAC地址作为服务器唯一识别码

			//查询状态为1的图片列表，依次更新
			List<ImgDO> list = imgService.queryImgByStatus(1);
			for (ImgDO imgDO : list) {
				// 若数据库IP为空，则表示此处为前台服务器A做更新，完成后将MAC地址写入IP字段；
				// 若IP不为空且与传入IP不同，则表示此处为前台服务器B做更新，完成后将状态改为2，后续定时任务会删除状态为2的数据
				String ipDB = imgDO.getIp();
				if(StringUtils.isEmpty(ipDB)){
					updatePic(request, imgDO);//更新图片到执行文件夹

					imgDO.setIp(ipServer);
					imgDO.setLastStatus(1);
					imgDO.setUser(loginName);
					imgService.updateImage(imgDO);
				}else {
					if(!ipDB.equals(ipServer)){
						updatePic(request, imgDO);//更新图片到执行文件夹

						//将处理过的图片数据状态更新为2
						imgDO.setStatus(2);
						imgDO.setLastStatus(1);
						imgDO.setUser(loginName);
						imgService.updateImage(imgDO);
					}
				}

			}

		} catch (Exception e) {
//            logger.error("Method[updateDevPic],catch exception:" + e.getMessage());
//			throw new Exception(e);
			e.printStackTrace();
		}

		return ResponseBean.successResponse("OK");
	}

	/**
	 * 更新图片到执行文件夹
	 * @param request
	 * @param img
	 */
	private void updatePic(HttpServletRequest request,ImgDO img){
		String path = PARK_DIR;
		String filePath = PARK_DIR1;
		Integer picType = img.getPicType();
		String folder = "park";
		if (picType == 2) {
			path = BUILDING_DIR;
			folder = "building";
		}
		// /data/wtyh/static/wtyh-admin/build/data/img
		if(org.apache.commons.lang3.StringUtils.isBlank(PARK_DIR1)){//正式环境
			filePath = request.getSession().getServletContext().getRealPath("/") + File.separator + path + img.getPicName();
		}else{//开发环境
			filePath += File.separator + folder+ File.separator + img.getPicName();
		}

		File f = new File(filePath);
		FileOutputStream fos = null;

		try {
			//若原图片已经被打开，是否还能直接删除？能。。。
			if (f.exists()){
				f.delete();
			}

			if(!f.getParentFile().exists()){
				f.getParentFile().mkdirs();
			}

//            f.createNewFile();

			fos = new FileOutputStream(f);
			int len = 0;
			byte[] buf = new byte[1024];
			InputStream ins = new ByteArrayInputStream(img.getPic());

			while ((len = ins.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}

			fos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != fos) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 此方法描述的是：获得服务器的MAC地址
	 */
	public static String getMacId() {
		String macId = "";
		InetAddress ip = null;
		NetworkInterface ni = null;
		try {
			boolean bFindIP = false;
			Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface
					.getNetworkInterfaces();
			while (netInterfaces.hasMoreElements()) {
				if (bFindIP) {
					break;
				}
				ni = (NetworkInterface) netInterfaces
						.nextElement();
				// ----------特定情况，可以考虑用ni.getName判断
				// 遍历所有ip
				Enumeration<InetAddress> ips = ni.getInetAddresses();
				while (ips.hasMoreElements()) {
					ip = (InetAddress) ips.nextElement();
					if (!ip.isLoopbackAddress() // 非127.0.0.1
							&& ip.getHostAddress().matches(
							"(\\d{1,3}\\.){3}\\d{1,3}")) {
						bFindIP = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != ip) {
			try {
				macId = getMacFromBytes(ni.getHardwareAddress());
			} catch (SocketException e) {

			}
		}
		return macId;
	}

	private static String getMacFromBytes(byte[] bytes) {
		StringBuffer mac = new StringBuffer();
		byte currentByte;
		boolean first = false;
		for (byte b : bytes) {
			if (first) {
				mac.append("-");
			}
			currentByte = (byte) ((b & 240) >> 4);
			mac.append(Integer.toHexString(currentByte));
			currentByte = (byte) (b & 15);
			mac.append(Integer.toHexString(currentByte));
			first = true;
		}
		return mac.toString().toUpperCase();
	}

}
