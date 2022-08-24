import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.concurrent.ExecutionException;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

class HorseTest {

    Horse horse;

    @Test
    void constructorNullName_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1));
    }

    @Test
    void constructorNullName_checkExceptionMessage() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1));
        assertEquals("Name cannot be null.", illegalArgumentException.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t"})
    void constructorSpaceCharName_throwIllegalArgumentException(String spaceChar) {
        assertThrows(IllegalArgumentException.class, () -> new Horse(spaceChar, 1));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t"})
    void constructorSpaceCharName_checkExceptionMessage(String spaceChar) {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Horse(spaceChar, 1));
        assertEquals("Name cannot be blank.", illegalArgumentException.getMessage());
    }

    @Test
    void constructorNegativeSpeed_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse("Mustang", -1));
    }

    @Test
    void constructorNegativeSpeed_checkExceptionMessage() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Horse("Mustang", -1));
        assertEquals("Speed cannot be negative.", illegalArgumentException.getMessage());
    }

    @Test
    void constructorNegativeDistance_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse("Mustang", 1, -1));
    }

    @Test
    void constructorNegativeDistance_checkExceptionMessage() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Horse("Mustang", 1, -1));
        assertEquals("Distance cannot be negative.", illegalArgumentException.getMessage());
    }

    @Test
    void testGetName() {
        horse = new Horse("Mustang", 1);
        String actual = horse.getName();
        assertEquals("Mustang", actual);
    }

    @Test
    void testGetSpeed() {
        horse = new Horse("Mustang", 1);
        double actual = horse.getSpeed();
        assertEquals(1, actual);
    }

    @Test
    void testGetDistanceInConstructorWithThreeParameters() {
        horse = new Horse("Mustang", 1, 1);
        double actual = horse.getDistance();
        assertEquals(1, actual);
    }

    @Test
    void testGetDistanceInConstructorWithTwoParameters() {
        horse = new Horse("Mustang", 1);
        double actual = horse.getDistance();
        assertEquals(0, actual);
    }

    @Test
    void checkMoveMethodCall_getRandomDouble() {

    }
}