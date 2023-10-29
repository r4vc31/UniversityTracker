package com.globant.model.students;

import com.globant.model.Identifiable;

public class Student extends Identifiable {
    private int age;

    public Student(String name, int age) {
        super();
        this.setName(name);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student "  + "( " +  "id#" + getId() + " )" +
                "\n\tName : " + getName() +
                "\n\tAge  : " + age;
    }
}
