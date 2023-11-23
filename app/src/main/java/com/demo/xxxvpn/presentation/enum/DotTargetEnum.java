package com.demo.xxxvpn.presentation;

public enum DotTargetEnum {
    VIEW(1, "view"),
    CLICK(2, "click");

    /**
     * 类型
     */
    private Integer type;
    /**
     * 描述
     */
    private String description;

    DotTargetEnum(Integer type, String description) {
        this.type = type;
        this.description = description;
    }

    public Integer getType() {
        return type;
    }
}
