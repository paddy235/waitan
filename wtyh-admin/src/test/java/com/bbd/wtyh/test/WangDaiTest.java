package com.bbd.wtyh.test;

import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.vo.FundVO;
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
    @Test
    public void test(){
        ResultsDO resultsDO=this.getPlatList();
        for(ResultsDO.WangDaiDO wangDaiDO:resultsDO.results){
            this.executeCUD("INSERT INTO wangdai(company_name,plat_name) values('"+wangDaiDO.getCompany_name()+"','"+wangDaiDO.getPlat_name()+"')");
        }
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
}
