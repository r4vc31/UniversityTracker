package com.globant.view;

import com.globant.controller.UniversityController;
import com.globant.model.courses.Course;
import com.globant.model.students.Student;
import com.globant.utils.PrintUtils;
import com.globant.utils.UniversityManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create a new UniversityController
        UniversityController universityController = new UniversityController();
        // Initialize data
        universityController.initializeData();

        String[] principalOptions = {
                "Print all the professors",
                "Print all the courses",
                "Register a new student",
                "Register a new course",
                "List all the classes in which a given student is included",
                "Exit"
        };

        String[] courseOptions = {
                "Show the teacher",
                "List students",
                "Exit"
        };

        Scanner scanner = new Scanner(System.in);
        String option;

        boolean exit = false;

        while (!exit){
            PrintUtils.printMenu(principalOptions, "University Management System");
            System.out.printf("Select an option (1 - %d): ", principalOptions.length);
            option = scanner.nextLine();
            switch (option){
                case "1":
                    universityController.printTeachers();
                    break;
                case "2":
                    universityController.printCourses();
                    System.out.println(" ");
                    Course course2 = UniversityManagementSystem.getItemFromUser("Enter the course ID to see details: ",
                            universityController::searchCourseByID);
                    boolean exitSubMenuCourse = false;
                    while (!exitSubMenuCourse){
                        PrintUtils.printMenu(courseOptions, "Course Details");
                        System.out.printf("Select an option (1 - %d): ", courseOptions.length);
                        option = scanner.nextLine();
                        switch (option){
                            case "1":
                                System.out.println(course2.getTeacher());
                                break;
                            case "2":
                                PrintUtils.printList(course2.getStudents());
                                break;
                            case "3":
                                exitSubMenuCourse = true;
                                break;
                            default:
                                System.out.println("The selection is not valid");
                                break;
                        }
                    }
                    break;
                case "3":
                    Student newStudent = universityController.createStudent();
                    universityController.addStudent(newStudent);
                    Course course3 = UniversityManagementSystem.getItemFromUser("Enter the target course ID: ",
                            universityController::searchCourseByID);
                    course3.addStudent(newStudent);
                    break;
                case "4":
                    Course newCourse = universityController.createCourse();
                    universityController.addCourse(newCourse);
                    break;
                case "5":
                    Student student = UniversityManagementSystem.getItemFromUser("Enter the student ID: ",
                            universityController::searchStudentByID);
                    List<Course> courses = new ArrayList<>();
                    for (Course c : universityController.getCourses()) {
                        if(c.getStudents().contains(student)){
                            courses.add(c);
                        }
                    }
                    PrintUtils.printList(courses);
                    break;
                case "6":
                    exit = true;
                    break;
                default:
                    System.out.println("The selection is not valid");
                    break;
            }
        }


    }
}