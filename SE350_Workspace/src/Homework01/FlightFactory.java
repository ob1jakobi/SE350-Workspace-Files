package Homework01;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FlightFactory {
    // The Flyweight pattern cache for all airlines
    private static Map<String, Airline> airLineCache = new HashMap<>();
    // The Flyweight pattern cache for all airports (destinations and origins)
    private static Map<String, Airport> airportCache = new HashMap<>();

    /**
     * Creates flights.
     * @param airlineName the name of the airline operating the flight.
     * @param originAirportDesignator the airport from which the airport flight departs.
     * @param destinationAirportDesignator the airport from which the flight arrives.
     * @param departureTime the date and time the flight is supposed to depart.
     * @param type the type of aircraft.
     * @return the flight that was created.
     * @throws IllegalArgumentException if the type of flight to be created is not supported.
     */
    public static Flight createFlight(String airlineName, int passengerCapacity, String originAirportDesignator, String destinationAirportDesignator,
                                         Date departureTime, String type) throws IllegalArgumentException {
        try {
            Airline tempAirline = getAirline(airlineName);
            Airport tempOriginAirport = getAirport(originAirportDesignator);
            Airport tempDestinationAirport = getAirport(destinationAirportDesignator);
            if (type.equalsIgnoreCase("Commercial")) {
                return new CommercialFlight(tempAirline, tempOriginAirport, tempDestinationAirport, departureTime);
            } else if (type.equalsIgnoreCase("Passenger")) {
                return new PassengerFlight(tempAirline, passengerCapacity, tempOriginAirport, tempDestinationAirport,
                        departureTime);
            }
        } catch (NullPointerException e) {
            return null;
        }
        throw new IllegalArgumentException("Please enter a valid flight type.");
    }

    /**
     * Searches for known airlines, or creates a new one if necessary (as part of Flyweight pattern).
     * @param airlineName the <code>String</code> name of an airline (up to 8 characters).
     * @return an <code>Airline</code> object with the name provided.
     * @throws IllegalArgumentException if the parameter <code>airlineName</code> is an empty/blank or longer than 8 characters
     * in length.
     */
    public static Airline getAirline(String airlineName) throws IllegalArgumentException{
        return airLineCache.computeIfAbsent(airlineName, newAirline -> {return new Airline(airlineName);});
    }

    /**
     * Searches for known airports, or creates a new one if necessary (as part of Flyweight pattern)
     * @param airportDesignator a three-letter long <code>String</code> representation of the airport's designator.
     * @return an <code>Airport</code> object with the name provided.
     * @throws IllegalArgumentException if the parameter <code>airportDesignator</code> is not a String comprised of 3 characters.
     */
    public static Airport getAirport(String airportDesignator) throws IllegalArgumentException {
        return airportCache.computeIfAbsent(airportDesignator, newAirport -> {return new Airport(airportDesignator);});
    }

    private FlightFactory() {
    }
}
