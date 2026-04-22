package com.employeepayroll;

public class EmployeeWageMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        int IS_FULL_TIME = 1;
        int IS_PART_TIME = 2;
        int WAGE_PER_HOUR = 20;
        int FULL_DAY_HOURS = 8;
        int PART_TIME_HOURS = 8;

        int MAX_WORKING_DAYS = 20;
        int MAX_WORKING_HOURS = 100;
        
        int totalWage = 0;
        int totalDays = 0;
        int totalHours = 0;

        while (totalDays < MAX_WORKING_DAYS && totalHours < MAX_WORKING_HOURS) {
            totalDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            int empHrs = 0;
            int dailyWage = 0;

            switch (empCheck) {
                case 1: // IS_FULL_TIME
                    empHrs = FULL_DAY_HOURS;
                    break;
                case 2: // IS_PART_TIME
                    empHrs = PART_TIME_HOURS;
                    break;
                default:
                    empHrs = 0;
                    break;
            }

            totalHours += empHrs;
            // if adding empHrs exceeds max, we shouldn't necessarily cap it based on typical problem statement, or maybe we do. 
            // Usually, it calculates for that day and stops if it reached/exceeded.

            dailyWage = WAGE_PER_HOUR * empHrs;
            totalWage += dailyWage;
            System.out.println("Day " + totalDays + " - Hours: " + empHrs + " - Wage: " + dailyWage);
        }

        System.out.println("Total Working Hours: " + totalHours);
        System.out.println("Total Monthly Wage: " + totalWage);
    }
}
