package com.bbd.wtyh.report.util;

import com.bbd.wtyh.web.relationVO.RelationDiagramVO;
import org.apache.commons.lang.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

/**
 * Created by cgj on 2017/6/15.
 */
public class DrawRelated {

    /** 绘图是否成功*/
    boolean drawSucceed =true;

    protected BufferedImage image;
    protected Graphics2D g2d;

    //图片尺寸
    protected int imgWidth = 720;
    protected int imgHigh = 720;
    protected double leHO =68; //图例外高度
    
    //色值
    protected static final Color C_TEXT_LEG =new Color(178,178,178); //图例文本
    protected static final Color C_TEXT =new Color(217,217,217); //正文文本
    protected Color textColor =C_TEXT_LEG; //文本颜色
    protected void setTextColor(Color textColor) {
        this.textColor = textColor;
    }
    protected Color cTargetCompany =new Color(254,0,0); //目标公司
    protected Color cSonCompany =new Color(255,202,0); //子公司
    protected Color cFirDegree =new Color(0,48,176); //一度
    protected Color cSecDegree =new Color(54,179,235); //二度
    protected Color cThiDegree =new Color(193,193,193); //三度
    protected Color cArrowLine =new Color(60,120,140); //箭头线 Color(65,132,156);
    protected Color cMainBkg =new Color(43,50,60); //主背景
    protected Color cLegendBkg =new Color(26,32,41); //图例背景
    protected Color cTagBkg =new Color(71,79,92); //标签背景
    //字体
    protected static Font FONT_LEG ; //图例字体
    protected static Font FONT_NORMAL; //常规字体
    static {
        if( ( FONT_LEG = new Font("微软雅黑" ,Font.PLAIN,12) ) !=null ) {
            FONT_NORMAL =new Font("微软雅黑" ,Font.PLAIN,10);
        }
        else if( ( FONT_LEG = new Font("文泉驿正黑" ,Font.PLAIN,13) ) !=null ) {
            FONT_NORMAL =new Font("文泉驿正黑" ,Font.PLAIN,11);
        }
        else if( ( FONT_LEG = new Font("文泉驿微米黑" ,Font.PLAIN,13) ) !=null ) {
            FONT_NORMAL =new Font("文泉驿微米黑" ,Font.PLAIN,11);
        }
        else {
            FONT_LEG =new Font("Default" ,Font.PLAIN,13);
            FONT_NORMAL =new Font("Default" ,Font.PLAIN,11);
        }
    }
    protected Font font; //
    protected void setFont(Font font) {
        this.font = font;
        g2d.setFont(font);
    }
    //
    protected static final float NODE_GRAPHIC_NORMAL =10f; //节点图形尺寸-正常
    protected static final float NODE_GRAPHIC_LEGEND =5f; //节点图形尺寸-图例

    protected static final float ARROW_LINE_WIDTH_NORMAL =1f; //箭头线宽-正常
    protected float ngrSize = NODE_GRAPHIC_NORMAL; //节点图形的尺寸（“半径”）
    protected void setNgrSize(float ngrSize) {
        this.ngrSize = ngrSize;
    }

    protected void initBlock() {
        image = new BufferedImage(imgWidth, imgHigh,BufferedImage.TYPE_INT_RGB); // 创建BufferedImage对象
        g2d = image.createGraphics(); // 获取Graphics2D
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //消锯齿
        g2d.setBackground(cMainBkg);
        g2d.clearRect(0, 0, imgWidth, imgHigh);
        setFont(FONT_NORMAL);
    }
    public DrawRelated() {
        initBlock();
    }

    //以坐标为中心画公司节点图形
    protected void drawCompanyGraphicAtCen( double cx, double cy, Color cr ) {
        g2d.setPaint(cr);
        Rectangle2D rec2D =new Rectangle2D.Double(cx - ngrSize, cy - ngrSize, ngrSize *2, ngrSize *2 );
        g2d.fill(rec2D);
    }
    //以坐标为中心画自然人节点图形
    protected void drawPersonGraphicAtCen( double cx, double cy, Color cr ) {
        g2d.setPaint(cr);
        Ellipse2D ell2D =new Ellipse2D.Double(cx - ngrSize, cy - ngrSize, ngrSize *2, ngrSize *2 );
        g2d.fill(ell2D);
    }

