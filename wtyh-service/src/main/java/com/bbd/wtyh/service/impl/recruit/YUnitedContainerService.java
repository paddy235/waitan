package com.bbd.wtyh.service.impl.recruit;

import com.bbd.higgs.utils.HTTPUtils;
import com.bbd.wtyh.common.recruit.StringUtil;
import com.bbd.wtyh.service.impl.relation.exception.BbdException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author wangchenge
 * @since 2016.08.17
 */
@Component
public class YUnitedContainerService {
    private Logger logger = Logger.getLogger(this.getClass());


    /**
     * 协议：HTTP
     * 传送方式：POST
     * 请求第三方接口数据
     *
     * @param param
     * @return
     */
    public String queryYUnitedInfo(String url, String param) {
        if (StringUtil.isNullOrEmpty(url) || StringUtil.isNullOrEmpty(param)) {
            logger.error("调用第三方接口地址或参数为空，url=" + url + "，param=" + param);
            throw new BbdException("调用第三方接口地址或参数为空，url=" + url + "，param=" + param);
        }
        try {
            return HTTPUtils.sendPost(url, param);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
