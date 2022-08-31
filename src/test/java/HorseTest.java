import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    Horse horse;

    @BeforeEach
    void init() {
        horse = new Horse("Mustang", 1, 1);
    }

    @Mock
    Horse mockHorse;

    @Test
    void horseConstructorNullName_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1));
    }

    @Test
    void horseConstructorNullName_checkExceptionMessage() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1));
        assertEquals("Name cannot be null.", illegalArgumentException.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t"})
    void horseConstructorSpaceCharName_throwIllegalArgumentException(String spaceChar) {
        assertThrows(IllegalArgumentException.class, () -> new Horse(spaceChar, 1));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t"})
    void horseConstructorSpaceCharName_checkExceptionMessage(String spaceChar) {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Horse(spaceChar, 1));
        assertEquals("Name cannot be blank.", illegalArgumentException.getMessage());
    }

    @Test
    void horseConstructorNegativeSpeed_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse("Mustang", -1));
    }

    @Test
    void horseConstructorNegativeSpeed_checkExceptionMessage() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Horse("Mustang", -1));
        assertEquals("Speed cannot be negative.", illegalArgumentException.getMessage());
    }

    @Test
    void horseConstructorNegativeDistance_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse("Mustang", 1, -1));
    }

    @Test
    void horseConstructorNegativeDistance_checkExceptionMessage() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Horse("Mustang", 1, -1));
        assertEquals("Distance cannot be negative.", illegalArgumentException.getMessage());
    }

    @Test
    void horseTestGetName() {
        String actual = horse.getName();
        assertEquals("Mustang", actual);
    }

    @Test
    void horseTestGetSpeed() {
        double actual = horse.getSpeed();
        assertEquals(1, actual);
    }

    @Test
    void horseTestGetDistanceInConstructorWithThreeParameters() {
        double actual = horse.getDistance();
        assertEquals(1, actual);
    }

    @Test
    void horseTestGetDistanceInConstructorWithTwoParameters() {
        double actual = horse.getDistance();
        assertEquals(1, actual);
    }

    @Test
    void horseCheckMoveMethodCall_getRandomDouble() {
        try (MockedStatic<Horse> mockedHorse = Mockito.mockStatic(Horse.class)) {
            horse.move();
            mockedHorse.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }

    @Test
    void horseCheckMoveMethodCall_setDistanceByExpression() {
        try (MockedStatic<Horse> mockedHorse = Mockito.mockStatic(Horse.class)) {
            mockedHorse.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(1.0);
            double expected = horse.getDistance() + horse.getSpeed() * Horse.getRandomDouble(0.2, 0.9);
            horse.move();
            assertEquals(expected, horse.getDistance());
        }
    }
}