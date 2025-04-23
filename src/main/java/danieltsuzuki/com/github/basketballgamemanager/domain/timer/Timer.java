package danieltsuzuki.com.github.basketballgamemanager.domain.timer;

public class Timer {
    /// Timer duration in seconds
    private int time;
    private int initialTime;

    public Timer(int time) {
        if (time < 1) {
            throw new IllegalArgumentException("Time must be greater than 0");
        }
        this.time = time;
        this.initialTime = time;
    }

    public void start() {
        while (this.time > 0) {
            try {
                Thread.sleep(1000);
                this.time--;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Timer interrupted", e);
            }
        }
    }

    public void stop() {
        Thread.currentThread().interrupt();
    }

    public void reset() {
        this.stop();
        this.time = this.initialTime;
    }

    public void continueTime() {
        this.start();
    }

    public int getTime() {
        return time;
    }
}
