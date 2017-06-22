package com.bbd.wtyh.report.util;

import net.sf.cglib.beans.BeanCopier;
import org.docx4j.TextUtils;
import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.DrawingML.Chart;
import org.docx4j.openpackaging.parts.Part;
import org.docx4j.openpackaging.parts.PartName;
import org.docx4j.openpackaging.parts.relationships.RelationshipsPart;
import org.docx4j.relationships.Relationship;
import org.docx4j.relationships.Relationships;
import org.docx4j.vml.CTRect;
import org.docx4j.vml.CTShape;
import org.docx4j.vml.CTTextbox;
import org.docx4j.wml.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.namespace.QName;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by cgj on 2017/5/9.
 */


public class DocxUtils {

    /**
     * double值四舍五入转成指定位数小数的字符串
     * @param val 待转值
     * @param scale 保留的小数位数
     * @return
     */
    public static String doubleToString(double val, int scale ) {
        BigDecimal perVal  =BigDecimal.valueOf( val );
        perVal =  perVal.setScale( scale, BigDecimal.ROUND_HALF_UP );
        return perVal.toString();
    }

    //beans copy，理论上说这个不能用于xml对象的深度复制，具体也没验证过
    public static void objectCopy( Object source, Object target) {
        BeanCopier copier = BeanCopier.create(source.getClass(), target.getClass(), false);
        copier.copy(source, target, null);
    }

