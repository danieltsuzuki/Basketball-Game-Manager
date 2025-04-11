package danieltsuzuki.com.github.basketballgamemanager.web.settings;

import danieltsuzuki.com.github.basketballgamemanager.application.settings.SettingsService;
import danieltsuzuki.com.github.basketballgamemanager.domain.settings.dto.SettingsDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/settings")
public class SettingsController {

    private final SettingsService service;

    public SettingsController(SettingsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<SettingsDto> getSettings() {
        return ResponseEntity.ok(service.getSettings());
    }

    @PutMapping
    public ResponseEntity<SettingsDto> updateSettings(@Valid @RequestBody SettingsDto dto) {
        return ResponseEntity.ok(service.updateSettings(dto));
    }
}
