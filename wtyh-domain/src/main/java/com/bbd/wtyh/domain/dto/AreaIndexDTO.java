package com.bbd.wtyh.domain.dto;


/**
* 区域发展指数
* @author Ian.Su
* @since 2016年8月10日 下午2:24:20
*/
public class AreaIndexDTO {

	private String area;//省份
	double ecosystem; //网贷生态环境
	double scale; //网贷规模
	double popularity; //网贷人气
	double safety; //网贷安全度
	double recognition; //资本认可度
	double competitiveness; //综合竞争力
	int rank;//上半年排名
	
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	public double getEcosystem() {
		return ecosystem;
	}
	
	public void setEcosystem(double ecosystem) {
		this.ecosystem = ecosystem;
	}
	
	
	public double getScale() {
		return scale;
	}
	
	
	public void setScale(double scale) {
		this.scale = scale;
	}
	
	
	public double getPopularity() {
		return popularity;
	}
	
	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}
	
	
	public double getSafety() {
		return safety;
	}
	
	
	public void setSafety(double safety) {
		this.safety = safety;
	}
	
	
	public double getRecognition() {
		return recognition;
	}
	
	public void setRecognition(double recognition) {
		this.recognition = recognition;
	}
	
	
	public double getCompetitiveness() {
		return competitiveness;
	}
	
	
	public void setCompetitiveness(double competitiveness) {
		this.competitiveness = competitiveness;
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
	
}
