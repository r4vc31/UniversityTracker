package com.globant.utils;

import java.util.List;

public class PrintUtils {
    public static void printMenu(String[] menuOptions, String menuTitle){
        System.out.println(" ");
        System.out.println("*** " + menuTitle + " ***");
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println((i+1) + ". " + menuOptions[i]+ ".");
        }
        System.out.println("*** *-*-*-*-* ***");
        System.out.println(" ");
    }
    public static <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.println(" ");
            System.out.println(item.toString());
        }
    }
}
