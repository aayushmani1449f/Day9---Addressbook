package com.employeepayroll;

public class EmployeeWageMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        int IS_FULL_TIME = 1;
        int IS_PART_TIME = 2;
        int WAGE_PER_HOUR = 20;
        int FULL_DAY_HOURS = 8;
        int PART_TIME_HOURS = 8;

        int empCheck = (int) Math.floor(Math.random() * 10) % 3;
        int empHrs = 0;
        int dailyWage = 0;

        if (empCheck == IS_FULL_TIME) {
            System.out.println("Employee is Present (Full-Time)");
            empHrs = FULL_DAY_HOURS;
        } else if (empCheck == IS_PART_TIME) {
            System.out.println("Employee is Present (Part-Time)");
            empHrs = PART_TIME_HOURS;
        } else {
            System.out.println("Employee is Absent");
            empHrs = 0;
        }

        dailyWage = WAGE_PER_HOUR * empHrs;
        System.out.println("Daily Wage: " + dailyWage);
    }
}
