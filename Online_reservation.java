import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Online_reservation {
    private static Map<String, String> users = new HashMap<>(); // Using HAshmap to store login id anf password

    public static void main(String[] args) {
        // sample login credentials
        users.put("Alan", "Alan@11");
        users.put("Jack", "Jack@11");
        users.put("Sameer", "Sameer@11");

        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Welcome to the Online Reservation System ***");

        // Login
        boolean loggedIn = false;
        do {
            System.out.print("Enter your login id: ");
            String loginId = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            if (isValidUser(loginId, password)) {
                loggedIn = true;
                System.out.println("Logged in successfully!");
                break;
            } else {
                System.out.println("Invalid login credentials! Please try again");
            }
        } while (!loggedIn);

        System.out.print(
                "Do you want to proceed with the booking or cancellation? Press 1 for booking, 2 for cancellation");
        int reason = scanner.nextInt();
        scanner.nextLine();
        switch (reason) {
            case 1:
                // Reservation
                System.out.println("\nReservation Form ");
                System.out.println("Please fill all the necessary details to proceed with the booking:");
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();

                // Assume train number and train name are fetched from a database. Here we are
                // using a sample
                System.out.print("Enter the train number you want to proceed with the booking:  ");
                String trainNumber = scanner.next();
                // According to the trainNumber the train name is to be fetched from the
                // database. Here we are using a sample
                String trainName = "Gorakhpur Express";

                System.out.println("Train Number: " + trainNumber);
                System.out.println("Train Name: " + trainName);
                // Enter your preferred class to proceed
                scanner.nextLine();
                System.out.print("Enter class type: ");
                String classType = scanner.nextLine();

                System.out.print("Enter date of journey: ");
                String dateOfJourney = scanner.nextLine();

                System.out.print("Enter from (station name): ");
                String fromPlace = scanner.nextLine();

                System.out.print("Enter destination (station name): ");
                String destination = scanner.nextLine();

                // Perform insertion or save the reservation details to a database
                // Insertion code here

                System.out.println("\nReservation successfull!");
                System.out.println("Here are the details you have entered");
                System.out.println("Your Name : " + name);
                System.out.println("Train Number: " + trainNumber);
                System.out.println("Train Name: " + trainName);
                System.out.println("classType: " + classType);
                System.out.println("Date of journey: " + dateOfJourney);
                System.out.println("From Place: " + fromPlace);
                System.out.println("Destination: " + destination + "\n");

                break;

            // Cancellation
            case 2:
                System.out.println("\nCancellation Form");
                System.out.print("Enter your PNR number: ");
                // The PNR number is to be checked in the database
                String pnrNumber = scanner.nextLine();

                // Fetch reservation details based on PNR number from the database
                // Cancellation code here

                System.out.println("Reservation details for PNR number " + pnrNumber + ":");
                // Display the reservation details after fetching from the database

                System.out.print("Do you want to confirm the cancellation? (y/n): ");
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("y")) {
                    // Perform cancellation
                    // Cancellation code here

                    System.out.println("Cancellation successfull!");
                } else {
                    System.out.println("Cancellation not confirmed.");
                }
                break;
        }

        scanner.close();
    }

    private static boolean isValidUser(String loginId, String password) {
        String storedPassword = users.get(loginId);
        return storedPassword != null && storedPassword.equals(password);
    }
}