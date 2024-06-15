package Todo;

public class TemporizerTime implements TemporizerTimeInterface {
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;
    private int elapsedSecondsTime = 0;

    
    public TemporizerTime(int elapsedSecondsTime) {
        this.elapsedSecondsTime = elapsedSecondsTime;
    }

    public TemporizerTime(int seconds, int minutes, int hours) {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
    }

    public TemporizerTime() {
    
    }


    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }
    public void setElapsedSecondsTime(int elapsedSecondsTime) {
        this.elapsedSecondsTime = elapsedSecondsTime;
        setTimeBasedOnElapsedSecondsTime();
    }
    public int getSeconds() {
        return seconds;
    }
    public int getMinutes() {
        return minutes;
    }
    public int getHours() {
        return hours;
    }
    public int getElapsedSecondsTime() {
        return elapsedSecondsTime;
    }


    public void setTime(int seconds, int minutes, int hours) {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
    }

    public void updateTime(int sumedSeconds) {
        elapsedSecondsTime += sumedSeconds;
        setTimeBasedOnElapsedSecondsTime();
    }

    public String getSecondsString() {
        return String.format("%02d", seconds);
    }

    public String getMinutesString() {
        return String.format("%02d", minutes);
    }

    public String getHoursString() {
        return String.format("%02d", hours);
    }

    public void setTimeBasedOnElapsedSecondsTime() {
        hours = (elapsedSecondsTime / 3600000);
        minutes = (elapsedSecondsTime/ 60000) % 60;
        seconds = (elapsedSecondsTime/ 1000) % 60;
    }

    public String getFullTimeString() {
        return getHoursString() + ":" + getMinutesString() + ":" + getSecondsString();
    }

    public void resetTime() {
        elapsedSecondsTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
    }
}

