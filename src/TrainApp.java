import java.util.HashSet;
import java.util.Set;

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        Set<String> bogieIds = new HashSet<>();

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101");
        bogieIds.add("BG102");

        System.out.println("Unique Bogie IDs:");
        System.out.println(bogieIds);

        System.out.println("Program continues...");
    }
}