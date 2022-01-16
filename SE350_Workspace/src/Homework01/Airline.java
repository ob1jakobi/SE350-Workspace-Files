package Homework01;

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

//    public static void main(String[] args) {
//        Airline test = new Airline("delta");
//        System.out.println(test.name);
//    }

}
