package com.bbd.wtyh.service.util;


import com.bbd.wtyh.service.impl.relation.LawsuitRecordService;
import com.bbd.wtyh.service.impl.relation.LawsuitRecordcContainerService;
import com.bbd.wtyh.util.ListUtils;
import com.bbd.wtyh.web.relationVO.LawsuitRecordVO;

import java.util.List;


public class SSJLReader implements Runnable {
	
	private String companyName;
	private LawsuitRecordcContainerService lawsuteContainerService;
	private List<LawsuitRecordVO> lawsuitRecordVOList;

	private int pageNumber;
	
	public SSJLReader() {
	}

	public SSJLReader(String companyName,
					  LawsuitRecordcContainerService lawsuteContainerService,
					  List<LawsuitRecordVO> lawsuitRecordVOList) {
		this.companyName = companyName;
		this.lawsuteContainerService = lawsuteContainerService;
		this.lawsuitRecordVOList = lawsuitRecordVOList;
	}
	public void run() {
		int page = pageNumber++;
		while (page > -1) {
			try {
				List<LawsuitRecordVO> pageList = lawsuteContainerService.getLawsuteDataByPage(companyName, page);
				if (ListUtils.isEmpty(pageList)) {
					break;
				}
				lawsuitRecordVOList.addAll(pageList);
				page += LawsuitRecordService.THREAD_COUNT;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		System.out.println("当前线程=" + Thread.currentThread().getId() + "，数据条数=" + lawsuitRecordVOList.size());
	}

}
