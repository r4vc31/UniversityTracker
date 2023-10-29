package com.globant.utils;

import com.globant.model.Identifiable;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class UniversityManagementSystem {
    public static <T extends Identifiable> T searchByID(int id, List<T> list){
        for (T item : list) {
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }

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
