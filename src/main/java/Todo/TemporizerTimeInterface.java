package Todo;

public interface TemporizerTimeInterface {
    public int getElapsedTime();
    public void setElapsedTime(int elapsedTime);

    public void setTime(int seconds, int minutes, int hours);
    public void updateTemporizerTime(int sumedTime);
    public String getSecondsString();
    public String getMinutesString();
    public String getHoursString();
    public void setTimeBasedOnElapsedTime();
    public String getFullTimeString();
}
