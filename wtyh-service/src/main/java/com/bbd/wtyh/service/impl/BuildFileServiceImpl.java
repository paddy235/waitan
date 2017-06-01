package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.vo.CompanyVO;
import com.bbd.wtyh.service.BuildFileService;
import com.bbd.wtyh.util.YEDUtils;
import com.bbd.wtyh.web.PathBean;
import org.springframework.stereotype.Service;
import y.base.Node;
import y.view.Graph2D;
import y.view.Graph2DView;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by win7 on 2016/8/10.
 */
@Service("buildFileService")
public class BuildFileServiceImpl implements BuildFileService {

    public boolean buildImage(List<List<Object>> data, String company, String filePath, boolean flag)throws Exception {
        /*ByteArrayOutputStream baos =new ByteArrayOutputStream();
        buildImageToFileOrStream(data, company, null, baos, flag);
        FileOutputStream fos =new FileOutputStream("F:\\aaa.gif");
        baos.writeTo(fos);
        fos.close();*/
        return buildImageToFileOrStream(data, company, filePath, null, flag);
    }

    public boolean buildImageToFileOrStream(List<List<Object>> data, String company, String filePath, ByteArrayOutputStream bos, boolean flag)
            throws Exception  {
        try {
            PathBean pathObject = new PathBean();//线条
            Map<String, CompanyVO> companyMap = new HashMap<String, CompanyVO>();//节点
            Map<String, Node> nodeMap = new HashMap<String,Node>();//主要用于去重节点
            Map<String,String> edgeMap = new HashMap<String,String>();//主要用于去重连线

            YEDUtils.initData(data, company, pathObject, companyMap);
            Graph2DView view = YEDUtils.getGraph2DView();
            Graph2D graph = YEDUtils.getGraph2D(view);
            int piexl=YEDUtils.getPixel(companyMap.keySet().size());

            System.out.println("节点数==="+companyMap.keySet().size());
            System.out.println("线数==="+pathObject.getKeys().size());

            YEDUtils.graphImage(graph,pathObject,companyMap,nodeMap,edgeMap,piexl);

            YEDUtils.writeImage(view,graph, filePath, bos, companyMap.keySet().size(),flag);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
