package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.domain.dto.KunLunApiResult;
import com.bbd.wtyh.domain.dto.RelationData;
import com.bbd.wtyh.service.OfflineFinanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * 线下理财接口实现层
 * @author zhouxuan
 * @since 2016.08.05
 */
@Service("offlineFinanceService")
public class OfflineFinanceServiceImpl implements OfflineFinanceService {
    private Logger logger = LoggerFactory.getLogger(OfflineFinanceServiceImpl.class);
    @Resource
    private HttpTemplate httpTemplate;

    @Value("${kunlun.relation.api}")
    private String kunlunRelationApi;

    @SuppressWarnings("rawtypes")
	@Override
    public List<Map> relatedGraph() {
        return null;
    }

    @Override
    public String getRelationFromKunLun(String companyName, String level, String version) {
        logger.debug("从kunlun获取关联方数据。");
        try {
            String url = MessageFormat.format(kunlunRelationApi, level, URLEncoder.encode(companyName,"utf-8"));
            RelationData data = httpTemplate.get(url, new HttpCallback<RelationData>() {
                private KunLunApiResult<RelationData> kunLunApiResult;

                @Override
                public RelationData parse(String result) {
                    kunLunApiResult = JSON.parseObject(result, new TypeReference<KunLunApiResult<RelationData>>() {});
                    if(valid()){
                        return kunLunApiResult.getData();
                    }else{
                        logger.error(kunLunApiResult.getErrmsg());
                        return null;
                    }
                }

                @Override
                public boolean valid() {
                    int errCode = kunLunApiResult.getErrcode();
                    return errCode == 0;
                }
            });
            return data == null ? null : data.toString();
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);

        }catch (Exception e) {

        }
        return null;
    }
}
