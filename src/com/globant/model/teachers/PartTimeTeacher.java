package com.globant.model.teachers;

public class PartTimeTeacher extends Teacher{
    private int activeHoursPerWeek;
    public PartTimeTeacher(String name, int activeHoursPerWeek) {
        super(name);
        this.activeHoursPerWeek = activeHoursPerWeek;
    }

    @Override
    public double calculateSalary() {
        this.setSalary(getBaseSalary() * activeHoursPerWeek);
        return this.getSalary();
    }

    @Override
    public String toString() {
        return "Part Time " + super.toString() +
                "\n\tWork Hours : " + activeHoursPerWeek + "pw";
    }
}
