package ua.com.foxminded.formula1qualification;

import java.util.Collections;
import java.util.List;

import static ua.com.foxminded.formula1qualification.Constants.*;

public class ResultOfFirstStageFormatter {
    private List<Racer> listRacer;

    public String getResultOfFirstStage(List<Racer> listRacers) {

        cheakForEmptyCollection(listRacers);

        listRacer = listRacers;
        Collections.sort(listRacers);

        String resultOfFirstStage = "";
        int racerPosition = 1;
        int numberOfDashesForTheWholeLine = 0;

        for (Racer racers : listRacers) {
            resultOfFirstStage += racerPosition + ". " + racers.getName() + getNumberOfSpacesForName(racers.getName(), racerPosition) + " | " + racers.getAuto() + getNumberOfSpacesForAuto(racers.getAuto()) + " | " + TIME_FORMAT.format(racers.getBestTime().toMillis()) + "\n";
            if (racerPosition == 1) {
                numberOfDashesForTheWholeLine = resultOfFirstStage.length() - 1;
            }
            if (racerPosition == 15) {
                resultOfFirstStage += DASH_CHARACTER.repeat(numberOfDashesForTheWholeLine) + "\n";
            }
            racerPosition++;
        }

        return resultOfFirstStage.trim();
    }


    private String getNumberOfSpacesForName(String name, int racerPosition) {

        int maxLengthStringName = listRacer.stream()
                .map(racer -> racer.getName())
                .mapToInt(String::length)
                .max()
                .getAsInt();
        return SPACE.repeat(maxLengthStringName - name.length() - String.valueOf(racerPosition).length() + 1);
    }

    private String getNumberOfSpacesForAuto(String auto) {

        int maxLengthStringAuto = listRacer.stream()
                .map(racer -> racer.getAuto())
                .mapToInt(String::length)
                .max()
                .getAsInt();
        return SPACE.repeat(maxLengthStringAuto - auto.length());
    }

    private void cheakForEmptyCollection(List<Racer> listRacers) {
        if (listRacers.size() == 0) {
            throw new NullPointerException("Riders collection is empty");
        }
    }

}
