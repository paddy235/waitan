package com.bbd.wtyh.domain.enums;

/**
 * Created by tracy zhou
 * on 2016/8/7 0007.
 */
public enum ExchangeCompanyStatus {
    清理整顿后市政府批复设立的交易场所("清理整顿后市政府批复设立的交易场所", 1),
    清理整顿后自行设立的交易场所("清理整顿后自行设立的交易场所", 2),
    清理整顿后主管单位批设但未经会商的交易场所("清理整顿后主管单位批设但未经会商的交易场所", 3),
    清理整顿后取得合规意见或经过会商的交易场所("清理整顿后取得合规意见或经过会商的交易场所", 4),
    清理整顿后通过验收的交易所("清理整顿通过验收的交易所", 5);

    // 成员变量
    private String name;
    private int type;

    /**
     *
     * @param name
     * @param type
     */
    private ExchangeCompanyStatus(String name, int type) {
        this.name = name;
        this.type = type;
    }

    /**
     *
     * @param type
     * @return
     */
    public static String getName(int type) {
        for (ExchangeCompanyStatus c : ExchangeCompanyStatus.values()) {
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
        for (ExchangeCompanyStatus c : ExchangeCompanyStatus.values()) {
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
