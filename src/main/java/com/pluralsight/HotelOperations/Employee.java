package com.pluralsight.HotelOperations;

/**
 * Represents an employee working at the hotel.
 * It "knows" about:
 *  - Their ID, name, and department
 *  - Their hourly pay rate
 *  - The number of hours they worked
 *
 * Derived getters calculate:
 *  - Regular hours (up to 40)
 *  - Overtime hours (above 40)
 *  - Total pay (regular + overtime at 1.5x)
 */
public class Employee {

    // Backing variables
    private String employeeId;
    private String name;
    private String department;
    private double payRate;     // hourly pay rate
    private double hoursWorked; // total hours for this pay period

    // Constructor
    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        setPayRate(payRate);
        setHoursWorked(hoursWorked);
    }

    //  Getters / Setters
    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        if (payRate < 0) {
            throw new IllegalArgumentException("Pay rate cannot be negative.");
        }
        this.payRate = payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked < 0) {
            throw new IllegalArgumentException("Hours worked cannot be negative.");
        }
        this.hoursWorked = hoursWorked;
    }



     //  Regular hours are capped at 40 per week.

    public double getRegularHours() {
        return Math.min(40.0, hoursWorked);
    }


     //  Overtime hours are any hours beyond 40.

    public double getOvertimeHours() {
        if (hoursWorked > 40.0) {
            return hoursWorked - 40.0;
        } else {
            return 0.0;
        }
    }


     // Total pay = regular pay + (overtime pay at 1.5x rate)

    public double getTotalPay() {
        double regularPay = getRegularHours() * payRate;
        double overtimePay = getOvertimeHours() * payRate * 1.5;
        return regularPay + overtimePay;
    }
}
