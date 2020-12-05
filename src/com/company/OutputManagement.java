package com.company;

import javax.print.DocFlavor;
import java.util.List;

public class OutputManagement {
    public void print_string_array(String[] args){
        for (String str : args){
            System.out.println(str);
        }
    }

    public void print_list(List<String> args){
        for (String str: args){
            System.out.println(str);
        }
    }
}
