package com.globant.model.students;

public class Student {
    private static int counter;
    private int id;
    private String name;
    private int age;

    public Student(String name, int age) {
        counter++;
        this.id = counter;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student" + " #" + id +
                "\n\tName : " + name +
                "\n\tAge  : " + age;
    }
}
