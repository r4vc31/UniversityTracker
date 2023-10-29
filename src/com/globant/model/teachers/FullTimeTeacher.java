package com.globant.model.teachers;

public class FullTimeTeacher extends Teacher{
    private static final double baseSalary = 1500;
    private int experienceYears;

    public FullTimeTeacher(String name, int experienceYears) {
        super(name);
        this.experienceYears = experienceYears;
    }

    @Override
    public double calculateSalary() {
        this.setSalary(FullTimeTeacher.baseSalary * (1.10 * experienceYears));
        return this.getSalary();
    }

    @Override
    public String toString() {
        return "Full Time " + super.toString() +
                "\n\tExperience : " + experienceYears + "yr";
    }
}
