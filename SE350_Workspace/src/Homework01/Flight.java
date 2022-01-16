package Homework01;

import java.util.Date;
import java.util.UUID;

public class Flight {

    private Airline airline;
    private Airport origin;
    private Airport destination;
    private String flightNumber;
    private Date departureTime;



    private void generateFlightNumber() {
        this.flightNumber = UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        UUID temp = UUID.randomUUID();
        System.out.println(temp);
    }
}
