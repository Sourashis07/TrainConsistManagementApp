import java.util.ArrayList;
import java.util.List;

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("Passenger Bogies after addition:");
        System.out.println(passengerBogies);

        passengerBogies.remove("AC Chair");

        System.out.println("Passenger Bogies after removal:");
        System.out.println(passengerBogies);

        System.out.println("Does Sleeper exist? " + passengerBogies.contains("Sleeper"));

        System.out.println("Final Bogie List:");
        System.out.println(passengerBogies);

        System.out.println("Program continues...");
    }
}