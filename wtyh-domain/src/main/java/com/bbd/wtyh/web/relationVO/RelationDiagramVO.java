package com.bbd.wtyh.web.relationVO;

import com.bbd.wtyh.excel.annotation.Excel;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 页面绘制关联方图VO
 * 
 * @author yanghongyan
 * @version $Id: AssociationDiagramVO.java, v 0.1 2016年11月8日 下午4:55:16
 *          yanghongyan Exp $
 */
public class RelationDiagramVO {

	private List<PointVO> pointList = Collections.emptyList();
	private List<LineVO> lineList = Collections.emptyList();

	public List<PointVO> getPointList() {
		return pointList;
	}

	public void setPointList(List<PointVO> pointList) {
		this.pointList = pointList;
	}

	public List<LineVO> getLineList() {
		return lineList;
	}

	public void setLineList(List<LineVO> lineList) {
		this.lineList = lineList;
	}

	/**
	 * 关联方图
	 * 
	 * @author yanghongyan
	 * @version $Id: AssociationDiagramVO.java, v 0.1 2016年11月8日 下午4:51:41
	 *          Administrator Exp $
	 */
	public static class PointVO implements Serializable {

		private static final long serialVersionUID = 1382814381367941238L;

		public static final String COMPANY_FLAG = "0";
		public static final String PERSON_FLAG = "1";

		/** 关联方ID */
		private String name;
		/** 关联方名称 */
		private String cname;
		/** 所处关联度数 */
		private String level;
		/** 是否是个人（0：公司；1：个人） */
		private String isPerson;
		/** 是否为子公司（0：否；1：是） */
		private String isSonCom;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLevel() {
			return level;
		}

		public void setLevel(String level) {
			this.level = level;
		}

		public String getIsPerson() {
			return isPerson;
		}

		public void setIsPerson(String isPerson) {
			this.isPerson = isPerson;
		}

		public String getIsSonCom() {
			return isSonCom;
		}

		public void setIsSonCom(String isSonCom) {
			this.isSonCom = isSonCom;
		}

		public String getCname() {
			return cname;
		}

		public void setCname(String cname) {
			this.cname = cname;
		}
	}

	public static class LineVO implements Serializable {

		private static final long serialVersionUID = 3057575994341547551L;

		@Excel(exportName = "序号")
		private int num;

		/** 源 */
		@Excel(exportName = "投资方")
		private String orig;

		/** 目标 */
		@Excel(exportName = "被投资方")
		private String target;

		/** 是否为实线（0：否；1：是） */
		private String isFullLine;

		/** 关联方类型 */
		@Excel(exportName = "关联关系")
		private String type;

		/** 关联方关系（0：公司与公司；1：人与公司） */
		private String relationship;

		/** 源维度 */
		@Excel(exportName = "投资方关联维度")
		private String origLevel;

		/** 目标维度 */
		@Excel(exportName = "被投资方关联维度")
		private String tarLevel;

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public String getOrig() {
			return orig;
		}

		public void setOrig(String orig) {
			this.orig = orig;
		}

		public String getTarget() {
			return target;
		}

		public void setTarget(String target) {
			this.target = target;
		}

		public String getIsFullLine() {
			return isFullLine;
		}

		public void setIsFullLine(String isFullLine) {
			this.isFullLine = isFullLine;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getRelationship() {
			return relationship;
		}

		public void setRelationship(String relationship) {
			this.relationship = relationship;
		}

		public String getOrigLevel() {
			return origLevel;
		}

		public void setOrigLevel(String origLevel) {
			this.origLevel = origLevel;
		}

		public String getTarLevel() {
			return tarLevel;
		}

		public void setTarLevel(String tarLevel) {
			this.tarLevel = tarLevel;
		}
	}
}
