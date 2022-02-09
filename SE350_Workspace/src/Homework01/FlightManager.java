package Homework01;

import java.util.*;

public final class FlightManager {

    // The ArrayList that contains all the flights.
    private static List<CommercialFlight> flights;

    /**
     * Creates flights based on the parameters.
     * @param airline the airline operating the flight.
     * @param originAirportDesignator the airport from which the flight departs.
     * @param destinationAirportDesignator the airport from which the flight arrives.
     * @param departureDate the date and time the flight is supposed to depart.
     * @param type if a null parameter is passed, or if the flight departure time is a past date.
     * @return the newly created <code>flight</code>.
     */
    public static CommercialFlight createFlight(Airline airline, Airport originAirportDesignator, Airport destinationAirportDesignator,
                                    Date departureDate, String type) {
        if (flights == null) {
            flights = new ArrayList<>();
        }
        CommercialFlight newFlight = FlightFactory.createFlight(airline, originAirportDesignator, destinationAirportDesignator,
                departureDate, type);
        flights.add(newFlight);
        return newFlight;
    }

    /**
     * Checks to see if a flight with the flight number <code>flightNum</code> exists.
     * @param flightNum the flight number of the flight to be checked.
     * @return the flight object matching the parameter <code>flightNum</code>
     * @throws IllegalArgumentException if no such flight exists with the <code>flightNum</code> passed as a parameter.
     */
    public static CommercialFlight getFlightByNumber(String flightNum) throws IllegalArgumentException {
        for (CommercialFlight f : flights) {
            if (f.getFlightNumber().equals(flightNum)) {
                return f;
            }
        }
        throw new IllegalArgumentException("No such flight exists");
    }

    private FlightManager() {}
}
