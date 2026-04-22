package com.employeepayroll;

public class EmployeeWageMain {
    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;
    public static final int FULL_DAY_HOURS = 8;
    public static final int PART_TIME_HOURS = 8;

    public static void computeWage(String company, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        System.out.println("--- Calculating Wages for " + company + " ---");
        int totalWage = 0;
        int totalDays = 0;
        int totalHours = 0;

        while (totalDays < maxWorkingDays && totalHours < maxWorkingHours) {
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
            dailyWage = wagePerHour * empHrs;
            totalWage += dailyWage;
            System.out.println("Day " + totalDays + " - Hours: " + empHrs + " - Wage: " + dailyWage);
        }

        System.out.println("Total Working Hours: " + totalHours);
        System.out.println("Total Monthly Wage for " + company + ": " + totalWage + "\n");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program\n");
        computeWage("Dmart", 20, 20, 100);
        computeWage("Reliance", 25, 25, 120);
        computeWage("Amazon", 30, 22, 110);
    }
}
