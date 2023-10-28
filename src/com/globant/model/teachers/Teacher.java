package com.globant.model.teachers;

public abstract class Teacher {
    private String name;
    private static final double baseSalary = 1020;
    private double salary;

    public Teacher(String name) {
        this.name = name;
    }

    public static double getBaseSalary() {
        return baseSalary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Teacher" +
                "\n\tName   : " + name +
                "\n\tSalary : " + ((salary <= 0)?"Not calculated":String.format("%.2f", salary));
    }
}
