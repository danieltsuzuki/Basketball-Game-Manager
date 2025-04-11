package danieltsuzuki.com.github.basketballgamemanager.infrastructure.settings;

import danieltsuzuki.com.github.basketballgamemanager.domain.settings.Settings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsRepository extends JpaRepository<Settings, Long> {
}
