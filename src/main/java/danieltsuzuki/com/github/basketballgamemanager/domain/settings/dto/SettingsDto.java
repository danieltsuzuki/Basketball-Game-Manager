package danieltsuzuki.com.github.basketballgamemanager.domain.settings.dto;

public record SettingsDto (
        int time,
        int maxScore,
        boolean isActivePlayer
) {}
