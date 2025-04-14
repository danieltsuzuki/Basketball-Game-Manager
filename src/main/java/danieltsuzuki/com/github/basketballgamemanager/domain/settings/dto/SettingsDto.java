package danieltsuzuki.com.github.basketballgamemanager.domain.settings.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record SettingsDto (
        @Min(1)
        int time,
        @Min(1)
        int maxScore,
        @NotNull
        boolean isActivePlayer
) {}
