package com.globant.controller;

import com.globant.model.courses.Course;
import com.globant.model.students.Student;
import com.globant.model.teachers.FullTimeTeacher;
import com.globant.model.teachers.PartTimeTeacher;
import com.globant.model.teachers.Teacher;
import com.globant.utils.PrintUtils;
import com.globant.utils.UniversityManagementSystem;

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

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // methods to add teachers, students, and courses
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }


    // methods to display teachers, students, and courses info
    public void printTeachers() {
        PrintUtils.printList(teachers);
    }

    public void printStudents() {
        PrintUtils.printList(students);
    }

    public void printCourses() {
        PrintUtils.printList(courses);
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
        Random rand = new Random();
        for (int i = 1; i <= 4; i++) {
            String name = coursesName[i-1];
            String classroom = "Room_" + (100+i);
            Student randomStudent;
            int numberStudents = rand.nextInt(students.size());
            List<Student> studentsCourse = new ArrayList<>();
            while (studentsCourse.size() < numberStudents){
                randomStudent = students.get(rand.nextInt(students.size()));
                if ((studentsCourse.contains(randomStudent))){
                    continue;
                }
                studentsCourse.add(randomStudent);
            }
            Teacher teacher = teachers.get(rand.nextInt(teachers.size()));
            courses.add(new Course(name, classroom, studentsCourse, teacher));
        }
    }

    public Course createCourse(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the course name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the classroom: ");
        String classroom = scanner.nextLine();

        boolean addStudent = true;
        String userInput;
        List<Student> studentsCourse = new ArrayList<>();
        while (addStudent){
            System.out.print("Add a student? (y/n): ");
            userInput = scanner.nextLine();
            if (userInput.equals("y")){
                Student student = UniversityManagementSystem.getItemFromUser("Enter the student ID: ",
                        this::searchStudentByID);
                studentsCourse.add(student);
            } else if (userInput.equals("n")) {
                addStudent = false;
            }else {
                System.out.println("The input is not valid");
            }
        }
        Teacher teacher = UniversityManagementSystem.getItemFromUser("Enter the teacher ID: ",
                this::searchTeacherByID);

        return new Course(name, classroom, studentsCourse, teacher);
    }

    public Student createStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student's name: ");
        String name = scanner.nextLine();
        int age = -1;
        while (age == -1){
            System.out.print("Enter the student's age: ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                age = (age > 0)?age:-1;
            }catch (NumberFormatException e){
                System.out.println("Invalid Age");
            }
        }

        return new Student(name, age);

    }

    //Search methods
    public Student searchStudentByID(int id){
        return UniversityManagementSystem.searchByID(id, students);
    }

    public Teacher searchTeacherByID(int id){
        return UniversityManagementSystem.searchByID(id, teachers);
    }

    public Course searchCourseByID(int id){
        return UniversityManagementSystem.searchByID(id, courses);
    }



}
