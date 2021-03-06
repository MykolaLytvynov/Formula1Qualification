package ua.com.foxminded.formula1qualification;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ua.com.foxminded.formula1qualification.Constants.DATE_AND_TIME_FORMAT;

class RacerBuilderTest {

    RacerBuilder objectForTest = new RacerBuilder();

    @Test
    @DisplayName("All valid lines in all 3 files")
    void createRacersShouldReturnCollectionRacersWhenAllValidLinesInAll3Files() {
        LocalDateTime startTimeOfSvf = LocalDateTime.parse("2018-05-24_12:02:58.917", DATE_AND_TIME_FORMAT);
        LocalDateTime endTimeOfSvf = LocalDateTime.parse("2018-05-24_12:04:03.332", DATE_AND_TIME_FORMAT);
        LocalDateTime startTimeOfNhr = LocalDateTime.parse("2018-05-24_12:02:49.914", DATE_AND_TIME_FORMAT);
        LocalDateTime endTimeOfNhr = LocalDateTime.parse("2018-05-24_12:04:02.979", DATE_AND_TIME_FORMAT);

        List<Racer> expectedList = new ArrayList<Racer>();
        Racer svf = new Racer("SVF", "Sebastian Vettel", "FERRARI", startTimeOfSvf, endTimeOfSvf, Duration.parse("PT1M4.415S"));
        Racer nhr = new Racer("NHR", "Nico Hulkenberg", "RENAULT", startTimeOfNhr, endTimeOfNhr, Duration.parse("PT1M13.065S"));
        expectedList.add(svf);
        expectedList.add(nhr);

        List<String> startFileListForExample = new ArrayList<>();
        startFileListForExample.add("SVF2018-05-24_12:02:58.917");
        startFileListForExample.add("NHR2018-05-24_12:02:49.914");

        List<String> endFileListForExample = new ArrayList<>();
        endFileListForExample.add("SVF2018-05-24_12:04:03.332");
        endFileListForExample.add("NHR2018-05-24_12:04:02.979");

        List<String> abbreviationsFileListForExample = new ArrayList<>();
        abbreviationsFileListForExample.add("SVF_Sebastian Vettel_FERRARI");
        abbreviationsFileListForExample.add("NHR_Nico Hulkenberg_RENAULT");

        List<Racer> resultList = objectForTest.createRacers(startFileListForExample, endFileListForExample, abbreviationsFileListForExample);

        assertEquals(true, expectedList.equals(resultList));
    }

    @Test
    @DisplayName("Collection with start-time has a different format")
    void createRacersShouldReturnExeptionWhenCollectionWithStartTimeHasDifferentFormat() {

        List<String> startFileListForExample = new ArrayList<>();
        startFileListForExample.add("SVF_12:02:58.917");
        startFileListForExample.add("NHR2018-05-24_12:02:49.914");

        List<String> endFileListForExample = new ArrayList<>();
        endFileListForExample.add("SVF2018-05-24_12:04:03.332");
        endFileListForExample.add("NHR2018-05-24_12:04:02.979");

        List<String> abbreviationsFileListForExample = new ArrayList<>();
        abbreviationsFileListForExample.add("SVF_Sebastian Vettel_FERRARI");
        abbreviationsFileListForExample.add("NHR_Nico Hulkenberg_RENAULT");

        assertThrows(IllegalArgumentException.class, () -> objectForTest.createRacers(startFileListForExample, endFileListForExample, abbreviationsFileListForExample));
    }

    @Test
    @DisplayName("Collection with end-time has a different format")
    void createRacersShouldReturnExeptionWhenCollectionWithEndTimeHasDifferentFormat() {

        List<String> startFileListForExample = new ArrayList<>();
        startFileListForExample.add("SVF2018-05-24_12:02:58.917");
        startFileListForExample.add("NHR2018-05-24_12:02:49.914");

        List<String> endFileListForExample = new ArrayList<>();
        endFileListForExample.add("SVF2018-05-24_12:04:03.332");
        endFileListForExample.add("NHR_12:04:02.979");

        List<String> abbreviationsFileListForExample = new ArrayList<>();
        abbreviationsFileListForExample.add("SVF_Sebastian Vettel_FERRARI");
        abbreviationsFileListForExample.add("NHR_Nico Hulkenberg_RENAULT");

        assertThrows(IllegalArgumentException.class, () -> objectForTest.createRacers(startFileListForExample, endFileListForExample, abbreviationsFileListForExample));
    }

