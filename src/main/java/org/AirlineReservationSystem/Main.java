package org.AirlineReservationSystem;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();

        Flight flight1 = new Flight("F001", "Airport A", "Airport B", "08:00", "10:00", 50, 100.0);
        Flight flight2 = new Flight("F002", "Airport B", "Airport C", "12:00", "14:00", 30, 150.0);
        reservationSystem.addFlight(flight1);
        reservationSystem.addFlight(flight2);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter departure airport: ");
        String departureAirport = scanner.nextLine();
        System.out.print("Enter arrival airport: ");
        String arrivalAirport = scanner.nextLine();

        List<Flight> searchResults = reservationSystem.searchFlights(departureAirport, arrivalAirport);
        if (searchResults.isEmpty()) {
            System.out.println("No flights available for the specified route.");
        } else {
            System.out.println("Available flights:");
            for (Flight flight : searchResults) {
                System.out.println("Flight Number: " + flight.getFlightNumber());
                System.out.println("Departure Time: " + flight.getDepartureTime());
                System.out.println("Arrival Time: " + flight.getArrivalTime());
                System.out.println("Price: $" + flight.getPrice());
                System.out.println("Available Seats: " + flight.getAvailableSeats());
                System.out.println();
            }

            System.out.print("Enter flight number to book: ");
            String flightNumber = scanner.nextLine();
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Enter your email: ");
            String email = scanner.nextLine();
            System.out.print("Enter seat number: ");
            String seatNumber = scanner.nextLine();

            User user = new User(name, email);
            Flight selectedFlight = null;
            for (Flight flight : searchResults) {
                if (flight.getFlightNumber().equals(flightNumber)) {
                    selectedFlight = flight;
                    break;
                }
            }

            if (selectedFlight != null) {
                Booking booking = reservationSystem.bookFlight(user, selectedFlight, seatNumber);
                if (booking != null) {
                    System.out.println("Flight booked successfully.");
                    System.out.println("Booking Details:");
                    System.out.println("Flight Number: " + booking.getFlight().getFlightNumber());
                    System.out.println("Departure Time: " + booking.getFlight().getDepartureTime());
                    System.out.println("Arrival Time: " + booking.getFlight().getArrivalTime());
                    System.out.println("Seat Number: " + booking.getSeatNumber());
                }
            } else {
                System.out.println("Invalid flight number.");
            }
        }
    }
}