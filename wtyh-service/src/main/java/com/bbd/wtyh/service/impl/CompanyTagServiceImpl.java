package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.CompanyTagDO;
import com.bbd.wtyh.mapper.CompanyTagMapper;
import com.bbd.wtyh.service.CompanyTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
@Service
public class CompanyTagServiceImpl extends BaseServiceImpl implements CompanyTagService {
    @Autowired
    private CompanyTagMapper companyTagMapper;

    @Override
    public void saveCompanyTag() {
        if(!compareVersion()){
            return;
        }
        int pageSize = 3000;
        int totalCount = companyTagMapper.countQyxxTag();
        Pagination pagination = new Pagination();
        pagination.setPageSize(pageSize);
        pagination.setCount(totalCount);
        int total = pagination.getLastPageNumber();
        //按公司名称删除tag
        companyTagMapper.deleteAllByQyxxTag();
        //分页新增
        for (int i = 1; i <= total; i++) {
            //分页查询
            pagination.setPageNumber(i);
            transAndSaveTag(pagination);
        }


    }

    private void transAndSaveTag(Pagination pagination){
        List<CompanyTagDO> list = companyTagMapper.selectFromQyxxTag(pagination);
        for(CompanyTagDO companyTagDO:list){
            Byte tag = CompanyInfo.companyType(companyTagDO.getTagDesc());
            companyTagDO.setTag(null==tag?null:Integer.valueOf(tag));
        }
        companyTagMapper.saveCompanyTag(list);
    }

    private boolean compareVersion(){

        Integer qyxxTd=companyTagMapper.getMaxDtFromQyxxTag();
        Integer companyTd=companyTagMapper.getMaxDtFromCompanyTag();
        if(null != qyxxTd && null != companyTd
                && qyxxTd > companyTd){
            return true;
        }
        return false;
    }


}
