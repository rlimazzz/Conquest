package Todo;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateAdapter implements TemporizerTimeInterface {
    private Clock adapteeClock = Clock.systemDefaultZone();
    private Instant startingInstant;

    public DateAdapter() {
        startingInstant = adapteeClock.instant();
    }

    private int getInstantSecond(Instant instant) {
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).getSecond();
    }

    public int getElapsedSecondsTimeof(Instant instant) {
        int seconds = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).getSecond();
        int minutes = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).getMinute() * 60;
        int hours = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).getHour() * 3600;
        return seconds + minutes + hours;
    }

    public int getElapsedSecondsTime() {
        return getElapsedSecondsTimeof(adapteeClock.instant()) - getElapsedSecondsTimeof(startingInstant);
    }

    public void setElapsedSecondsTime(int elapsedSecondsTime) {
        startingInstant = adapteeClock.instant().minus(Duration.ofSeconds(elapsedSecondsTime));
    }

    public void setTime(int seconds, int minutes, int hours) {
        int totalElapsedSeconds = seconds + minutes * 60 + hours * 3600;
        startingInstant = adapteeClock.instant().minus(Duration.ofSeconds(totalElapsedSeconds));
    }

    public void updateTime(int sumedSeconds) {
        startingInstant = startingInstant.minus(Duration.ofSeconds(sumedSeconds));
    }

    public String getFullTimeString() {
        int elapsedSecondsTime = getElapsedSecondsTime();
        long hours = (elapsedSecondsTime / 3600000);
        long minutes = (elapsedSecondsTime / 60000) % 60;
        long seconds = (elapsedSecondsTime / 1000) % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public String getFullTimeString(Duration time) {
        long elapsedSecondsTime;
        if (time != null) {
            elapsedSecondsTime = time.toMillis();
        } else {
            elapsedSecondsTime = getElapsedSecondsTime();
        }
        long hours = (elapsedSecondsTime / 3600000);
        long minutes = (elapsedSecondsTime / 60000) % 60;
        long seconds = (elapsedSecondsTime / 1000) % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public String getFullDateTimeString() {
        LocalDateTime dateTime = LocalDateTime.ofInstant(startingInstant, ZoneId.systemDefault());
        return dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public void resetTime() {
        startingInstant = adapteeClock.instant();
    }
}
