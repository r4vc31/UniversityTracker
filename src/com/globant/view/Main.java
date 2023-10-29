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

        // Options available from the main menu
        String[] principalOptions = {
                "Print all the professors",
                "Print all the courses",
                "Register a new student",
                "Register a new course",
                "List all the classes in which a given student is included",
                "Exit"
        };

        // Options available from the course detail submenu
        String[] courseOptions = {
                "Show the teacher",
                "List students",
                "Exit"
        };

        Scanner scanner = new Scanner(System.in);
        // Variable for the data entered by the user
        String option;

        // Variable that controls execution in the main menu
        boolean exit = false;

        while (!exit){
            // Present the main menu
            PrintUtils.printMenu(principalOptions, "University Management System");
            // Request a menu option from the user
            System.out.printf("Select an option (1 - %d): ", principalOptions.length);
            option = scanner.nextLine();
            // Establish sharing based on what is selected
            switch (option){
                case "1":
                    // Print the list of all teachers in the university.
                    universityController.printTeachers();
                    break;
                case "2":
                    // Print the list of all courses in the university.
                    universityController.printCourses();
                    System.out.println(" ");
                    // Ask the user about the course to see in detail and search for it among existing ones
                    Course course2 = UniversityManagementSystem.getItemFromUser("Enter the course ID to see details: ",
                            universityController::searchCourseByID);
                    // Variable that controls execution in the sub-menu
                    boolean exitSubMenuCourse = false;
                    while (!exitSubMenuCourse){
                        // Displays a sub-menu where the user can choose to see details about the course or exit
                        PrintUtils.printMenu(courseOptions, "Course Details");
                        // Request a sub-menu option from the user
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
                    // Create a new student
                    Student newStudent = universityController.createStudent();
                    // Add them to the university
                    universityController.addStudent(newStudent);
                    // Prompt the user for a course ID and search among existing ones
                    Course course3 = UniversityManagementSystem.getItemFromUser("Enter the target course ID: ",
                            universityController::searchCourseByID);
                    // Add the new student to that course
                    course3.addStudent(newStudent);
                    break;
                case "4":
                    Course newCourse = universityController.createCourse();
                    universityController.addCourse(newCourse);
                    break;
                case "5":
                    // Prompt the user for a student ID and search among existing ones
                    Student student = UniversityManagementSystem.getItemFromUser("Enter the student ID: ",
                            universityController::searchStudentByID);
                    // Initialize an empty list of courses.
                    List<Course> courses = new ArrayList<>();
                    // Search in the courses if the student is there
                    for (Course c : universityController.getCourses()) {
                        if(c.getStudents().contains(student)){
                            //this student is enrolled in, add the course to the list
                            courses.add(c);
                        }
                    }
                    // Print the list of courses the student is in
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