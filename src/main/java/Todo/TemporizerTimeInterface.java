package Todo;

import java.time.Duration;

public interface TemporizerTimeInterface {
    public int getElapsedSecondsTime();

    public void setElapsedSecondsTime(int elapsedSecondsTime);

    public void setTime(int seconds, int minutes, int hours);

    public void updateTime(int sumedSeconds);

    public String getFullTimeString(Duration time);

    public void resetTime();

    public String getFullDateTimeString();
}
