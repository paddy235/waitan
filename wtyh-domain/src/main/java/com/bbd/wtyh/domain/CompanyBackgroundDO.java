package com.bbd.wtyh.domain;

public class CompanyBackgroundDO extends BaseDO {
	
    private Integer id;

    private Integer companyId;

    private Byte background;
    
    static public enum Bg {
        
    	//1:上市公司 2:非上市公司 3:国企 4:民营企业 5:外资企业
    	Ssgs( (byte) 1,"上市公司"),
    	Fssgs((byte) 2,"非上市公司"),
    	Gq(   (byte) 3,"国企"),
    	Myqy( (byte) 4,"民营企业"),
        Wzqy( (byte) 5,"外资企业");
    	
        public final Byte val;
        public final String CN;

        private Bg(Byte val, String CN) {
            this.val = val;
            this.CN = CN;
        }
        
        public static Bg getBg(Byte val){
        	switch (val) {
    		case 1:
    			return Bg.Ssgs;
    		case 2:
    			return Bg.Fssgs;
    		case 3:
    			return Bg.Gq;
    		case 4:
    			return Bg.Myqy;
            case 5:
                return Bg.Wzqy;
    		default:
    			return null;
    		}
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Byte getBackground() {
        return background;
    }

    public void setBackground(Byte background) {
        this.background = background;
    }
}