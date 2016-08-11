package com.bbd.wtyh.domain.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class RlinksVO implements Serializable {


	private static final long serialVersionUID = 1L;
	private String source;
	private String target;
	private String line;
	private String guanlian;
	private String relatedParyName;
	private String addflag ="false";
	public RlinksVO() {
		// TODO Auto-generated constructor stub
	}

	public RlinksVO(String source, String target) {
		super();
		this.source = source;
		this.target = target;
	}

	public RlinksVO(String source, String target, String line ,String guanlian,String relatedParyName,String addflag) {
		super();
		this.source = source;
		this.target = target;
		this.line = line;
		this.guanlian = guanlian;
		this.relatedParyName = relatedParyName;
		this.addflag = addflag;

	}
	@Override
	public String toString() {
		return "links [line=" + line + ", source=" + source +", guanlian=" + guanlian+ ", target="+ target +", relatedParyName="+ relatedParyName +", addflag="+ addflag+"]";
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTarget() {
		return target;
	}
	public String getAddflag() {
		return addflag;
	}
	public void setAddflag(String addflag) {
		this.addflag = addflag;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}

	public String getGuanlian() {
		return guanlian;
	}

	public void setGuanlian(String guanlian) {
		this.guanlian = guanlian;
	}

	public String getRelatedParyName() {
		return relatedParyName;
	}

	public void setRelatedParyName(String relatedParyName) {
		this.relatedParyName = relatedParyName;
	}

	public Map<String,String> toMap(){
		Map<String,String>  result = new HashMap<String,String>();
		result.put("source", source);
		result.put("target", target);
		result.put("line", line);
		result.put("guanlian", guanlian);
		result.put("relatedParyName", relatedParyName);
		result.put("addflag", addflag);
		return result;
	}

	public static RlinksVO asMap(Map<String,String> map){
		return new RlinksVO(map.get("source"),map.get("target"),map.get("line"),map.get("guanlian"),map.get("relatedParyName"),map.get("addflag"));
	}

}
