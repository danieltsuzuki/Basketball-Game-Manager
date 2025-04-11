package danieltsuzuki.com.github.basketballgamemanager.domain.settings;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "settings")
public class Settings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int time;
    private int maxScore;
    private boolean isActivePlayer;

    public Settings() {}
    public Settings(Long id, int time, int maxScore, boolean isActivePlayer) {
        if (time <= 0) throw new IllegalArgumentException("Time must be greater than 0");
        if (maxScore <= 0) throw new IllegalArgumentException("MaxScore must be greater than 0");
        this.id = id;
        this.time = time;
        this.maxScore = maxScore;
        this.isActivePlayer = isActivePlayer;
    }

    public int getTime() {
        return time;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public boolean isActivePlayer() {
        return isActivePlayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Settings)) return false;
        Settings settings = (Settings) o;
        return time == settings.time &&
                maxScore == settings.maxScore &&
                isActivePlayer == settings.isActivePlayer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, maxScore, isActivePlayer);
    }
}
