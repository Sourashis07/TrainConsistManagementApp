import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest_UC9 {

    static class Bogie {
        private String bogieId;
        private String bogieType;
        private int capacity;

        public Bogie(String bogieId, String bogieType, int capacity) {
            this.bogieId = bogieId;
            this.bogieType = bogieType;
            this.capacity = capacity;
        }

        public String getBogieId() {
            return bogieId;
        }

        public String getBogieType() {
            return bogieType;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    private Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getBogieType));
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<Bogie> bogies = List.of(
                new Bogie("B1", "Sleeper", 72),
                new Bogie("B2", "Sleeper", 70),
                new Bogie("B3", "AC Chair", 60)
        );

        Map<String, List<Bogie>> result = groupBogiesByType(bogies);

        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> bogies = List.of(
                new Bogie("B1", "Sleeper", 72),
                new Bogie("B2", "Sleeper", 75)
        );

        Map<String, List<Bogie>> result = groupBogiesByType(bogies);

        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<Bogie> bogies = List.of(
                new Bogie("B1", "Sleeper", 72),
                new Bogie("B2", "AC Chair", 60),
                new Bogie("B3", "First Class", 50)
        );

        Map<String, List<Bogie>> result = groupBogiesByType(bogies);

        assertEquals(3, result.size());
        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        Map<String, List<Bogie>> result = groupBogiesByType(bogies);

        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> bogies = List.of(
                new Bogie("B1", "Sleeper", 72),
                new Bogie("B2", "Sleeper", 75)
        );

        Map<String, List<Bogie>> result = groupBogiesByType(bogies);

        assertEquals(1, result.size());
        assertTrue(result.containsKey("Sleeper"));
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> bogies = List.of(
                new Bogie("B1", "Sleeper", 72),
                new Bogie("B2", "AC Chair", 60),
                new Bogie("B3", "First Class", 50)
        );

        Map<String, List<Bogie>> result = groupBogiesByType(bogies);

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        List<Bogie> bogies = List.of(
                new Bogie("B1", "Sleeper", 72),
                new Bogie("B2", "Sleeper", 75),
                new Bogie("B3", "AC Chair", 60)
        );

        Map<String, List<Bogie>> result = groupBogiesByType(bogies);

        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("B1", "Sleeper", 72));
        bogies.add(new Bogie("B2", "AC Chair", 60));

        int originalSize = bogies.size();
        String firstId = bogies.get(0).getBogieId();

        Map<String, List<Bogie>> result = groupBogiesByType(bogies);

        assertEquals(originalSize, bogies.size());
        assertEquals(firstId, bogies.get(0).getBogieId());
    }
}