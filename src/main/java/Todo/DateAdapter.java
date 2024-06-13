package Todo;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.util.TimeZone;

public class DateAdapter implements TemporizerTimeInterface {
    private Clock adapteeClock = Clock.systemDefaultZone();
    private Instant startingInstant;


    public DateAdapter() {
        startingInstant = adapteeClock.instant();
    }


    private int getInstantSecond(Instant instant) {
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).getSecond();
    }

    public int getElapsedSecondsTime() {
        int startingSecond = getInstantSecond(startingInstant);
        int endingSecond = getInstantSecond(adapteeClock.instant());
        return endingSecond - startingSecond;
    }

    public void setElapsedSecondsTime(int elapsedSecondsTime) {
        startingInstant = adapteeClock.instant().minus(Duration.ofSeconds(elapsedSecondsTime));
    }

    public void setTime(int seconds, int minutes, int hours) {
        int totalElapsedSeconds = seconds + minutes * 60 + hours * 3600;
        startingInstant = adapteeClock.instant().minus(Duration.ofSeconds(totalElapsedSeconds));
    }

    public void updateTime(int sumedSeconds) {
        startingInstant = adapteeClock.instant().minus(Duration.ofSeconds(sumedSeconds));
    }

    public String getFullTimeString() {
        ZonedDateTime zonedDateTime = adapteeClock.instant().atZone(adapteeClock.getZone());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return zonedDateTime.format(dateTimeFormatter);
    }

    public String getFullDateTimeString(LocalDateTime dateTime) {
        int day = LocalDateTime.ofInstant(startingInstant, ZoneId.systemDefault()).getDayOfMonth();
        int month = LocalDateTime.ofInstant(startingInstant, ZoneId.systemDefault()).getMonthValue();
        int year = LocalDateTime.ofInstant(startingInstant, ZoneId.systemDefault()).getYear();
        int hour = LocalDateTime.ofInstant(startingInstant, ZoneId.systemDefault()).getHour();
        int minute = LocalDateTime.ofInstant(startingInstant, ZoneId.systemDefault()).getMinute();

        return String.format("%02d/%02d/%04d %02d:%02d", day, month, year, hour, minute);
    }

    public void resetTime() {
        startingInstant = adapteeClock.instant();
    }
}
