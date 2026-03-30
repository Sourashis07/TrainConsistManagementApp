import java.util.LinkedList;

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        LinkedList<String> consist = new LinkedList<>();

        consist.add("Engine");
        consist.add("Sleeper");
        consist.add("AC");
        consist.add("Cargo");
        consist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(consist);

        consist.add(2, "Pantry Car");

        System.out.println("After adding Pantry Car at position 2:");
        System.out.println(consist);

        consist.removeFirst();
        consist.removeLast();

        System.out.println("Final Train Consist after removals:");
        System.out.println(consist);

        System.out.println("Program continues...");
    }
}