    @Test
    @DisplayName("Collection with abbreviations has a different format")
    void createRacersShouldReturnExeptionWhenCollectionWithAbbreviationsHasDifferentFormat() {

        List<String> startFileListForExample = new ArrayList<>();
        startFileListForExample.add("SVF2018-05-24_12:02:58.917");
        startFileListForExample.add("NHR2018-05-24_12:02:49.914");

        List<String> endFileListForExample = new ArrayList<>();
        endFileListForExample.add("SVF2018-05-24_12:04:03.332");
        endFileListForExample.add("NHR2018-05-24_12:04:02.979");

        List<String> abbreviationsFileListForExample = new ArrayList<>();
        abbreviationsFileListForExample.add("SVF_FERRARI");
        abbreviationsFileListForExample.add("NHR_Nico Hulkenberg_RENAULT");

        assertThrows(IllegalArgumentException.class, () -> objectForTest.createRacers(startFileListForExample, endFileListForExample, abbreviationsFileListForExample));
    }

    @Test
    @DisplayName("Impossible time in Collection with Start-Time")
    void createRacersShouldReturnExeptionWhenCollectionWithImpossibleTimeInCollectionWithStartTime() {

        List<String> startFileListForExample = new ArrayList<>();
        startFileListForExample.add("SVF2018-05-24_88:88:88.888");
        startFileListForExample.add("NHR2018-05-24_12:02:49.914");

        List<String> endFileListForExample = new ArrayList<>();
        endFileListForExample.add("SVF2018-05-24_12:04:03.332");
        endFileListForExample.add("NHR2018-05-24_12:04:02.979");

        List<String> abbreviationsFileListForExample = new ArrayList<>();
        abbreviationsFileListForExample.add("SVF_FERRARI");
        abbreviationsFileListForExample.add("NHR_Nico Hulkenberg_RENAULT");

        assertThrows(IllegalArgumentException.class, () -> objectForTest.createRacers(startFileListForExample, endFileListForExample, abbreviationsFileListForExample));
    }

    @Test
    @DisplayName("Impossible time in Collection with End-Time")
    void createRacersShouldReturnExeptionWhenCollectionWithImpossibleTimeInCollectionWithEndTime() {

        List<String> startFileListForExample = new ArrayList<>();
        startFileListForExample.add("SVF2018-05-24_12:02:58.917");
        startFileListForExample.add("NHR2018-05-24_12:02:49.914");

        List<String> endFileListForExample = new ArrayList<>();
        endFileListForExample.add("SVF2018-05-24_88:88:88.888");
        endFileListForExample.add("NHR2018-05-24_12:04:02.979");

        List<String> abbreviationsFileListForExample = new ArrayList<>();
        abbreviationsFileListForExample.add("SVF_FERRARI");
        abbreviationsFileListForExample.add("NHR_Nico Hulkenberg_RENAULT");

        assertThrows(IllegalArgumentException.class, () -> objectForTest.createRacers(startFileListForExample, endFileListForExample, abbreviationsFileListForExample));
    }

    @Test
    @DisplayName("Collection abbreviations does not start with abbreviation")
    void createRacersShouldReturnExeptionWhenCollectionWithCollectionAbbreviationsDoesNotStartWithAbbreviation() {

        List<String> startFileListForExample = new ArrayList<>();
        startFileListForExample.add("SVF2018-05-24_12:02:58.917");
        startFileListForExample.add("NHR2018-05-24_12:02:49.914");

        List<String> endFileListForExample = new ArrayList<>();
        endFileListForExample.add("SVF2018-05-24_12:04:03.332");
        endFileListForExample.add("NHR2018-05-24_12:04:02.979");

        List<String> abbreviationsFileListForExample = new ArrayList<>();
        abbreviationsFileListForExample.add("SVF_Sebastian Vettel_FERRARI");
        abbreviationsFileListForExample.add("RENAULT_Nico Hulkenberg_NHR");

        assertThrows(IllegalArgumentException.class, () -> objectForTest.createRacers(startFileListForExample, endFileListForExample, abbreviationsFileListForExample));
    }

}