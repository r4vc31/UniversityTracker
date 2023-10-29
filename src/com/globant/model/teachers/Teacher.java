package com.globant.model.teachers;

import com.globant.model.ISalaryCalculator;
import com.globant.model.Identificable;

public abstract class Teacher extends Identificable implements ISalaryCalculator {
    private double salary;

    public Teacher(String name) {
        Identificable.counter++;
        this.id = Identificable.counter;
        this.name = name;
    }

    public int getId() {
        return id;
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
