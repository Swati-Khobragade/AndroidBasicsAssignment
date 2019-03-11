package com.example.employeeloginapplication.employee;

import java.util.ArrayList;

/**
 * @author swati.khobragade
 */
public class Employee {
    private String empName;
    private int empAge;
    private String empDesignation;
    private int empResId;


    public Employee(String empName, int empAge, String empDesignation, int empResId) {
        super();
        this.empName = empName;
        this.empAge = empAge;
        this.empDesignation = empDesignation;
        this.empResId = empResId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public int getEmpResId() {
        return empResId;
    }

    public void setEmpResId(int empResId) {
        this.empResId = empResId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("empName='").append(empName).append('\'');
        sb.append(", empAge=").append(empAge);
        sb.append(", empDesignation='").append(empDesignation).append('\'');
        sb.append(", empResId=").append(empResId);
        sb.append('}');
        return sb.toString();
    }
}
