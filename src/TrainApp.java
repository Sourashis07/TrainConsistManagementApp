import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class TrainApp {

    static class BinarySearch {
        public boolean search(String[] bogieIds, String key) {
            Arrays.sort(bogieIds);

            int low = 0;
            int high = bogieIds.length - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                int cmp = key.compareTo(bogieIds[mid]);

                if (cmp == 0) return true;
                else if (cmp < 0) high = mid - 1;
                else low = mid + 1;
            }
            return false;
        }
    }

    @Test
    void testBinarySearch_BogieFound() {
        BinarySearch searcher = new BinarySearch();

        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(searcher.search(ids, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        BinarySearch searcher = new BinarySearch();

        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};
        assertFalse(searcher.search(ids, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        BinarySearch searcher = new BinarySearch();

        String[] ids = {"BG101","BG205","BG309"};
        assertTrue(searcher.search(ids, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        BinarySearch searcher = new BinarySearch();

        String[] ids = {"BG101","BG205","BG309"};
        assertTrue(searcher.search(ids, "BG309"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        BinarySearch searcher = new BinarySearch();

        String[] ids = {"BG101"};
        assertTrue(searcher.search(ids, "BG101"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        BinarySearch searcher = new BinarySearch();

        String[] ids = {};
        assertFalse(searcher.search(ids, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        BinarySearch searcher = new BinarySearch();

        String[] ids = {"BG309","BG101","BG550","BG205","BG412"};
        assertTrue(searcher.search(ids, "BG205"));
    }
}
