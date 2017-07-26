package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.ImgDO;

import java.util.List;

/**
 * Created by Barney on 2017/7/6.
 */
public interface ImgService {

    int addImage(ImgDO img);

    ImgDO queryImgById(int id);

    List<ImgDO> queryImgByStatus(int status);

    void updateImage(ImgDO img);

}
