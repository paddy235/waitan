package com.bbd.wtyh.service;

import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created by win7 on 2016/8/10.
 */
public interface BuildFileService {

    public boolean buildImage(List<List<Object>> data, String company, String filePath, boolean flag)throws Exception;

    /**
     *
     * @param data
     * @param company
     * @param filePath 当此参数置空时，图片被写入到bos中，所以此时bos一定不能为空
     * @param bos
     * @param flag
     * @return
     * @throws Exception
     */
    public boolean buildImageToFileOrStream(List<List<Object>> data, String company, String filePath,
                                            ByteArrayOutputStream bos, boolean flag) throws Exception;
}
