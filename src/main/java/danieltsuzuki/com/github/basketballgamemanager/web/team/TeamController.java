package danieltsuzuki.com.github.basketballgamemanager.web.team;

import danieltsuzuki.com.github.basketballgamemanager.application.team.TeamService;
import danieltsuzuki.com.github.basketballgamemanager.domain.team.dto.TeamDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDto> updateTeam(@PathVariable Long id, @Valid @RequestBody TeamDto dto) {
        return ResponseEntity.ok(teamService.updateTeam(id, dto));
    }

    @GetMapping
    public ResponseEntity<List<TeamDto>> getTeams() {
        return ResponseEntity.ok(teamService.getTeams());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDto> getTeam(@PathVariable Long id) {
        return ResponseEntity.ok(teamService.getTeam(id));
    }
}
