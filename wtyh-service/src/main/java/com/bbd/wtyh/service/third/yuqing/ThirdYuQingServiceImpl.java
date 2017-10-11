package com.bbd.wtyh.service.third.yuqing;

import com.alibaba.fastjson.JSON;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.SysConfigDo;
import com.bbd.wtyh.domain.third.yuqing.ImportRecordDO;
import com.bbd.wtyh.excel.imp.constants.ImpRecord;
import com.bbd.wtyh.exception.BusinessException;
import com.bbd.wtyh.mapper.third.yuqing.ThirdYuQingMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ThirdYuQingServiceImpl
 *
 * @author Created by LiYao on 2017-10-09 10:18.
 */
@Service
public class ThirdYuQingServiceImpl extends BaseServiceImpl implements ThirdYuQingService {

    @Autowired
    private ThirdYuQingMapper thirdYuQingMapper;

    @PostConstruct
    @PreDestroy
    public void serverShutdown() {
        executeCUD("UPDATE third_yuqing_imp_record SET imp_state = 4, remark = '服务器关闭，导致中断' WHERE imp_state = 2");
    }

    @Override
    public ImportRecordDO createImpRecord(String fileName, Date yuqingTime, long fileSize, String createBy, Integer source) {
        ImportRecordDO recordDO = new ImportRecordDO();
        recordDO.setFileName(fileName);
        recordDO.setFileSize(fileSize);
        recordDO.setCreateBy(createBy);
        recordDO.setCreateDate(new Date());
        recordDO.setYuqingTime(yuqingTime);
        recordDO.setImpState(ImpRecord.ING.state());
        recordDO.setSource(source);
        this.insert(recordDO);
        return recordDO;
    }

    @Override
    public void modifyStateAndRemark(Integer recordId, ImpRecord impRecord, String remark) {
        Assert.notNull(recordId, "recordId - the object argument must be null");
        Assert.notNull(impRecord, "impRecord - the object argument must be null");

        ImportRecordDO recordDO = new ImportRecordDO();
        recordDO.setId(recordId);
        recordDO.setImpState(impRecord.state());
        recordDO.setRemark(remark);
        this.update(recordDO);
    }

    @Override
    public void saveYuQingFile(ImportRecordDO recordDO, InputStream input) throws Exception {
        String fileName = recordDO.getId() + recordDO.getFileName();
        File file = new File(FILE_PATH + fileName);
        FileUtils.forceMkdirParent(file);
        file.createNewFile();
        try (OutputStream output = new FileOutputStream(file)) {
            int i;
            while ((i = input.read()) != -1) {
                output.write(i);
            }
        }
    }

    @Override
    public List<ImportRecordDO> findImportRecord(Map<String, String> param) {
        Object orderBy = param.get("orderBy");
        if (orderBy != null) {
            param.put("orderBy", orderBy.toString().toUpperCase());
        } else {
            param.put("orderBy", "DESC");
        }
        return thirdYuQingMapper.findImportRecord(param);
    }

    @Override
    public byte[] download(ImportRecordDO recordDO) throws Exception {
        if (recordDO == null) {
            return null;
        }
        String fileName = recordDO.getId() + recordDO.getFileName();
        File file = new File(FILE_PATH + fileName);
        if (!file.exists()) {
            return null;
        }
        byte[] bytes = new byte[recordDO.getFileSize().intValue()];
        try (InputStream input = new FileInputStream(file)) {
            input.read(bytes);
        }
        return bytes;
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public void delete(Integer recordId) throws Exception {
        ImportRecordDO recordDO = selectById(ImportRecordDO.class, recordId);
        if (recordDO == null) {
            throw new BusinessException("记录不存在!");
        }
        String fileName = recordDO.getId() + recordDO.getFileName();
        this.delete(recordDO);
        File file = new File(FILE_PATH + fileName);
        file.delete();
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public void batchDelete(String recordIds) throws Exception {
        String[] ids = null;
        if(StringUtils.isNotBlank(recordIds)){
            ids=recordIds.split(",");
        }
        if(ArrayUtils.isEmpty(ids)){
            return;
        }

        for(int i=0;i<ids.length;i++){

            ImportRecordDO recordDO = selectById(ImportRecordDO.class, ids[i]);
            if (recordDO == null) {
                throw new BusinessException("记录不存在!");
            }
            String fileName = recordDO.getId() + recordDO.getFileName();
            this.delete(recordDO);
            File file = new File(FILE_PATH + fileName);
            file.delete();
        }

    }

    @Override
    public Map<Integer, String> allSource() {
        SysConfigDo sysConfig = selectOne(SysConfigDo.class,
                "config_key = 'thirdYuqingSource' AND config_group = 'thirdYuqingSource' LIMIT 1");
        if (sysConfig == null) {
            return new HashMap<>(0);
        }
        String jsonStr = sysConfig.getValue();
        return JSON.parseObject(jsonStr, HashMap.class);
    }

}
