package Homework01;

import java.util.Date;

public class TravelManager {

    public static void main(String[] args) {
        Airline airline = new Airline("Delta");
        Airport origin = new Airport("ORD");
        Airport destination = new Airport("MDW");
        Date futureDate = new Date(2022, 02, 01);
        Flight test = new Flight(airline, origin, destination, futureDate);
        System.out.println(test);
    }
}
