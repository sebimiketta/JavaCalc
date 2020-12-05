package com.company;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class InputManagment {

    Helper helper = new Helper();

    /**
     * Validate the User Input
     * Check if the string only contains supported operations
     * Check and replace whitespaces
     * check if the string contains a valid operation
     * @param calc_string user input with the calculation
     * @return user input as array
     */
    private String validate_user_input(String calc_string){
        calc_string = calc_string.replaceAll("\\s+", "");
        // Check if only supported operations are in the String
        if (helper.find_match(calc_string, "[^\\+\\-\\*\\/\\d]")){
            System.out.println("Not Valid operation or char in calculation");
            return null;
        }
        // Check that operation starts with a number
        if (!helper.find_match(calc_string, "^\\d")){
            System.out.println("calculation does not start with a number");
            return null;
        }
        // Check that operation ends with a number
        if (!helper.find_match(calc_string, "\\d$")){
            System.out.println("calculation does not end with a number");
            return null;
        }
        return calc_string;
    }

    private String read_input(){
        System.out.println("Please type what you want to calculate and hit enter");
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        return input.next();
    }

    public String GetInput(){
        // Get user input from std input and return as string
        String user_input;
        String valid_input;
        user_input = read_input();
        while (validate_user_input(user_input) == null){
            user_input = read_input();
        }
        return validate_user_input(user_input);
    }
}
