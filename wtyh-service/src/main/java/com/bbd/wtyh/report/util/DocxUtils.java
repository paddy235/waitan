package com.bbd.wtyh.report.util;

import net.sf.cglib.beans.BeanCopier;
import org.docx4j.TextUtils;
import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.DrawingML.Chart;
import org.docx4j.openpackaging.parts.Part;
import org.docx4j.openpackaging.parts.PartName;
import org.docx4j.openpackaging.parts.relationships.Namespaces;
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
import java.math.BigInteger;
import java.util.*;

/**
 * Created by cgj on 2017/5/9.
 */


public class DocxUtils {

    /**
     * double值四舍五入转成指定位数小数的字符串
     * @param val 待转值
     * @param scale 保留的小数位数
     * @return 结果字符串
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
        List<Object> removeColl =new LinkedList<>();
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
        List<Object> removeColl =new LinkedList<>();
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
        List<Object> removeColl =new LinkedList<>();
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
     * @return 结果列表
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
    /**
     *  将目录表添加到文档.
     *
     *  首先我们创建段落. 然后添加标记域开始的指示符, 然后添加域内容(真正的目录表), 接着添加域
     *  结束的指示符. 最后将段落添加到给定文档的JAXB元素中.
     *
     *  @param paragraphs
     */
    public static void addTableOfContent(int idx, List<Object> paragraphs ) {
        //插入“目录”标题
        RPr catalogRPr = getRPr("华文细黑", "000000", "30", STHint.EAST_ASIA,
                true, false, false, false);
        P catalogP =addParagraphOfText("目录", catalogRPr);
        setParagraphSpacing( catalogP, JcEnumeration.CENTER, true, "0",
                "0", "200", "100", true,
                "240", STLineSpacingRule.AUTO);
        paragraphs.add(idx, catalogP);
        //插入目录
        ObjectFactory factory =Context.getWmlObjectFactory();
        P paragraph = factory.createP();
        addFieldBegin(paragraph);
        addTableOfContentField(paragraph);
        addFieldEnd(paragraph);
        paragraphs.add(idx +1, paragraph);
        addPageBreak( idx +2, paragraphs, STBrType.PAGE ); //插入分页符
    }

    /**
     *  将Word用于创建目录表的域添加到段落中.
     *
     *  首先创建一个可运行块和一个文本. 然后指出文本中所有的空格都被保护并给TOC域设置值. 这个域定义
     *  需要一些参数, 确切定义可以在Office Open XML标准的§17.16.5.58找到, 这种情况我们指定所有
     *  段落使用1-3级别的标题来格式化(\0 "1-3").
     *  最后使用文本对象创建了一个JAXB元素包含文本并添加到随后被添加到段落中的可运行块中.
     *
     *  @param paragraph
     */
    private static void addTableOfContentField(P paragraph) {
        ObjectFactory factory =Context.getWmlObjectFactory();
        R run = factory.createR();
        /*RPr cont = getRPr("华文细黑", "000000", "9", STHint.EAST_ASIA,
                true, false, false, false);
        run.setRPr(cont);*/
        Text txt = new Text();
        txt.setSpace("preserve");
        txt.setValue("TOC \\o \"1-3\" \\h \\z \\u");
        run.getContent().add(factory.createRInstrText(txt));
        paragraph.getContent().add(run);
    }

    /**
     *  每个域都需要用复杂的域字符来确定界限. 本方法向给定段落添加在真正域之前的界定符.
     *
     *  再一次以创建一个可运行块开始, 然后创建一个域字符来标记域的起始并标记域是'脏的'因为我们想要
     *  在整个文档生成之后进行内容更新.
     *  最后将域字符转换成JAXB元素并将其添加到可运行块, 然后将可运行块添加到段落中.
     *
     *  @param paragraph
     */
    private static void addFieldBegin(P paragraph) {
        ObjectFactory factory =Context.getWmlObjectFactory();
        R run = factory.createR();
        FldChar fldchar = factory.createFldChar();
        fldchar.setFldCharType(STFldCharType.BEGIN);
        fldchar.setDirty(true);
        run.getContent().add(getWrappedFldChar(fldchar));
        paragraph.getContent().add(run);
    }

    /**
     *  每个域都需要用复杂的域字符来确定界限. 本方法向给定段落添加在真正域之后的界定符.
     *
     *  跟前面一样, 从创建可运行块开始, 然后创建域字符标记域的结束, 最后将域字符转换成JAXB元素并
     *  将其添加到可运行块, 可运行块再添加到段落中.
     *
     *  @param paragraph
     */
    private static void addFieldEnd(P paragraph) {
        ObjectFactory factory =Context.getWmlObjectFactory();
        R run = factory.createR();
        FldChar fldcharend = factory.createFldChar();
        fldcharend.setFldCharType(STFldCharType.END);
        run.getContent().add(getWrappedFldChar(fldcharend));
        paragraph.getContent().add(run);
    }

