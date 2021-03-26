package ua.com.foxminded.formula1qualification;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ua.com.foxminded.formula1qualification.Constants.*;

public class RacerBuilder {
    private static final Map<String, LocalDateTime> START_TIME_BEST_LAP = new HashMap<>();
    private static final Map<String, LocalDateTime> END_TIME_BEST_LAP = new HashMap<>();

    public List<Racers> createRacers(List<String> startFileList, List<String> endFileList, List<String> abbreviationsFileList) {

        checkTimeValidate(startFileList);
        checkTimeValidate(endFileList);
        checkAbbreviationsValidate(abbreviationsFileList);

        startFileList.stream().map(line -> line.split(LINE_SPLIT_FOR_FILES_WITH_TIME))
                .forEach(part -> START_TIME_BEST_LAP.put(part[0], getTime(part[1])));

        endFileList.stream().map(line -> line.split(LINE_SPLIT_FOR_FILES_WITH_TIME))
                .forEach(part -> END_TIME_BEST_LAP.put(part[0], getTime(part[1])));

        List<Racers> listRacers = abbreviationsFileList.stream().map(line -> line.split("_"))
                .map(part -> new Racers(part[0], part[1], part[2], START_TIME_BEST_LAP.get(part[0]), END_TIME_BEST_LAP.get(part[0]), getBestTime(part[0])))
                .collect(Collectors.toList());


        return listRacers;
    }

    private LocalDateTime getTime(String time) {

        LocalDateTime dateTime = null;
        try {
            dateTime = DATE_AND_TIME_FORMAT.parse(time).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateTime;
    }


    private void checkTimeValidate(List<String> listForCheckFormat) {

        Pattern format = Pattern.compile("^[A-Z]{3}[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}[_]{1}[0-9]{2}[:]{1}[0-9]{2}[:]{1}[0-9]{2}[.]{1}[0-9]{3}$");

        for (CharSequence line : listForCheckFormat) {
            Matcher m = format.matcher(line);
            if (!m.matches()) {
                throw new IllegalArgumentException("Format Times : does not match");
            }
        }
    }

    private void checkAbbreviationsValidate(List<String> listForCheckFormat) {

        for (String line : listForCheckFormat) {
            String[] arrayForCheck = line.split("_");
            if (arrayForCheck.length != 3) {
                throw new IllegalArgumentException("Format Abbreviations : does not match");
            }
        }
    }

    private Duration getBestTime (String racer) {
        return Duration.between(START_TIME_BEST_LAP.get(racer), END_TIME_BEST_LAP.get(racer));
    }

}