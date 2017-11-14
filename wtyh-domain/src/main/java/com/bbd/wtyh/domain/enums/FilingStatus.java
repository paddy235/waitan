package com.bbd.wtyh.domain.enums;

/**
 * 备案状态
 * @author tracy zhou.
 */
public enum FilingStatus {
    基金募集中("已备案", 1),
    已完成境外投资("取消备案", 2);

    // 成员变量
    private String name;
    private int type;

    /**
     *
     * @param name
     * @param type
     */
    private FilingStatus(String name, int type) {
        this.name = name;
        this.type = type;
    }

    /**
     *
     * @param type
     * @return
     */
    public static String getName(int type) {
        for (FilingStatus c : FilingStatus.values()) {
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
        for (FilingStatus c : FilingStatus.values()) {
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