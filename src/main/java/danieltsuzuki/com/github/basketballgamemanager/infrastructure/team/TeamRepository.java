package danieltsuzuki.com.github.basketballgamemanager.infrastructure.team;

import danieltsuzuki.com.github.basketballgamemanager.domain.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
