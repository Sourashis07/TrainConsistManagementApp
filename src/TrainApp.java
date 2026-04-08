import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest_UC13 {

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

    private List<Bogie> filterWithLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.getCapacity() > 60) {
                result.add(bogie);
            }
        }
        return result;
    }

    private List<Bogie> filterWithStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> bogies = List.of(
                new Bogie("B1", "Sleeper", 72),
                new Bogie("B2", "AC Chair", 60),
                new Bogie("B3", "First Class", 80),
                new Bogie("B4", "Sleeper", 55)
        );

        List<Bogie> result = filterWithLoop(bogies);

        assertEquals(2, result.size());
        assertEquals("B1", result.get(0).getBogieId());
        assertEquals("B3", result.get(1).getBogieId());
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> bogies = List.of(
                new Bogie("B1", "Sleeper", 72),
                new Bogie("B2", "AC Chair", 60),
                new Bogie("B3", "First Class", 80),
                new Bogie("B4", "Sleeper", 55)
        );

        List<Bogie> result = filterWithStream(bogies);

        assertEquals(2, result.size());
        assertEquals("B1", result.get(0).getBogieId());
        assertEquals("B3", result.get(1).getBogieId());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = List.of(
                new Bogie("B1", "Sleeper", 72),
                new Bogie("B2", "AC Chair", 60),
                new Bogie("B3", "First Class", 80),
                new Bogie("B4", "Sleeper", 55),
                new Bogie("B5", "AC Chair", 90)
        );

        List<Bogie> loopResult = filterWithLoop(bogies);
        List<Bogie> streamResult = filterWithStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());

        for (int i = 0; i < loopResult.size(); i++) {
            assertEquals(loopResult.get(i).getBogieId(), streamResult.get(i).getBogieId());
        }
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            bogies.add(new Bogie("B" + i, "Sleeper", 50 + (i % 40)));
        }

        long startTime = System.nanoTime();
        List<Bogie> result = filterWithStream(bogies);
        long endTime = System.nanoTime();

        long elapsedTime = endTime - startTime;

        assertNotNull(result);
        assertTrue(elapsedTime > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies = new ArrayList<>();

        for (int i = 1; i <= 10000; i++) {
            bogies.add(new Bogie("B" + i, "Sleeper", 50 + (i % 20)));
        }

        List<Bogie> loopResult = filterWithLoop(bogies);
        List<Bogie> streamResult = filterWithStream(bogies);

        assertNotNull(loopResult);
        assertNotNull(streamResult);
        assertEquals(loopResult.size(), streamResult.size());
    }
}