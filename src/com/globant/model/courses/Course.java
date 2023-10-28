package com.globant.model.courses;

import com.globant.model.students.Student;
import com.globant.model.teachers.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private static int counter = 0;
    private int id;
    private String name;
    private String classroom;
    private List<Student> students;
    private Teacher teacher;

    public Course(String name) {
        counter++;
        this.id = counter;
        this.name = name;
    }

    public Course(String name, String classroom, List<Student> students, Teacher teacher) {
        this(name);
        this.classroom = classroom;
        this.students = students;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void assignClassroom(String classroom){
        this.classroom = classroom;
    }

    public void addStudent(Student newStudent){
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(newStudent);
    }

    public void assignTeacher(Teacher newTeacher){
        this.teacher = newTeacher;
    }

    @Override
    public String toString() {
        return "Course" + " #" + id +
                "\n\tName:               " + name +
                "\n\tClassroom:          " + ((classroom==null)?"NA":classroom) +
                "\n\tNumber of students: " + ((students==null)?0:students.size()) +
                "\n\tTeacher:            " + ((teacher==null)?"NA":teacher);
    }
}

