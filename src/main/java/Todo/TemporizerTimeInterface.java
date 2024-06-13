package Todo;

public interface TemporizerTimeInterface {
    public int getElapsedSecondsTime();
    public void setElapsedSecondsTime(int elapsedSecondsTime);

    public void setTime(int seconds, int minutes, int hours);
    public void updateTime(int sumedSeconds);
    public String getFullTimeString();
    public void resetTime();
}
