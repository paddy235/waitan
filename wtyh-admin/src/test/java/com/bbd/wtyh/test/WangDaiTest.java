package com.bbd.wtyh.test;

import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.constants.SourceType;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.vo.FundVO;
import com.bbd.wtyh.log.user.Operation;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.Table;
import java.util.List;

/**
 * Created by Administrator on 2017/4/26 0026.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class WangDaiTest extends BaseServiceImpl {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String url="http://121.40.187.134:5002/financial_services?dataType=plat_list";

    private String url_plat_info="http://121.40.187.134:5002/financial_services?dataType=plat_rank_data";

    private String url_plat_exist="http://121.40.187.134:5002/financial_services?dataType=yuqing&plat_name=";

    private String url_plat_core="http://121.40.187.134:5002/financial_services?dataType=plat_data&plat_name=";
    @Test
    public void test(){
        ResultsDO resultsDO=this.getPlatList();
        for(ResultsDO.WangDaiDO wangDaiDO:resultsDO.results){
            this.executeCUD("INSERT INTO test_wangdai(company_name,plat_name) values('"+wangDaiDO.getCompany_name()+"','"+wangDaiDO.getPlat_name()+"')");
        }
        System.out.println("---wang dai---");
        ResultsInfoDO resultsInfoDO=this.getPlatInfoList();
        for(ResultsInfoDO.WangDaiInfoDO wangDaiInfoDO:resultsInfoDO.results){
            this.executeCUD("INSERT INTO test_wangdai_info(plat_name,plat_status) values('"+wangDaiInfoDO.getPlat_name()+"','"+wangDaiInfoDO.getPlat_status()+"')");
        }
        System.out.println("---wang dai info ---");
    }

    @Test
    public void platExistTest(){
        ResultsDO resultsDO=this.getPlatList();
        for(ResultsDO.WangDaiDO wangDaiDO:resultsDO.results){
            String platName=wangDaiDO.getPlat_name();
            try {
                String result = new HttpTemplate().get(url_plat_exist+platName);
                if("平台不存在".equals(result)){
                    this.executeCUD("INSERT INTO test_wangdai_exist(plat_name,is_exist) values('"+wangDaiDO.getPlat_name()+"','"+"NO"+"')");
                }else{
                    this.executeCUD("INSERT INTO test_wangdai_exist(plat_name,is_exist) values('"+wangDaiDO.getPlat_name()+"','"+"YES"+"')");
                }
            } catch (Exception e) {
                logger.error("err :"+platName + e.getMessage());
            }
        }

    }

    @Test
    public void platCoreTest(){
        ResultsDO resultsDO=this.getPlatList();
        for(ResultsDO.WangDaiDO wangDaiDO:resultsDO.results){
            String platName=wangDaiDO.getPlat_name();
            try {
                String result = new HttpTemplate().get(url_plat_core+platName);

                if("平台不存在".equals(result)){
                    this.executeCUD("INSERT INTO test_wangdai_core(plat_name,is_exist) values('"+wangDaiDO.getPlat_name()+"','"+"NO"+"')");
                }else{
                    this.executeCUD("INSERT INTO test_wangdai_core(plat_name,company_name,is_exist) values('"+wangDaiDO.getPlat_name()+"','"+wangDaiDO.getCompany_name()+"','"+"YES"+"')");
                }
            } catch (Exception e) {
                logger.error("err :"+platName + e.getMessage());
            }
        }

    }

    @Test
    public void platCoreTest2(){
        Byte ii=null;
        Integer i=(int)ii;
        System.out.println(i);

    }

    public ResultsDO getPlatList() {
        try {
            String result = new HttpTemplate().get(url);
            Gson gson = new Gson();
            ResultsDO resultsDO = gson.fromJson("{\"results\":"+result+"}",new TypeToken<ResultsDO>(){}.getType());

            return resultsDO;
        } catch (Exception e) {
            logger.error("Method getPrivateFundCompanyData get Exception." + e.getMessage());
            return null;
        }
    }

    public ResultsInfoDO getPlatInfoList() {
        try {
            String result = new HttpTemplate().get(url_plat_info);
            Gson gson = new Gson();
            ResultsInfoDO resultsInfoDO = gson.fromJson("{\"results\":"+result+"}",new TypeToken<ResultsInfoDO>(){}.getType());

            return resultsInfoDO;
        } catch (Exception e) {
            logger.error("Method getPrivateFundCompanyData get Exception." + e.getMessage());
            return null;
        }
    }




    @Table()
    public static class ResultsDO{

        private List<WangDaiDO> results;

        public List<WangDaiDO> getResults() {
            return results;
        }

        public void setResults(List<WangDaiDO> results) {
            this.results = results;
        }

        public static  class  WangDaiDO{

            private String plat_name;
            private String company_name;
            private String logo_url;

            public String getPlat_name() {
                return plat_name;
            }

            public void setPlat_name(String plat_name) {
                this.plat_name = plat_name;
            }

            public String getCompany_name() {
                return company_name;
            }

            public void setCompany_name(String company_name) {
                this.company_name = company_name;
            }

            public String getLogo_url() {
                return logo_url;
            }

            public void setLogo_url(String logo_url) {
                this.logo_url = logo_url;
            }
        }
    }

    @Table()
    public static class ResultsInfoDO{

        private List<WangDaiInfoDO> results;

        public List<WangDaiInfoDO> getResults() {
            return results;
        }

        public void setResults(List<WangDaiInfoDO> results) {
            this.results = results;
        }

        public static  class  WangDaiInfoDO{

            private String amount;
            private String area_id;
            private String income_rate;
            private String loan_period;
            private String plat_name;
            private String plat_status;
            private String rank;
            private String registered_address;
            private String stay_still_of_total;

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getArea_id() {
                return area_id;
            }

            public void setArea_id(String area_id) {
                this.area_id = area_id;
            }

            public String getIncome_rate() {
                return income_rate;
            }

            public void setIncome_rate(String income_rate) {
                this.income_rate = income_rate;
            }

            public String getLoan_period() {
                return loan_period;
            }

            public void setLoan_period(String loan_period) {
                this.loan_period = loan_period;
            }

            public String getPlat_name() {
                return plat_name;
            }

            public void setPlat_name(String plat_name) {
                this.plat_name = plat_name;
            }

            public String getPlat_status() {
                return plat_status;
            }

            public void setPlat_status(String plat_status) {
                this.plat_status = plat_status;
            }

            public String getRank() {
                return rank;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public String getRegistered_address() {
                return registered_address;
            }

            public void setRegistered_address(String registered_address) {
                this.registered_address = registered_address;
            }

            public String getStay_still_of_total() {
                return stay_still_of_total;
            }

            public void setStay_still_of_total(String stay_still_of_total) {
                this.stay_still_of_total = stay_still_of_total;
            }
        }
    }
}
