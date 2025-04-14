package danieltsuzuki.com.github.basketballgamemanager.domain.team.dto;

import jakarta.validation.constraints.NotBlank;

public record TeamDto(
        @NotBlank
        String name
) {}
