package com.globant.model.courses;

import com.globant.model.Identifiable;
import com.globant.model.students.Student;
import com.globant.model.teachers.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Course extends Identifiable {
    private String classroom;
    private List<Student> students;
    private Teacher teacher;

    public Course(String name) {
        super();
        this.name = name;
        students = new ArrayList<>();
    }

    public Course(String name, String classroom, List<Student> students, Teacher teacher) {
        this(name);
        this.classroom = classroom;
        this.students = students;
        this.teacher = teacher;
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
        students.add(newStudent);
    }

    public void removeStudent(Student newStudent){
        students.remove(newStudent);
    }

    public void assignTeacher(Teacher newTeacher){
        this.teacher = newTeacher;
    }

    @Override
    public String toString() {
        return "Course " + "( " +  "id#" + id + " )" +
                "\n\tName            : " + name +
                "\n\tClassroom       : " + ((classroom==null)?"NA":classroom) +
                "\n\tNo. of Students : " + ((students==null)?0:students.size());
    }
}

