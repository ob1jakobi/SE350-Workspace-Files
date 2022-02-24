package Homework01;

import java.util.*;

public final class FlightManager {

    // The ArrayList that contains all the flights.
    private static List<Flight> flights;

    // The single instance, as part of Singleton
    private static FlightManager flightMgrInstance;

    /**
     * Creates flights based on the parameters.
     * @param airlineName the airline operating the flight.
     * @param passengerCapacity the capacity of passengers (for passenger flights).  If flight is not a passenger flight,
     *                          enter 0.
     * @param originAirportDesignator the airport from which the flight departs.
     * @param destinationAirportDesignator the airport from which the flight arrives.
     * @param departureDate the date and time the flight is supposed to depart.
     * @param type if a null parameter is passed, or if the flight departure time is a past date.
     * @return the newly created <code>flight</code>.
     */
    public static Flight createFlight(String airlineName, int passengerCapacity, String originAirportDesignator, String destinationAirportDesignator,
                                    Date departureDate, String type) {
        if (flightMgrInstance == null) {
            flightMgrInstance = new FlightManager();
        }
        Flight newFlight = FlightFactory.createFlight(airlineName, passengerCapacity, originAirportDesignator, destinationAirportDesignator,
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
    public static Flight getFlightByNumber(String flightNum) throws IllegalArgumentException {
        for (Flight f : flights) {
            if (f.getFlightNumber().equals(flightNum)) {
                return f;
            }
        }
        throw new IllegalArgumentException("No such flight exists");
    }

    /**
     * Gets the instance of this FlightManager; if none has been created, this will create a new FlightManager.
     * @return the instance of this FlightManager.
     */
    public static FlightManager getInstance() {
        if (flightMgrInstance == null) {
            flightMgrInstance = new FlightManager();
        }
        return flightMgrInstance;
    }

    private FlightManager() {
        flights = new ArrayList<>();
    }
}
