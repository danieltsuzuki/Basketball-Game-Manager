package danieltsuzuki.com.github.basketballgamemanager.domain.timer;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class TimerTest {

    @Test
    void mustCreateValidTimer() {
        Timer timer = new Timer(60000);
        assertEquals(60000, timer.getTime(), "Timer deve iniciar com o valor 60 segundos");
    }

    @Test
    void shouldThrowExceptionWhenTimeLessThanOne() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Timer(0));
        assertEquals("Time must be greater than 0", exception.getMessage());
    }

    @Test
    void startShouldCountDownToZeroWithinTimeout() {
        Timer timer = new Timer(1);
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> {
            timer.start();
            assertEquals(0, timer.getTime(), "Após start(), time deve chegar a 0");
        });
    }

    @Test
    void resetShouldRestoreInitialTimeAfterStart() {
        Timer timer = new Timer(1);
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            timer.start();
            assertEquals(0, timer.getTime(), "Após start(), time deve chegar a 0");
            timer.reset();
            assertEquals(1, timer.getTime(), "Após reset(), time deve voltar ao valor inicial");
        });
    }

    @Test
    void continueTimeDelegatesToStart() {
        Timer timer = new Timer(1);
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> {
            timer.continueTime();
            assertEquals(0, timer.getTime(), "continueTime() deve funcionar igual a start()");
        });
    }

}
