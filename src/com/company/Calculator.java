package com.company;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    InputManagment input_manager = new InputManagment();
    OutputManagement output_manager = new OutputManagement();
    CalculatorData calculator_data = new CalculatorData();
    Helper helper = new Helper();
    boolean exit_calc = false;

    public void help_text(){
        output_manager.print_string_array(calculator_data.help_text);
    }

    /**
     * Get the user input as a array
     * @param calc_string user input as string
     * @return user input as array
     */
    private String[] get_calc_array(String calc_string){
        return calc_string.split("(?<=\\+)|(?=\\+)|(?<=\\*)|(?=\\*)|(?<=\\/)|(?=\\/)|(?<=\\-)|(?=\\-)");
    }

    private double multiply(String value_1, String value_2){
        // multiply Value 1 and Value 2
        return Double.parseDouble(value_1) * Double.parseDouble(value_2);
    }

    private double div(String value_1, String value_2){
        // multiply Value 1 and Value 2
        return Double.parseDouble(value_1) / Double.parseDouble(value_2);
    }
    private double add(String value_1, String value_2){
        // add Value 1 and Value 2
        return Double.parseDouble(value_1) + Double.parseDouble(value_2);
    }

    private double subtract(String value_1, String value_2){
        // subtract Value 1 and Value 2
        return Double.parseDouble(value_1) - Double.parseDouble(value_2);
    }

    /**
     * Run one Calculation operation on the given array
     * this function iterates through the given array and on runs the operation on the first encounter with the given
     * operation. Than the result is set as replacement for the two values in the returned list
     * @param calc_array array with the operations
     * @param operation wanted operation
     * @return new array with the result
     */
    private String[] one_operation(String[] calc_array, String operation){
        int index = 0;
        int result_index = 0;
        int operation_index = 0;
        int index_before = 0;
        int index_after = 0;
        List<String> result_list = new ArrayList<String>();
        double tmp_result = 0;
        for (String elem: calc_array){
            if (elem.equals(operation)){
                operation_index = index;
                index_before = operation_index - 1;
                index_after = operation_index + 1;
                switch (operation) {
                    case "*" -> tmp_result = multiply(calc_array[index_before], calc_array[index_after]);
                    case "/" -> tmp_result = div(calc_array[index_before], calc_array[index_after]);
                    case "+" -> tmp_result = add(calc_array[index_before], calc_array[index_after]);
                    case "-" -> tmp_result = subtract(calc_array[index_before], calc_array[index_after]);
                }
                break;
            }
            index += 1;
        }
        for (String elem: calc_array){
            if (result_index == operation_index){
                result_list.add(Double.toString(tmp_result));
            }
            else if (result_index != index_before && result_index != index_after){
                result_list.add(elem);
            }
            result_index += 1;
        }
        return helper.convert_list_to_array(result_list);
    }

    /**
     * Check if the wanted operation is in the given array and if the operation is found the calculation is run
     * This is repeated until no more of the wanted operations are found in the given list
     * @param calc_array array which contians the calucations
     * @param operation wanted operation
     * @return array with the results
     */
    public String[] calculate(String[] calc_array, String operation){
        String[] result_array;
        result_array = one_operation(calc_array, operation);
        if (helper.array_contains(result_array, operation)){
            return calculate(result_array, operation);
        }
        else{
            return result_array;
        }
    }

    /**
     * Try to run all calculations on the given array, starting with * and /
     * and than run add and substract and return the result
     * @param calc_array array which contains all operations
     * @return result of the operations
     */
    public double calculation(String[] calc_array){
        String[] result_array;
        double result = 0;
        if (helper.array_contains(calc_array, "/")) {
            result_array = calculate(calc_array, "/");
        }
        else if (helper.array_contains(calc_array, "*")) {
            result_array = calculate(calc_array, "*");
        }
        else if (helper.array_contains(calc_array, "+")) {
            result_array = calculate(calc_array, "+");
        }
        else if (helper.array_contains(calc_array, "-")) {
            result_array = calculate(calc_array, "-");
        }
        else{
            System.out.println(calculator_data.invalid_operation_error);
            return 0;
        }
        if (result_array.length == 1){
            return Double.parseDouble(result_array[0]);
        }
            return calculation(result_array);
    }

    public void start(){
        double result;
        String[] valid_user_input;
        String user_input;
        output_manager.print_string_array(calculator_data.start_string);
        while (!exit_calc){
            user_input = input_manager.GetInput();
            if (user_input.equals(calculator_data.exit_string)){
                exit_calc = true;
            }
            else if (user_input.equals(calculator_data.help_string)){
                help_text();
            }
            else{
                result = calculation(get_calc_array(user_input));
                output_manager.print_result(user_input, result);
            }
        }
        System.out.println(calculator_data.quit_string);
        System.exit(0);
    }
}
