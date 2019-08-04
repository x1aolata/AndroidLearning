package com.example.advancedskills;

import java.io.Serializable;

public class Person implements Serializable {


    public Person(String name,boolean ismarried)
    {
        this.name=name;
        this.ismarried=ismarried;
    }
    private String name;

    private boolean ismarried;

    public void setName(String name) {
        this.name = name;
    }

    public void setIsmarried(boolean ismarried) {
        this.ismarried = ismarried;
    }

    public String getName() {
        return name;
    }

    public boolean getismarried() {
        return ismarried;
    }
}
