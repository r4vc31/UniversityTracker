package com.globant.utils;

import java.util.List;

public class PrintUtils {

    /**
     * This method prints a menu to the console.
     *
     * @param menuOptions An array of Strings where each String is a menu option.
     * @param menuTitle The title of the menu to be displayed.
     */public static void printMenu(String[] menuOptions, String menuTitle){
        System.out.println(" ");
        System.out.println("*** " + menuTitle + " ***");
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println((i+1) + ". " + menuOptions[i]+ ".");
        }
        System.out.println("*** *-*-*-*-* ***");
        System.out.println(" ");
    }

    /**
     * This method prints a list to the console.
     *
     * @param list A list of elements of generic type T. Each element is printed on a new line.
     */
    public static <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.println(" ");
            System.out.println(item.toString());
        }
    }
}
