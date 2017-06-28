package com.bbd.wtyh.report.util;

import java.awt.*;
import java.awt.geom.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.bbd.wtyh.web.relationVO.RelationDiagramVO;

/**
 * Created by Administrator on 2017/6/15.
 */
public class DrawRelatedG2 extends DrawRelated {
    public enum DegreeType { //画图的度类型
        ONE(1), TWO(2), THREE(3);

        private int degVal;

        DegreeType(int dVal) {
            this.degVal =dVal;
        }

        public int getDegVal() {
            return degVal;
        }

        public static DegreeType findDegreeTypeByVal(int degreeVal) {
            for ( DegreeType dt : DegreeType.values() ) {
                if( dt.getDegVal() == degreeVal ) {
                    return  dt;
                }
            }
            return ONE;
        }
    }

    private DegreeType degreeType;

    public DegreeType getDegreeType() {
        return degreeType;
    }

    private int spacing; //圆环间距

    private static final int initR =30; //初始半径

    /**
     *
     * @param degreeType 度类型
     * @param spacing 圆环间距
     */
    public DrawRelatedG2( DegreeType degreeType, int spacing ) {
        //super();
        this.spacing =spacing;
        this.degreeType =degreeType;
        this.imgWidth = ( spacing *(degreeType.getDegVal() +1) +initR ) *2;
        this.imgHigh  = this.imgWidth;
        initBlock();
    }

    public DrawRelatedG2( DegreeType degreeType ) {
        this(degreeType, 110);
    }

