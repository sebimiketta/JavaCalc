package com.company;

public class CalculatorData {
    public final String[] help_text = {
        "Help from Calculator",
        "Here are the options to use this Calculator",
        "Options:",
        "help : Display this help",
        "exit : Exit the Calculator",
        "supported operations",
        "1*4-5+2/5"
    };

    public final String[] start_string = {
            "Start Calculator",
            "Type 'help' for Information about this Calculator"
    };

    public final String exit_string = "exit";
    public final String help_string = "help";
    public final String quit_string = "Quit Calculator";
    public final String start_calc_string = "Please type what you want to calculate and hit enter";
    public final String invalid_char_error = "Not Valid operation or char in calculation";
    public final String invalid_start_error = "calculation does not start with a number";
    public final String invalid_end_error = "calculation does not end with a number";
    public final String invalid_operation_error = "Wanted Cal operation contains not valid operation";
}
