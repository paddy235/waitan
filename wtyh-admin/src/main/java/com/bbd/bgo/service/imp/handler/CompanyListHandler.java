package com.bbd.bgo.service.imp.handler;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by cgj on 2017/7/19.
 */

@Component  //引入事务
@Scope("prototype") //非单例模式
public class CompanyListHandler extends AbstractImportHandler<CompanyDO> {
    //@Transactional //事务--原子性操作
    @Override
    public void start(HttpServletRequest request) throws Exception {

    }

    @Override
    public void startRow(Map<String, String> row) throws Exception {

    }

    @Override
    public boolean validateRow(Map<String, String> row) throws Exception {
        return false;
    }

    @Override
    public void endRow(Map<String, String> row, CompanyDO bean) throws Exception {

    }

    @Override
    public void end() throws Exception {

    }

    @Override
    public void exception(Exception e) {

    }
}
