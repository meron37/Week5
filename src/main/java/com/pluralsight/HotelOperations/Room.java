package com.pluralsight.HotelOperations;

public class Room {
   private int numbersOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;


    // === Constructor ===
    // Used to create a Room and set its starting values
    public Room(int numbersOfBeds, double price, boolean occupied, boolean dirty) {
        this.numbersOfBeds = numbersOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }

    public int getNumberOfBeds() {
        return numbersOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDirty() {
        return dirty;
    }
    public boolean isAvailable() {
        if(!this.occupied && !this.dirty) {
            return true;
        }
        else {
            return false;
        }
    }

}





