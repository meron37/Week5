package com.pluralsight.HotelOperations;

/**
 * Reservation class stores information about a guest's stay.
 * A room type can be "king" or "double".
 * - King costs $139.00 per night
 * - Double costs $124.00 per night
 * If the stay is over a weekend, the price increases by 10%.
 */
public class Reservation {
    // === Instance variables (backing variables) ===
    private String roomType;
    private double price;
    private int numberOfNights;
    private boolean weekend;

    // === Constructor ===
    public Reservation(String roomType, int numberOfNights, boolean weekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.weekend = weekend;

        // set base price based on room type
        if (roomType.equalsIgnoreCase("king")) {
            price = 139.00;
        } else if (roomType.equalsIgnoreCase("double")) {
            price = 124.00;
        } else {
            // if the user types something else, just set price to 0
            price = 0;
        }

        // if it's a weekend, increase price by 10%
        if (weekend) {
            price = price + (price * 0.10);
        }
    }

    // === Getters and Setters ===

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return price;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return weekend;
    }

    public void setWeekend(boolean weekend) {
        this.weekend = weekend;
    }


     // Calculates the total cost of the reservation.

    public double getReservationTotal() {
        return price * numberOfNights;
    }
}
