package danieltsuzuki.com.github.basketballgamemanager.application.settings;

import danieltsuzuki.com.github.basketballgamemanager.domain.settings.Settings;
import danieltsuzuki.com.github.basketballgamemanager.domain.settings.dto.SettingsDto;
import danieltsuzuki.com.github.basketballgamemanager.infrastructure.settings.SettingsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SettingsService {

    private final SettingsRepository settingsRepository;

    public SettingsService(SettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }

    public SettingsDto getSettings() {
        Optional<Settings> settings = settingsRepository.findById(1L);
        return settings.map(s -> new SettingsDto(s.getTime(), s.getMaxScore(), s.isActivePlayer()))
                .orElseThrow(() -> new RuntimeException("Configuração encontrada"));
    }

    public SettingsDto updateSettings(SettingsDto dto) {
        Settings settings = new Settings(1L, dto.time(), dto.maxScore(), dto.isActivePlayer());
        Settings saved = settingsRepository.save(settings);
        return new SettingsDto(saved.getTime(), saved.getMaxScore(), saved.isActivePlayer());
    }

}