    /**
     *  创建包含给定复杂域字符的JAXBElement的便利方法.
     *
     *  @param fldchar
     *  @return
     */
    public static JAXBElement getWrappedFldChar(FldChar fldchar) {
        return new JAXBElement(new QName(Namespaces.NS_WORD12, "fldChar"), FldChar.class, fldchar);
    }

    /**
     * 创建字体
     *
     * @param isBlod
     *            粗体
     * @param isUnderLine
     *            下划线
     * @param isItalic
     *            斜体
     * @param isStrike
     *            删除线
     */
    public static RPr getRPr(String fontFamily, String colorVal, String fontSize, STHint sTHint, boolean isBlod,
                      boolean isUnderLine, boolean isItalic, boolean isStrike) {
        ObjectFactory factory =Context.getWmlObjectFactory();
        RPr rPr = factory.createRPr();
        RFonts rf = new RFonts();
        rf.setHint(sTHint);
        rf.setAscii(fontFamily);
        rf.setHAnsi(fontFamily);
        rPr.setRFonts(rf);

        BooleanDefaultTrue bdt = factory.createBooleanDefaultTrue();
        rPr.setBCs(bdt);
        if (isBlod) {
            rPr.setB(bdt);
        }
        if (isItalic) {
            rPr.setI(bdt);
        }
        if (isStrike) {
            rPr.setStrike(bdt);
        }
        if (isUnderLine) {
            U underline = new U();
            underline.setVal(UnderlineEnumeration.SINGLE);
            rPr.setU(underline);
        }

        Color color = new Color();
        color.setVal(colorVal);
        rPr.setColor(color);

        HpsMeasure sz = new HpsMeasure();
        sz.setVal(new BigInteger(fontSize));
        rPr.setSz(sz);
        rPr.setSzCs(sz);
        return rPr;
    }

    // 设置段间距-->行距 段前段后距离
    // 段前段后可以设置行和磅 行距只有磅
    // 段前磅值和行值同时设置，只有行值起作用
    // TODO 1磅=20 1行=100 单倍行距=240 为什么是这个值不知道
    /**
     * @param jcEnumeration
     *            对齐方式
     * @param isSpace
     *            是否设置段前段后值
     * @param before
     *            段前磅数
     * @param after
     *            段后磅数
     * @param beforeLines
     *            段前行数
     * @param afterLines
     *            段后行数
     * @param isLine
     *            是否设置行距
     * @param lineValue
     *            行距值
     * @param sTLineSpacingRule
     *            自动auto 固定exact 最小 atLeast
     */
    public static void setParagraphSpacing(P p, JcEnumeration jcEnumeration, boolean isSpace, String before,
                                    String after, String beforeLines, String afterLines,
                                    boolean isLine, String lineValue,
                                    STLineSpacingRule sTLineSpacingRule) {
        ObjectFactory factory =Context.getWmlObjectFactory();
        PPr pPr = p.getPPr();
        if (pPr == null) {
            pPr = factory.createPPr();
        }
        Jc jc = pPr.getJc();
        if (jc == null) {
            jc = new Jc();
        }
        jc.setVal(jcEnumeration);
        pPr.setJc(jc);
        PPrBase.Spacing spacing = new PPrBase.Spacing();
        if (isSpace) {
            if (before != null) {
                // 段前磅数
                spacing.setBefore(new BigInteger(before));
            }
            if (after != null) {
                // 段后磅数
                spacing.setAfter(new BigInteger(after));
            }
            if (beforeLines != null) {
                // 段前行数
                spacing.setBeforeLines(new BigInteger(beforeLines));
            }
            if (afterLines != null) {
                // 段后行数
                spacing.setAfterLines(new BigInteger(afterLines));
            }
        }
        if (isLine) {
            if (lineValue != null) {
                spacing.setLine(new BigInteger(lineValue));
            }
            spacing.setLineRule(sTLineSpacingRule);
        }
        pPr.setSpacing(spacing);
        p.setPPr(pPr);
    }

    public static P addParagraphOfText( String text, RPr rpr ) {
        ObjectFactory factory =Context.getWmlObjectFactory();
        P paragraph = factory.createP();
        Text txt = factory.createText();
        txt.setValue(text);
        R run = factory.createR();
        run.getContent().add(txt);
        run.setRPr(rpr);
        paragraph.getContent().add(run);
        return paragraph;
    }


    // 分页
    public static void addPageBreak(int idx, List<Object> paragraphs, STBrType sTBrType) {
        ObjectFactory factory =Context.getWmlObjectFactory();
        Br breakObj = new Br();
        breakObj.setType(sTBrType);
        P paragraph = factory.createP();
        paragraph.getContent().add(breakObj);
        paragraphs.add(idx, paragraph);
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
