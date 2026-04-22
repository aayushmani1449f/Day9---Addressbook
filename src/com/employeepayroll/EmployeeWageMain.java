package com.employeepayroll;

public class EmployeeWageMain {
    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;
    public static final int WAGE_PER_HOUR = 20;
    public static final int FULL_DAY_HOURS = 8;
    public static final int PART_TIME_HOURS = 8;
    public static final int MAX_WORKING_DAYS = 20;
    public static final int MAX_WORKING_HOURS = 100;

    public static void computeWage() {
        int totalWage = 0;
        int totalDays = 0;
        int totalHours = 0;

        while (totalDays < MAX_WORKING_DAYS && totalHours < MAX_WORKING_HOURS) {
            totalDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            int empHrs = 0;
            int dailyWage = 0;

            switch (empCheck) {
                case IS_FULL_TIME:
                    empHrs = FULL_DAY_HOURS;
                    break;
                case IS_PART_TIME:
                    empHrs = PART_TIME_HOURS;
                    break;
                default:
                    empHrs = 0;
                    break;
            }

            totalHours += empHrs;
            dailyWage = WAGE_PER_HOUR * empHrs;
            totalWage += dailyWage;
            System.out.println("Day " + totalDays + " - Hours: " + empHrs + " - Wage: " + dailyWage);
        }

        System.out.println("Total Working Hours: " + totalHours);
        System.out.println("Total Monthly Wage: " + totalWage);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        computeWage();
    }
}
