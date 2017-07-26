package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.ImgDO;
import com.bbd.wtyh.mapper.ImgMapper;
import com.bbd.wtyh.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Barney on 2017/7/6.
 */
@Service
public class ImgServiceImpl implements ImgService {

    @Autowired
    private ImgMapper mapper;

    @Override
    public int addImage(ImgDO img) {
        return mapper.addImage(img);
    }

    @Override
    public ImgDO queryImgById(int id) {
        return mapper.queryImgById(id);
    }

    @Override
    public List<ImgDO> queryImgByStatus(int status) {
        return mapper.queryImgByStatus(status);
    }

    @Override
    public void updateImage(ImgDO img) {
        mapper.updateImage(img);
    }
}
