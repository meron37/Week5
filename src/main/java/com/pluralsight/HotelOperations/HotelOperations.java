//package com.pluralsight.HotelOperations;
//
//public class HotelOperations {
//    public static void main(String[] args) {
//
//        // == Test Room ==
//        Room room101 = new Room(2, 129.99, false, false);
//        System.out.println("Room 101 has " + room101.getNumberOfBeds() + " beds.");
//        System.out.println("Room 101 available? " + room101.isAvailable()); // true
//        System.out.println();
//
//        // Test Reservation
//        Reservation weekendKing = new Reservation("king", 3, true);
//        System.out.println("Room type: " + weekendKing.getRoomType());
//        System.out.printf("Nightly price: $%.2f%n", weekendKing.getPrice());
//        System.out.printf("Total for %d nights: $%.2f%n",
//                weekendKing.getNumberOfNights(), weekendKing.getReservationTotal());
//        System.out.println();
//
//        // Test Employee
//        Employee emp1 = new Employee("E1001", "Dana Wyatt", "Front Desk", 22.50, 46.0);
//        System.out.println("Employee: " + emp1.getName() + " (" + emp1.getEmployeeId() + ")");
//        System.out.println("Regular hours: " + emp1.getRegularHours());
//        System.out.println("Overtime hours: " + emp1.getOvertimeHours());
//        System.out.printf("Total pay: $%.2f%n", emp1.getTotalPay());
//
//    }
//}
//
//


// === ========== Exercise 3 ====================
package com.pluralsight.HotelOperations;

public class HotelOperations {
    public static void main(String[] args) {

        // Employee (overloaded methods)

        Employee emp = new Employee("E1001", "Dana Wyatt", "Front Desk", 22.50, 0.0);

        // Manual punch
        emp.punchIn(9.0);      // 9:00 AM
        emp.punchOut(17.5);    // 5:30 PM
        System.out.printf("Manual shift -> Hours: %.2f, Total Pay: $%.2f%n",
                emp.getHoursWorked(), emp.getTotalPay());

        // Automatic punch (uses current time)
        emp.punchIn();
        emp.punchOut();
        System.out.printf("After auto punch -> Hours: %.2f, Regular: %.2f, OT: %.2f, Total: $%.2f%n",
                emp.getHoursWorked(), emp.getRegularHours(), emp.getOvertimeHours(), emp.getTotalPay());

        System.out.println();

        // ==========================
        //  Hotel

        // Constructor #1 (booked counts default to 0)
        Hotel h1 = new Hotel("Sunrise Inn", 5, 20);
        System.out.println("== Sunrise Inn (fresh day) ==");
        System.out.println("Suites available: " + h1.getAvailableSuites());
        System.out.println("Basic rooms available: " + h1.getAvailableRooms());

        System.out.println("Book 2 suites: " + h1.bookRoom(2, true));
        System.out.println("Book 5 basic rooms: " + h1.bookRoom(5, false));
        System.out.println("Suites available: " + h1.getAvailableSuites());
        System.out.println("Basic rooms available: " + h1.getAvailableRooms());
        System.out.println("Overbook 10 suites (expect false): " + h1.bookRoom(10, true));
        System.out.println();

        // Constructor #2 (start with some already booked)
        Hotel h2 = new Hotel("Downtown Lodge", 3, 10, 1, 4);
        System.out.println("== Downtown Lodge (pre-booked) ==");
        System.out.println("Suites available: " + h2.getAvailableSuites());
        System.out.println("Basic rooms available: " + h2.getAvailableRooms());
        System.out.println("Book 2 suites (expect true if enough): " + h2.bookRoom(2, true));
        System.out.println("Book 7 basic rooms (expect true if enough): " + h2.bookRoom(7, false));
        System.out.println("Suites available: " + h2.getAvailableSuites());
        System.out.println("Basic rooms available: " + h2.getAvailableRooms());

//        // Optional: show summary
//        System.out.println();
//        System.out.println(h1);
//        System.out.println(h2);
    }
}


