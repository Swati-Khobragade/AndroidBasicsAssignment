package com.example.employeeloginapplication.employee;
/*
@author Swati.Khobragade
 */

import com.example.employeeloginapplication.R;

import java.util.ArrayList;

public class EmployeeDataHandler {
    /**
     * Method to get List of Employees
     *
     * @return
     */
    public static ArrayList<Employee> getEmpData() {
        ArrayList<Employee> empList = new ArrayList<>(10);

        Employee employee1 = new Employee("Radhika", 24, "Software Developer", R.drawable.img1);
        Employee employee2 = new Employee("Vedant", 22, "Software Tester", R.drawable.img7);
        Employee employee3 = new Employee("Vaibhav", 24, "Software Developer", R.drawable.img6);
        Employee employee4 = new Employee("Swarna", 25, "Software Developer", R.drawable.img4);
        Employee employee5 = new Employee("Sayali", 24, "Software Developer", R.drawable.img5);
        Employee employee6 = new Employee("Swati", 25, "Software Engineer", R.drawable.img2);
        Employee employee7 = new Employee("Sanjana", 24, "Software Developer", R.drawable.img3);
        Employee employee8 = new Employee("Amit", 24, "Software Developer", R.drawable.img8);
        Employee employee9 = new Employee("Ragini", 24, "Software Developer", R.drawable.img9);
        Employee employee10 = new Employee("Pratik", 22, "Software Tester", R.drawable.img13);
        Employee employee11 = new Employee("Komal", 25, "Software Developer", R.drawable.img10);
        Employee employee12 = new Employee("Neha", 25, "Software Tester", R.drawable.img11);
        Employee employee13 = new Employee("Suryanshu", 22, "Software Developer", R.drawable.img14);
        Employee employee14 = new Employee("Nikita", 23, "Software Tester", R.drawable.img12);
        Employee employee15 = new Employee("Vicky", 22, "Software Developer", R.drawable.img15);
        empList.add(employee1);
        empList.add(employee2);
        empList.add(employee3);
        empList.add(employee4);
        empList.add(employee5);
        empList.add(employee6);
        empList.add(employee7);
        empList.add(employee8);
        empList.add(employee9);
        empList.add(employee10);
        empList.add(employee11);
        empList.add(employee12);
        empList.add(employee13);
        empList.add(employee14);
        empList.add(employee15);
        System.out.println("empList::" + empList);
        return empList;
    }
}
