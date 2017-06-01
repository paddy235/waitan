package com.bbd.wtyh.util;

import com.bbd.wtyh.domain.vo.CompanyVO;
import com.bbd.wtyh.domain.vo.RlinksVO;
import com.bbd.wtyh.service.impl.relation.common.Constants;
import com.bbd.wtyh.util.relation.Utils;
import com.bbd.wtyh.web.PathBean;
import net.sf.json.JSONArray;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import y.base.Node;
import y.io.GIFIOHandler;
import y.layout.circular.CircularLayouter;
import y.layout.tree.BalloonLayouter;
import y.view.*;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 本类主要是用YED生成静态图谱工具类
 * 图谱节点及线条生成原画：是广度按索，感染模型
 * @author hekf
 *
 */
public class YEDUtils {
	//YED静态变量定义
	public static final class RELATION_CONSTANTS {
		public static final Color Color_background = Color.decode("#2B323C");//图片背景色
		public static final Color Color_Destion_Company = Color.decode("#FF0000");//目标公司颜色
		public static final Color Color_Child_Company = Color.decode("#FFD700");//子公司颜色
		public static final Color Color_1 = Color.decode("#0031B0");//一度关联颜色
		public static final Color Color_2 = Color.decode("#36B3EA");//二度关联颜色
		public static final Color Color_3 = Color.decode("#C0C0C0");//三度关联颜色
		public static final Color Color_Line = Color.decode("#8F8F8F");//连接线颜色
		public static final int level_1_ = -1;//子公司
		public static final int level_0 = 0;//目标公司
		public static final int level_1 = 1;//一度关联公司
		public static final int level_2 = 2;//二度关联公司
		public static final int level_3 = 3;//三度关联公司
		public static final int level_4 = 4;//四度关联公司
		public static final int company_length = 8;//公司长度判断
	}
	//画布长宽
	public static final class BOUND_CONSTANTS{
		public static final int[] Bound_1 = {1000,950};//长宽
		public static final int[] Bound_2 = {2200,2000};
		public static final int[] Bound_3 = {3200,3000};
		public static final int[] Bound_4 = {5000,4000};
		public static final int[] Bound_5 = {5200,5000};
		public static final int[] Bound_6 = {6200,6000};
	}
	/**
	 * 获取画布
	 * @return
	 * @author hekf
	 */
	public static Graph2DView getGraph2DView(){
		Graph2DView view = new Graph2DView();
		DefaultBackgroundRenderer bgRenderer = new DefaultBackgroundRenderer(view);
	    bgRenderer.setColor(RELATION_CONSTANTS.Color_background);
		view.setBackgroundRenderer(bgRenderer);
		return view;
	}
	
	
	

	/**
	 * 获取Graph2D
	 * @param view
	 * @return
	 * @author hekf
	 */
	public static Graph2D getGraph2D(Graph2DView view){
		if(view!=null){
			Graph2D graph = view.getGraph2D();
			graph.getDefaultEdgeRealizer().setTargetArrow(Arrow.STANDARD);
			return graph;
		}else{
			return null;
		}
	}
	/**
	 * 返回线接线
	 * @param isDashed 是否是虚线
	 * @return
	 * @author hekf
	 */
	public static EdgeRealizer getEdgeRealizer(boolean isDashed,String edgeText) {
		PolyLineEdgeRealizer edgeRealizer = new PolyLineEdgeRealizer();
		if(isDashed){
			edgeRealizer.setLineType(LineType.DASHED_1);
		}
		edgeRealizer.setLineColor(RELATION_CONSTANTS.Color_Line);
		edgeRealizer.setTargetArrow(Arrow.STANDARD);
		edgeRealizer.setLabelText(edgeText); 
		return edgeRealizer;
	}
	
