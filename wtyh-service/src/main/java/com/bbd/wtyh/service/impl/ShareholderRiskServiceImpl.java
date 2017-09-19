package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.dto.RelatedCompanyDTO;
import com.bbd.wtyh.domain.dto.ShareholderRiskDTO;
import com.bbd.wtyh.mapper.RelatedCompanyMapper;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.OfflineFinanceService;
import com.bbd.wtyh.service.ShareholderRiskService;
import com.bbd.wtyh.service.impl.relation.RegisterUniversalFilterChainImp;
import com.bbd.wtyh.web.relationVO.RelationDiagramVO;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Marco on 2016/8/8.
 */
@Service
public class ShareholderRiskServiceImpl implements ShareholderRiskService {
    private static final String SHAREHOLDER_RISK_CACHE_PRIFIX = "ShareholderRisk-";
    private static final String RELATED_COMPANY_CACHE_PRIFIX = "RelatedCompany-";
    @Autowired
    private OfflineFinanceService offlinefinanceservice;
    @Autowired
    private RelatedCompanyMapper relatedCompanyMapper;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private RegisterUniversalFilterChainImp relatedCompanyService;
    @Autowired
    private RedisDAO redisDAO;
    @Value("${related.party.dataVersion}")
    private String dataVersion;
    private Set<Integer> relatedCompanyTypes = Sets.newHashSet((int) CompanyDO.TYPE_P2P_1, (int) CompanyDO.TYPE_XXLC_4, (int) CompanyDO.TYPE_SMJJ_5);


    @Override
    public List<ShareholderRiskDTO> listShareholderRisk(Integer companyType) {
        List<ShareholderRiskDTO> riskList = (List<ShareholderRiskDTO>) redisDAO.getObject(SHAREHOLDER_RISK_CACHE_PRIFIX + companyType);
        if (null == riskList) {
            riskList = innerListShareholderRisk(companyType);
            redisDAO.addObject(SHAREHOLDER_RISK_CACHE_PRIFIX + companyType, riskList, Constants.REDIS_10, riskList.getClass());
        }
        return riskList;
    }

//    @Scheduled(cron = "0 0 3 * * *")
//    public void warmupShareholderRiskCache() {
//        List<ShareholderRiskDTO> riskList = innerListShareholderRisk((int) CompanyDO.TYPE_XD_2);
//        redisDAO.addObject(SHAREHOLDER_RISK_CACHE_PRIFIX + (int) CompanyDO.TYPE_XD_2, riskList, Constants.REDIS_10, riskList.getClass());
//        riskList = innerListShareholderRisk((int) CompanyDO.TYPE_RZDB_3);
//        redisDAO.addObject(SHAREHOLDER_RISK_CACHE_PRIFIX + (int) CompanyDO.TYPE_RZDB_3, riskList, Constants.REDIS_10, riskList.getClass());
//    }

    private List<ShareholderRiskDTO> innerListShareholderRisk(Integer companyType) {
        List<CompanyDO> companyList = companyService.queryCompanyByType(companyType, null, null);
        List<ShareholderRiskDTO> dtoList = Lists.newArrayList();
        for (CompanyDO companyDO : companyList) {
            try {
                //Map<String, List> relationMap = relatedCompanyService.queryRelation(companyDO.getName(), dataVersion, 1);
                RelationDiagramVO relationDiagramVO=offlinefinanceservice.queryRealRealation(companyDO.getName(),null, 1);
                //List<RelationDiagramVO.PointVO> pointList = relationMap.get("pointList");
                List<RelationDiagramVO.PointVO> pointList = relationDiagramVO.getPointList();
                if (CollectionUtils.isEmpty(pointList)) {
                    continue;
                }
                ShareholderRiskDTO dto = new ShareholderRiskDTO();
                dto.setCompanyId(companyDO.getCompanyId());
                dto.setCompanyName(companyDO.getName());
                int p2p = 0;
                int offlineFinance = 0;
                int privateFund = 0;
                for (RelationDiagramVO.PointVO pointVO : pointList) {
                    if (pointVO.getIsPerson().equals("1")) {
                        continue;
                    }
                    CompanyDO relatedCompany = companyService.getCompanyByName(pointVO.getCname());
                    if (null == relatedCompany || null == relatedCompany.getCompanyType()) {
                        continue;
                    }
                    switch (relatedCompany.getCompanyType()) {
                        case CompanyDO.TYPE_P2P_1:
                            p2p++;
                            break;
                        case CompanyDO.TYPE_XXLC_4:
                            offlineFinance++;
                            break;
                        case CompanyDO.TYPE_SMJJ_5:
                            privateFund++;
                            break;
                        default:
                            break;
                    }
                }
                if (p2p <= 0 && offlineFinance <= 0 && privateFund <= 0) {
                    continue;
                }
                dto.setP2p(p2p);
                dto.setOfflineFinance(offlineFinance);
                dto.setPrivateFund(privateFund);
                dtoList.add(dto);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        return dtoList;
    }

    @Override
    public Multimap<Integer, RelatedCompanyDTO> getRelatedCompany(Integer companyId) {
        Object object = redisDAO.getObject(RELATED_COMPANY_CACHE_PRIFIX + companyId);
        if (null == object) {
            object = innerGetRelatedCompany(companyId);
            redisDAO.addObject(RELATED_COMPANY_CACHE_PRIFIX + companyId, object, Constants.REDIS_10, ArrayListMultimap.class);
        }
        return (Multimap<Integer, RelatedCompanyDTO>) object;
    }

    @Override
    public Multimap<Integer, RelatedCompanyDTO> getRelatedCompany(String companyName) {
        return getRelatedCompany(companyService.getCompanyByName(companyName, true).getCompanyId());
    }

    private Multimap<Integer, RelatedCompanyDTO> innerGetRelatedCompany(Integer companyId) {
        try {
            Multimap<Integer, RelatedCompanyDTO> relatedCompanyMap = ArrayListMultimap.create();
            //Map<String, List> relationMap = relatedCompanyService.queryRelation(companyService.getNameById(companyId), dataVersion, 1);
            RelationDiagramVO relationDiagramVO=offlinefinanceservice.queryRealRealation(companyService.getNameById(companyId),null, 1);
            List<RelationDiagramVO.PointVO> pointList = relationDiagramVO.getPointList();
            if (null == pointList) {
                return ArrayListMultimap.create();
            }
            for (RelationDiagramVO.PointVO pointVO : pointList) {
                if (pointVO.getIsPerson().equals("1")) {
                    continue;
                }
                CompanyDO relatedCompany = companyService.getCompanyByName(pointVO.getCname());
                if (null == relatedCompany) {
                    continue;
                }
                if (null == relatedCompany.getCompanyType()) {
                    continue;
                }
                if (relatedCompanyTypes.contains(relatedCompany.getCompanyType().intValue())) {
                    relatedCompanyMap.put(relatedCompany.getCompanyType().intValue(), new RelatedCompanyDTO(relatedCompany.getName(), relatedCompany.getRiskLevel()));
                }
            }
            return relatedCompanyMap;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
