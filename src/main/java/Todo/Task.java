package Todo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String startTimeStr = (startTime != null) ? startTime.format(formatter) : "N/A";
        String fullDateTime = adapter.getFullDateTimeString(startTime);
        String timeSpentStr = String.format("%02d:%02d:%02d",
                timeSpent.toHours(),
                timeSpent.toMinutes() % 60,
                timeSpent.getSeconds() % 60);
        return String.format("%s (Start: %s, Spent: %s)", description, fullDateTime, timeSpentStr);
    }
}
