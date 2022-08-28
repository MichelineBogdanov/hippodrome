import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    @Disabled
    void failsIfExecutionTimeExceeds22Seconds() throws Exception {
        Main.main(null);
    }
}