package com.globant.model.teachers;

public class FullTimeTeacher extends Teacher{
    private int experienceYears;

    public FullTimeTeacher(String name, int experienceYears) {
        super(name);
        this.experienceYears = experienceYears;
    }

    @Override
    public double calculateSalary() {
        this.setSalary(getBaseSalary() * (1.10 * experienceYears));
        return this.getSalary();
    }

    @Override
    public String toString() {
        return "Full Time " + super.toString() +
                "\n\tExperience : " + experienceYears + "yr";
    }
}
