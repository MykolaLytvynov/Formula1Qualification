package ua.com.foxminded.formula1qualification;


import java.io.IOException;
import java.util.List;

public class Q1Stage {


    public String getResultQ1Stage(String pathToStartFile, String pathToEndFile, String pathToAbbreviationsFile) throws IOException {
        FileReader file = new FileReader();

        List<String> startFileStream = file.read(pathToStartFile);
        List<String> endFileStream = file.read(pathToEndFile);
        List<String> abbreviationsFileStream = file.read(pathToAbbreviationsFile);

        RacerBuilder racerBuilder = new RacerBuilder();
        List<Racer> racersList = racerBuilder.createRacers(startFileStream, endFileStream, abbreviationsFileStream);

        ResultOfFirstStageFormatter getResultOfFirstStage = new ResultOfFirstStageFormatter();
        String resultOfFirstStage = getResultOfFirstStage.getResultOfFirstStage(racersList);


        return resultOfFirstStage;
    }

}

