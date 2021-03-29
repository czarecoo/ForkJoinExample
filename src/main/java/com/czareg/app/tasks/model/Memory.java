package com.czareg.app.tasks.model;

public class Memory {
    private String size = "8GB";
    private String type = "DDR3";

    @Override
    public String toString() {
        return "Memory{" +
                "size='" + size + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}