package danieltsuzuki.com.github.basketballgamemanager.domain.settings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SettingsTest {

    @Test
    void mustCreateValidSettings() {
        Settings settings = new Settings(1L, 10, 21, true);
        assertEquals(10, settings.getTime());
        assertEquals(21, settings.getMaxScore());
        assertTrue(settings.isActivePlayer());
    }

    @Test
    void shouldThrowExceptionWhenTimeIsZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Settings(1L, 0, 21, true));
        assertEquals("Time must be greater than 0", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenMaxScoreIsZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Settings(1L, 10, 0, false));
        assertEquals("MaxScore must be greater than 0", exception.getMessage());
    }
}