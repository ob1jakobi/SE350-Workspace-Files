package Homework01;

import java.util.Date;

public interface Flight {

    Airline getAirlineName();

    void setAirlineName(Airline airlineName) throws IllegalArgumentException;

    Airport getOriginAirportDesignator();

    void setOriginAirportDesignator(Airport originAirportDesignator) throws IllegalArgumentException;

    Airport getDestinationAirportDesignator();

    void setDestinationAirportDesignator(Airport destinationAirportDesignator) throws IllegalArgumentException;

    Date getDepartureTime();

    void setDepartureTime(Date departureTime) throws IllegalArgumentException;

    String getFlightNumber();

}
