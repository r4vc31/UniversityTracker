package com.globant.model.teachers;

public class PartTimeTeacher extends Teacher{
    private static final double baseSalary = 800;
    private int activeHoursPerWeek;
    public PartTimeTeacher(String name, int activeHoursPerWeek) {
        super(name);
        this.activeHoursPerWeek = activeHoursPerWeek;
    }

    public int getActiveHoursPerWeek() {
        return activeHoursPerWeek;
    }

    public void setActiveHoursPerWeek(int activeHoursPerWeek) {
        this.activeHoursPerWeek = activeHoursPerWeek;
    }

    @Override
    public double calculateSalary() {
        this.setSalary(PartTimeTeacher.baseSalary * activeHoursPerWeek);
        return this.getSalary();
    }

    @Override
    public String toString() {
        return "Part Time " + super.toString() +
                "\n\tWork Hours : " + activeHoursPerWeek + "pw";
    }
}
