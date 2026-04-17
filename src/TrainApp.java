import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainApp {

    static class SafeSearch {

        public boolean search(String[] bogieIds, String key) {
            // Fail-fast validation
            if (bogieIds == null || bogieIds.length == 0) {
                throw new IllegalStateException("No bogies available for search");
            }

            // Linear search after validation
            for (String id : bogieIds) {
                if (id.equals(key)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        SafeSearch searcher = new SafeSearch();

        String[] ids = {};
        assertThrows(IllegalStateException.class, () -> searcher.search(ids, "BG101"));
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        SafeSearch searcher = new SafeSearch();

        String[] ids = {"BG101","BG205"};
        assertDoesNotThrow(() -> searcher.search(ids, "BG101"));
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        SafeSearch searcher = new SafeSearch();

        String[] ids = {"BG101","BG205","BG309"};
        assertTrue(searcher.search(ids, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        SafeSearch searcher = new SafeSearch();

        String[] ids = {"BG101","BG205","BG309"};
        assertFalse(searcher.search(ids, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        SafeSearch searcher = new SafeSearch();

        String[] ids = {"BG101"};
        assertTrue(searcher.search(ids, "BG101"));
    }
}