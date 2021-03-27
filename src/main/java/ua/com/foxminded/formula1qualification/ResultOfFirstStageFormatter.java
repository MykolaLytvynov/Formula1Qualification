package ua.com.foxminded.formula1qualification;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import static ua.com.foxminded.formula1qualification.Constants.TIME_FORMAT;

public class ResultOfFirstStageFormatter {

    public String getResultOfFirstStage(List<Racers> listRacers) {

        Collections.sort(listRacers);
        String resultOfFirstStage = "";

        for (Racers racers : listRacers) {
            resultOfFirstStage += racers.getName() + " | " + racers.getAuto() + " | " + TIME_FORMAT.format(racers.getBestTime().toMillis()) + "\n";
        }

        return resultOfFirstStage;
    }
}
