package com.bbd.wtyh.service.third.yuqing;

import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.third.yuqing.ImportRecordDO;
import com.bbd.wtyh.util.WtyhHelper;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 第三方舆情
 *
 * @author Created by LiYao on 2017-10-09 10:17.
 */
public interface ThirdYuQingService extends BaseService {

    String FILE_PATH = WtyhHelper.pathWrap(WtyhHelper.fileRootPath + File.separator + "third-yuqing" + File.separator);

    void upload(String originalFilename, Date yuqingTime, String createBy, long fileSize, InputStream input) throws Exception;

    void saveYuQingFile(Integer recordId, String originalFilename, InputStream input) throws Exception;

    List<ImportRecordDO> findImportRecord(String fileName, String startDate, String endDate);

    byte[] download(ImportRecordDO recordDO) throws Exception;

    void delete(Integer recordId) throws Exception;
}
