package com.globant.model.teachers;

import com.globant.model.ISalaryCalculator;
import com.globant.model.Identifiable;

public abstract class Teacher extends Identifiable implements ISalaryCalculator {
    private double salary;

    public Teacher(String name) {
        super();
        this.setName(name);
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
        return "Teacher "  + "( " +  "id#" + getId() + " )" +
                "\n\tName   : " + getName() +
                "\n\tSalary : " + ((salary <= 0)?"Not calculated":String.format("%.2f", salary));
    }
}
