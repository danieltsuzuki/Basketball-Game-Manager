package danieltsuzuki.com.github.basketballgamemanager.application.team;

import danieltsuzuki.com.github.basketballgamemanager.domain.exception.NotFoundException;
import danieltsuzuki.com.github.basketballgamemanager.domain.team.Team;
import danieltsuzuki.com.github.basketballgamemanager.domain.team.dto.TeamDto;
import danieltsuzuki.com.github.basketballgamemanager.infrastructure.team.TeamRepository;
import jakarta.validation.constraints.AssertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TeamServiceTest {
    private TeamRepository repository;
    private TeamService service;

    @BeforeEach
    void setup() {
        repository = mock(TeamRepository.class);
        service = new TeamService(repository);
    }

    @Test
    void shouldReturnTeamWhenExisting() {
        Team team = new Team(1L, "Time A");
        when(repository.findById(1L)).thenReturn(Optional.of(team));

        TeamDto dto = service.getTeam(1L);

        assertEquals("Time A", dto.name());
    }

    @Test
    void shouldThrowExceptionWhenTeamDoesNotExist() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(NotFoundException.class, () -> service.getTeam(1L));
        assertEquals("Team not found", exception.getMessage());
    }

    @Test
    void shouldReturnListTeamsWhenExisting() {
        Team team = new Team(1L, "Time A");
        Team team2 = new Team(2L, "Time B");
        List<Team> listTeams = Arrays.asList(team, team2);
        when(repository.findAll()).thenReturn(listTeams);

        List<TeamDto> dto = service.getTeams();

        assertEquals("Time A", dto.get(0).name());
        assertEquals("Time B", dto.get(1).name());
        assertEquals(2, dto.size());
    }

    @Test
    void shouldSaveTeamWhenUpdating() {
        Team team = new Team(1L, "Time sem camisa");
        when(repository.save(Mockito.any(Team.class))).thenReturn(team);

        TeamDto dto = new TeamDto("Time sem camisa");
        TeamDto result = service.updateTeam(1L ,dto);

        assertEquals("Time sem camisa", result.name());
    }
}
