package com.bbd.wtyh.domain.dto;


/**
* 区域发展指数
* @author Ian.Su
* @since 2016年8月10日 下午2:24:20
*/
public class AreaIndexDTO {

	private String area;
	double ecosystem; 
	double scale; 
	double popularity; 
	double safety; 
	double recognition; 
	double competitiveness; 
	int rank;
	
	
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
