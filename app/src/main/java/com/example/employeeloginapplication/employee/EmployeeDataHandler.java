package com.example.employeeloginapplication.employee;
/*
@author Swati.Khobragade
 */

import java.util.ArrayList;

public class EmployeeDataHandler {
    /**
     * Method to get List of Employees
     * @return
     */
    public static ArrayList<Employee> getEmpData() {
        ArrayList<Employee> empList = new ArrayList<>(10);

        Employee employee1 = new Employee("Radhika", 24, "Software Developer", "developer");
        Employee employee2 = new Employee("Vedant", 22, "Software Tester", "developer");
        Employee employee3 = new Employee("Vaibhav", 24, "Software Developer", "manager");
        Employee employee4 = new Employee("Swarna", 25, "Software Developer", "admin");
        Employee employee5 = new Employee("Sayali", 24, "Software Developer", "developer");
        Employee employee6 = new Employee("Swati", 25, "Software Engineer", "developer");
        Employee employee7 = new Employee("Sanjana", 24, "Software Developer", "developer");
        Employee employee8 = new Employee("Amit", 24, "Software Developer", "developer");
        empList.add(employee1);
        empList.add(employee2);
        empList.add(employee3);
        empList.add(employee4);
        empList.add(employee5);
        empList.add(employee6);
        empList.add(employee7);
        empList.add(employee8);
        System.out.println("empList::" + empList);
        return empList;
    }
}
