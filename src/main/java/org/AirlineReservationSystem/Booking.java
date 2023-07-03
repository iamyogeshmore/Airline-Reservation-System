package org.AirlineReservationSystem;

public class Booking {
    private User user;
    private Flight flight;
    private String seatNumber;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Booking(User user, Flight flight, String seatNumber) {
        this.user = user;
        this.flight = flight;
        this.seatNumber = seatNumber;
    }
}