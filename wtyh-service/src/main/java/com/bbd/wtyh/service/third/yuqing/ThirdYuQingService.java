package com.bbd.wtyh.service.third.yuqing;

import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.third.yuqing.ImportRecordDO;
import com.bbd.wtyh.excel.imp.constants.ImpRecord;
import com.bbd.wtyh.util.WtyhHelper;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 第三方舆情
 *
 * @author Created by LiYao on 2017-10-09 10:17.
 */
public interface ThirdYuQingService extends BaseService {

    String FILE_PATH = WtyhHelper.pathWrap(WtyhHelper.fileRootPath + File.separator + "third-yuqing" + File.separator);

    void saveYuQingFile(ImportRecordDO recordDO, InputStream input) throws Exception;

    List<ImportRecordDO> findImportRecord(Map<String, String> param);

    byte[] download(ImportRecordDO recordDO) throws Exception;

    void delete(Integer recordId) throws Exception;

    void batchDelete(String recordIds)throws Exception;

    ImportRecordDO createImpRecord(String fileName, Date yuqingTime, long fileSize, String createBy, Integer source);

    void modifyStateAndRemark(Integer recordId, ImpRecord impRecord, String remark);

    Map<Integer, String> allSource();
}
