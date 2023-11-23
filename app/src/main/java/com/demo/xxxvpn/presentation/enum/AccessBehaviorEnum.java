package com.demo.xxxvpn.presentation;

public enum AccessBehaviorEnum {

    VIEW(1, "view"),
    START_DOT(2, "start"),
    AD_LIMIT(3, "limit");

    /**
     * 状态
     */
    private Integer type;
    /**
     * 描述
     */
    private String description;

    AccessBehaviorEnum(Integer type, String description) {
        this.type = type;
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