    //画图例
    private void drawLegendG2( ) {
        double bouWidth =10D;              //边界宽度 boundaryWidth
        double leX =bouWidth;
        double leY =bouWidth;
        double leW = imgWidth -bouWidth *2;
        double leH =leHO -bouWidth *2;
        g2d.setPaint(cLegendBkg);
        Rectangle2D rec2D =new Rectangle2D.Double(leX, leY, leW, leH );
        g2d.fill(rec2D);

        double dltW =leW/( 2 +degreeType.getDegVal() );
        double dltW1 =dltW/3;
        double dltW2 =dltW1/2;
        //double dltW3 =dltW1/3;
        double dltH1 =leH/4;
        setNgrSize(NODE_GRAPHIC_LEGEND); //设置成图例尺寸
        setFont(FONT_LEG);
        setTextColor(C_TEXT_LEG);

        int wStep =0;

        drawCompanyGraphicAtCen(leX +dltW2 +dltW *wStep, leY +dltH1 +dltH1*2 *0, cTargetCompany);
        drawTextAtCen( "目标公司", leX +dltW1 +dltW *wStep, leY +dltH1 +dltH1*2 *0, false );
        drawCompanyGraphicAtCen(leX +dltW2 +dltW *wStep, leY +dltH1 +dltH1*2 *1, cSonCompany);
        drawTextAtCen( "子公司", leX +dltW1 +dltW *wStep, leY +dltH1 +dltH1*2 *1, false );
        wStep++;

        if( degreeType.getDegVal() >=1 ) {
            drawCompanyGraphicAtCen(leX + dltW2 + dltW *wStep, leY + dltH1 + dltH1 * 2 * 0, cFirDegree);
            drawTextAtCen("一度关联公司", leX + dltW1 + dltW *wStep, leY + dltH1 + dltH1 * 2 * 0, false);
            drawPersonGraphicAtCen(leX + dltW2 + dltW *wStep, leY + dltH1 + dltH1 * 2 * 1, cFirDegree);
            drawTextAtCen("一度关联自然人", leX + dltW1 + dltW *wStep, leY + dltH1 + dltH1 * 2 * 1, false);
            wStep++;
        }

        if ( degreeType.getDegVal() >=2 ) {
            drawCompanyGraphicAtCen(leX + dltW2 + dltW *wStep, leY + dltH1 + dltH1 * 2 * 0, cSecDegree);
            drawTextAtCen("二度关联公司", leX + dltW1 + dltW *wStep, leY + dltH1 + dltH1 * 2 * 0, false);
            drawPersonGraphicAtCen(leX + dltW2 + dltW *wStep, leY + dltH1 + dltH1 * 2 * 1, cSecDegree);
            drawTextAtCen("二度关联自然人", leX + dltW1 + dltW *wStep, leY + dltH1 + dltH1 * 2 * 1, false);
            wStep++;
        }

        if ( degreeType.getDegVal() >=3 ) {
            drawCompanyGraphicAtCen(leX + dltW2 + dltW *wStep, leY + dltH1 + dltH1 * 2 * 0, cThiDegree);
            drawTextAtCen("三度关联公司", leX + dltW1 + dltW *wStep, leY + dltH1 + dltH1 * 2 * 0, false);
            drawPersonGraphicAtCen(leX + dltW2 + dltW *wStep, leY + dltH1 + dltH1 * 2 * 1, cThiDegree);
            drawTextAtCen("三度关联自然人", leX + dltW1 + dltW *wStep, leY + dltH1 + dltH1 * 2 * 1, false);
            wStep++;
        }

        double  ceX =leX +dltW2 +dltW *wStep,          ceY =leY +dltH1 +dltH1*2 *0;
        double ceX1 =leX +dltW1 +dltW2/2 +dltW *wStep, ceY1 =leY +dltH1 +dltH1*2 *1;
        g2d.setPaint(cArrowLine);
        drawArrowLine(ceX -dltW2, ceY, ceX +dltW2, ceY, true, 1);
        drawTextAtCen( "投资人", ceX1, ceY, false );
        g2d.setPaint(cArrowLine);
        drawArrowLine(ceX -dltW2, ceY1, ceX +dltW2, ceY1, false, 1);
        drawTextAtCen( "企业高管", ceX1, ceY1, false );

    }
    /**
     * 画关联图
     * @param rVO 画图数据
     */
	public void drawRelatedG2( RelationDiagramVO rVO) {
        List<List<NodeInfo>> nodeLList = relationDiagramVoToNodeListG2( rVO );
        List<LineInfo> lineList =relationDiagramVoToLineListG2(rVO);
        if ( nodeLList == null || lineList ==null || nodeLList.size() <(degreeType.getDegVal() +1)
                || nodeLList.get(0).size() != 1 ) {
            return;
        }
		// 画图例
		drawLegendG2();
		//
		double rdHO = imgHigh - leHO; // 关联图外高
		double textDown = 25D; // 文字下沉尺度
		double []scaleOffset = {0 ,0, 0, 0}; // Math.PI/40; //n度节点起始偏移的弧度数，注意超过4度要需添加
		double bouWidth = 10D; // 边界宽度 boundaryWidth
		double rdX = bouWidth; // 绘图区起点x
		double rdY = imgHigh - rdHO; // 绘图区起点y
		double rdW = imgWidth - bouWidth * 2; // 绘图区宽度
		double rdH = rdHO - bouWidth * 1; // 绘图区高度
		double rdcX = rdX + rdW / 2; // 绘图区中心x
		double rdcY = rdY + rdH / 2; // 绘图区中心y
		//double[][] coordinateArr = new double[nodeList.size()][2]; // 创建节点坐标数组
		// 设置目标公司坐标
        nodeLList.get(0).get(0).xCoordinate =rdcX;
        nodeLList.get(0).get(0).yCoordinate =rdcY;
        List<NodeInfo> nodeList =new ArrayList<>(); //构造用于线性查找的节点列表
        nodeList.addAll(nodeLList.get(0));
        for ( int idx =1; idx <= degreeType.getDegVal(); idx++ ) {
            List<NodeInfo> degList =nodeLList.get(idx);
            nodeList.addAll( nodeLList.get(idx) );
            double radius =spacing *idx;
            if ( degreeType.equals(DegreeType.ONE) ) {
                radius *= 1.2; // 仅一度公司时，适当增大一度半径
            }
            double scale = 2 * Math.PI / degList.size();
            double sccOff =scaleOffset[idx -1];
            for ( int dIx =0; dIx <degList.size(); dIx++ ) {
                NodeInfo ni =degList.get(dIx);
                ni.xCoordinate =rdcX + radius * Math.cos(scale * dIx + sccOff);
                ni.yCoordinate =rdcY + radius * Math.sin(scale * dIx + sccOff);
            }
        }

        //节点搜索工具
		SearchCoordinateG2 searchCoordinate = (String Id) -> {
			if (StringUtils.isBlank(Id)) {
				return null;
			}
			for ( NodeInfo ni : nodeList ) {
                String sId = ni.companyId;
                if (StringUtils.isNotBlank(sId) && sId.equals(Id)) {
                    return ni;
                }
			}
			return null;
		};

		// 画关联箭头线
		g2d.setPaint(cArrowLine);
		setNgrSize(NODE_GRAPHIC_NORMAL);
		for  (LineInfo line : lineList) {
            NodeInfo oriCoordinate = searchCoordinate.fun(line.oriId);
            NodeInfo tagCoordinate = searchCoordinate.fun(line.tagId);
            if (oriCoordinate != null && tagCoordinate != null ) {
                drawArrowLine(oriCoordinate.xCoordinate, oriCoordinate.yCoordinate,
                        tagCoordinate.xCoordinate, tagCoordinate.yCoordinate, line.lineIs, ARROW_LINE_WIDTH_NORMAL);
            }
		}

		// 画文字和节点
		// setNgrSize(NODE_GRAPHIC_NORMAL);
		setFont(FONT_NORMAL);
		setTextColor(C_TEXT);
		for (NodeInfo node : nodeList) {
            drawTextAtCen(node.companyName, node.xCoordinate, node.yCoordinate + textDown, true); // 画文字
            //画节点
            if (node.companyIs) {
                drawCompanyGraphicAtCen(node.xCoordinate, node.yCoordinate, node.color); // 公司
            } else {
                drawPersonGraphicAtCen(node.xCoordinate, node.yCoordinate, node.color); // 自然人
            }
		}
	}

