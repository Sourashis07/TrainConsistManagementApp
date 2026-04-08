import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainApp {

    // Helper method for filtering
    private List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .toList();
    }

    // 1. Capacity > Threshold
    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC", 60),
                new Bogie("FirstClass", 90)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertEquals(2, result.size());
    }

    // 2. Capacity == Threshold
    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 70),
                new Bogie("AC", 75)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertEquals(1, result.size()); // 70 excluded
    }

    // 3. Capacity < Threshold
    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 50),
                new Bogie("AC", 60)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    // 4. Multiple Matching
    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC", 85),
                new Bogie("FirstClass", 90)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertEquals(3, result.size());
    }

    // 5. No Matching
    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 40),
                new Bogie("AC", 50)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    // 6. All Matching
    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC", 85)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertEquals(bogies.size(), result.size());
    }

    // 7. Empty List
    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    // 8. Original List Unchanged
    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 80));
        bogies.add(new Bogie("AC", 60));

        int originalSize = bogies.size();

        List<Bogie> result = filterBogies(bogies, 70);

        assertEquals(originalSize, bogies.size()); // original unchanged
        assertEquals(1, result.size());
    }
}