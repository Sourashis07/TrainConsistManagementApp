import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest_UC10 {

    static class Bogie {
        private String bogieId;
        private String bogieType;
        private int capacity;

        public Bogie(String bogieId, String bogieType, int capacity) {
            this.bogieId = bogieId;
            this.bogieType = bogieType;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }

        public String getBogieId() {
            return bogieId;
        }
    }

    private int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = List.of(
                new Bogie("B1", "Sleeper", 72),
                new Bogie("B2", "AC Chair", 60),
                new Bogie("B3", "First Class", 50)
        );

        int total = calculateTotalSeats(bogies);

        assertEquals(182, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = List.of(
                new Bogie("B1", "Sleeper", 70),
                new Bogie("B2", "Sleeper", 80),
                new Bogie("B3", "AC Chair", 60)
        );

        int total = calculateTotalSeats(bogies);

        assertEquals(210, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = List.of(
                new Bogie("B1", "Sleeper", 75)
        );

        int total = calculateTotalSeats(bogies);

        assertEquals(75, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int total = calculateTotalSeats(bogies);

        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = List.of(
                new Bogie("B1", "Sleeper", 10),
                new Bogie("B2", "AC Chair", 20),
                new Bogie("B3", "First Class", 30)
        );

        int total = calculateTotalSeats(bogies);

        assertEquals(60, total);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = List.of(
                new Bogie("B1", "Sleeper", 40),
                new Bogie("B2", "AC Chair", 50),
                new Bogie("B3", "First Class", 60),
                new Bogie("B4", "Sleeper", 70)
        );

        int total = calculateTotalSeats(bogies);

        assertEquals(220, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("B1", "Sleeper", 72));
        bogies.add(new Bogie("B2", "AC Chair", 60));

        int originalSize = bogies.size();
        String firstId = bogies.get(0).getBogieId();

        int total = calculateTotalSeats(bogies);

        assertEquals(originalSize, bogies.size());
        assertEquals(firstId, bogies.get(0).getBogieId());
    }
}