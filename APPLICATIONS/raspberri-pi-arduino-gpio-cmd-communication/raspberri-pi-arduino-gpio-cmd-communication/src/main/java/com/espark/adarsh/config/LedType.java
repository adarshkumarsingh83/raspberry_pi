package com.espark.adarsh.config;

public enum LedType {

    RED(1), GREEN(3), YELLOW(5);
    private Integer type;

    LedType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return this.type;
    }
}