    @FunctionalInterface
    interface SearchCoordinate {
        NodeInfo fun(String Id);
    };

    public static void main(String []argc) {

        DrawRelatedG2 dr =new DrawRelatedG2(DegreeType.ONE);
        RelationDiagramVO rv =new RelationDiagramVO();
        //rv.setLineList();

        dr.drawRelatedG2(rv );

        ////测试
        //dr.testText( );
        //dr.testArrow( );

        String dateTimeStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        dr.saveFile("C:\\Users\\Administrator\\Desktop\\test_" +dateTimeStr +".png");
    }

    public List<List<NodeInfo>> relationDiagramVoToNodeListG2(RelationDiagramVO rVO) {
        if( rVO ==null || rVO.getPointList() ==null )
            return null;
        List<RelationDiagramVO.PointVO> rpVoList =rVO.getPointList();
        List<NodeInfo> nodeList0 = new ArrayList<>();
        List<NodeInfo> nodeList1 = new ArrayList<>();
        List<NodeInfo> nodeList2 = new ArrayList<>();
        List<NodeInfo> nodeList3 = new ArrayList<>();
        List<List<NodeInfo>> nodeLList = new ArrayList<>();
        nodeLList.add(nodeList0);
        nodeLList.add(nodeList1);
        nodeLList.add(nodeList2);
        nodeLList.add(nodeList3);
        for ( int idx =0; idx <rpVoList.size(); idx++ ) {
            RelationDiagramVO.PointVO rpVo = rpVoList.get(idx);
            if( rpVo !=null ) {
                int degree =1000;
                String []node ={"","",""};//Id,name,nodeType
                NodeInfo pi =new NodeInfo();
                if( StringUtils.isNotBlank( rpVo.getName() ) ) {
                    pi.companyId =rpVo.getName();
                } else continue;
                if( StringUtils.isNotBlank( rpVo.getCname() ) ) {
                    pi.companyName =rpVo.getCname();
                } else continue;
                if( StringUtils.isNotBlank(rpVo.getLevel()) ) {
                    if( rpVo.getLevel().equals("1") ) {
                        pi.color =cFirDegree;
                        degree =1;
                    } else if ( rpVo.getLevel().equals("2") ) {
                        pi.color =cSecDegree;
                        degree =2;
                    } else if ( rpVo.getLevel().equals("3") ) {
                        pi.color =cThiDegree;
                        degree =3;
                    } else if ( rpVo.getLevel().equals("0") ) {
                        pi.color =cTargetCompany;
                        degree =0;
                    } else {
                        continue;
                    }
                }
                if( StringUtils.isNotBlank(rpVo.getIsPerson()) ) {
                    if( rpVo.getIsPerson().equals("1") ) {
                        pi.companyIs =false;
                    } else if( rpVo.getIsPerson().equals("0") ) {
                        pi.companyIs =true;
                    } else {
                        continue;
                    }
                }
                if( StringUtils.isNotBlank( rpVo.getIsSonCom() ) ) {
                    if( rpVo.getIsSonCom().equals("1") ) {
                        pi.color = cSonCompany;
                    } else if( ! rpVo.getIsSonCom().equals("0") ) {
                        continue;
                    }
                }
                if( degree >3 ) {
                    continue;
                }
                ( nodeLList.get(degree) ).add(pi);
            }
        }
        return nodeLList;
    }

    public class NodeInfo {
        public String companyName;
        public String companyId;
        public boolean companyIs;
        public double xCoordinate;
        public double yCoordinate;
        public Color color;
    }

    public class LineInfo {
        public String oriId;
        public String tagId;
        public boolean lineIs; //lineType
    }

    protected List<LineInfo> relationDiagramVoToLineListG2(RelationDiagramVO rVO) {
        if( rVO ==null || rVO.getLineList() ==null )
            return null;
        List<RelationDiagramVO.LineVO> rpVoList =rVO.getLineList();
        List<LineInfo> lineList = new ArrayList<>();
        for ( int idx =0; idx <rpVoList.size(); idx++ ) {
            RelationDiagramVO.LineVO rlVo = rpVoList.get(idx);
            if( rlVo !=null ) {
                LineInfo li =new LineInfo();
                if( StringUtils.isNotBlank( rlVo.getOrig() ) ) {
                    li.oriId =rlVo.getOrig();
                } else continue;
                if( StringUtils.isNotBlank( rlVo.getTarget() ) ) {
                    li.tagId =rlVo.getTarget();
                } else continue;
                if( StringUtils.isNotBlank( rlVo.getIsFullLine() ) ) {
                    if( rlVo.getIsFullLine().equals("1") ) {
                        li.lineIs =true;
                    } else if ( rlVo.getIsFullLine().equals("0") ) {
                        li.lineIs =false;
                    } else {
                        continue;
                    }
                }
                lineList.add(li);
            }
        }
        return lineList;
    }

    @FunctionalInterface
    interface SearchCoordinateG2 {
        NodeInfo fun( String Id );
    };

}
