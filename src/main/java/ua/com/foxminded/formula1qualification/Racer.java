package ua.com.foxminded.formula1qualification;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Racer implements Comparable<Racer> {
    private String abbreviations;
    private String name;
    private String auto;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Duration bestTime;


    public Racer(String abbreviations, String name, String auto, LocalDateTime startTime, LocalDateTime endTime, Duration bestTime) {
        this.abbreviations = abbreviations;
        this.name = name;
        this.auto = auto;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bestTime = bestTime;
    }

    public String getAbbreviations() {
        return abbreviations;
    }

    public String getName() {
        return name;
    }

    public String getAuto() {
        return auto;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Duration getBestTime() {
        return bestTime;
    }

    @Override
    public int compareTo(Racer racer) {

        if (this.getBestTime().toMillis() == racer.getBestTime().toMillis())
            return 0;
        else {
            if (this.getBestTime().toMillis() < racer.getBestTime().toMillis())
                return -1;
            else
                return 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Racer racer = (Racer) o;
        return abbreviations.equals(racer.abbreviations) && name.equals(racer.name) && auto.equals(racer.auto) && startTime.equals(racer.startTime) && endTime.equals(racer.endTime) && bestTime.equals(racer.bestTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(abbreviations, name, auto, startTime, endTime, bestTime);
    }


}

