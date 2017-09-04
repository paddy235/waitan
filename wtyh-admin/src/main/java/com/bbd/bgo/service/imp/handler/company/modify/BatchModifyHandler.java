package com.bbd.bgo.service.imp.handler.company.modify;

import com.bbd.wtyh.domain.dto.CoBatchModifyDTO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-09-04 9:45.
 */
public class BatchModifyHandler extends AbstractImportHandler<CoBatchModifyDTO> {

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
    public void endRow(Map<String, String> row, CoBatchModifyDTO bean) throws Exception {

    }

    @Override
    public void end() throws Exception {

    }

    @Override
    public void exception(Exception e) {

    }
}
