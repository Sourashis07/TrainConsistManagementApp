import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class TrainApp{

    static class BogieNameSorter {
        public String[] sortNames(String[] names) {
            Arrays.sort(names);
            return names;
        }
    }

    @Test
    void testSort_BasicAlphabeticalSorting() {
        BogieNameSorter sorter = new BogieNameSorter();

        String[] input = {"Sleeper","AC Chair","First Class","General","Luxury"};
        String[] expected = {"AC Chair","First Class","General","Luxury","Sleeper"};

        assertArrayEquals(expected, sorter.sortNames(input));
    }

    @Test
    void testSort_UnsortedInput() {
        BogieNameSorter sorter = new BogieNameSorter();

        String[] input = {"Luxury","General","Sleeper","AC Chair"};
        String[] expected = {"AC Chair","General","Luxury","Sleeper"};

        assertArrayEquals(expected, sorter.sortNames(input));
    }

    @Test
    void testSort_AlreadySortedArray() {
        BogieNameSorter sorter = new BogieNameSorter();

        String[] input = {"AC Chair","First Class","General"};
        String[] expected = {"AC Chair","First Class","General"};

        assertArrayEquals(expected, sorter.sortNames(input));
    }

    @Test
    void testSort_DuplicateBogieNames() {
        BogieNameSorter sorter = new BogieNameSorter();

        String[] input = {"Sleeper","AC Chair","Sleeper","General"};
        String[] expected = {"AC Chair","General","Sleeper","Sleeper"};

        assertArrayEquals(expected, sorter.sortNames(input));
    }

    @Test
    void testSort_SingleElementArray() {
        BogieNameSorter sorter = new BogieNameSorter();

        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};

        assertArrayEquals(expected, sorter.sortNames(input));
    }
}