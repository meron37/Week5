package com.pluralsight.HotelOperations;

/**
 * Simple Hotel that tracks same-day availability for two room types:
 * King Suites and Basic Double rooms.
 * - No public setters for core state
 * - Two constructors (with/without initial booked counts)
 * - bookRoom(...) updates booked inventory if available
 * - getAvailableSuites / getAvailableRooms are derived (no backing vars)
 */
public class Hotel {

    // Core fields (no public setters)
    private final String name;
    private final int numberOfSuites;     // total King Suites
    private final int numberOfRooms;      // total Basic Double rooms

    // Mutable state for "today" (internal only)
    private int bookedSuites;             // King Suites booked today
    private int bookedBasicRooms;         // Basic rooms booked today


    // Constructor 1: starts with zero booked rooms
    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this(name, numberOfSuites, numberOfRooms, 0, 0);
    }

    // Constructor 2: specify current booked counts
    public Hotel(String name,
                 int numberOfSuites,
                 int numberOfRooms,
                 int bookedSuites,
                 int bookedBasicRooms) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Hotel name cannot be null/blank.");
        }
        if (numberOfSuites < 0 || numberOfRooms < 0 ||
                bookedSuites < 0 || bookedBasicRooms < 0) {
            throw new IllegalArgumentException("Counts cannot be negative.");
        }
        if (bookedSuites > numberOfSuites) {
            throw new IllegalArgumentException("Booked suites exceed total suites.");
        }
        if (bookedBasicRooms > numberOfRooms) {
            throw new IllegalArgumentException("Booked basic rooms exceed total rooms.");
        }

        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    // ------------------------------
    // Getters (no public setters)
    // ------------------------------
    public String getName() {
        return name; }
    public int getNumberOfSuites() {
        return numberOfSuites; }
    public int getNumberOfRooms() {
        return numberOfRooms; }
    public int getBookedSuites() {
        return bookedSuites; }
    public int getBookedBasicRooms() {
        return bookedBasicRooms; }

    // Derived getters (no backing variables)
    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    public int getAvailableRooms() {
        return numberOfRooms - bookedBasicRooms;
    }

    public boolean bookRoom(int numberOfRooms, boolean isSuite) {
        if (numberOfRooms <= 0) return false;

        if (isSuite) {
            if (getAvailableSuites() >= numberOfRooms) {
                bookedSuites += numberOfRooms;
                return true;
            }
        } else {
            if (getAvailableRooms() >= numberOfRooms) {
                bookedBasicRooms += numberOfRooms;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", suites=" + numberOfSuites +
                ", rooms=" + numberOfRooms +
                ", bookedSuites=" + bookedSuites +
                ", bookedBasicRooms=" + bookedBasicRooms +
                ", availableSuites=" + getAvailableSuites() +
                ", availableRooms=" + getAvailableRooms() +
                '}';
    }
}
