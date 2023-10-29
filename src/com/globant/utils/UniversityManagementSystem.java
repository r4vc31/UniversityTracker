package com.globant.utils;

import com.globant.model.Identifiable;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class UniversityManagementSystem {

    /**
     * This method searches for an item in a list by its ID.
     *
     * @param id The ID of the item to search for.
     * @param list A list of elements of a generic type T that extends Identifiable.
     * @return The item if found, or null if not found.
     */
    public static <T extends Identifiable> T searchByID(int id, List<T> list){
        for (T item : list) {
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }

    /**
     * This method prompts the user for an ID and retrieves the corresponding item.
     *
     * @param prompt The prompt to display to the user.
     * @param searchFunction The function to apply to the ID to retrieve the item.
     * @return The item if found, or null if not found.
     * @throws NumberFormatException If the input from the user is not a valid integer.
     * @throws IllegalArgumentException If the ID provided by the user is not found.
     */
    public static <T extends Identifiable> T getItemFromUser(String prompt, Function<Integer, T> searchFunction) {
        Scanner scanner = new Scanner(System.in);
        int id;
        T item = null;
        while (item == null) {
            System.out.print(prompt);
            try {
                id = Integer.parseInt(scanner.nextLine());
                item = searchFunction.apply(id);
                if(item == null){
                    throw new IllegalArgumentException("ID not found");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return item;
    }

}
