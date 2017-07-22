package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.EasyExport.PawnData;
import com.bbd.wtyh.domain.MortgageStatisticDO;
import com.bbd.wtyh.mapper.MortgageStatisticMapper;
import com.bbd.wtyh.service.MortgageService;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Marco on 2016/8/10.
 */
@Service
public class MortgageServiceImpl implements MortgageService {

    @Autowired
    private MortgageStatisticMapper mortgageStatisticMapper;


    @Override
    public List<MortgageStatisticDO> getMortgageStatisticList() {
        return mortgageStatisticMapper.selectAll();
    }

}
