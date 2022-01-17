package Homework01;

import java.util.Objects;

public class Airline {

    private String name;

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

    public static void main(String[] args) {
        Airline test = new Airline("delta");
        System.out.println(test);
    }
}
