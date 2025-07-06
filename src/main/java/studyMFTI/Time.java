package studyMFTI;

// Задача 1.1.4
public class Time {
    private int second;

    public Time(int second) {
        this.second = second;
    }

    @Override
    public String toString() {
        if (second < 0) throw new RuntimeException();
        if (second / 86400 > 0) second -= (second / 86400) * 86400;
        int hour = second / 3600;
        int minutes = (second - hour * 3600) / 60;
        int seconds = second - hour * 3600 - minutes * 60;
        return hour + ":" + minutes +  ":" + seconds;
    }
}
