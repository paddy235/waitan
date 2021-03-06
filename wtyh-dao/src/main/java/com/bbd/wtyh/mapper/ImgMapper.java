package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.ImgDO;

import java.util.List;
import java.util.Map;

/**
 * Created by Barney on 2017/7/6.
 */
public interface ImgMapper {

    int addImage(ImgDO img);

    void updateImage(ImgDO img);

    ImgDO queryImgById(int id);

    List<ImgDO> queryImgByStatus(int status);

    void delImg(Map<String, Object> params);

}
