package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

    public String[] convert_list_to_array(List<String> args){
        String[] ret = new String[args.size()];
        ret = args.toArray(ret);
        return ret;
    }

    public List<String> convert_array_to_list(String[] args){
        return Arrays.asList(args);
    }

    public boolean array_contains(String[] string_array, String check_string){
        List<String> string_list = convert_array_to_list(string_array);
        return string_list.contains(check_string);
    }
    public boolean find_match(String input, String pattern){
        Pattern my_pattern = Pattern.compile(pattern);
        Matcher match = my_pattern.matcher(input);
        return match.find();
    }
}
