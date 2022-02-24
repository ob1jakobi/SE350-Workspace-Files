package Homework01;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class PassengerFlight implements Flight{

    private Airline airLine;
    private int passengerCapacity;
    private Airport origin;
    private Airport destination;
    private String flightNumber;
    private Date departureTime;

    public PassengerFlight(Airline airline, int passengerCapacity, Airport originAirportDesignator, Airport destinationAirportDesignator,
                           Date departureTime) throws IllegalArgumentException {
        setAirlineName(airline);
        setPassengerCapacity(passengerCapacity);
        setOriginAirportDesignator(originAirportDesignator);
        setDestinationAirportDesignator(destinationAirportDesignator);
        setDepartureTime(departureTime);
        generateFlightNumber();
    }


    @Override
    public Airline getAirlineName() {
        return airLine;
    }

    @Override
    public void setAirlineName(Airline airline) throws IllegalArgumentException {
        if (airline == null) {
            throw new IllegalArgumentException("Null value passed airline name");
        }
        this.airLine = airline;
    }

    public int getPassengerCapacity() {
        return this.passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) throws IllegalArgumentException {
        if (passengerCapacity < 1) {
            throw new IllegalArgumentException("Please enter a positive value for passenger capacity");
        }
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public Airport getOriginAirportDesignator() {
        return origin;
    }

    @Override
    public void setOriginAirportDesignator(Airport originAirportDesignator) throws IllegalArgumentException {
        if (originAirportDesignator == null) {
            throw new IllegalArgumentException("Null value passed as airportDesignator.");
        }
        this.origin = originAirportDesignator;
    }

    @Override
    public Airport getDestinationAirportDesignator() {
        return destination;
    }

    @Override
    public void setDestinationAirportDesignator(Airport destinationAirportDesignator) throws IllegalArgumentException {
        if (destinationAirportDesignator == null) {
            throw new IllegalArgumentException("Null value passed as airportDesignator");
        }
        this.destination = destinationAirportDesignator;
    }

    @Override
    public Date getDepartureTime() {
        return departureTime;
    }

    @Override
    public void setDepartureTime(Date departureTime) throws IllegalArgumentException {
        if (departureTime == null) {
            throw new IllegalArgumentException("Null value passed as departureTime.");
        }
        if (departureTime.before(new Date())) {
            throw new IllegalArgumentException("Cannot set flight date for past flights.");
        }
        this.departureTime = departureTime;
    }

    @Override
    public String getFlightNumber() {
        return flightNumber;
    }

    private void generateFlightNumber() {
        this.flightNumber = UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerFlight that = (PassengerFlight) o;
        return passengerCapacity == that.passengerCapacity && airLine.equals(that.airLine) && origin.equals(that.origin) && destination.equals(that.destination) && flightNumber.equals(that.flightNumber) && departureTime.equals(that.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airLine, passengerCapacity, origin, destination, flightNumber, departureTime);
    }

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
