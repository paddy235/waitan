package com.bbd.wtyh.test;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.mapper.CompanyMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/7/10 0010.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class WriteTest {
    @Autowired
    private CompanyMapper companyMapper;
    public  static  void main(String[] args){

    }

    @Test
    public void test(){


        try
        {
            List<CompanyDO> list=companyMapper.getCompanyList(91539,"0",50000);
            String content  ;
            Random r=new Random();
            for(CompanyDO c:list){
                String name=c.getName();
                if(name.contains("/")){
                    continue;
                }
                int i=r.nextInt(4);
                if(i==0){
                    content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><GRZX name=\"" +
                            name +
                            "\" zjhm=\"null\" tydm=\"null\" cxbh=\"JKCX201706061451231004001000005547\"><RESULT>1003</RESULT></GRZX>";
                }else{
                   content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><GRZX name=\"" +
                            name +
                            "\" zjhm=\"null\" tydm=\"null\" cxbh=\"JKCX201706061455331004001000028469\"><RESULT>1005</RESULT><RESOURCE XXSSDWDM=\"D010025\" XXLB=\"监管类\" RESOURCENAME=\"经营异常名录\" XXSSDW=\"市工商局\" RESOURCES=\"except\" RESOURCECODE=\"except\"><move_in_reason>通过登记的住所或者经营场所无法联系的</move_in_reason><undo_date></undo_date><move_in_organ_id></move_in_organ_id><undo_reason></undo_reason><move_in_date>20170210</move_in_date></RESOURCE></GRZX>";
                }

                File file = new File("D:\\credit\\" + name + ".xml");

                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content);
                bw.close();

                System.out.println(name);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
