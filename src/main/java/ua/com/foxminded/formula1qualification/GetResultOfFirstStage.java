package ua.com.foxminded.formula1qualification;

import java.text.SimpleDateFormat;
import java.util.List;

public class GetResultOfFirstStage {
    private SimpleDateFormat formatTime = new SimpleDateFormat("mm:ss.SSS");


    public String getResultOfFirstStage (List<Racers> listRacers) {

        String resultOfFirstStage = "";

        for (Racers racers : listRacers) {
            resultOfFirstStage += racers.getName() + " | " + racers.getAuto() + " | " + formatTime.format(racers.getBestTime().toMillis()) + "\n";
        }

        return resultOfFirstStage;
    }
}
