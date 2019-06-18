package com.example.demo.components;

public interface Selectable {

    String getSelectorId();

    String getSelectorTitle();

    default public String getClassName() {
        return "";
    }
}
