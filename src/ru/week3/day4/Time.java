package ru.week3.day4;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        normalize();
    }

    // +sec секунд
    public void addSeconds(int sec) {
        int total = getTotalSeconds() + sec;
        setFromTotalSeconds(total);
    }

    // -sec секунд
    public void subtractSeconds(int sec) {
        int total = getTotalSeconds() - sec;
        if (total < 0) total = 0; // чтобы не уйти в минус (можно сделать иначе)
        setFromTotalSeconds(total);
    }

    // не должен менять состояние объекта, только считать
    public int getTotalSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    public void displayTime() {
        System.out.printf("%02d:%02d:%02d%n", hours, minutes, seconds);
    }

    // привести поля к нормальному виду: 0<=seconds<60, 0<=minutes<60
    private void normalize() {
        setFromTotalSeconds(getTotalSeconds());
    }

    private void setFromTotalSeconds(int totalSeconds) {
        if (totalSeconds < 0) totalSeconds = 0;

        hours = totalSeconds / 3600;
        totalSeconds = totalSeconds % 3600;

        minutes = totalSeconds / 60;
        seconds = totalSeconds % 60;
    }

    public static void main(String[] args) {
        Time time = new Time(1, 30, 59);
        time.displayTime();      // 01:30:59

        time.addSeconds(30);
        time.displayTime();      // 01:31:29

        System.out.println(time.getTotalSeconds()); // 5489
    }
}
