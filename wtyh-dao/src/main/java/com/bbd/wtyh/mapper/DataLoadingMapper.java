package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.dataLoading.*;

import java.util.List;


/**
* 数据落地
* @author ZhaoHongWen
* @since 2016年8月21日 下午1:52:45
*/
public interface DataLoadingMapper {


	int saveDishonestyDO(List<DishonestyDO> dishonestyList);

	int saveKtggDO(List<KtggDO> ktggList);

	int saveQyxgYuqingDO(List<QyxgYuqingDO> qyxgYuqingList);

	int saveQyxxBasicDO(List<QyxxBasicDO> qyxxBasicList);

	int saveQyxxBaxxDO(List<QyxxBaxxDO> qyxxBaxxList);

	int saveQyxxGdxxDO(List<QyxxGdxxDO> qyxxGdxxList);

	int saveQyxxZhuanliDO(List<QyxxZhuanliDO> qyxxZhuanliList);

	int saveRmfyggDO(List<RmfyggDO> rmfyggList);

	int saveZgcpwswDO(List<ZgcpwswDO> zgcpwswDOList);

	int saveZhixingDO(List<ZhixingDO> zhixingList);
}
