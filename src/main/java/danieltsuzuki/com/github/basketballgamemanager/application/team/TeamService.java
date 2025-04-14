package danieltsuzuki.com.github.basketballgamemanager.application.team;

import danieltsuzuki.com.github.basketballgamemanager.domain.exception.NotFoundException;
import danieltsuzuki.com.github.basketballgamemanager.domain.team.Team;
import danieltsuzuki.com.github.basketballgamemanager.domain.team.dto.TeamDto;
import danieltsuzuki.com.github.basketballgamemanager.infrastructure.team.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public TeamDto updateTeam(Long id, TeamDto dto) {
        if (teamRepository.existsById(id))
            new NotFoundException("Team not found");

        var newTeam = new Team(id, dto.name());
        var saved = teamRepository.save(newTeam);
        return new TeamDto(saved.getName());
    }

    public List<TeamDto> getTeams() {
        return teamRepository.findAll().stream()
                .map(team -> new TeamDto(team.getName()))
                .toList();
    }

    public TeamDto getTeam(Long id) {
        var team = teamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Team not found"));
        return new TeamDto(team.getName());
    }
}
