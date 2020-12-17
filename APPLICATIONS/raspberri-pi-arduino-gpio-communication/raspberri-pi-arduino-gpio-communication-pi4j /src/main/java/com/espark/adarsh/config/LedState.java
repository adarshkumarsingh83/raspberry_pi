package com.espark.adarsh.config;

public enum LedState {

    ON(1), OFF(0);

    private Integer state;

    LedState(Integer state) {
        this.state = state;
    }

    public Integer getState() {
        return this.state;
    }
}
