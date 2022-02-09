package Homework01;

import java.util.Date;

public class TravelManager {

    public static void main(String[] args) {
        Airline airline = new Airline("Delta");
        Airport origin = new Airport("ORD");
        Airport destination = new Airport("MDW");
        Date futureDate = new Date(2022, 04, 01);
        CommercialFlight test = FlightManager.createFlight(airline, origin, destination, futureDate, "Commercial");
        String testFlightNumber = test.getFlightNumber();
        CommercialFlight test2 = FlightManager.getFlightByNumber(testFlightNumber);
        System.out.printf("test: %s%n%ntestFlightNumber: %s%n%ntest2: %s%n", test, testFlightNumber, test2);
    }
}
