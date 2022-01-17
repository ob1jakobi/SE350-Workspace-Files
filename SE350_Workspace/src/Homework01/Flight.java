package Homework01;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Flight {

    private Airline airline;
    private Airport origin;
    private Airport destination;
    private String flightNumber;
    private Date departureTime;


    public Flight(Airline airline, Airport originAirportDesignator, Airport destinationAirportDesignator,
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

    public void setAirlineName(Airline airlineName) throws IllegalArgumentException {
        if (airlineName == null) {
            throw new IllegalArgumentException("Null value passed as airlineName");
        }
        this.airline = airlineName;
    }

    public Airport getOriginAirportDesignator() {
        return origin;
    }

    public void setOriginAirportDesignator(Airport originAirportDesignator) throws IllegalArgumentException {
        if (originAirportDesignator == null) {
            throw new IllegalArgumentException("Null value passed as airportDesignator.");
        }
        this.origin = originAirportDesignator;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestinationAirportDesignator(Airport destinationAirportDesignator) throws IllegalArgumentException {
        if (destinationAirportDesignator == null) {
            throw new IllegalArgumentException("Null value passed as airportDesignator.");
        }
        this.destination = destinationAirportDesignator;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

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

    public String getFlightNumber() {
        return flightNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
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
        result.append(getDestination()).append("\n");
        result.append("FlightNumber{");
        result.append(getFlightNumber()).append("}\n");
        result.append("DepartureTime{");
        result.append(getDepartureTime()).append("}\n}");
        return result.toString();
    }

}
