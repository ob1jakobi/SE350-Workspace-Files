package Homework01;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class CommercialFlight implements Flight {

    private Airline airline;
    private Airport origin;
    private Airport destination;
    private String flightNumber;
    private Date departureTime;

    /**
     * Constructor for initializing Flight objects.
     * @param airline the airline operating the flight.
     * @param originAirportDesignator the airport from which the flight departs.
     * @param destinationAirportDesignator the airport from which the flight arrives.
     * @param departureTime the date and time the flight is supposed to depart.
     * @throws IllegalArgumentException if a null parameter is passed, or if the flight departure time is a past date.
     */
    public CommercialFlight(Airline airline, Airport originAirportDesignator, Airport destinationAirportDesignator,
                            Date departureTime) throws IllegalArgumentException {
        setAirlineName(airline);
        setOriginAirportDesignator(originAirportDesignator);
        setDestinationAirportDesignator(destinationAirportDesignator);
        generateFlightNumber();
        setDepartureTime(departureTime);
    }

    public Airline getAirlineName() {
        return airline;
    }

    /**
     * Allows the airline name to be updated.
     * @param airlineName the name of the airline operating the flight.
     * @throws IllegalArgumentException if the value passed is null.
     */
    public void setAirlineName(Airline airlineName) throws IllegalArgumentException {
        if (airlineName == null) {
            throw new IllegalArgumentException("Null value passed as airlineName");
        }
        this.airline = airlineName;
    }

    public Airport getOriginAirportDesignator() {
        return origin;
    }

    /**
     * Allows the name of the airport origin/departure to be updated.
     * @param originAirportDesignator the 3-digit airport designation for the departing airport.
     * @throws IllegalArgumentException if the value passed is null.
     */
    public void setOriginAirportDesignator(Airport originAirportDesignator) throws IllegalArgumentException {
        if (originAirportDesignator == null) {
            throw new IllegalArgumentException("Null value passed as airportDesignator.");
        }
        this.origin = originAirportDesignator;
    }

    public Airport getDestinationAirportDesignator() {
        return destination;
    }

    /**
     * Allows the name of the airport destination/arrival to be updated.
     * @param destinationAirportDesignator the 3-digit airport designation for the destination/arrival airport.
     * @throws IllegalArgumentException if the value passed is null.
     */
    public void setDestinationAirportDesignator(Airport destinationAirportDesignator) throws IllegalArgumentException {
        if (destinationAirportDesignator == null) {
            throw new IllegalArgumentException("Null value passed as airportDesignator.");
        }
        this.destination = destinationAirportDesignator;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    /**
     * Sets/updates the flight's departure date and time.
     * @param departureTime the date and time at which this flight is scheduled to depart.
     * @throws IllegalArgumentException if the value passed is null or a past date.
     */
    public void setDepartureTime(Date departureTime) throws IllegalArgumentException {
        if (departureTime == null) {
            throw new IllegalArgumentException("Null value passed as departureTime.");
        }
        if (departureTime.before(new Date())) {
            throw new IllegalArgumentException("Cannot set flight date for past flights.");
        }
        this.departureTime = departureTime;
    }

    private void generateFlightNumber() {
        this.flightNumber = UUID.randomUUID().toString();
    }

    /**
     * Retrieves the unique flight number for this flight.
     * @return the flight number for this flight
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommercialFlight flight = (CommercialFlight) o;
        return airline.equals(flight.airline) && origin.equals(flight.origin) && destination.equals(flight.destination) && flightNumber.equals(flight.flightNumber) && departureTime.equals(flight.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airline, origin, destination, flightNumber, departureTime);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Flight{\n");
        result.append(getAirlineName()).append("\n");
        result.append(getOriginAirportDesignator()).append("\n");
        result.append(getDestinationAirportDesignator()).append("\n");
        result.append("FlightNumber{");
        result.append(getFlightNumber()).append("}\n");
        result.append("DepartureTime{");
        result.append(getDepartureTime()).append("}\n}");
        return result.toString();
    }

}
