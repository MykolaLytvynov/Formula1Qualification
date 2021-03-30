package ua.com.foxminded.formula1qualification;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ua.com.foxminded.formula1qualification.Constants.*;

public class RacerBuilder {
    Map<String, LocalDateTime> startTimeBestLap = new HashMap<>();
    Map<String, LocalDateTime> endTimeBestLap = new HashMap<>();
    private static final int ABBREVIATION = 0;
    private static final int NAME = 1;
    private static final int AUTO = 2;

    public List<Racer> createRacers(List<String> startFileList, List<String> endFileList, List<String> abbreviationsFileList) {

        startFileList.stream().peek(this::checkTimeValidate)
                .map(line -> line.split(LINE_SPLIT_FOR_FILES_WITH_TIME))
                .forEach(part -> startTimeBestLap.put(part[0], getTime(part[1])));

        endFileList.stream().peek(this::checkTimeValidate)
                .map(line -> line.split(LINE_SPLIT_FOR_FILES_WITH_TIME))
                .forEach(part -> endTimeBestLap.put(part[0], getTime(part[1])));

        List<Racer> listRacers = abbreviationsFileList.stream().peek(this::checkAbbreviationsValidate)
                .map(line -> line.split("_"))
                .map(part -> new Racer(part[ABBREVIATION], part[NAME], part[AUTO], startTimeBestLap.get(part[ABBREVIATION]), endTimeBestLap.get(part[ABBREVIATION]), getBestTime(part[ABBREVIATION])))
                .collect(Collectors.toList());

        return listRacers;
    }


    private void checkTimeValidate(String lineForCheck) {


        if (!lineForCheck.matches(START_OR_END_TIME_PATTERN)) {
            throw new IllegalArgumentException("Format Times (" + lineForCheck + "): does not match");
        }
    }

    private void checkAbbreviationsValidate(String lineForCheck) {

        String[] arrayForCheck = lineForCheck.split("_");
        if (arrayForCheck.length != 3) {
            throw new IllegalArgumentException("Format Abbreviations (" + lineForCheck + "): does not match");
        }
        if (arrayForCheck[0].length() != 3) {
            throw new IllegalArgumentException("List of abbreviations must start with abbreviations");
        }
    }

    private LocalDateTime getTime(String time) {
        LocalDateTime dateTime = null;
        try {
            dateTime = LocalDateTime.parse(time, DATE_AND_TIME_FORMAT);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Impossible time");
        }
        return dateTime;
    }

    private Duration getBestTime(String racer) {
        return Duration.between(startTimeBestLap.get(racer), endTimeBestLap.get(racer));
    }

}