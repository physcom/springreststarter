package io.qtechdigital.onlineTutoring.components;

public interface Selectable {

    String getSelectorId();

    String getSelectorTitle();

    default public String getClassName() {
        return "";
    }
}
