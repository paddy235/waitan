package com.bbd.bgo.service.task;

import java.util.List;

import com.bbd.bgo.service.imp.handler.assist.CompanyImportAssist;
import com.bbd.wtyh.domain.CompanyDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.CompanyTagDO;
import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.mapper.CompanyTagMapper;

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

    @Override
    public void addCompanyFromQyxxTag() {
        if(!compareVersion()){
            return;
        }
        CompanyImportAssist companyImportAssist=new CompanyImportAssist(null,null);
        //包含一个外滩线下理财企业的标签
        List<CompanyDO> list;
        int pageSize = 200;
        int totalCount = companyTagMapper.countCompanyHaveOfflineType();
        Pagination pagination = new Pagination();
        pagination.setPageSize(pageSize);
        pagination.setCount(totalCount);
        int total = pagination.getLastPageNumber();
        //分页新增
        for (int i = 1; i <= total; i++) {
            //分页查询
            pagination.setPageNumber(i);
            list=companyTagMapper.queryCompanyHaveOfflineType(pagination);
            companyImportAssist.processCp(list,true);
            companyImportAssist.save("system-tag");
            companyImportAssist.clearList();
        }
        //只有一个标签且不是线下理财
        totalCount = companyTagMapper.countCompanyHaveOneTagExceptOfflineType();
        pagination = new Pagination();
        pagination.setPageSize(pageSize);
        pagination.setCount(totalCount);
        total = pagination.getLastPageNumber();
        //分页新增
        for (int i = 1; i <= total; i++) {
            //分页查询
            pagination.setPageNumber(i);
            list=companyTagMapper.queryCompanyHaveOneTagExceptOfflineType(pagination);
            companyImportAssist.processCp(list,true);
            companyImportAssist.save("system-tag2");
            companyImportAssist.clearList();
        }

    }

    @Override
    public void updateCompanyTypeFromQyxxTag() {
        if(!compareVersion()){
            return;
        }
        companyTagMapper.updateCompanyTypeFromQyxxTag();
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
