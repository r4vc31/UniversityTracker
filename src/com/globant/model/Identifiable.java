package com.globant.model;

/**
 * Abstract Class for any entity that has an id and a name
 */
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