	/**
	 * 返回节点对象
	 * @param relationNumber 节点关联度数
	 * @return
	 * @author hekf
	 */
	public static NodeRealizer getNodeRealizer(String nodeText,int relationNumber,boolean isRect,int pixelNum) {
		Color color = getColor(relationNumber);
		ShapeNodeRealizer nodeRealizer = null;
		if(isRect){
			nodeRealizer = new ShapeNodeRealizer(ShapeNodeRealizer.RECT);
		}else{
			nodeRealizer = new ShapeNodeRealizer(ShapeNodeRealizer.ELLIPSE);
		}
		nodeRealizer.setSize(pixelNum, pixelNum);
		nodeRealizer.setFillColor(color);
		nodeRealizer.setLineColor(Color.WHITE);
		NodeLabel nodeLabel = new NodeLabel();
		nodeLabel.setTextColor(Color.decode("#CCCCCC"));
		nodeLabel.setText(nodeText);
		nodeRealizer.setLabel(nodeLabel);
		return nodeRealizer;
	}
	/**
	 * 根据关联数，获取对应的颜色值
	 * @param relationNumber
	 * @return
	 */
	public static Color getColor(int relationNumber){
		Color color = null;
		switch (relationNumber) {
		case RELATION_CONSTANTS.level_1_:// 子公司
			color = RELATION_CONSTANTS.Color_Child_Company;
			break;
		case RELATION_CONSTANTS.level_0:// 目标公司
			color = RELATION_CONSTANTS.Color_Destion_Company;
			break;
		case RELATION_CONSTANTS.level_1:// 一度关联
			color = RELATION_CONSTANTS.Color_1;
			break;
		case RELATION_CONSTANTS.level_2:// 二度关联
			color = RELATION_CONSTANTS.Color_2;
			break;
		case RELATION_CONSTANTS.level_3:// 三度关联
			color = RELATION_CONSTANTS.Color_3;
			break;
		case RELATION_CONSTANTS.level_4:// 四度关联
			color = RELATION_CONSTANTS.Color_Line;
			break;
		default:// 四度关联
			color = RELATION_CONSTANTS.Color_Line;
			break;
		}
		return color;
	}
	/**
	 * 生成图片
	 * @param graph 画图对象
	 * @param pathObject 图像线条走向的对象
	 * @param companyMap 公司对象 key为：公司名称，value为Company对象;
	 * @param nodeMap 用于存放已生成的节点，key为公司名称，value为节点对象，用于保存是否已经生成节点，如果生成，就不再生成
	 * @param edgeMap 为节点走向，key为源公司+"@"+目标公司，value为null
	 * @author hekf
	 */
	public static void graphImage(Graph2D graph,PathBean pathObject,Map<String, CompanyVO> companyMap, Map<String, Node> nodeMap,Map<String, String> edgeMap,int pixelNum) {
		Set<String> set = companyMap.keySet();
		for (String sourceCompany : set) {
			CompanyVO company = companyMap.get(sourceCompany);
			Node rootNode = nodeMap.get(sourceCompany);
			if (rootNode == null) {
				boolean isCompany = company.getIsCompany();
				/*if (sourceCompany.length() < RELATION_CONSTANTS.company_length) {
					isCompany = false;
				}*/
				NodeRealizer rootNodeRealize = null;
				if (isCompany) {
					rootNodeRealize = YEDUtils.getNodeRealizer(sourceCompany,company.getRelationNumber(), true,pixelNum);
				} else {
					rootNodeRealize = YEDUtils.getNodeRealizer(sourceCompany,company.getRelationNumber(), false,pixelNum);
				}
				rootNode = graph.createNode(rootNodeRealize);
				nodeMap.put(sourceCompany, rootNode);
			}
			graphNodeAndEdge(graph, sourceCompany, rootNode, pathObject,companyMap, nodeMap, edgeMap,pixelNum);
		}
	}
	/**
	 * 生成图片
	 * @param graph 画图对象
	 * @param sourceCompanyName 头节点公司名
	 * @param rootNode 头节点公司节点对象，
	 * @param pathObject 图像线条走向的对象
	 * @param companyMap 公司对象 key为：公司名称，value为Company对象;
	 * @param nodeMap 用于存放已生成的节点，key为公司名称，value为节点对象，用于保存是否已经生成节点，如果生成，就不再生成
	 * @param edgeMap 为节点走向，key为源公司+"@"+目标公司，value为null
	 * @author hekf
	 */
	public static void graphNodeAndEdge(Graph2D graph,String sourceCompanyName,Node rootNode,PathBean pathObject,Map<String, CompanyVO> companyMap,Map<String, Node> nodeMap,Map<String,String> edgeMap,int pixelNum){
		List<String> list = pathObject.getValuesByKey(sourceCompanyName);
		for(String companyName:list){
			String edgeKey=sourceCompanyName+"@"+companyName;
			if(!edgeMap.keySet().contains(edgeKey)){
				CompanyVO company = companyMap.get(companyName);
				EdgeRealizer edge = null;
				if (pathObject.getInvestType(edgeKey) == 0) {
					edge = YEDUtils.getEdgeRealizer(true, null);
				} else {
					edge = YEDUtils.getEdgeRealizer(false, null);
				}
				boolean isCompany = true;
				if (companyName.length() < 8) {
					isCompany = false;
				}
				Node node = nodeMap.get(companyName);
				if(node==null){
					NodeRealizer nodeRealizer = null;
					if (isCompany) {
						nodeRealizer = YEDUtils.getNodeRealizer(companyName,company.getRelationNumber(), true,pixelNum);
					} else {
						nodeRealizer = YEDUtils.getNodeRealizer(companyName,company.getRelationNumber(), false,pixelNum);
					}
					node = graph.createNode(nodeRealizer);
					nodeMap.put(companyName, node);
				}
				graph.createEdge(node, rootNode, edge);
				edgeMap.put(edgeKey, null);
				graphNodeAndEdge(graph, companyName,node, pathObject,companyMap,nodeMap,edgeMap,pixelNum);
			}
		}
	}