    //此方法来源于对“org.docx4j.XmlUtils.deepCopy()”的修改
    public static <T> T deepCopy(T value ) {
        JAXBContext jc = Context.jc;
        if (value==null) {
            throw new IllegalArgumentException("Can't clone a null argument");
        }
        JAXBElement<T> elem;
        try {
            if (value instanceof JAXBElement<?>) {
                Object wrapped = ((JAXBElement)value).getValue();
                @SuppressWarnings("unchecked")
                Class clazz = wrapped.getClass();
                //原来的语句：JAXBElement contentObject = new JAXBElement(new QName(clazz.getSimpleName()), clazz, wrapped);
                JAXBElement contentObject = new JAXBElement(((JAXBElement)value).getName(), clazz, wrapped);
                JAXBSource source = new JAXBSource(jc, contentObject);
                elem = jc.createUnmarshaller().unmarshal(source, clazz);
            } else {
                // Usual case
                @SuppressWarnings("unchecked")
                Class<T> clazz = (Class<T>) value.getClass();
                JAXBElement<T> contentObject = new JAXBElement<T>(new QName(clazz.getSimpleName()), clazz, value);
                JAXBSource source = new JAXBSource(jc, contentObject);
                elem = jc.createUnmarshaller().unmarshal(source, clazz);
            }

			/*
			 * Losing content here?
			 *
			 * First, make absolutely sure that what you have is valid.
			 *
			 * For example, Word 2010 is happy to open w:p/w:pict
			 * (as opposed to w:p/w:r/w:pict).
			 * docx4j is happy to marshall w:p/w:pict, but not unmarshall it,
			 * so that content would get dropped here.
			 */

            T res;
            if (value instanceof JAXBElement<?>) {
                @SuppressWarnings("unchecked")
                T resT = (T) elem;
                res = resT;
            } else {
                @SuppressWarnings("unchecked")
                T resT = (T) elem.getValue();
                res = resT;
            }
//			log.info("deep copy success!");
            return res;
        } catch (JAXBException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    /**
     * 修改Run中的字符串，保留原样式，请注意：若原run中有多个字符串时，只修改首个中的文本，其余删除
     * @param run 待修改的run
     * @param replaceStr 提供的替换值
     */
    public static void modifyTextInRun(R run, String replaceStr  ) {
        if(!( run instanceof R )) {
            return;
        }
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
     * 修改段落中的字符串，保留原样式，请注意：若原段落中有多个Run时，只修改首个中的文本，其余删除
     * @param paragraph 待修改的 paragraph
     * @param replaceStr 提供的替换值
     */
    public static void modifyTextInParagraph( P paragraph, String replaceStr ) {
        if(!( paragraph instanceof P )) {
            return;
        }
        List removeColl =new LinkedList();
        List<Object> objs = paragraph.getContent();
        boolean firstMk =true;
        for( Object obj : objs ) {
            if( obj instanceof R ) {
                if (firstMk) {
                    modifyTextInRun((R) obj, replaceStr);
                    firstMk = false;
                } else {
                    removeColl.add(obj);
                }
            }
        }
        objs.removeAll(removeColl);
    }

    /**
     * 修改修改表格单元格中的字符串，保留原样式，请注意：若原单元格中有多个段落时，只修改首个中的文本，其余删除
     * @param tc 待修改的 Tc
     * @param replaceStr 提供的替换值
     */
    public static void modifyTextInTc( Tc tc, String replaceStr  ) {
        if(!( tc instanceof Tc )) {
            return;
        }
        List removeColl =new LinkedList();
        List<Object> list = tc.getContent();
        boolean firstMk =true;
        for( Object obj : list ) {
            if( obj instanceof P ) {
                if (firstMk) {
                    modifyTextInParagraph((P) obj, replaceStr);
                    firstMk = false;
                } else {
                    removeColl.add(obj);
                }
            }
        }
        list.removeAll(removeColl);
    }

    /**
     * 替换列表中的含有特定字符串的段落对象
     * @param objectList
     * @param signReplaceMap key：待替换的原字符串，value：用于替换原字符串的字符串
     * 快速构建参数 signReplaceMap：new HashMap<String, String>() {{put("$企业名称", "成都数联铭品");}}
     */
    public static void replacePlaceholder(List<?> objectList, Map<String, String> signReplaceMap ) {
        if( objectList ==null || objectList.isEmpty() || signReplaceMap ==null || signReplaceMap.isEmpty() ) {
            return;
        }
        for (Object obj : objectList) {
            if( obj instanceof P ) {
                P paragraph = (P)obj;
                for( Map.Entry<String, String> entry : signReplaceMap.entrySet() ) {
                    if( entry.getKey().equals( docx4jObjectToString(paragraph) ) ) {
                        modifyTextInParagraph( paragraph, entry.getValue() );
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
        if(parentObj ==null) {
            return result;
        }
        if (parentObj instanceof JAXBElement)
            parentObj = ((JAXBElement<?>) parentObj).getValue();
        if (parentObj.getClass().equals(toSearch)) {
            result.add(parentObj);
            //以下代码用于为深度遍历“搭桥”
        } else if (parentObj instanceof List ) {
            List<?> children = (List<?>) parentObj;
            for (Object child : children) {
                result.addAll(getAllElementFromObject(child, toSearch));
            }
        } else if (parentObj instanceof ContentAccessor) {
            List<?> children = ((ContentAccessor) parentObj).getContent();
            for (Object child : children) {
                result.addAll(getAllElementFromObject(child, toSearch));
            }
        } else if (parentObj instanceof Pict) {
            List<?> children = ((Pict) parentObj).getAnyAndAny();
            for (Object child : children) {
                result.addAll(getAllElementFromObject(child, toSearch));
            }
        } else if (parentObj instanceof CTShape ) {
            List<?> children = ((CTShape) parentObj).getEGShapeElements();
            for (Object child : children) {
                result.addAll(getAllElementFromObject(child, toSearch));
            }
        } else if (parentObj instanceof CTRect) {
            List<?> children = ((CTRect) parentObj).getEGShapeElements();
            for (Object child : children) {
                result.addAll(getAllElementFromObject(child, toSearch));
            }
        } else if (parentObj instanceof CTTextbox) {
            List<?> children = ((CTTextbox) parentObj).getTxbxContent().getContent();
            for (Object child : children) {
                result.addAll(getAllElementFromObject(child, toSearch));
            }
        }
        return result;
    }


    public static void main(String []argc) {
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
                //Object object = chart.getJaxbElement().getChart().getPlotArea().getAreaChartOrArea3DChartOrLineChart();
                Object object1 = chart.getContents().getChart().getPlotArea().getAreaChartOrArea3DChartOrLineChart();
            }

            if(false) {
                List<?> paragraphList = wm.getMainDocumentPart().getContent(); //取主文档的段落为单位且以文档书写顺序排列的列表，会包含表格对象，此列表删除元素后会同步修改待保存的文档
                List<Object> paragraph1 = getAllElementFromObject(paragraphList.get(17), Text.class);
                List<Object> paragraph2 = getAllElementFromObject(paragraphList, CTTextbox.class);
                List<Object> paragraph21 = getAllElementFromObject(paragraph2, P.class);

                List<Object> paragraph = getAllElementFromObject(wm.getMainDocumentPart(), P.class); //段落才是操作文档的合理单位

                paragraphList.remove(17);//删除段落
                //paragraphList.re
                modifyTextInParagraph((P) paragraphList.get(17), "已被替换");
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
