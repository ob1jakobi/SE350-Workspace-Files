package Homework01;

import java.util.Date;

public class TravelManager {

    public static void main(String[] args) {
//        Airline airline = new Airline("Delta");
//        Airport origin = new Airport("ORD");
//        Airport destination = new Airport("MDW");
        Date futureDate = new Date(2022, 04, 01);
        Flight test = FlightManager.createFlight("FEDEX", 0, "ORD", "MDW", futureDate, "Commercial");
        String testFlightNumber = test.getFlightNumber();
        Flight test2 = FlightManager.createFlight("Delta", 150, "DEN", "ORD",
                new Date(2022, 5, 01), "Passenger");
        System.out.printf("test: %s%n%ntestFlightNumber: %s%n%ntest2: %s%n", test, testFlightNumber, test2);
    }
}
