package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.ImgDO;

/**
 * Created by Barney on 2017/7/6.
 */
public interface ImgService {

    int addImage(ImgDO img);

    ImgDO queryImgById(int id);

}
