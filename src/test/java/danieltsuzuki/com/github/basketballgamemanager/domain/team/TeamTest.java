package danieltsuzuki.com.github.basketballgamemanager.domain.team;

import danieltsuzuki.com.github.basketballgamemanager.domain.settings.Settings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    void mustCreateValidTeam() {
        Team team = new Team(1L, "Flamengo");
        assertEquals("Flamengo", team.getName());
        assertTrue(!team.getName().isEmpty());
    }

    @Test
    void shouldThrowExceptionWhenNameIsEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Team(1L, ""));
        assertEquals("Name cannot be empty", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenNameIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Team(1L, null));
        assertEquals("Name cannot be null", exception.getMessage());
    }
}