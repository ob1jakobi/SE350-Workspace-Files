package Homework01;

import java.util.Date;

public class FlightFactory {

    /**
     * Creates flights.
     * @param airline the name of the airline operating the flight.
     * @param originAirportDesignator the airport from which the airport flight departs.
     * @param destinationAirportDesignator the airport from which the flight arrives.
     * @param departureTime the date and time the flight is supposed to depart.
     * @param type the type of aircraft.
     * @return the flight that was created.
     * @throws IllegalArgumentException if the type of flight to be created is not supported.
     */
    public static CommercialFlight createFlight(Airline airline, Airport originAirportDesignator, Airport destinationAirportDesignator,
                                         Date departureTime, String type) throws IllegalArgumentException {
        if (type.equalsIgnoreCase("Commercial")) {
            try {
                return new CommercialFlight(airline, originAirportDesignator, destinationAirportDesignator, departureTime);
            } catch (NullPointerException e) {
                return null;
            }
        }
        throw new IllegalArgumentException("Please enter a valid flight type.");
    }
    private FlightFactory() {
    }
}
