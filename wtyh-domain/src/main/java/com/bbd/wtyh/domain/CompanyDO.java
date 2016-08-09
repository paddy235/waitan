package com.bbd.wtyh.domain;

import java.util.Date;


public class CompanyDO extends BaseDO {


	//1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:金融  8:其他
	public static final byte TYPE_P2P_1  = 1;
	public static final byte TYPE_XD_2   = 2;
	public static final byte TYPE_RZDB_3 = 3;
	public static final byte TYPE_XXLC_4 = 4;
	public static final byte TYPE_SMJJ_5 = 5;
	public static final byte TYPE_ZC_6   = 6;
	public static final byte TYPE_JR_7   = 7;
	public static final byte TYPE_QT_8   = 8;


    private Integer companyId;

    private String name;

    private String legalPerson;

    private Integer areaId;

    private String address;

    private Integer registeredCapital;

    private Date registeredDate;

    private Byte companyType;

    @SuppressWarnings("unused")
	private String comTypeCN;



	private String products;

    private Byte status;

    private Byte background;

    @SuppressWarnings("unused")
	private String backgroundCN;

    private String registeredType;

    private String businessType;




	public String getBackgroundCN() {
	    if(null == background){
	        return null;
        }
		return CompanyBackgroundDO.Bg.getBg(this.background).CN;
	}





	public String getComTypeCN(){
	    if(null == companyType){
	        return null;
        }
    	switch (companyType) {
		case TYPE_P2P_1:
			return "p2p";
		case TYPE_XD_2:
			return "小贷";
		case TYPE_RZDB_3:
			return "融资担保";
		case TYPE_XXLC_4:
			return "线下理财";
		case TYPE_SMJJ_5:
			return "私募基金";
		case TYPE_ZC_6:
			return "众筹";
		case TYPE_JR_7:
			return "金融";
		case TYPE_QT_8:
			return "其他";
		default:
			return null;
		}
    }






	public String getRegisteredType() {
		return registeredType;
	}


	public void setRegisteredType(String registeredType) {
		this.registeredType = registeredType;
	}



	public void setComTypeCN(String comTypeCN) {
		this.comTypeCN = comTypeCN;
	}

	public Byte getBackground() {
		return background;
	}


	public void setBackground(Byte background) {
		this.background = background;
	}


    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(Integer registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Byte getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Byte companyType) {
        this.companyType = companyType;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products == null ? null : products.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
}