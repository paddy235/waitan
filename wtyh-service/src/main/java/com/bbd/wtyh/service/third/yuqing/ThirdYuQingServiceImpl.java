package com.bbd.wtyh.service.third.yuqing;

import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.third.yuqing.ImportRecordDO;
import com.bbd.wtyh.exception.BusinessException;
import com.bbd.wtyh.mapper.third.yuqing.ThirdYuQingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public void upload(String originalFilename, Date yuqingTime, String createBy, long fileSize, InputStream input) throws Exception {
        ImportRecordDO recordDO = this.createImpRecord(originalFilename, yuqingTime, fileSize, createBy);
        saveYuQingFile(recordDO.getId(), originalFilename, input);
    }

    @Override
    public void saveYuQingFile(Integer recordId, String originalFilename, InputStream input) throws Exception {
        String fileName = recordId + originalFilename;
        File file = new File(FILE_PATH + fileName);

        try (OutputStream output = new FileOutputStream(file)) {
            int i;
            while ((i = input.read()) != -1) {
                output.write(i);
            }
        }
    }

    @Override
    public List<ImportRecordDO> findImportRecord(String fileName, String startDate, String endDate) {
        Map<String, Object> param = new HashMap<>();
        param.put("fileName", fileName);
        param.put("startDate", startDate);
        param.put("endDate", endDate);
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

    private ImportRecordDO createImpRecord(String originalFilename, Date yuqingTime, long fileSize, String createBy) {
        ImportRecordDO recordDO = new ImportRecordDO();
        recordDO.setFileName(originalFilename);
        recordDO.setFileSize(fileSize);
        recordDO.setCreateBy(createBy);
        recordDO.setCreateDate(new Date());
        recordDO.setYuqingTime(yuqingTime);
        this.insert(recordDO);
        return recordDO;
    }

}
