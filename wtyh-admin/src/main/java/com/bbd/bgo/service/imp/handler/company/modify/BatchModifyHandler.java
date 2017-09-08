package com.bbd.bgo.service.imp.handler.company.modify;

import com.bbd.wtyh.domain.dto.CoBatchModifyDTO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-09-04 9:45.
 */
@Component
@Scope("prototype")
public class BatchModifyHandler extends AbstractImportHandler<CoBatchModifyDTO> {

    @Override
    public void start(HttpServletRequest request) throws Exception {
        System.out.println("开始处理");
    }

    @Override
    public void startRow(Map<String, String> row) throws Exception {
        System.out.println(row);
    }

    @Override
    public boolean validateRow(Map<String, String> row) throws Exception {
        return false;
    }

    @Override
    public void endRow(Map<String, String> row, CoBatchModifyDTO bean) throws Exception {

    }

    @Override
    public void end() throws Exception {
        System.out.println("处理结束");
    }

    @Override
    public void exception(Exception e) {

    }
}
