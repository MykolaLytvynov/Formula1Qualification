package ua.com.foxminded.formula1qualification;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.util.Date;

public class Racers implements Comparable<Racers> {
    private String abbreviations;
    private String name;
    private String auto;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private SimpleDateFormat formatTime = new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss.SSS");
    private Duration bestTime;


    public Racers(String abbreviations, String name, String auto, String startTime, String endTime) {
        this.abbreviations = abbreviations;
        this.name = name;
        this.auto = auto;
        try {
            this.startTime = formatTime.parse(startTime).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            this.endTime = formatTime.parse(endTime).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        bestTime = Duration.between(this.startTime, this.endTime);
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
    public int compareTo(Racers racer) {

        if (this.getBestTime().toMillis() == racer.getBestTime().toMillis())
            return 0;
        else {
            if (this.getBestTime().toMillis() < racer.getBestTime().toMillis())
                return -1;
            else
                return 1;
        }
    }

}

