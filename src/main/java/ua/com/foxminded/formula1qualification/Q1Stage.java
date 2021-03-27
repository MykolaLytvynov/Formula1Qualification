package ua.com.foxminded.formula1qualification;


import java.io.IOException;
import java.util.List;

public class Q1Stage {

    FileReader file = new FileReader();


    public String getResultQ1Stage(String pathToStartFile, String pathToEndFile, String pathToAbbreviationsFile) throws IOException {

        List<String> startFileStream = file.read(pathToStartFile);
        List<String> endFileStream = file.read(pathToEndFile);
        List<String> abbreviationsFileStream = file.read(pathToAbbreviationsFile);

        RacerBuilder racerBuilder = new RacerBuilder();
        List<Racers> racersList = racerBuilder.createRacers(startFileStream, endFileStream, abbreviationsFileStream);

        ResultOfFirstStageFormatter getResultOfFirstStage = new ResultOfFirstStageFormatter();
        String resultOfFirstStage = getResultOfFirstStage.getResultOfFirstStage(racersList);


        return resultOfFirstStage;
    }

}

