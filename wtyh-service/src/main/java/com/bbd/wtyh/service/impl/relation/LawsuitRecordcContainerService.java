package com.bbd.wtyh.service.impl.relation;

import com.bbd.wtyh.common.relation.APIConstants;
import com.bbd.wtyh.common.relation.Constants;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.redis.RedisDAOImpl;
import com.bbd.wtyh.util.relation.StringUtils;
import com.bbd.wtyh.web.relationVO.CourtAnnouncementVO;
import com.bbd.wtyh.web.relationVO.DishonestPersonsVO;
import com.bbd.wtyh.web.relationVO.ExecutedPersonVO;
import com.bbd.wtyh.web.relationVO.LawsuitRecordVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Wen Jie on 2015/8/15.
 * 诉讼记录API Service
 */
@Service
public class LawsuitRecordcContainerService extends ApiContainerService {

    private static final String[] SSJL_FIELDS = new String[]{"案号", "title", "type", "main", "案由", "裁判日期", "起诉方当事人", "起诉方其他相关人", "被诉方当事人", "被诉方其他相关人", "案件结果",
            "审理法院", "法院方当事人", "适用法条"};
    private static final String[] SXBZX_FIELD = new String[]{"执行法院", "案号", "发布时间", "执行依据文号"};
    private static final String[] BZX_FIELD = new String[]{"被执行人姓名/名称", "身份证号码/组织机构代码", "执行法院", "立案时间", "案号", "执行标的"};
    private static final String KTGG_FIELD[] = new String[]{"案号", "案由", "当事人", "时间", "main", "city"};
    private static final String[] SSJL_FIELD = {"title", "main"};
    private static final Integer PAGE_SIZE = 50;
    private static Logger log = LoggerFactory.getLogger(LawsuitRecordcContainerService.class);

//    TODO
//    @Value("${" + Constants.API_SEARCH_URL + "}")
    private String url;

    //    TODO
//    @Resource
    private RedisDAO redisDao = new RedisDAOImpl();

    /**
     * API接口获得诉讼记录--分页
     *
     * @param company
     * @return
     * @throws Exception
     */
    public List<LawsuitRecordVO> getLawsuteDataByPage(String company, Integer pageNum) throws Exception {
        String resultJson = apiContainerServicePostByPage(url, APIConstants.COMPANYINFO_SSJL, company,
                SSJL_FIELD, APIConstants.SEARCHTYPE_DETAIL, Constants.SSJL_DATA_VERSION, pageNum, PAGE_SIZE, SSJL_FIELDS[0], SSJL_FIELDS[1], SSJL_FIELDS[2],
                SSJL_FIELDS[3], SSJL_FIELDS[4], SSJL_FIELDS[5], SSJL_FIELDS[6], SSJL_FIELDS[7], SSJL_FIELDS[8], SSJL_FIELDS[9], SSJL_FIELDS[10], SSJL_FIELDS[11], SSJL_FIELDS[12], SSJL_FIELDS[13]);
        log.info(company + "API接口 诉讼记录返回数据为：" + resultJson);
        if (!StringUtils.isNotNullOrEmpty(resultJson)) {
            throw new Exception("API 诉讼记录请求超时 ，返回数据为空");
        }
        return handleSSJLJson(resultJson, false, null, company);
    }

    /**
     * API接口获得诉讼记录--总条数
     *
     * @param company
     * @return
     * @throws Exception
     */
    public int getLawsuteDataCount(String company, Integer pageNum) throws Exception {
        String resultJson = apiContainerServicePostByPage(url, APIConstants.COMPANYINFO_SSJL, company,
                SSJL_FIELD, APIConstants.SEARCHTYPE_DETAIL, Constants.DATA_VERSION, PAGE_SIZE, pageNum, SSJL_FIELDS[0]);
        log.info(company + "API接口 诉讼记录返回数据为：" + resultJson);
        if (!StringUtils.isNotNullOrEmpty(resultJson)) {
            throw new Exception("API 诉讼记录请求超时 ，返回数据为空");
        }
        JSONObject jsonValue = JSONObject.fromObject(resultJson);
        int value = Integer.parseInt(jsonValue.get("sum").toString());
        return value;
    }

