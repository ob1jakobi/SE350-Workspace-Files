package Homework01;

import java.util.Objects;

public class Airline {

    private String name;

    /**
     * Constructor for initializing an Airline object.
     * @param airlineName the <code>String</code> name of the company that operates this airline.  Must be less than
     *                    eight characters in length.
     * @throws IllegalArgumentException if the name of the airline is less than 0 or larger than 8 characters in length (inclusive).
     * @throws NullPointerException if the name of this Airline is null.
     */
    public Airline(String airlineName) throws IllegalArgumentException, NullPointerException {
        airlineNameValidator(airlineName);
    }

    private void airlineNameValidator(String airlineName) throws IllegalArgumentException, NullPointerException {
        if (airlineName == null) {
            throw new NullPointerException("Null value passed as airlineName.");
        }
        if (airlineName.length() <= 0 || airlineName.length() >= 8) {
            throw new IllegalArgumentException("Please enter a name that is less than 8 characters in length.");
        }
        this.name = Character.toTitleCase(airlineName.charAt(0)) + airlineName.substring(1);
    }

    public String getAirlineName() {
        return name;
    }

    /**
     * Sets/updates the name of this Airline.
     * @param airlineName the <code>String</code> name of this Airline.
     * @throws IllegalArgumentException if the Airline name is less than 0 characters or larger than 8 characters (inclusive).
     * @throws NullPointerException if the Airline passed is null.
     */
    public void setAirlineName(String airlineName) throws IllegalArgumentException, NullPointerException {
        airlineNameValidator(airlineName);
    }

    @Override
    public String toString() {
        return String.format("Airline{%s}", getAirlineName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return name.equals(airline.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
