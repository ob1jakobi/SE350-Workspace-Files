package Homework01;

import java.util.Objects;

public class Airport {

    private String name;

    /**
     * Creates an Airport object with a 3-letter airport designator.
     * @param airportDesignator a 3-letter airport designator (e.g., ORD for O'Hare International Airport).
     * @throws IllegalArgumentException if airportDesignator is not 3-letters in length.
     * @throws NullPointerException if <code>airportDesignator</code> is <code>null</code>.
     */
    public Airport(String airportDesignator) throws IllegalArgumentException, NullPointerException {
        designatorValidator(airportDesignator);
    }

    /**
     * Ensures that the airport's designator is 3-letters long and uppercase.
     * @param airportDesignator a 3-letter airport designator (e.g., ORD for O'Hare International Airport).
     * @throws IllegalArgumentException if the parameter <code>airportDesignator</code> is not 3-letters long.
     * @throws NullPointerException if <code>airportDesignator</code> is <code>null</code>.
     */
    private void designatorValidator(String airportDesignator) throws IllegalArgumentException, NullPointerException {
        if (airportDesignator == null) {
            throw new NullPointerException("Null value passed as airportDesignator.");
        }
        if (airportDesignator.length() != 3) {
            throw new IllegalArgumentException("Please enter 3-letter airport designator.");
        }
        this.name = airportDesignator.toUpperCase();
    }

    public String getAirportDesignator() {
        return name;
    }

    /**
     * Ensures that the airport's designator is 3-letters long and uppercase.
     * @param airportDesignator a 3-letter airport designator (e.g., ORD for O'Hare International Airport).
     * @throws IllegalArgumentException if the parameter <code>airportDesignator</code> is not 3-letters long.
     * @throws NullPointerException if <code>airportDesignator</code> is <code>null</code>.
     */
    public void setAirportName(String airportDesignator) throws IllegalArgumentException, NullPointerException {
        designatorValidator(airportDesignator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return name.equals(airport.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String toString() {
        return String.format("AirportDesignator{%s}", getAirportDesignator());
    }
}