    /**
     * API接口获得诉讼记录
     *
     * @param company
     * @param companySSJLKey
     * @return
     * @throws Exception
     */
    public List<LawsuitRecordVO> getLawsuteData(String company, String companySSJLKey) throws Exception {
        String resultJson = apiContainerServicePost(url, APIConstants.COMPANYINFO_SSJL, company,
                SSJL_FIELD, APIConstants.SEARCHTYPE_DETAIL, Constants.DATA_VERSION, SSJL_FIELDS[0], SSJL_FIELDS[1], SSJL_FIELDS[2],
                SSJL_FIELDS[3], SSJL_FIELDS[4], SSJL_FIELDS[5], SSJL_FIELDS[6], SSJL_FIELDS[7], SSJL_FIELDS[8], SSJL_FIELDS[9], SSJL_FIELDS[10], SSJL_FIELDS[11], SSJL_FIELDS[12], SSJL_FIELDS[13]);
        log.info(company + "API接口 诉讼记录返回数据为：" + resultJson);
        if (!StringUtils.isNotNullOrEmpty(resultJson)) {
            throw new Exception("API 诉讼记录请求超时 ，返回数据为空");
        }
        if (!checkData(resultJson)) {
            throw new Exception("API 诉讼记录请求数据异常");
        }
        return handleSSJLJson(resultJson, true, companySSJLKey, null);
    }

    /**
     * API接口获得开庭公告---分页
     *
     * @param company
     * @return
     * @throws Exception
     */
    public List<CourtAnnouncementVO> getKtggDataByPage(String company, Integer pageNum) throws Exception {

        String resultJson = apiContainerServicePostByPage(url, APIConstants.COMPANYINFO_KTGG, company, new String[]{"main"},
                APIConstants.SEARCHTYPE_SEARCH, Constants.DATA_VERSION, pageNum, PAGE_SIZE, KTGG_FIELD[0], KTGG_FIELD[1], KTGG_FIELD[2], KTGG_FIELD[3], KTGG_FIELD[4], KTGG_FIELD[5]);
        log.info(company + "API接口 开庭公告返回数据为：" + resultJson);
        if (!StringUtils.isNotNullOrEmpty(resultJson)) {
            throw new Exception("API开庭公告请求超时 ，返回数据为空");
        }
        return handleKTGGJson(resultJson, false, null);
    }


    /**
     * API接口获得开庭公告
     *
     * @param company
     * @param companyKTGGkey
     * @return
     * @throws Exception
     */
    public List<CourtAnnouncementVO> getKtggData(String company, String companyKTGGkey) throws Exception {

        String resultJson = apiContainerServicePost(url, APIConstants.COMPANYINFO_KTGG, company, "main",
                APIConstants.SEARCHTYPE_SEARCH, Constants.SSJL_DATA_VERSION, KTGG_FIELD[0], KTGG_FIELD[1], KTGG_FIELD[2], KTGG_FIELD[3], KTGG_FIELD[4], KTGG_FIELD[5]);
        log.info(company + "API接口 开庭公告返回数据为：" + resultJson);
        if (!StringUtils.isNotNullOrEmpty(resultJson)) {
            throw new Exception("API开庭公告请求超时 ，返回数据为空");
        }
        if (!checkData(resultJson)) {
            throw new Exception("API 开庭公告请求数据异常");
        }
        return handleKTGGJson(resultJson, true, companyKTGGkey);
    }

    /**
     * API接口获得失信被执行人--分页
     *
     * @param company
     * @return
     * @throws Exception
     */
    public List<DishonestPersonsVO> getDishonestyDataByPage(String company, Integer pageNum) throws Exception {
        String resultJson = apiContainerServicePostByPage(url, APIConstants.COMPANYINFO_SXBZX, company,
                new String[]{"被执行人姓名或名称"}, APIConstants.SEARCHTYPE_DETAIL, Constants.DATA_VERSION, pageNum, PAGE_SIZE, SXBZX_FIELD[0], SXBZX_FIELD[1], SXBZX_FIELD[2],
                SXBZX_FIELD[3]);
        log.info(company + "API接口 失信被执行人返回数据为：" + resultJson);
        if (!StringUtils.isNotNullOrEmpty(resultJson)) {
            throw new Exception("API 失信被执行人请求超时 ，返回数据为空");
        }
        return handleSXBZXJson(resultJson, false, null);
    }


