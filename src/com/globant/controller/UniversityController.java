package com.globant.controller;

import com.globant.model.courses.Course;
import com.globant.model.students.Student;
import com.globant.model.teachers.Teacher;

import java.util.*;

public class UniversityController {
    private List<Teacher> teachers;
    private List<Student> students;
    private List<Course> courses;

    public UniversityController() {
        teachers = new ArrayList<>();
        students = new ArrayList<>();
        courses = new ArrayList<>();
    }

    // methods to add teachers, students, and courses
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addClass(Course course) {
        courses.add(course);
    }

    // methods to display teachers, students, and courses info
    public void printTeachers() {
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    public void printStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void printCourses() {
        for (Course course : courses) {
            String courseInfo = course.getName().toUpperCase() + " Course " + " - " +
                    "Clasroom: " + course.getClassroom();
            System.out.println(courseInfo);
        }
    }
}
