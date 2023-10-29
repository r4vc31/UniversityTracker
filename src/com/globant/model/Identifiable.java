package com.globant.model;

public abstract class Identifiable {
    public static int counter = 0;
    public final int id;
    public String name;

    protected Identifiable() {
        counter++;
        this.id = counter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
