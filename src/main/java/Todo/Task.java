package Todo;

import java.time.Duration;
import java.time.LocalDateTime;

public class Task {
    private String description;
    private LocalDateTime startTime;
    private Duration timeSpent;
    DateAdapter adapter = new DateAdapter();

    public Task(String description) {
        this.description = description;
        this.startTime = null;
        this.timeSpent = Duration.ZERO;
    }

    public String getDescription() {
        return description;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Duration getTimeSpent() {
        return timeSpent;
    }

    public void updateTimeSpent(Duration duration) {
        if (startTime != null) {
            timeSpent = timeSpent.plus(duration);
        }
    }

    @Override
    public String toString() {
        
        String fullDateTime = adapter.getFullDateTimeString();
       
        String timeSpentStr = adapter.getFullTimeString(timeSpent);
        return String.format("%s (Início: %s, Tempo gasto: %s)", description, fullDateTime, timeSpentStr);
    }
}
