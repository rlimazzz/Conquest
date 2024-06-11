package Todo;

public class TemporizerTime implements TemporizerTimeInterface {
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;
    private int elapsedTime = 0;

    public TemporizerTime(int seconds, int minutes, int hours, int elapsedTime) {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
        this.elapsedTime = elapsedTime;
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
    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
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
    public int getElapsedTime() {
        return elapsedTime;
    }


    public void setTime(int seconds, int minutes, int hours) {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
    }

    public void updateTemporizerTime(int sumedElapsedTime) {
        elapsedTime += sumedElapsedTime;
        setTimeBasedOnElapsedTime();
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

    public void setTimeBasedOnElapsedTime() {
        hours = (elapsedTime / 3600000);
        minutes = (elapsedTime/ 60000) % 60;
        seconds = (elapsedTime/ 1000) % 60;
    }

    public String getFullTimeString() {
        return getHoursString() + ":" + getMinutesString() + ":" + getSecondsString();
    }
}

