package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.ImgDO;

/**
 * Created by Barney on 2017/7/6.
 */
public interface ImgMapper {

    int addImage(ImgDO img);

    void updateImage(ImgDO img);

    ImgDO queryImgById(int id);

}