    /**
     * API接口获得失信被执行人
     *
     * @param company
     * @param companySXBZXKey
     * @return
     * @throws Exception
     */
    public List<DishonestPersonsVO> getDishonestyData(String company, String companySXBZXKey) throws Exception {
        String resultJson = apiContainerServicePost(url, APIConstants.COMPANYINFO_SXBZX, company,
                "被执行人姓名或名称", APIConstants.SEARCHTYPE_DETAIL, Constants.SSJL_DATA_VERSION, SXBZX_FIELD[0], SXBZX_FIELD[1], SXBZX_FIELD[2],
                SXBZX_FIELD[3]);
        log.info(company + "API接口 失信被执行人返回数据为：" + resultJson);
        if (!StringUtils.isNotNullOrEmpty(resultJson)) {
            throw new Exception("API 失信被执行人请求超时 ，返回数据为空");
        }
        if (!checkData(resultJson)) {
            throw new Exception("API 失信被执行人请求数据异常");
        }
        return handleSXBZXJson(resultJson, true, companySXBZXKey);
    }

    /**
     * API接口获得被执行人--分页
     *
     * @param company
     * @return
     * @throws Exception
     */
    public List<ExecutedPersonVO> getExecutedDataByPage(String company, Integer pageNum) throws Exception {
        String resultJson = apiContainerServicePostByPage(url, APIConstants.COMPANYINFO_BZX, company,
                new String[]{"被执行人姓名/名称"}, APIConstants.SEARCHTYPE_DETAIL, Constants.DATA_VERSION, pageNum, PAGE_SIZE, BZX_FIELD[0], BZX_FIELD[1], BZX_FIELD[2],
                BZX_FIELD[3], BZX_FIELD[4], BZX_FIELD[5]);
        log.info(company + "API接口 被执行人返回数据为：" + resultJson);
        if (!StringUtils.isNotNullOrEmpty(resultJson)) {
            throw new Exception("API 被执行人请求超时 ，返回数据为空");
        }
        return handleBZXJson(resultJson, false, null);
    }


    /**
     * API接口获得被执行人
     *
     * @param company
     * @return
     * @throws Exception
     */
    public List<ExecutedPersonVO> getExecutedData(String company, String companyBZXKey) throws Exception {
        String resultJson = apiContainerServicePost(url, APIConstants.COMPANYINFO_BZX, company,
                "被执行人姓名/名称", APIConstants.SEARCHTYPE_DETAIL, Constants.SSJL_DATA_VERSION, BZX_FIELD[0], BZX_FIELD[1], BZX_FIELD[2],
                BZX_FIELD[3], BZX_FIELD[3], BZX_FIELD[4], BZX_FIELD[5]);
        log.info(company + "API接口 被执行人返回数据为：" + resultJson);
        if (!StringUtils.isNotNullOrEmpty(resultJson)) {
            throw new Exception("API 被执行人请求超时 ，返回数据为空");
        }
        if (!checkData(resultJson)) {
            throw new Exception("API 被执行人请求数据异常");
        }
        return handleBZXJson(resultJson, true, companyBZXKey);
    }


    /**
     * 诉讼记录---处理API返回出的多层JSON数据
     *
     * @param json
     * @param company_redis_key
     * @param isSave            是否存储到redis， API接口请求总数的时候用
     * @param company           是否更新数据库，NULL 不更新，API请求总数外层要更新，， 有值则更新，说明是新华08项目
     * @return
     */
    public List<LawsuitRecordVO> handleSSJLJson(String json, Boolean isSave, String company_redis_key, String company) {
        Map<String, String> map = APIConstants.LawsuitRecordDataMap;
        // 转换中文字段名为英文
        for (String key : map.keySet()) {
            json = json.replace("\"" + key + "\"", "\"" + map.get(key) + "\"");
        }
        JSONObject jsonValue = JSONObject.fromObject(json);
        JSONArray jsonArray = JSONArray.fromObject(jsonValue.get("rdata"));

        // 封装结果成Map并返回给Controller层，并存入redis
        if (isSave) {
            redisDao.addString(company_redis_key, jsonArray.toString(), Constants.cacheDays);
        }
        if (jsonArray.size() > 0) {
            // 诉讼记录VO
            List<LawsuitRecordVO> lawsuitRecordList = new ArrayList<LawsuitRecordVO>();
            for (Object object : jsonArray) {
                JSONObject obj = JSONObject.fromObject(object);
                lawsuitRecordList.add((LawsuitRecordVO) JSONObject.toBean(obj, LawsuitRecordVO.class));
            }
            return lawsuitRecordList;
        }
        return null;
    }

