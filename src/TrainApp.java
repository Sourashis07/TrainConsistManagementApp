import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest_UC16 {

    static class PassengerBogieSorter {

        public int[] bubbleSort(int[] capacities) {
            int n = capacities.length;

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (capacities[j] > capacities[j + 1]) {
                        // swap
                        int temp = capacities[j];
                        capacities[j] = capacities[j + 1];
                        capacities[j + 1] = temp;
                    }
                }
            }
            return capacities;
        }
    }

    @Test
    void testSort_BasicSorting() {
        PassengerBogieSorter sorter = new PassengerBogieSorter();

        int[] input = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};

        assertArrayEquals(expected, sorter.bubbleSort(input));
    }

    @Test
    void testSort_AlreadySortedArray() {
        PassengerBogieSorter sorter = new PassengerBogieSorter();

        int[] input = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};

        assertArrayEquals(expected, sorter.bubbleSort(input));
    }

    @Test
    void testSort_DuplicateValues() {
        PassengerBogieSorter sorter = new PassengerBogieSorter();

        int[] input = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};

        assertArrayEquals(expected, sorter.bubbleSort(input));
    }

    @Test
    void testSort_SingleElementArray() {
        PassengerBogieSorter sorter = new PassengerBogieSorter();

        int[] input = {50};
        int[] expected = {50};

        assertArrayEquals(expected, sorter.bubbleSort(input));
    }

    @Test
    void testSort_AllEqualValues() {
        PassengerBogieSorter sorter = new PassengerBogieSorter();

        int[] input = {40, 40, 40};
        int[] expected = {40, 40, 40};

        assertArrayEquals(expected, sorter.bubbleSort(input));
    }
}