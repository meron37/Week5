package com.pluralsight.HotelOperations;

public class HotelOperations {
    public static void main(String[] args) {

        // Test Room
        Room room101 = new Room(2, 129.99, false, false);
        System.out.println("Room 101 has " + room101.getNumberOfBeds() + " beds.");
        System.out.println("Room 101 available? " + room101.isAvailable()); // true
        System.out.println();

        // Test Reservation
        Reservation weekendKing = new Reservation("king", 3, true);
        System.out.println("Room type: " + weekendKing.getRoomType());
        System.out.printf("Nightly price: $%.2f%n", weekendKing.getPrice());
        System.out.printf("Total for %d nights: $%.2f%n",
                weekendKing.getNumberOfNights(), weekendKing.getReservationTotal());
        System.out.println();

        // Test Employee
        Employee emp1 = new Employee("E1001", "Dana Wyatt", "Front Desk", 22.50, 46.0);
        System.out.println("Employee: " + emp1.getName() + " (" + emp1.getEmployeeId() + ")");
        System.out.println("Regular hours: " + emp1.getRegularHours());
        System.out.println("Overtime hours: " + emp1.getOvertimeHours());
        System.out.printf("Total pay: $%.2f%n", emp1.getTotalPay());
    }
}
