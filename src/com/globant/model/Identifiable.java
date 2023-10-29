package com.globant.model;

public abstract class Identifiable {
    private static int counter = 0;
    private final int id;
    private String name;

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