    //以坐标为中心画文本
    protected void drawTextAtCen(String str, double x, double cy, boolean xCen ) {
        g2d.setPaint(textColor); //设置颜色
        float fontSz =font.getSize();
        //cy += fontSz/2;
        cy =cy +(fontSz*0.4);
        if(xCen) {
            x -= (double)(g2d.getFontMetrics().stringWidth(str) )/2;
        }
        g2d.drawString(str,(float)x, (float)cy);
    }

    //画箭头
    protected void drawArrowLine( double ox, double oy, double tx, double ty, boolean solidLine,  float width ) {
        float [] lineType =null;
        if( !solidLine ) {
            lineType  =new float[]{width *4, width *4};
        }
        BasicStroke basicStroke =new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, width *3,
                lineType, 0);
        g2d.setStroke(basicStroke);
        Line2D li2d =new Line2D.Double(ox, oy ,tx, ty);
        g2d.draw(li2d);
        double mvX =ngrSize *1.2D;
        double mvY =-0.1D;
        //准备箭头坐标集合
        double [][]ptArr =new double[][]{
                new double[]{mvX, mvY},
                new double[]{mvX +width*8, mvY +width*5 },
                new double[]{mvX +width*4, mvY },
                new double[]{mvX +width*8, mvY -width*5 }, };
        GeneralPath gp =new GeneralPath(GeneralPath.WIND_NON_ZERO);
        gp.moveTo(ptArr[0][0], ptArr[0][1]);
        gp.lineTo(ptArr[1][0], ptArr[1][1]);
        gp.lineTo(ptArr[2][0], ptArr[2][1]);
        gp.lineTo(ptArr[3][0], ptArr[3][1]);
        gp.closePath();
        //坐标旋转变换
        Double dltX =ox-tx;
        Double dltY =oy-ty;
        AffineTransform at =new AffineTransform();
        at.rotate(dltX, dltY, tx, ty); //传tx、ty不合理，但是结果是正确的，其他方式无法得到正确结果
        at.translate(tx, ty);
        g2d.fill(at.createTransformedShape(gp));
    }

    //画图例，leHO 图例外高
    private void drawLegend( /*double leHO*/ ) {
        double bouWidth =10D;              //边界宽度 boundaryWidth
        double leX =bouWidth;
        double leY =bouWidth;
        double leW = imgWidth -bouWidth *2;
        double leH =leHO -bouWidth *2;
        g2d.setPaint(cLegendBkg);
        Rectangle2D rec2D =new Rectangle2D.Double(leX, leY, leW, leH );
        g2d.fill(rec2D);

        double dltW =leW/4;
        double dltW1 =dltW/3;
        double dltW2 =dltW1/2;
        double dltH1 =leH/4;
        setNgrSize(NODE_GRAPHIC_LEGEND); //设置成图例尺寸
        setFont(FONT_LEG);
        setTextColor(C_TEXT_LEG);

        drawCompanyGraphicAtCen(leX +dltW2 +dltW*0, leY +dltH1 +dltH1*2 *0, cTargetCompany);
        drawTextAtCen( "目标公司", leX +dltW1 +dltW*0, leY +dltH1 +dltH1*2 *0, false );

        drawCompanyGraphicAtCen(leX +dltW2 +dltW*0, leY +dltH1 +dltH1*2 *1, cSonCompany);
        drawTextAtCen( "子公司", leX +dltW1 +dltW*0, leY +dltH1 +dltH1*2 *1, false );

        drawCompanyGraphicAtCen(leX +dltW2 +dltW*1, leY +dltH1 +dltH1*2 *0, cFirDegree);
        drawTextAtCen( "一度关联公司", leX +dltW1 +dltW*1, leY +dltH1 +dltH1*2 *0, false );

        drawPersonGraphicAtCen(leX +dltW2 +dltW*1, leY +dltH1 +dltH1*2 *1, cFirDegree);
        drawTextAtCen( "一度关联自然人", leX +dltW1 +dltW*1, leY +dltH1 +dltH1*2 *1, false );

        drawCompanyGraphicAtCen(leX +dltW2 +dltW*2, leY +dltH1 +dltH1*2 *0, cSecDegree);
        drawTextAtCen( "二度关联公司", leX +dltW1 +dltW*2, leY +dltH1 +dltH1*2 *0, false );

        drawPersonGraphicAtCen(leX +dltW2 +dltW*2, leY +dltH1 +dltH1*2 *1, cSecDegree);
        drawTextAtCen( "二度关联自然人", leX +dltW1 +dltW*2, leY +dltH1 +dltH1*2 *1, false );

        double ceX =leX +dltW2 +dltW*3, ceY =leY +dltH1 +dltH1*2 *0;
        g2d.setPaint(cArrowLine);
        drawArrowLine(ceX -dltW2, ceY, ceX +dltW2, ceY, true, 1);
        drawTextAtCen( "投资人", leX +dltW1 +dltW2/2 +dltW*3, leY +dltH1 +dltH1*2 *0, false );

        //drawPersonGraphicAtCen(leX +dltW2 +dltW*3, leY +dltH1 +dltH1*2 *1, cArrowLine);
        ceX =leX +dltW2 +dltW*3; ceY =leY +dltH1 +dltH1*2 *1;
        g2d.setPaint(cArrowLine);
        drawArrowLine(ceX -dltW2, ceY, ceX +dltW2, ceY, false, 1);
        drawTextAtCen( "企业高管", leX +dltW1 +dltW2/2 +dltW*3, leY +dltH1 +dltH1*2 *1, false );

    }

    /**
    * 画关联图
    * @param nodeList 节点数组，一维含义{"Id","name","pntType"},nodeType:["0t":目标公司, "1c":子公司, "1e":一度公司,
    *                "1r":一度自然人, "2e":二度公司, "2r":二度自然人]
    * @param lineList 连续数组，一维含义{"oriId","tagId","lineType"},lineType:["1":line, "0":dot]
    */
	public void drawRelated( List<String[]> nodeList, List<String[]> lineList) {
		if (nodeList == null || lineList == null) {
		    drawSucceed =false;
			return;
		}
		// 画图例
		drawLegend();
		//
		double rdHO = imgHigh - leHO; // 关联图外高
		double textDown = 25D; // 文字下沉尺度
		double firOffset = 0; // Math.PI/40; //一度节点起始偏移的弧度数
		double secOffset = 0; // Math.PI/-60; //二度节点起始偏移的弧度数
		double bouWidth = 10D; // 边界宽度 boundaryWidth
		double rdX = bouWidth; // 绘图区起点x
		double rdY = imgHigh - rdHO; // 绘图区起点y
		double rdW = imgWidth - bouWidth * 2; // 绘图区宽度
		double rdH = rdHO - bouWidth * 1; // 绘图区高度
		double rdcX = rdX + rdW / 2; // 绘图区中心x
		double rdcY = rdY + rdH / 2; // 绘图区中心y
		double firRadius = 1 * rdW / 6; // 一度半径
		double secRadius = 2 * rdW / 6; // 二度半径
		int firDegreeStart = 1; // 默认idx =0，存目标公司
		int firDegreeTotal = 0; // 一度节点总数
		// 统计一度节点总数
		for (String[] node : nodeList) {
			if (node.length > 2) {
				String nodeType = node[2];
				if (nodeType != null && nodeType.length() > 1 && '1' == nodeType.charAt(0)) {
					firDegreeTotal++;
				}
			}
		}
		if (0 == firDegreeTotal) {
			return;
		}
		int secDegreeStart = firDegreeStart + firDegreeTotal;
		int secDegreeTotal = nodeList.size() - 1 - firDegreeTotal; // 二度节点总数
		double[][] coordinateArr = new double[nodeList.size()][2]; // 创建节点坐标数组
		// 设置目标公司坐标
		coordinateArr[0][0] = rdcX;
		coordinateArr[0][1] = rdcY;
		if (secDegreeTotal <= 0) {
			firRadius *= 1.2; // 没有二度公司时，适当增大一度半径
		} else { // 计算二度坐标
			double scale = 2 * Math.PI / secDegreeTotal;
			for (int idx = 0; idx < secDegreeTotal; idx++) {
				coordinateArr[secDegreeStart + idx][0] = rdcX + secRadius * Math.cos(scale * idx + secOffset);
				coordinateArr[secDegreeStart + idx][1] = rdcY + secRadius * Math.sin(scale * idx + secOffset);
			}
		}
		// 计算一度坐标
		double scale = 2 * Math.PI / firDegreeTotal;
		for (int idx = 0; idx < firDegreeTotal; idx++) {
			coordinateArr[firDegreeStart + idx][0] = rdcX + firRadius * Math.cos(scale * idx + firOffset);
			coordinateArr[firDegreeStart + idx][1] = rdcY + firRadius * Math.sin(scale * idx + firOffset);
		}
		SearchCoordinate searchCoordinate = (String Id) -> {
			if (StringUtils.isBlank(Id)) {
				return null;
			}
			for (int idx = 0; idx < nodeList.size(); idx++) {
				String[] node = nodeList.get(idx);
				if (node.length > 0) {
					String sId = node[0];
					if (StringUtils.isNotBlank(sId) && sId.equals(Id)) {
						// coordinate[0] =coordinateArr[idx][0];
						// coordinate[1] =coordinateArr[idx][1];
						return coordinateArr[idx];
					}
				}
			}
			return null;
		};

		// 画关联箭头线
		g2d.setPaint(cArrowLine);
		setNgrSize(NODE_GRAPHIC_NORMAL);
		for (String[] line : lineList) {
			if (line.length > 2) {
				double[] oriCoordinate = searchCoordinate.fun(line[0]);
				double[] tagCoordinate = searchCoordinate.fun(line[1]);
				Boolean isLine = null;
				if (StringUtils.isNotBlank(line[2])) {
					if ('1' == line[2].charAt(0)) {
						isLine = true;
					} else if ('0' == line[2].charAt(0)) {
						isLine = false;
					}
				}
				if (oriCoordinate != null && tagCoordinate != null && isLine != null) {
					drawArrowLine(oriCoordinate[0], oriCoordinate[1], tagCoordinate[0], tagCoordinate[1], isLine, ARROW_LINE_WIDTH_NORMAL);
				}
			}
		}

		// 画文字和节点
		// setNgrSize(NODE_GRAPHIC_NORMAL);
		setFont(FONT_NORMAL);
		setTextColor(C_TEXT);
		for (String[] node : nodeList) {
			if (node != null && node.length > 2 && StringUtils.isNotBlank(node[1])) { // [1]name
				double[] coordinate = searchCoordinate.fun(node[0]);
				String nodeType = node[2];
				Color color = null;
				Boolean isCompany = null;
				if (nodeType != null && nodeType.length() > 1) {
					if ('0' == nodeType.charAt(0)) {
						color = cTargetCompany;
						isCompany = true;
					} else if ('1' == nodeType.charAt(0)) {
						color = cFirDegree;
					} else if ('2' == nodeType.charAt(0)) {
						color = cSecDegree;
					}
					if ('e' == nodeType.charAt(1)) {
						isCompany = true;
					} else if ('r' == nodeType.charAt(1)) {
						isCompany = false;
					} else if ('c' == nodeType.charAt(1)) {
						color = cSonCompany;
						isCompany = true;
					}
				}
				if (coordinate != null && color != null && isCompany != null) {
					drawTextAtCen(node[1], coordinate[0], coordinate[1] + textDown, true); // 画文字
                    //画节点
					if (isCompany) {
						drawCompanyGraphicAtCen(coordinate[0], coordinate[1], color); // 公司
					} else {
						drawPersonGraphicAtCen(coordinate[0], coordinate[1], color); // 自然人
					}
				}
			}
		}
	}

    @FunctionalInterface
    interface SearchCoordinate {
        double [] fun( String Id );
    };

    public static void main(String []argc) {

        DrawRelated dr =new DrawRelated();
        /**
         * 画关联图
         * @param nodeArr 节点数组，一维含义{"Id","name","pntType"},nodeType:["0t":目标公司, "1c":子公司, "1e":一度公司,
         *                "1r":一度自然人, "2e":二度公司, "2r":二度自然人]
         * @param lineArr 连续数组，一维含义{"oriId","tagId","lineType"},lineType:["1":line, "0":dot]
         */

        dr.drawRelated(
                new LinkedList<String[]>(){{
                    add( new String[]{ "000", "Target", "0t" } );
                    add( new String[]{ "001", "1自然a", "1r" } );
                    add( new String[]{ "002", "子公司c", "1c" } );
                    add( new String[]{ "003", "子公司b", "1c" } );
                    add( new String[]{ "004", "一度公司", "1e" } );
                    add( new String[]{ "005", "1自然b", "1r" } );
                    add( new String[]{ "006", "子公司a", "1c" } );
                    add( new String[]{ "007", "一度公司b", "1e" } );
                    add( new String[]{ "008", "一度公司a", "1e" } ); }},
                new LinkedList<String[]>(){{
                    add( new String[] { "000", "002", "1" } );
                    add( new String[] { "000", "003", "1" } );
                    add( new String[] { "000", "006", "1" } );
                    add( new String[] { "005", "000", "0" } );
                    add( new String[] { "001", "000", "0" } );
                    add( new String[] { "004", "000", "1" } );
                    add( new String[] { "007", "000", "1" } );
                    add( new String[] { "008", "000", "1" } );
                    add( new String[] { "008", "003", "1" } );
                }} );

        ////测试
        //dr.testText( );
        //dr.testArrow( );

        String dateTimeStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        dr.saveFile("C:\\Users\\Administrator\\Desktop\\test_" +dateTimeStr +".png");
    }

    //nodeArr {"Id","name","pntType"},nodeType:["0t":目标公司, "1c":子公司, "1e":一度公司, "1r":一度自然人, "2e":二度公司, "2r":二度自然人]
    public List<String[]> relationDiagramVoToNodeList(RelationDiagramVO rVO) {
        if( rVO ==null || rVO.getPointList() ==null )
            return null;
        List<RelationDiagramVO.PointVO> rpVoList =rVO.getPointList();
        List<String[]> nodeList = new ArrayList<>();
        List<String[]> nodeList2 = new ArrayList<>();
        for ( int idx =0; idx <rpVoList.size(); idx++ ) {
            RelationDiagramVO.PointVO rpVo = rpVoList.get(idx);
            if( rpVo !=null ) {
                int degree =1000;
                String []node ={"","",""};//Id,name,nodeType
                if( StringUtils.isNotBlank( rpVo.getName() ) ) {
                    node[0] =rpVo.getName();
                } else continue;
                if( StringUtils.isNotBlank( rpVo.getCname() ) ) {
                    node[1] =rpVo.getCname();
                } else continue;
                if( StringUtils.isNotBlank(rpVo.getLevel()) ) {
                    if( rpVo.getLevel().equals("1") ) {
                        node[2] ="1"; degree =1;
                    } else if ( rpVo.getLevel().equals("2") ) {
                        node[2] ="2"; degree =2;
                    } else if ( rpVo.getLevel().equals("0") ) {
                        node[2] ="0t";
                        nodeList.add(0,node);
                        continue; //特殊处理
                    } else {
                        continue;
                    }
                }
                if( StringUtils.isNotBlank(rpVo.getIsPerson()) ) {
                    if( rpVo.getIsPerson().equals("1") ) {
                        node[2] +="r";
                    } else if ( rpVo.getIsPerson().equals("0") ) {
                        node[2] +="e";
                    } else {
                        continue;
                    }
                }
                if( StringUtils.isNotBlank( rpVo.getIsSonCom() ) ) {
                    if( rpVo.getIsSonCom().equals("1") ) {
                        node[2] = node[2].charAt(0) +"c";
                    } else if ( rpVo.getIsSonCom().equals("0") ) {
                        //node[2] = node[2].charAt(0) +"e";
                    } else {
                        continue;
                    }
                }
                if( 1 ==degree )
                    nodeList.add(node);
                else if ( 2 ==degree )
                    nodeList2.add(node);
            }
        }
        nodeList.addAll(nodeList2);
        return nodeList;
    }

    //lineArr 连续数组，一维含义{"oriId","tagId","lineType"},lineType:["1":line, "0":dot]
    public List<String[]> relationDiagramVoToLineList(RelationDiagramVO rVO) {
        if( rVO ==null || rVO.getLineList() ==null )
            return null;
        List<RelationDiagramVO.LineVO> rpVoList =rVO.getLineList();
        List<String[]> lineList = new ArrayList<>();
        for ( int idx =0; idx <rpVoList.size(); idx++ ) {
            RelationDiagramVO.LineVO rlVo = rpVoList.get(idx);
            if( rlVo !=null ) {
                String []line ={"","",""};//"oriId","tagId","lineType"
                if( StringUtils.isNotBlank( rlVo.getOrig() ) ) {
                    line[0] =rlVo.getOrig();
                } else continue;
                if( StringUtils.isNotBlank( rlVo.getTarget() ) ) {
                    line[1] =rlVo.getTarget();
                } else continue;
                if( StringUtils.isNotBlank( rlVo.getIsFullLine() ) ) {
                    if( rlVo.getIsFullLine().equals("1") ) {
                        line[2] +="1";
                    } else if ( rlVo.getIsFullLine().equals("0") ) {
                        line[2] +="0";
                    } else {
                        continue;
                    }
                }
                lineList.add(line);
            }
        }
        return lineList;
    }

    //保存到指定路径及名称
    public String saveFile( String fileName ) {
        g2d.dispose(); //释放对象
        if( !drawSucceed ) {
            return null;
        }
        try { //保存图像数据
            ImageIO.write(image, "png", new File(fileName));
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return fileName;
    }

    //返回存放图片的字节数组
    public byte [] saveToBytes( ) {
        g2d.dispose(); //释放对象
        if( !drawSucceed ) {
            return null;
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try { //保存图像数据
            ImageIO.write(image, "png", bos);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return bos.toByteArray();
    }

    //文本测试
    protected void testText( ) {
        //g2d.drawRect(100,300, 99,11);
        drawCompanyGraphicAtCen(100,300, cSecDegree);
        Line2D pt2d =new Line2D.Double(100, 300, 100, 300);
        g2d.setPaint(cTargetCompany);
        g2d.draw(pt2d);
        drawTextAtCen("这是一个忧伤的故事", 105, 300, false);
        pt2d =new Line2D.Double(105, 300, 105, 300);
        g2d.setPaint(cSonCompany);
        g2d.draw(pt2d);
        //drawTextAtCen("这是一个忧伤的故事", 100, 300, false);
        //g2d.setPaint(cSonCompany);
        //drawTextAtCen("这是一个忧伤的故事", 100, 300, true);
    }

    //箭头测试
    protected void testArrow( ) {
        g2d.setPaint(cArrowLine);
        setNgrSize(NODE_GRAPHIC_NORMAL);
        Double ox =300D;
        Double oy =300D;
        drawArrowLine(ox +100, oy +0, ox, oy, true, 1 );
        drawArrowLine(ox +100, oy +100, ox, oy, false, 1 );
        drawArrowLine(ox +0, oy +100, ox, oy, true, 1 );
        drawArrowLine(ox -100, oy +100, ox, oy, true, 1 );
        drawArrowLine(ox -100, oy +0, ox, oy, true, 1 );
        drawArrowLine(ox -100, oy -100, ox, oy, true, 1 );
        drawArrowLine(ox +0, oy -100, ox, oy, true, 1 );
        drawArrowLine(ox +100, oy -100, ox, oy, true, 1 );
        //drawArrowLine(500, 400, 300, 400, true, 5 );
        //drawArrowLine(500, 500, 300, 500, true, 10 );
    }
}
