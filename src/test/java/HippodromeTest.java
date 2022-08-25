import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {

    Hippodrome hippodrome;

    @Test
    void hippodromeConstructorNullHorseList_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
    }

    @Test
    void hippodromeConstructorNullHorseList_checkExceptionMessage() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", illegalArgumentException.getMessage());
    }

    @Test
    void hippodromeConstructorSpaceListHorseList_throwIllegalArgumentException() {
        List<Horse> list = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(list));
    }

    @Test
    void hippodromeConstructorSpaceListHorseList_checkExceptionMessage() {
        List<Horse> list = new ArrayList<>();
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(list));
        assertEquals("Horses cannot be empty.", illegalArgumentException.getMessage());
    }

    @Test
    void getHorses() {
        assertTrue(true);
    }

    @Test
    void move() {
        assertTrue(true);
    }

    @Test
    void getWinner() {
        assertTrue(true);
    }
}