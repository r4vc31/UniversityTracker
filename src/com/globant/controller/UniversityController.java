package com.globant.controller;

import com.globant.model.courses.Course;
import com.globant.model.students.Student;
import com.globant.model.teachers.FullTimeTeacher;
import com.globant.model.teachers.PartTimeTeacher;
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
    //General
    public static void printElements(Object[] objects ){
        for (int i = 0; i < objects.length; i++) {
            Object obj = objects[i];
            System.out.println((i+1) + ". " + obj.toString());
        }
    }
    //Specific
    public void printTeachers() {
        printElements(teachers.toArray());
    }

    public void printStudents() {
        printElements(students.toArray());
    }

    public void printCourses() {
        printElements(courses.toArray());
    }


    public void initializeData() {
        // Initialize teachers, students, and classes

        // Add 2 full time teachers
        teachers.add(new FullTimeTeacher("Alice", 10));
        teachers.add(new FullTimeTeacher("Bob", 12));

        // Add 2 part-time teachers
        teachers.add(new PartTimeTeacher("Charlie",20));
        teachers.add(new PartTimeTeacher("Dave",15));

        // Add 6 students
        String[] studentsName = {"Juan", "Ronald", "José", "Antony", "Helen", "Katy"};
        for (int i = 0; i < 6; i++) {
            students.add(new Student(studentsName[i], 20 + i));
        }

        // Add 4 courses
        String[] coursesName = {"OS Design", "DB Systems", "AI Basics", "ML Intro"};
        for (int i = 1; i <= 4; i++) {
            Course course = new Course(coursesName[i-1]);
            course.assignClassroom("Room_" + (100+i));
            course.setTeacher(teachers.get(i - 1));
            Student randomStudent;
            Random rand = new Random();
            for (int j = 0; j < 3; j++) {
                randomStudent = students.get(rand.nextInt(students.size()));
                course.addStudent(randomStudent);
            }
            courses.add(course);
        }
    }
}
