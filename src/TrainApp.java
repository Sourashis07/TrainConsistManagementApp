import java.util.LinkedHashSet;

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        LinkedHashSet<String> consist = new LinkedHashSet<>();

        consist.add("Engine");
        consist.add("Sleeper");
        consist.add("Cargo");
        consist.add("Guard");

        consist.add("Sleeper");
        consist.add("Engine");

        System.out.println("Final Train Formation:");
        System.out.println(consist);

        System.out.println("Program continues...");
    }
}