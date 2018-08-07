package com.tianhong.DaoFu;

import java.io.*;
import java.util.ArrayList;

public class IOUtil {
    private static int indentation;
    // 读取文本文件中的数据
    public static ArrayList<Employee> readFile(String fileUrl) throws IOException {
        File file = new File(fileUrl);
        if(!file.exists()) {
            throw new IllegalArgumentException("The file: "+fileUrl+" not exist!");
        }
        FileReader reader = new FileReader(file);
        BufferedReader in = new BufferedReader(reader);

        String lineData;
        String[] attributs;
        Employee employee;
        ArrayList<Employee> employees = new ArrayList<Employee>();
        while((lineData = in.readLine()) != null) {
            attributs = lineData.split(", ");
            if(attributs.length == 4){
                employee = new Employee(attributs[0], Integer.valueOf(attributs[1]), Integer.valueOf(attributs[2]), Integer.valueOf(attributs[3]));
            } else {
                employee = new Employee(attributs[0], Integer.valueOf(attributs[1]), Integer.valueOf(attributs[2]));
            }
            employees.add(employee);
        }

        return employees;
    }

    public static void printAll(ArrayList<Employee> employees) {
        // 1. find all the employees with no boss
        ArrayList<Employee> bossList = findTopBoss(employees);
        // 2. print all the subordinates from a boss recursively
        for(Employee employee : bossList) {
            System.out.println("********************************");
            printSubs(employee, employees);
            System.out.println("********************************");
        }

    }

    public static ArrayList<Employee> findTopBoss(ArrayList<Employee> employees) {
        ArrayList<Employee> bossList = new ArrayList<Employee>();
        for(Employee employee : employees) {
            if(employee.isTopBoss()) {
                bossList.add(employee);
            }
        }
        return bossList;
    }

    public static boolean printSubs(Employee boss, ArrayList<Employee> employees) {
        ArrayList<Employee> subs = getSubs(boss, employees);
        if(subs.size() == 0) {
            System.out.println(boss.toString());
            return false;
        }

        System.out.println(boss.toString());

        for(Employee employee : subs) {
            printSubs(employee, employees);
        }
        return true;
    }

    public static ArrayList<Employee> getSubs(Employee boss, ArrayList<Employee> employees) {
        ArrayList<Employee> subs = new ArrayList<Employee>();
        int bossEmployId = boss.getEmployId();
        for(Employee employee : employees) {
            if(employee.getBossId() == bossEmployId) {
                subs.add(employee);
            }
        }
        return subs;
    }
}
