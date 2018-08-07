package com.tianhong.DaoFu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees = IOUtil.readFile("src/main/java/com/tianhong/DaoFu/data.txt");
        IOUtil.printAll(employees);
//        System.out.println("Welcome to use the EMS...");
//        System.out.println("Type in the employee id: ");
//        Scanner in = new Scanner(System.in);
//        String consoleInput;
//        while(!(consoleInput = in.next()).toUpperCase().equals("EXIT")) {
//            if(consoleInput.toUpperCase().equals("ALL")) {
//                IOUtil.printAll(employees);
//            }
//        }


    }
}
