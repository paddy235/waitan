package com.bbd.wtyh.report.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Administrator on 2017/6/15.
 */
public class DrawRelated {
    private BufferedImage image;
    private Graphics2D g2d;
    //图片尺寸
    private int width = 720;
    private int height = 720;
    //色值
    private Color cText =new Color(220,220,220); //文本
    private Color cTargetCompany =new Color(254,0,0); //目标公司
    private Color cChildCompany =new Color(255,202,0); //子公司
    private Color cFirDegree =new Color(0,48,176); //一度
    private Color cSecDegree =new Color(54,179,235); //二度
    private Color cThiDegree =new Color(193,193,193); //三度
    private Color cArrowLine =new Color(65,132,156); //箭头线
    private Color cMainBkg =new Color(43,50,60); //主背景
    private Color cLegendBkg =new Color(26,32,41); //图例背景
    private Color cTagBkg =new Color(71,79,92); //标签背景
    //字体
    private Font fontLeg=new Font("黑体" ,Font.PLAIN,13); //图例字体
    private Font font=new Font("黑体" ,Font.PLAIN,11);
    //
    private static final float NODE_GRAPHIC_NORMAL =10f; //节点图形尺寸-正常
    private static final float NODE_GRAPHIC_LEGEND =5f; //节点图形尺寸-图例
    private float ngrSize = NODE_GRAPHIC_NORMAL; //节点图形的尺寸（“半径”）

    private static final Float ARROW_LINE_WIDTH_NORMAL =1f; //箭头线宽-正常

    public void setNgrSize(float ngrSize) {
        this.ngrSize = ngrSize;
    }

    public DrawRelated() {
        // 创建BufferedImage对象
        // 获取Graphics2D
        image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
        g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //消锯齿
        g2d.setBackground(cMainBkg);
        g2d.clearRect(0, 0, width, height);
        g2d.setFont(fontLeg);
        //g2d.setPaint(cText); //设置颜色
    }

    //以坐标为中心画公司节点图形
    private void drawCompanyGraphicAtCen( double cx, double cy, Color cr ) {
        g2d.setPaint(cr);
        Rectangle2D rec2D =new Rectangle2D.Double(cx - ngrSize, cy - ngrSize, ngrSize *2, ngrSize *2 );
        g2d.fill(rec2D);
    }
    //以坐标为中心画自然人节点图形
    private void drawPersonGraphicAtCen( double cx, double cy, Color cr ) {
        g2d.setPaint(cr);
        Ellipse2D ell2D =new Ellipse2D.Double(cx - ngrSize, cy - ngrSize, ngrSize *2, ngrSize *2 );
        g2d.fill(ell2D);
    }

    //以坐标为中心画文本
    private void drawTextAtCen(String str, double x, double cy, boolean xCen ) {
        g2d.setPaint(cText);
        float fontSz =font.getSize();
        cy =cy +(fontSz*0.43);
        if(xCen) {
            x =x -( fontSz *str.length() /2 );
        }
        g2d.drawString(str,(float)x, (float)cy);
    }

    //画箭头
    private void drawArrowLine( double ox, double oy, double tx, double ty, boolean solidLine,  float width ) {
        float [] lineType =null;
        if( !solidLine ) {
            lineType  =new float[]{width *4, width *4};
        }
        BasicStroke basicStroke =new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, width *3,
                lineType, 0);
        g2d.setStroke(basicStroke);
        Line2D li2d =new Line2D.Double(ox, oy ,tx, ty);
        g2d.draw(li2d);
        double mvX =ngrSize;
        double mvY =-0.2D;
        //准备箭头坐标集合
        double [][]ptArr =new double[][]{
                new double[]{mvX, mvY},
                new double[]{mvX +width*7, mvY +width*4 },
                new double[]{mvX +width*4, mvY },
                new double[]{mvX +width*7, mvY -width*4 }, };
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

    //画图例，leHW 图例外高
    private void drawLegend( double leHW ) {
        double leX =10;
        double leY =10;
        double leW =width -leX *2;
        double leH =leHW -leY *2;
        g2d.setPaint(cLegendBkg);
        Rectangle2D rec2D =new Rectangle2D.Double(leX, leY, leW, leH );
        g2d.fill(rec2D);

        double dltW =leW/4;
        double dltW1 =dltW/3;
        double dltW2 =dltW1/2;
        double dltH1 =leH/4;
        setNgrSize(NODE_GRAPHIC_LEGEND); //设置成图例尺寸

        drawCompanyGraphicAtCen(leX +dltW2 +dltW*0, leY +dltH1 +dltH1*2 *0, cTargetCompany);
        drawTextAtCen( "目标公司", leX +dltW1 +dltW*0, leY +dltH1 +dltH1*2 *0, false );

        drawCompanyGraphicAtCen(leX +dltW2 +dltW*0, leY +dltH1 +dltH1*2 *1, cChildCompany);
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

    //计算云图坐标


    public static void main(String []argc) {

        DrawRelated dr =new DrawRelated();
        // 画图例
        double leHW =68;
        dr.drawLegend( leHW);


        //测试
        dr.testText( );
        dr.testArrow( );

        dr.saveFile("C:\\Users\\Administrator\\Desktop\\test.png");
    }
    public String saveFile( String fileName ) {
        //释放对象
        g2d.dispose();
        try {
            // 保存文件
            ImageIO.write(image, "png", new File(fileName));
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        return fileName;
    }



    //文本测试
    private void testText( ) {
        //g2d.drawRect(100,300, 99,11);
        drawCompanyGraphicAtCen(100,300, cSecDegree);
        Line2D pt2d =new Line2D.Double(100, 300, 100, 300);
        g2d.setPaint(cTargetCompany);
        g2d.draw(pt2d);
        drawTextAtCen("这是一个忧伤的故事", 105, 300, false);
        pt2d =new Line2D.Double(105, 300, 105, 300);
        g2d.setPaint(cChildCompany);
        g2d.draw(pt2d);
        //drawTextAtCen("这是一个忧伤的故事", 100, 300, false);
        //g2d.setPaint(cChildCompany);
        //drawTextAtCen("这是一个忧伤的故事", 100, 300, true);
    }

    //箭头测试
    private void testArrow( ) {
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
