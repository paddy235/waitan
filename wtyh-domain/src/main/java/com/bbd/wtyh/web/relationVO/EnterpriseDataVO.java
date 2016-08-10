package com.bbd.wtyh.web.relationVO;

/**
 * 工商注册资料json model
 * @author caoyu
 *
 */
public class EnterpriseDataVO {

	private String registId; //注册号
	private String name; //名称
	private String type; //类型
	private String representative;//代表人
	private String capital;//注册资本
	private String buildDate;//成立日期
	private String position;//住所
	private String operatorPeriodStart;//营业期限自
	private String operatorPeriodEnd;//营业期限至
	private String businessScope;//经营范围
	private String registation;//登记机关
	private String approveDate;//核准日期
	private String registStatus;//登记状态
	
	public String [] redisPros()
	{
		String [] data = new String [] {"registId","name","type","representative",
				"capital","buildDate","position","operatorPeriodStart","operatorPeriodEnd",
				"businessScope","registation","approveDate","registStatus"};
		return data;
	}
	
	public String getRegistId() {
		return registId;
	}
	public void setRegistId(String registId) {
		this.registId = registId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRepresentative() {
		return representative;
	}
	public void setRepresentative(String representative) {
		this.representative = representative;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getBuildDate() {
		return buildDate;
	}
	public void setBuildDate(String buildDate) {
		this.buildDate = buildDate;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getOperatorPeriodStart() {
		return operatorPeriodStart;
	}
	public void setOperatorPeriodStart(String operatorPeriodStart) {
		this.operatorPeriodStart = operatorPeriodStart;
	}
	public String getOperatorPeriodEnd() {
		return operatorPeriodEnd;
	}
	public void setOperatorPeriodEnd(String operatorPeriodEnd) {
		this.operatorPeriodEnd = operatorPeriodEnd;
	}
	public String getBusinessScope() {
		return businessScope;
	}
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	public String getRegistation() {
		return registation;
	}
	public void setRegistation(String registation) {
		this.registation = registation;
	}
	public String getApproveDate() {
		return approveDate;
	}
	public void setApproveDate(String approveDate) {
		this.approveDate = approveDate;
	}
	public String getRegistStatus() {
		return registStatus;
	}
	public void setRegistStatus(String registStatus) {
		this.registStatus = registStatus;
	}
	
	
}