	/**
	 * 编辑svg图片
	 * 调整大小，去除YED水印
	 */
	public static void editSVG(String filePath,double x,double y) throws Exception{
		long start = System.currentTimeMillis();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(filePath));
        org.w3c.dom.Node svgNode = doc.getElementsByTagName("svg").item(0);
        NamedNodeMap attributes =  svgNode.getAttributes();
        for(int i = 0; i < attributes.getLength(); i++)
        {
        	org.w3c.dom.Node attribute = attributes.item(i);
        	if("height".equals(attribute.getNodeName()))
        	{
        		int orgHeight = Integer.parseInt(attribute.getNodeValue());
        		int height = orgHeight - (int)y;
        		((Element)svgNode).setAttribute(attribute.getNodeName(), height+"");
        	}
        	if("width".equals(attribute.getNodeName()))
        	{
        		int orgWidth = Integer.parseInt(attribute.getNodeValue());
        		int width = orgWidth - (int)x;
        		((Element) svgNode).setAttribute(attribute.getNodeName(), width+"");
        	}
        }
        NodeList nodes = doc.getElementsByTagName("g");
        org.w3c.dom.Node node = nodes.item(2);
        node.getParentNode().removeChild(node);
        new File(filePath).delete();
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        OutputStream outputStream = new FileOutputStream(new File(filePath));
        StreamResult result = new StreamResult(outputStream);
        transformer.transform(source, result);
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end -start ));
        
	}
	
	
	/**
	 * 编辑svg图片
	 * 调整大小，去除YED水印
	 */
	public static void editSVG(String filePath) throws Exception{
		long start = System.currentTimeMillis();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(filePath));
        NodeList nodes = doc.getElementsByTagName("g");
        org.w3c.dom.Node node = nodes.item(2);
        node.getParentNode().removeChild(node);
        new File(filePath).delete();
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        OutputStream outputStream = new FileOutputStream(new File(filePath));
        StreamResult result = new StreamResult(outputStream);
        transformer.transform(source, result);
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end -start ));
        
	}
	
	/**
	 * 输出为图片
	 * @param graph 
	 * @param
	 * @author hekf
	 */
	public static void writeImage(Graph2DView view,Graph2D graph,String filePath, ByteArrayOutputStream bos,int nodeNum,boolean flag){
		try {
			GIFIOHandler gifIO = new GIFIOHandler();
			CircularLayouter c = new CircularLayouter();
			BalloonLayouter balloonLayouter = c.getBalloonLayouter();
			balloonLayouter.setAllowOverlaps(true);
			//System.out.println(balloonLayouter.getMinimalNodeDistance());
			int nodeDis = getMinimalNodeDistance(nodeNum);
			balloonLayouter.setMinimalNodeDistance(nodeDis);
			
	    	c.doLayout(graph);
	    	double percent=extendPercent(nodeNum);
	    	
	    	Rectangle box = graph.getBoundingBox();
	    	double width = 0.0;
	    	double height = 0.0;
	    	int h = 0;
	    	if(box.width>6000 ||box.height>6000) {
	    		//图片大小大于6000后进行处理
	    		width = 6000.0; 
		    	height = 6000.0;
		    	double zoom = 1.0;
		    	Point viewPoint = view.getViewPoint();
		    	if(box.height>box.width)
		    	{
		    		zoom = height/box.getHeight();
		    		width = height*box.getWidth()/box.getHeight();
		    		height = height*percent;
		    	}else
		    	{
		    		zoom = width/box.getWidth();
		    		height = width*box.getHeight()/box.getWidth()*percent;
		    	}
		    	viewPoint = new Point(box.x, box.y);
		    	view.setZoom(zoom);
		    	view.setSize((int)width, (int)height);
		    	view.setViewPoint(viewPoint.x, viewPoint.y);
	    	}else{
	    		//小于6000的图片处理
	    		width=graph.getBoundingBox().width;
				height=(int)(graph.getBoundingBox().height*percent);
				int	centerX=(int)width/4;
				int	centerY=(int)height/4;
				view.setBounds(centerX, centerY, (int)width, (int)height);
	    	}
			if(null != filePath) {
				gifIO.write(graph, filePath);
				File picfile = new File(filePath);
				if (!picfile.exists()) {
					System.out.println("图片文件生成失败");
				}
			} else {
				bos.reset();
				gifIO.write(graph, bos);
			}
			//下面代码为去YED水印字样
			h=(int)(height/percent);
			if(h>0){
				cutImage(filePath,filePath,bos, 0,0,(int)width,h,"gif");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
	/**
	 * 根据节点来确认截图比例
	 * @param nodeNum
	 */
	public static double extendPercent(int nodeNum){
		double percent=1.1;
		if(nodeNum<=2){
			percent=5;
		}else if(nodeNum>2&&nodeNum<=30){
			percent=3;
		}else if(nodeNum>30&&nodeNum<=100){
			percent=2;
		}else{
			percent=1.1;
		}
		return percent;
	}
	
	/**
	 * 
	 * @param src 原文件路径
	 * @param dest 目标文件路径
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param extendFileName 文件扩展名 如gif jpg bmp
	 */
	public static void cutImage(String src, String dest, ByteArrayOutputStream bos, int x, int y, int w,int h, String extendFileName) {
		InputStream in=null;
		ImageInputStream iis=null;
		try {
			Iterator<?> iterator = ImageIO.getImageReadersByFormatName(extendFileName);
			ImageReader reader = (ImageReader) iterator.next();
			if(  null != src) {
				in = new FileInputStream(src);
			} else {
				in = new ByteArrayInputStream( bos.toByteArray() );
			}
		    iis = ImageIO.createImageInputStream(in);
			reader.setInput(iis, true);
			ImageReadParam param = reader.getDefaultReadParam();
			Rectangle rect = new Rectangle(x, y, w, h);
			System.out.println("x:"+x+"y:"+y+"w:"+w+"h:"+h);
			param.setSourceRegion(rect);
			BufferedImage bi = reader.read(0, param);
			if(  null != src) {
				ImageIO.write(bi, extendFileName, new File(dest));
			} else {
				bos.reset();
				ImageIO.write(bi, extendFileName, bos);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in!=null){
					in.close();
				}
				if(iis!=null){
					iis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * 
	 * @param src 原文件路径
	 * @param dest 目标文件路径
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param extendFileName 文件扩展名 如gif jpg bmp
	 */
	public static void addImage(String src, String dest, int x, int y, int w,int h, String extendFileName,String imagePath) {
		try {
			
			//以关联方图片为底
			BufferedImage image = ImageIO.read(new File(src));
			Graphics g = image.createGraphics();
			File f = new File(imagePath);
			BufferedImage im = ImageIO.read(f);
            g.drawImage(im,image.getWidth()/2-im.getWidth()/2,image.getHeight()/2-im.getHeight()/2,null); 
            g.dispose();
			ImageIO.write(image, extendFileName, new File(dest));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 根据节点个数，获取最大节点间距
	 * @param nodeNum 节点个数
	 * @return
	 */
	public static int getMinimalNodeDistance(int nodeNum){
		int nodeDistance = 1;
		if(nodeNum<500&&nodeNum>0)
		{
			nodeDistance = 50;
		}else if(nodeNum>=500&&nodeNum<1000)
		{
			nodeDistance = 8;
		}else if(nodeNum>=1000&&nodeNum<2000)
		{
			nodeDistance = 5;
		}else if(nodeNum>=2000&&nodeNum<3000)
		{
			nodeDistance = 3;
		}else if(nodeNum>=3000)
		{
			nodeDistance = 1;
		}
		return nodeDistance;
	}
	
	/**
	 * 根据节点个数，获取像素值
	 * 24为最大像素
	 * 17/200为变化量,按最大4000个节点来计算
	 * @param nodeNum 节点个数
	 * @return
	 */
	public static int getPixel(int nodeNum){
		int pixel = 1;
		if(nodeNum<500&&nodeNum>0)
		{
			pixel = 16;
		}else if(nodeNum>=500&&nodeNum<1000)
		{
			pixel = 12;
		}else if(nodeNum>=1000&&nodeNum<2000)
		{
			pixel = 10;
		}else if(nodeNum>=2000&&nodeNum<4000)
		{
			pixel = 8;
		}else{
			pixel = 1;
		}
		System.out.println("像素返回=="+pixel);
		return pixel;
	}
	
	/**
	 * 初始化数据
	 * 初始化原理：广度搜索，感染模型
	 * @param sourceData 原字符串数据
	 * 0列 投资方
	 * 1列 被投资方
	 * 2列 职位
	 * 3列 投资方度数
	 * 4列 被投资方度数
	 * 5列  线条 0 虚线 1 实线
	 * 6列  关系 0 公司 1 人
	 * @param destionCompany 目标公司
	 * @param pathObject 图像线条走向的对象
	 * @param companyMap 公司对象 key为：公司名称，value为Company对象;
	 * @author hekf
	 */
	public static void initData(List<List<Object>> sourceData,String destionCompany,PathBean pathObject,Map<String, CompanyVO> companyMap){
        for (List<Object> row : sourceData) {
        	int relationNumber = Integer.parseInt(row.get(3).toString());
        	int relationNumberEd = Integer.parseInt(row.get(4).toString());
			String sourceCompanyName= row.get(1).toString();
			String targetCompanyName= row.get(0).toString();
			String isPerson = row.get(6).toString();
			CompanyVO sourceCompany=companyMap.get(sourceCompanyName);
			if(sourceCompany==null){
				sourceCompany = new CompanyVO();
				sourceCompany.setCompany(sourceCompanyName);
				sourceCompany.setRelationNumber(relationNumberEd);
				sourceCompany.setIsCompany(true);
			}else{
				if(sourceCompany.getIsInfected()){
					//之前为targetCompany
					if(relationNumber>0&&(relationNumber+1)<sourceCompany.getRelationNumber()){
						sourceCompany.setRelationNumber(relationNumber+1);
					}
				}else{
					if(relationNumberEd<sourceCompany.getRelationNumber()){
						sourceCompany.setRelationNumber(relationNumberEd);
					}
				}
			}
			//判断是子公司
			if(relationNumber==0){
				sourceCompany.setRelationNumber(relationNumber-1);
				sourceCompany.setIsInfected(true);
			}

			CompanyVO targetCompany = companyMap.get(targetCompanyName);
			if(targetCompany==null){
				targetCompany = new CompanyVO();
				targetCompany.setCompany(targetCompanyName);
				targetCompany.setRelationNumber(relationNumber);
				targetCompany.setIsInfected(true);
			}else{
				//投资公司不为空
				if(targetCompany.getIsInfected()){
					//之前已被感染
					if(relationNumber>0&&relationNumber<targetCompany.getRelationNumber()){
						targetCompany.setRelationNumber(relationNumber);
					}
				}else{
					//之前没有感染
					//之前为sourceCompany，虽然赋值了，但没有感染，此时成了targetCompany
					//传播模型最近感染
					if(relationNumber>0&&relationNumber<targetCompany.getRelationNumber()){
						targetCompany.setRelationNumber(relationNumber);
					}
					targetCompany.setIsInfected(true);
				}
			}
			targetCompany.setAppearFirst(true);//出现过在第一列
			if(Constants.YesOrNo.YES.equals(isPerson)){
				targetCompany.setIsCompany(false);
			}else{
				targetCompany.setIsCompany(true);
			}
			
			if(destionCompany.equals(sourceCompanyName)){
				sourceCompany.setRelationNumber(YEDUtils.RELATION_CONSTANTS.level_0);
			}
			if(destionCompany.equals(targetCompanyName)){
				targetCompany.setRelationNumber(YEDUtils.RELATION_CONSTANTS.level_0);
			}
			companyMap.put(sourceCompanyName, sourceCompany);
			companyMap.put(targetCompanyName, targetCompany);
			pathObject.add(sourceCompanyName, targetCompanyName,Integer.valueOf(row.get(5).toString()), row.get(2).toString());
        }
        companyMap.get(destionCompany).setIsCompany(true);
        //处理公司在数据中，没有出现在第一列，只出现过在第二列的情况，这个时候，关联度数就要以被指向的最小度数为准（以 重庆银行股份有限公司 为例 长沙市开瑞建筑材料有限公司 的计算就有问题）
        Set<String> set = companyMap.keySet();
        for(String name:set){
			CompanyVO company = companyMap.get(name);
        	if(company.getIsCompany()&&!company.getAppearFirst()){
        		//是公司，但没有出现过在第一列，这个时候关联度数以指向的为准
				PathBean path = pathObject.getPathObjectByKey(name);
        		List<String> targets = path.getValues();
        		for(String target :targets){
					CompanyVO targetCompny = companyMap.get(target);
        			if(targetCompny.getRelationNumber()== RELATION_CONSTANTS.level_1_){//子公司
        				company.setRelationNumber(RELATION_CONSTANTS.level_2);
        			} else if(targetCompny.getRelationNumber()<company.getRelationNumber()){//非子公司
        				company.setRelationNumber(targetCompny.getRelationNumber()+1);
        			}
        		}
        	}
        }
	}



	/**
	 * 初始化数据
	 * 初始化原理：广度搜索，感染模型
	 * @param sourceData 原字符串数据
	 * @param destionCompany 目标公司
	 * @param pathObject 图像线条走向的对象
	 * @param companyMap 公司对象 key为：公司名称，value为Company对象;
	 * @param linkList   封装原始数据
	 * @param AddCompanyMap  用户添加公司
	 * @author David
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void initDynamicData(String sourceData,String destionCompany,PathBean pathObject,Map<String, CompanyVO> companyMap ,List<Integer> DegreesMax, List<RlinksVO> linkList,Map<String, String> AddCompanyMap){
		JSONArray node = JSONArray.fromObject(sourceData);
        List<List<String>> list = JSONArray.toList(node);
        int nodeMax=0;
        for (List<String> row : list) {
        	String c01 = row.get(0).trim();
            String c02 = row.get(1).trim();
            String c04 = row.get(2).trim();
            String c03 = row.get(4).trim();
            String c05 = row.get(5).trim();

			RlinksVO links = new RlinksVO();
            links.setSource(c01);
            links.setTarget(c02);
            links.setGuanlian(c04);
            links.setRelatedParyName(c05);
            if(destionCompany.equals(c01) && AddCompanyMap.get(c02) != null){
            	 links.setAddflag("true");
            }else{
            	 links.setAddflag("false");
            }
            if ("0".equals(c03)) {
                links.setLine("dotted");
            } else {
                links.setLine("line");
            }
            linkList.add(links);

        	int relationNumber = Integer.valueOf(row.get(3));
        	if(nodeMax < relationNumber){
        		nodeMax = relationNumber+1;
        	}
			String sourceCompanyName=row.get(1);
			String targetCompanyName=row.get(0);
			String isPerson = Utils.trimString(row.get(5));
			CompanyVO sourceCompany=companyMap.get(sourceCompanyName);
			if(sourceCompany==null){
				sourceCompany = new CompanyVO();
				sourceCompany.setCompany(sourceCompanyName);
				sourceCompany.setRelationNumber(relationNumber+1);

			}else{
				if(sourceCompany.getIsInfected()){
					//之前为targetCompany
					if(relationNumber>0&&(relationNumber+1)<sourceCompany.getRelationNumber()){
						sourceCompany.setRelationNumber(relationNumber+1);
					}
				}else{
					//之前还是sourceCompany，此时什么都不做
				}
			}
			//判断是子公司
			if(relationNumber==0){
				sourceCompany.setRelationNumber(relationNumber-1);
				sourceCompany.setIsInfected(true);
			}

			CompanyVO targetCompany = companyMap.get(targetCompanyName);
			if(targetCompany==null){
				targetCompany = new CompanyVO();
				targetCompany.setCompany(targetCompanyName);
				targetCompany.setRelationNumber(relationNumber);
				targetCompany.setIsInfected(true);
			}else{
				//投资公司不为空
				if(targetCompany.getIsInfected()){
					//之前已被感染
					if(relationNumber>0&&relationNumber<targetCompany.getRelationNumber()){
						targetCompany.setRelationNumber(relationNumber);
					}
				}else{
					//之前没有感染
					//之前为sourceCompany，虽然赋值了，但没有感染，此时成了targetCompany
					//传播模型最近感染
					if(relationNumber>0&&relationNumber<targetCompany.getRelationNumber()){
						targetCompany.setRelationNumber(relationNumber);
					}
					targetCompany.setIsInfected(true);
				}
			}
			if(Constants.YesOrNo.YES.equals(isPerson)){
				targetCompany.setIsCompany(false);
			}else{
				targetCompany.setIsCompany(true);
			}

			if(destionCompany.equals(sourceCompanyName)){
				sourceCompany.setRelationNumber(YEDUtils.RELATION_CONSTANTS.level_0);
			}
			if(destionCompany.equals(targetCompanyName)){
				targetCompany.setRelationNumber(YEDUtils.RELATION_CONSTANTS.level_0);
			}
			companyMap.put(sourceCompanyName, sourceCompany);
			companyMap.put(targetCompanyName, targetCompany);
			pathObject.add(sourceCompanyName, targetCompanyName,Integer.valueOf(row.get(4)), row.get(2)); 

        }
        DegreesMax.add(nodeMax);

	}
	
	
	
	/**
	 * 递规更新关联度数
	 * @param companyName
	 * @param pathObject
	 * @param companyMap
	 */
	public static void loop(String companyName, PathBean pathObject, Map<String, CompanyVO> companyMap){
		CompanyVO companyObject = companyMap.get(companyName);
		if(companyObject!=null){
			 int relationNumber=companyObject.getRelationNumber();
			 List<String> list = pathObject.getValuesByKey(companyName);
			 if(list!=null&&list.size()>0){
				 for(String name:list){
					 CompanyVO childCompany = companyMap.get(name);
					if(childCompany!=null){
						childCompany.setRelationNumber(relationNumber+1);
						loop(name, pathObject, companyMap);
					}
				 }
			 }
		}
	}
	
	 public static void xPic(String filePath,int imageNum,String outPath) throws IOException{//横向处理图片  
		 BufferedImage bimage = ImageIO.read(new File(filePath));
		  int width = bimage.getWidth();
		  int height = bimage.getHeight();
		  
		  
		  //不一定是TYPE_INT_RGB，可以看API自己需要哪种格式
		  BufferedImage outImage = new BufferedImage(width* imageNum, height , BufferedImage.TYPE_INT_RGB);
		  Graphics g = outImage.getGraphics();
		  Graphics2D g2d = (Graphics2D) g;
		  outImage = g2d.getDeviceConfiguration().createCompatibleImage(width* imageNum, height, Transparency.TRANSLUCENT);
		  g2d = outImage.createGraphics();
		  for(int i=0; i<imageNum; i++)
		  {
		   g2d.drawImage(bimage, width*i, 0, null);
		   //需要改变颜色的话在这里绘上颜色。可能会用到AlphaComposite类
		  }
		  g2d.dispose();
		  String format = "png";
		  ImageIO.write(outImage, format, new File(outPath));
	    } 
	 
	 public static void yPic(String filePath,int imageNum,String outPath) throws IOException{//横向处理图片  
		  BufferedImage bimage = ImageIO.read(new File(filePath));
		  int width = bimage.getWidth();
		  int height = bimage.getHeight();
		  
		  
		  //不一定是TYPE_INT_RGB，可以看API自己需要哪种格式
		  BufferedImage outImage = new BufferedImage(width, height * imageNum, BufferedImage.TYPE_INT_RGB);
		  Graphics g = outImage.getGraphics();
		  Graphics2D g2d = (Graphics2D) g;
		  outImage = g2d.getDeviceConfiguration().createCompatibleImage(width, height* imageNum, Transparency.TRANSLUCENT);
		  g2d.dispose();
		  g2d = outImage.createGraphics();
		  for(int i=0; i<imageNum; i++)
		  {
		   g2d.drawImage(bimage, 0, height * i, null);
		   //需要改变颜色的话在这里绘上颜色。可能会用到AlphaComposite类
		  }
		  
		  g2d.dispose();
		  String format = "png";
		  ImageIO.write(outImage, format, new File(outPath));
	    }

}
