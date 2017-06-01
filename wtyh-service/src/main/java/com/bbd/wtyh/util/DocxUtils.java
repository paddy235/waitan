package com.bbd.wtyh.util;

import net.sf.cglib.beans.BeanCopier;
import org.docx4j.TextUtils;
import org.docx4j.model.structure.SectionWrapper;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.DrawingML.Chart;
import org.docx4j.openpackaging.parts.Part;
import org.docx4j.openpackaging.parts.PartName;
import org.docx4j.openpackaging.parts.Parts;
import org.docx4j.openpackaging.parts.WordprocessingML.DocumentPart;
import org.docx4j.openpackaging.parts.WordprocessingML.HeaderPart;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.openpackaging.parts.relationships.RelationshipsPart;
import org.docx4j.relationships.Relationship;
import org.docx4j.relationships.Relationships;
import org.docx4j.vml.CTRect;
import org.docx4j.vml.CTShape;
import org.docx4j.vml.CTTextPath;
import org.docx4j.vml.CTTextbox;
import org.docx4j.wml.*;

import javax.xml.bind.JAXBElement;
import java.io.*;
import java.util.*;

import y.io.ImageOutputHandler;

/**
 * Created by cgj on 2017/5/9.
 */


public class DocxUtils {

    public static void main(String []argc) {
        String rootPath ="/docx/template/shanghai-company-anti-fraud-template.docx";
        String localPath ="D:\\bbdPrjIj\\wtyh-dv\\wtyh-web\\src\\main\\resources\\docx\\";
        String templateFile1 = localPath +"template\\shanghai-company-anti-fraud-template.docx";
        String targetPath = localPath +"target\\";
        String targetFileTail ="-anti-fraud1.docx";
        String companyName ="上海复旦复华药业有限公司";
//        File file1 = new File(localPath);
        //byte [] te = new byte[100];
        try {
            WordprocessingMLPackage wm; //= getTemplate(templateFile1);
            if(false) { //通过“关系结构”这种方式去查询目标对象
                RelationshipsPart relsPart = wm.getMainDocumentPart().getRelationshipsPart();
                Relationships rels = relsPart.getRelationships();
                List<Relationship> relsList = rels.getRelationship();
                Relationship r = relsList.get(1);
                Part p = relsPart.getPart(r);
                Chart chartPart = new Chart(p.getPartName());//这种写法是不行的
            }
            if(false) {
                Chart chart = (Chart) wm.getParts().get(new PartName("/word/charts/chart2.xml"));
                Object object = chart.getJaxbElement().getChart().getPlotArea().getAreaChartOrArea3DChartOrLineChart();
                Object object1 = chart.getContents().getChart().getPlotArea().getAreaChartOrArea3DChartOrLineChart();
            }


            //writeDocxToStream(wm, targetPath +companyName +targetFileTail );
            if(false) {
                List<?> paragraphList = wm.getMainDocumentPart().getContent(); //取主文档的段落为单位且以文档书写顺序排列的列表，会包含表格对象，此列表删除元素后会同步修改待保存的文档
                List<Object> paragraph1 = getAllElementFromObject(paragraphList.get(17), Text.class);
                List<Object> paragraph2 = getAllElementFromObject(paragraphList, CTTextbox.class);
                List<Object> paragraph21 = getAllElementFromObject(paragraph2, P.class);
                List<Object> paragraph3 = getAllElementFromObject(paragraphList.get(24), Text.class);
                List<Object> paragraph4 = getAllElementFromObject(paragraphList.get(24), P.class);

                List<Object> texts = getAllElementFromObject(wm.getMainDocumentPart(), Text.class);
                List<Object> paragraph = getAllElementFromObject(wm.getMainDocumentPart(), P.class); //段落才是操作文档的合理单位
                List<Object> ctTextbox = getAllElementFromObject(wm.getMainDocumentPart(), CTTextbox.class);
                //String txt = ((P) paragraph.get(18)).toString();

                paragraphList.remove(17);//删除段落
                paragraphList.remove(16);
                //paragraphList.re
                replaceTextInParagraph((P) paragraphList.get(17), "已被替换");
                //replacePlaceholder(wm, companyName, "headCompanyName");
            }
            //writeDocxToStream(wm, targetPath +companyName +targetFileTail );
/*            File fl =new File(".");
            FileOutputStream fos = new FileOutputStream (fl);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos.writeTo(fos);
            for( byte i =20; i >0; i-- ) {
                fos.write(i);
            }*/


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 //beans copy
    public static void objectCopy( Object source, Object target) {
        BeanCopier copier = BeanCopier.create(source.getClass(), target.getClass(), false);
        copier.copy(source, target, null);
    }



    /**
     * 修改段落中的字符串，保留原样式，请注意：若原段落中有多个Run时，只替换首个，其余删除
     * @param paragraph 待修改的 paragraph
     * @param replaceStr 提供的替换值
     */
    public static void replaceTextInParagraph( org.docx4j.wml.P paragraph, String replaceStr  ) {
        List removeColl =new LinkedList();
        List<Object> objs = paragraph.getContent();
        boolean firstMk =true;
        for( Object obj : objs ) {
            if( firstMk ) {
                replaceTextInRun((R)obj, replaceStr);
                firstMk =false;
            } else {
                //replaceTextInRun((R)obj, "");
                removeColl.add(obj);
            }
        }
        objs.removeAll(removeColl);
    }

    /**
     * 修改Run中的字符串，保留原样式，请注意：若原run中有多个字符串时，只替换首个，其余删除
     * @param run 待修改的run
     * @param replaceStr 提供的替换值
     */
    public static void replaceTextInRun( org.docx4j.wml.R run, String replaceStr  ) {
        List removeColl =new LinkedList();
        List<Object> objs = run.getContent();
        boolean firstMk =true;
        for( Object obj : objs ) {
            if( obj instanceof JAXBElement ) {
                obj =((JAXBElement)obj).getValue();
            }
            if(  obj instanceof Text ) {
                Text tmpT =(Text)obj;
                if( firstMk ) {
                    tmpT.setValue(replaceStr);
                    firstMk =false;
                } else {
                    //tmpT.setValue("");
                    removeColl.add(obj);
                }
            }
        }
        objs.removeAll(removeColl);
    }

    /**
     * 替换列表中的含有特定字符串的段落对象
     * @param objectList
     * @param signReplaceMap key：待替换的原字符串，value：用于替换原字符串的字符串
     * 快速构建参数 signReplaceMap：new HashMap<String, String>() {{put("$企业名称", "成都数联铭品");}}
     */
    public static void replacePlaceholder(List<?> objectList, Map<String, String> signReplaceMap ) {
        for (Object obj : objectList) {
            if( signReplaceMap.isEmpty() ) {
                break;
            }
            if( obj instanceof P ) {
                P paragraph = (P)obj;
                for( Map.Entry<String, String> entry : signReplaceMap.entrySet() ) {
                    if( entry.getKey().equals( docx4jObjectToString(paragraph) ) ) {
                        replaceTextInParagraph( paragraph, entry.getValue() );
                        signReplaceMap.remove( entry.getKey() );
                        break;
                    }
                }
            }
        }
    }

    public static String docx4jObjectToString( Object o ) {
        Writer aa = new StringWriter();
        try {
            TextUtils.extractText(o, aa);
        } catch (Exception e) {
            return "";
        }
        return aa.toString();
    }

    /**
     * 搜索指定类型的对象到列表
     * @param parentObj 待搜索的父级对象
     * @param toSearch 指定待获取的对象类型
     * @return
     */
    public static List<Object> getAllElementFromObject(Object parentObj, Class<?> toSearch) {
        List<Object> result = new ArrayList<Object>();
        if (parentObj instanceof JAXBElement)
            parentObj = ((JAXBElement<?>) parentObj).getValue();
        if (parentObj.getClass().equals(toSearch))
            result.add(parentObj);
            //以下代码用于为深度遍历“搭桥”
        else if (parentObj instanceof ContentAccessor) {
            List<?> children = ((ContentAccessor) parentObj).getContent();
            for (Object child : children) {
                result.addAll(getAllElementFromObject(child, toSearch));
            }
        } else if (parentObj instanceof Pict) {
            List<?> children = ((Pict) parentObj).getAnyAndAny();
            for (Object child : children) {
                result.addAll(getAllElementFromObject(child, toSearch));
            }
        } else if (parentObj instanceof CTShape) {
            List<?> children = ((CTShape) parentObj).getPathOrFormulasOrHandles();
            for (Object child : children) {
                result.addAll(getAllElementFromObject(child, toSearch));
            }
        } else if (parentObj instanceof CTRect) {
            List<?> children = ((CTRect) parentObj).getPathOrFormulasOrHandles();
            for (Object child : children) {
                result.addAll(getAllElementFromObject(child, toSearch));
            }
        } else if (parentObj instanceof CTTextbox) {
            List<?> children = ((CTTextbox) parentObj).getTxbxContent().getContent();
            for (Object child : children) {
                result.addAll(getAllElementFromObject(child, toSearch));
            }
        } else if (parentObj instanceof List ) {
            List<?> children = (List<?>) parentObj;
            for (Object child : children) {
                result.addAll(getAllElementFromObject(child, toSearch));
            }
        }
        return result;
    }

//    /**
//     *
//     * @param name
//     * @return 将模板文件载入到内存
//     * @throws Docx4JException
//     * @throws FileNotFoundException
//     */
//    public static WordprocessingMLPackage getTemplate(String name) throws Docx4JException, FileNotFoundException {
//        WordprocessingMLPackage template = WordprocessingMLPackage.load(new File(name));   //(new FileInputStream(new File(name)));
//        return template;
//    }
//
//    /**
//     * 将修改后的文件存盘
//     * @param wmp 修改完成的WordprocessingMLPackage
//     * @param target 指定待写入的目标文件（含路径）
//     * @throws IOException
//     * @throws Docx4JException
//     */
//    public static void writeDocxToStream(WordprocessingMLPackage wmp, String target) throws IOException, Docx4JException {
//        File f = new File(target);
//        wmp.save(f);
//    }
}
