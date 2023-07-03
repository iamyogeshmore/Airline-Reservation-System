package org.AirlineReservationSystem;

import java.util.ArrayList;
import java.util.List;

public class ReservationSystem {
    private List<Flight> flights;
    private List<Booking> bookings;

    public ReservationSystem() {
        flights = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> searchFlights(String departureAirport, String arrivalAirport) {
        List<Flight> searchResults = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDepartureAirport().equals(departureAirport) && flight.getArrivalAirport().equals(arrivalAirport)) {
                searchResults.add(flight);
            }
        }
        return searchResults;
    }

    public Booking bookFlight(User user, Flight flight, String seatNumber) {
        if (flight.getAvailableSeats() > 0) {
            flight.setAvailableSeats(flight.getAvailableSeats() - 1);
            Booking booking = new Booking(user, flight, seatNumber);
            bookings.add(booking);
            return booking;
        } else {
            System.out.println("No available seats for this flight.");
            return null;
        }
    }
}