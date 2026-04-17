import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainApp {

    static class LinearSearch {
        public boolean search(String[] bogieIds, String key) {
            for (String id : bogieIds) {
                if (id.equals(key)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Test
    void testSearch_BogieFound() {
        LinearSearch searcher = new LinearSearch();

        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(searcher.search(ids, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        LinearSearch searcher = new LinearSearch();

        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};
        assertFalse(searcher.search(ids, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        LinearSearch searcher = new LinearSearch();

        String[] ids = {"BG101","BG205","BG309"};
        assertTrue(searcher.search(ids, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        LinearSearch searcher = new LinearSearch();

        String[] ids = {"BG101","BG205","BG309"};
        assertTrue(searcher.search(ids, "BG309"));
    }

    @Test
    void testSearch_SingleElementArray() {
        LinearSearch searcher = new LinearSearch();

        String[] ids = {"BG101"};
        assertTrue(searcher.search(ids, "BG101"));
    }
}
