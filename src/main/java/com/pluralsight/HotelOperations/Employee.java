//package com.pluralsight.HotelOperations;
//
///**
// * Represents an employee working at the hotel.
// * It "knows" about:
// *  - Their ID, name, and department
// *  - Their hourly pay rate
// *  - The number of hours they worked
// * Derived getters calculate:
// *  - Regular hours (up to 40)
// *  - Overtime hours (above 40)
// *  - Total pay (regular + overtime at 1.5x)
// */
//public class Employee {
//
//    // Backing variables
//    private String employeeId;
//    private String name;
//    private String department;
//    private double payRate;     // hourly pay rate
//    private double hoursWorked; // total hours for this pay period
//
//    // Constructor
//    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
//        this.employeeId = employeeId;
//        this.name = name;
//        this.department = department;
//        setPayRate(payRate);
//        setHoursWorked(hoursWorked);
//    }
//
//    //  Getters / Setters
//    public String getEmployeeId() {
//        return employeeId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public double getPayRate() {
//        return payRate;
//    }
//
//    public void setPayRate(double payRate) {
//        if (payRate < 0) {
//            throw new IllegalArgumentException("Pay rate cannot be negative.");
//        }
//        this.payRate = payRate;
//    }
//
//    public double getHoursWorked() {
//        return hoursWorked;
//    }
//
//    public void setHoursWorked(double hoursWorked) {
//        if (hoursWorked < 0) {
//            throw new IllegalArgumentException("Hours worked cannot be negative.");
//        }
//        this.hoursWorked = hoursWorked;
//    }
//
//
//
//     //  Regular hours are capped at 40 per week.
//
//    public double getRegularHours() {
//        return Math.min(40.0, hoursWorked);
//    }
//
//
//     //  Overtime hours are any hours beyond 40.
//
//    public double getOvertimeHours() {
//        if (hoursWorked > 40.0) {
//            return hoursWorked - 40.0;
//        } else {
//            return 0.0;
//        }
//    }
//
//
//     // Total pay = regular pay + (overtime pay at 1.5x rate)
//
//    public double getTotalPay() {
//        double regularPay = getRegularHours() * payRate;
//        double overtimePay = getOvertimeHours() * payRate * 1.5;
//        return regularPay + overtimePay;
//    }
//}



// ==================== EXERCISE 2 ==============//


//package com.pluralsight.HotelOperations;
//
//// class stores employee details
//public class Employee {
//    private String employeeId;
//    private String name;
//    private String department;
//    private double payRate;
//    private double hoursWorked;
//
//
//    private double startTime;   // when the employee punches in
//    private boolean working;    // to track if they are currently clocked in
//
//    // Constructor
//    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
//        this.employeeId = employeeId;
//        this.name = name;
//        this.department = department;
//        this.payRate = payRate;
//        this.hoursWorked = hoursWorked;
//        this.working = false;
//    }
//
//    // Getters
//    public String getEmployeeId() { return employeeId; }
//    public String getName() { return name; }
//    public String getDepartment() { return department; }
//    public double getPayRate() { return payRate; }
//    public double getHoursWorked() { return hoursWorked; }
//
//    // Derived getters
//    public double getRegularHours() { return Math.min(40.0, hoursWorked); }
//    public double getOvertimeHours() { return hoursWorked > 40.0 ? hoursWorked - 40.0 : 0.0; }
//    public double getTotalPay() {
//        double regularPay = getRegularHours() * payRate;
//        double overtimePay = getOvertimeHours() * payRate * 1.5;
//        return regularPay + overtimePay;
//    }
//
//
//
//    // Record the time the employee starts work
//    public void punchIn(double time) {
//        if (!working) {
//            startTime = time;
//            working = true;
//            System.out.println(name + " punched in at " + time);
//        } else {
//            System.out.println(name + " is already punched in.");
//        }
//    }
//
//    // Record the time the employee ends work and add hours to total
//    public void punchOut(double time) {
//        if (working) {
//            double hours = time - startTime;
//            hoursWorked += hours;
//            working = false;
//            System.out.println(name + " punched out at " + time + ". Hours worked this shift: " + hours);
//        } else {
//            System.out.println(name + " has not punched in yet.");
//        }
//    }
//}


// ================== Exercise 3  Overloading Methods ============//

package com.pluralsight.HotelOperations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Employee {
    // Fields
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double startTime;   // when the employee punches in
    private boolean working;    // to track if they are currently clocked in

    // Constructor
    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.working = false;
    }

    // Getters
    public String getEmployeeId() {
        return employeeId; }
    public String getName() {
        return name; }
    public String getDepartment() {
        return department; }
    public double getPayRate() {
        return payRate; }
    public double getHoursWorked() {
        return hoursWorked; }

    // Derived getters
    public double getRegularHours() {
        return Math.min(40.0, hoursWorked); }
    public double getOvertimeHours() {
        return hoursWorked > 40.0 ? hoursWorked - 40.0 : 0.0; }
    public double getTotalPay() {
        double regularPay = getRegularHours() * payRate;
        double overtimePay = getOvertimeHours() * payRate * 1.5;
        return regularPay + overtimePay;
    }



    // Record the time the employee starts work
    public void punchIn(double time) {
        if (!working) {
            startTime = time;
            working = true;
            System.out.println(name + " punched in at " + time);
        } else {
            System.out.println(name + " is already punched in.");
        }
    }

    // Record the time the employee ends work and add hours to total
    public void punchOut(double time) {
        if (working) {
            double hours = time - startTime;
            hoursWorked += hours;
            working = false;
            System.out.println(name + " punched out at " + time + ". Hours worked this shift: " + hours);
        } else {
            System.out.println(name + " has not punched in yet.");
        }
    }
    //  Auto punch-in (uses current system time)
    public void punchIn() {
        if (!working) {
            LocalDateTime now = LocalDateTime.now();
            double currentTime = now.getHour() + (now.getMinute() / 60.0);
            startTime = currentTime;
            working = true;

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm a");
            String formattedTime = now.format(formatter);

            System.out.println(name + " punched in automatically on " + formattedTime);
        } else {
            System.out.println(name + " is already punched in.");
        }
    }

    //  Auto punch-out (uses current system time)
    public void punchOut() {
        if (working) {
            LocalDateTime now = LocalDateTime.now();
            double currentTime = now.getHour() + (now.getMinute() / 60.0);
            double hours = currentTime - startTime;
            hoursWorked += hours;
            working = false;

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm a");
            String formattedTime = now.format(formatter);

            System.out.println(name + " punched out automatically on " + formattedTime
                    + ". Hours worked this shift: " + String.format("%.2f", hours));
        } else {
            System.out.println(name + " has not punched in yet.");
        }
    }}
