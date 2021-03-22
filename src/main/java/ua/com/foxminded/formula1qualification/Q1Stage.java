package ua.com.foxminded.formula1qualification;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q1Stage {
    private static final Map<String, String> START_TIME_BEST_LAP = new HashMap<>();
    private static final Map<String, String> END_TIME_BEST_LAP = new HashMap<>();
    private static List<Racers> LIST_RACERS = new ArrayList<>();
    ReadFiles files = new ReadFiles();


    public String getResultQ1Stage(String pathToStartFile, String pathToEndFile, String pathToAbbreviationsFile) throws IOException {

        getMapStartTime(pathToStartFile);
        getMapEndTime(pathToEndFile);

        addRacerToCollection(pathToAbbreviationsFile);
        Collections.sort(LIST_RACERS);

        GetResultOfFirstStage getResultQ1Stage = new GetResultOfFirstStage();
        String resultOfFirstStage = getResultQ1Stage.getResultOfFirstStage(LIST_RACERS);

        return resultOfFirstStage;
    }


    private void getMapStartTime(String pathToStartFile) throws IOException {
        Stream<String> start = files.readFilesWithTimes(pathToStartFile);

        start.map(line -> line.split("(?<=[A-Z])(?=\\d)"))
                .map(symbol -> START_TIME_BEST_LAP.put(symbol[0], symbol[1]))
                .collect(Collectors.joining());
    }


    private void getMapEndTime(String pathToEndFile) throws IOException {
        Stream<String> end = files.readFilesWithTimes(pathToEndFile);

        end.map(line -> line.split("(?<=[A-Z])(?=\\d)"))
                .map(symbol -> END_TIME_BEST_LAP.put(symbol[0], symbol[1]))
                .collect(Collectors.joining());
    }


    private void addRacerToCollection(String pathToAbbreviationsFile) throws IOException {

        Stream<String> abbreviations = files.readFilesWithAbbreviations(pathToAbbreviationsFile);

        LIST_RACERS = abbreviations.map(line -> line.split("_"))
                .map(word -> new Racers(word[0], word[1], word[2], START_TIME_BEST_LAP.get(word[0]), END_TIME_BEST_LAP.get(word[0])))
                .collect(Collectors.toList());
    }

}

