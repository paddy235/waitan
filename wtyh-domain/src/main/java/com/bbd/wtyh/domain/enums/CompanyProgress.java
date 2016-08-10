package com.bbd.wtyh.domain.enums;

/**
 * 企业进展
 * @author tracy zhou.
 */
public enum CompanyProgress {
    公司注册中("公司注册中", 1),
    等待获批额度("等待获批额度", 2),
    基金募集中("公司注册完成，基金募集中", 3),
    已完成境外投资("已完成境外投资", 4);

    // 成员变量
    private String name;
    private int type;

    /**
     *
     * @param name
     * @param type
     */
    private CompanyProgress(String name, int type) {
        this.name = name;
        this.type = type;
    }

    /**
     *
     * @param type
     * @return
     */
    public static String getName(int type) {
        for (CompanyProgress c : CompanyProgress.values()) {
            if (c.getType() == type) {
                return c.name;
            }
        }
        return null;
    }

    /**
     *
     * @param name
     * @return
     */
    public static int getType(String name) {
        for (CompanyProgress c : CompanyProgress.values()) {
            if (name.trim().equals(c.getName())) {
                return c.type;
            }
        }
        return 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}