    /**
     * 失信被执行人---处理API返回出的多层JSON数据
     *
     * @param json
     * @param companySXBZXKey
     * @return
     */
    public List<DishonestPersonsVO> handleSXBZXJson(String json, boolean isSave, String companySXBZXKey) {
        Map<String, String> map = APIConstants.DishonestPersonsDataMap;
        // 转换中文字段名为英文
        for (String key : map.keySet()) {
            json = json.replace("\"" + key + "\"", "\"" + map.get(key) + "\"");
        }
        JSONObject jsonValue = JSONObject.fromObject(json);
        JSONArray jsonArray = JSONArray.fromObject(jsonValue.get("rdata"));
        // 封装结果成Map并返回给Controller层，并存入redis
        if (isSave)
            redisDao.addString(companySXBZXKey, jsonArray.toString(), Constants.cacheDays);
        // 诉讼记录VO
        List<DishonestPersonsVO> dishonestPersonsList = new ArrayList<DishonestPersonsVO>();
        for (Object object : jsonArray) {
            JSONObject obj = JSONObject.fromObject(object);
            dishonestPersonsList.add((DishonestPersonsVO) JSONObject.toBean(obj, DishonestPersonsVO.class));
        }
        return dishonestPersonsList;
    }

    /**
     * 被执行人---处理API返回出的多层JSON数据
     *
     * @param json
     * @param companyBZXKey
     * @return
     */
    public List<ExecutedPersonVO> handleBZXJson(String json, boolean isSave, String companyBZXKey) {
        Map<String, String> map = APIConstants.ExecutedDataMap;
        // 转换中文字段名为英文
        for (String key : map.keySet()) {
            json = json.replace("\"" + key + "\"", "\"" + map.get(key) + "\"");
        }
        JSONObject jsonValue = JSONObject.fromObject(json);
        JSONArray jsonArray = JSONArray.fromObject(jsonValue.get("rdata"));
        // 封装结果成Map并返回给Controller层，并存入redis
        if (isSave)
            redisDao.addString(companyBZXKey, jsonArray.toString(), Constants.cacheDays);
        // 被执行人VO
        List<ExecutedPersonVO> executedPersonVOList = new ArrayList<ExecutedPersonVO>();
        for (Object object : jsonArray) {
            JSONObject obj = JSONObject.fromObject(object);
            executedPersonVOList.add((ExecutedPersonVO) JSONObject.toBean(obj, ExecutedPersonVO.class));
        }
        return executedPersonVOList;
    }


    /**
     * 开庭公告---处理API返回出的多层JSON数据
     *
     * @param json
     * @param companyKTGGkey
     * @return
     */
    public List<CourtAnnouncementVO> handleKTGGJson(String json, Boolean isSave, String companyKTGGkey) {
        Map<String, String> map = APIConstants.KtggDataMap;
        // 转换中文字段名为英文
        for (String key : map.keySet()) {
            json = json.replace("\"" + key + "\"", "\"" + map.get(key) + "\"");
        }
        // 循环JSON数组，将每个JSON对象中的内层json数据取出，只取出内层的关键数据放到外层json里
        JSONObject jsonValue = JSONObject.fromObject(json);
        JSONArray jsonArray = JSONArray.fromObject(jsonValue.get("rdata"));
        // 封装结果成Map并返回给Controller层，并存入redis
        if (isSave)
            redisDao.addString(companyKTGGkey, jsonArray.toString(), Constants.cacheDays);
        // 诉讼记录VO
        List<CourtAnnouncementVO> courtAnnouncementList = new ArrayList<CourtAnnouncementVO>();
        for (Object object : jsonArray) {
            JSONObject obj = JSONObject.fromObject(object);
            courtAnnouncementList.add((CourtAnnouncementVO) JSONObject.toBean(obj, CourtAnnouncementVO.class));
        }
        return courtAnnouncementList;
    }
}
