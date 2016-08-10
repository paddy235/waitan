package com.bbd.wtyh.service.impl.relation;

import com.bbd.wtyh.common.relation.APIConstants;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.redis.RedisDAOImpl;
import com.bbd.wtyh.service.util.SSJLReader;
import com.bbd.wtyh.web.relationVO.CourtAnnouncementVO;
import com.bbd.wtyh.web.relationVO.DishonestPersonsVO;
import com.bbd.wtyh.web.relationVO.ExecutedPersonVO;
import com.bbd.wtyh.web.relationVO.LawsuitRecordVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 诉讼记录 Service
 *
 * @author Administrator
 */
@Service
public class LawsuitRecordService {

    Logger log = LoggerFactory.getLogger(LawsuitRecordService.class);

    @Autowired
    private RedisDAO redisDao;
    @Resource
    private LawsuitRecordcContainerService lawsuteContainerService;

    public static final int THREAD_COUNT = 30;

    /**
     * 诉讼记录--分页
     *
     * @param company
     * @param pageNum
     * @return
     */
    public List<LawsuitRecordVO> getLawsuitRecordByPage(String company, Integer pageNum) throws Exception {
        return lawsuteContainerService.getLawsuteDataByPage(company, pageNum);
    }


    /**
     * 诉讼记录--条数
     *
     * @param company
     * @param pageNum
     * @return
     */
    public int getLawsuteDataCount(String company, Integer pageNum) throws Exception {
        return lawsuteContainerService.getLawsuteDataCount(company, pageNum);
    }

    /**
     * 开庭公告--分页
     *
     * @param company
     * @param pageNum
     * @return
     * @throws Exception
     */
    public List<CourtAnnouncementVO> getKTGGByPage(String company, Integer pageNum) throws Exception {
        return lawsuteContainerService.getKtggDataByPage(company, pageNum);
    }

    /**
     * 失信被执行人--分页
     *
     * @param company
     * @param pageNum
     * @return
     * @throws Exception
     */
    public List<DishonestPersonsVO> getSXBZXByPage(String company, Integer pageNum) throws Exception {
        return lawsuteContainerService.getDishonestyDataByPage(company, pageNum);
    }

    /**
     * 被执行人--分页
     *
     * @param company
     * @param pageNum
     * @return
     * @throws Exception
     */
    public List<ExecutedPersonVO> getBZXByPage(String company, Integer pageNum) throws Exception {
        return lawsuteContainerService.getExecutedDataByPage(company, pageNum);
    }


