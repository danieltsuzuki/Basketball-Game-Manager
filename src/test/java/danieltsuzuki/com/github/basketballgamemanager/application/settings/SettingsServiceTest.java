package danieltsuzuki.com.github.basketballgamemanager.application.settings;

import danieltsuzuki.com.github.basketballgamemanager.domain.exception.NotFoundException;
import danieltsuzuki.com.github.basketballgamemanager.domain.settings.Settings;
import danieltsuzuki.com.github.basketballgamemanager.domain.settings.dto.SettingsDto;
import danieltsuzuki.com.github.basketballgamemanager.infrastructure.settings.SettingsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SettingsServiceTest {

    private SettingsRepository repository;
    private SettingsService service;

    @BeforeEach
    void setup() {
        repository = mock(SettingsRepository.class);
        service = new SettingsService(repository);
    }

    @Test
    void shouldReturnSettingsWhenExisting() {
        Settings settings = new Settings(1L, 10, 21, true);
        when(repository.findById(1L)).thenReturn(Optional.of(settings));

        SettingsDto dto = service.getSettings();

        assertEquals(10, dto.time());
        assertEquals(21, dto.maxScore());
        assertTrue(dto.isActivePlayer());
    }

    @Test
    void shouldThrowExceptionWhenSettingsDoesNotExist() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(NotFoundException.class, () -> service.getSettings());
        assertEquals("Settings not found!", exception.getMessage());
    }

    @Test
    void shouldSaveSettingsWhenUpdating() {
        Settings settings = new Settings(1L, 15, 30, false);
        when(repository.save(Mockito.any(Settings.class))).thenReturn(settings);

        SettingsDto dto = new SettingsDto(15, 30, false);
        SettingsDto resultado = service.updateSettings(dto);

        assertEquals(15, resultado.time());
        assertEquals(30, resultado.maxScore());
        assertFalse(resultado.isActivePlayer());
    }
}