    /**
     * 获取开庭公告、失信被执行人、诉讼记录
     *
     * @param company
     * @param ssjl    是否获取诉讼记录
     * @param sxbzx   是否获取失信被执行人
     * @param ktgg    是否获取开庭公告
     * @return map<String, List>
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public Map<String, List> getLawsuitRecord(String company, boolean ssjl, boolean sxbzx, boolean ktgg, boolean bzx) throws Exception {

        Map<String, List> resultMap = new HashMap<String, List>();

        String companySSJLKey = company + APIConstants.redis_bd_ssjl;
        String companySXBZXKey = company + APIConstants.redis_bd_sxbzx;
        String companyKTGGkey = company + APIConstants.redis_bd_ktgg;
        String companyBZXKey = company + APIConstants.redis_bd_bzx;


        // ------------------------------失信被执行--------------------------------
        if (sxbzx) {
            try {
                String sxbzxValue = redisDao.getString(companySXBZXKey);
                if (sxbzxValue != null) {
                    // 将失信被执行人处理的结果添加到map里
                    resultMap.put("sxbzx", handleSXBZXResultJson(JSONArray.fromObject(sxbzxValue)));
                } else {
                    resultMap.put("sxbzx", lawsuteContainerService.getDishonestyData(company, companySXBZXKey));
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }

        if (bzx) {
            try {
                String bzxValue = redisDao.getString(companyBZXKey);
                if (bzxValue != null) {
                    // 被执行人处理的结果添加到map里
                    resultMap.put("bzx", handleBZXResultJson(JSONArray.fromObject(bzxValue)));
                } else {
                    resultMap.put("bzx", lawsuteContainerService.getExecutedData(company, companyBZXKey));
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }

        // ------------------------------诉讼记录--------------------------------
        if (ssjl) {
            String ssjlValue = redisDao.getString(companySSJLKey);
            try {
                if (ssjlValue != null) {
                    // 将诉讼记录处理的结果添加到map里
                    resultMap.put("ssjl", handleSSJLResultJson(JSONArray.fromObject(ssjlValue)));
                } else {
//							List<LawsuitRecordVO> lawsuitRecordVOList = lawsuteContainerService.getLawsuteData(company, companySSJLKey);
                    List<LawsuitRecordVO> lawsuitRecordVOList = new LinkedList<LawsuitRecordVO>();
                    SSJLReader ssjlReader = new SSJLReader(company, lawsuteContainerService, lawsuitRecordVOList);
                    List<Thread> threadList = new ArrayList<Thread>();

                    for (int i = 0; i < THREAD_COUNT; i++) {
                        Thread thread = new Thread(ssjlReader);
                        threadList.add(thread);
                        thread.start();
                    }

                    while (true) {
                        Thread.sleep(5000l); // 每5秒执行一次检查，减少性能损耗
                        boolean threadMark = false;
                        for (Thread t : threadList) {
                            if (t.isAlive()) {
                                threadMark = false;
                                break;
                            }
                            threadMark = true;
                        }
                        if (threadMark) {
                            break;
                        }
                    }
                    resultMap.put("ssjl", lawsuitRecordVOList);
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }

        // ------------------------------开庭公告--------------------------------
        if (ktgg) {
            try {
                String ktggValue = redisDao.getString(companyKTGGkey);
                if (ktggValue != null) {
                    // 将开庭公告处理的结果添加到map里
                    resultMap.put("ktgg", handleKTGGResultJson(JSONArray.fromObject(ktggValue)));
                } else {
                    resultMap.put("ktgg", lawsuteContainerService.getKtggData(company, companyKTGGkey));
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
        // return Map
        return resultMap;
    }


    /**
     * 裁判文书---处理诉讼记录详细的信息结果，（通用方法，API取出时使用，Redis取出json时直接使用这一部分）
     *
     * @param sxjlResult
     * @return
     */
    public List<LawsuitRecordVO> handleSSJLResultJson(JSONArray sxjlResult) {
        // 裁判文书VO
        List<LawsuitRecordVO> lawsuitRecordList = new ArrayList<LawsuitRecordVO>();
        for (Object object : sxjlResult) {
            JSONObject obj = JSONObject.fromObject(object);
            lawsuitRecordList.add((LawsuitRecordVO) JSONObject.toBean(obj, LawsuitRecordVO.class));
        }
        return lawsuitRecordList;
    }

    // ---------------------------------------------失信被执行人----------------------------------------------

    /**
     * 失信被执行人---处理诉讼记录详细的信息结果，（通用方法，API取出时使用，Redis取出json时直接使用这一部分）
     *
     * @param sxbzxResult
     * @return
     */
    public List<DishonestPersonsVO> handleSXBZXResultJson(JSONArray sxbzxResult) {
        // 诉讼记录VO
        List<DishonestPersonsVO> dishonestPersonsList = new ArrayList<DishonestPersonsVO>();
        for (Object object : sxbzxResult) {
            JSONObject obj = JSONObject.fromObject(object);
            dishonestPersonsList.add((DishonestPersonsVO) JSONObject.toBean(obj, DishonestPersonsVO.class));
        }
        return dishonestPersonsList;
    }

    // --------------------------------------------------开庭公告---------------------------------------------------

    /**
     * 开庭公告---处理诉讼记录详细的信息结果，（通用方法，API取出时使用，Redis取出json时直接使用这一部分）
     *
     * @param ktggResult
     * @return
     */
    public List<CourtAnnouncementVO> handleKTGGResultJson(JSONArray ktggResult) {
        // 诉讼记录VO
        List<CourtAnnouncementVO> courtAnnouncementList = new ArrayList<CourtAnnouncementVO>();
        for (Object object : ktggResult) {
            JSONObject obj = JSONObject.fromObject(object);
            courtAnnouncementList.add((CourtAnnouncementVO) JSONObject.toBean(obj, CourtAnnouncementVO.class));
        }
        return courtAnnouncementList;
    }

    /**
     * 被执行---处理诉讼记录详细的信息结果，（通用方法，API取出时使用，Redis取出json时直接使用这一部分）
     *
     * @param ktggResult
     * @return
     */
    public List<ExecutedPersonVO> handleBZXResultJson(JSONArray bzxResult) {
        // 诉讼记录VO
        List<ExecutedPersonVO> executedPersonVOList = new ArrayList<ExecutedPersonVO>();
        for (Object object : bzxResult) {
            JSONObject obj = JSONObject.fromObject(object);
            executedPersonVOList.add((ExecutedPersonVO) JSONObject.toBean(obj, ExecutedPersonVO.class));
        }
        return executedPersonVOList;
    }
}
