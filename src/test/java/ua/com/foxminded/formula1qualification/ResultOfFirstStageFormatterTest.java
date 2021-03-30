package ua.com.foxminded.formula1qualification;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ua.com.foxminded.formula1qualification.Constants.DATE_AND_TIME_FORMAT;

class ResultOfFirstStageFormatterTest {

    ResultOfFirstStageFormatter objectForTest = new ResultOfFirstStageFormatter();
    LocalDateTime startTimeOfSvf = LocalDateTime.parse("2018-05-24_12:02:58.917", DATE_AND_TIME_FORMAT);
    LocalDateTime endTimeOfSvf = LocalDateTime.parse("2018-05-24_12:04:03.332", DATE_AND_TIME_FORMAT);
    LocalDateTime startTimeOfNhr = LocalDateTime.parse("2018-05-24_12:02:49.914", DATE_AND_TIME_FORMAT);
    LocalDateTime endTimeOfNhr = LocalDateTime.parse("2018-05-24_12:04:02.979", DATE_AND_TIME_FORMAT);
    LocalDateTime startTimeOfDrr = LocalDateTime.parse("2018-05-24_12:14:12.054", DATE_AND_TIME_FORMAT);
    LocalDateTime endTimeOfDrr = LocalDateTime.parse("2018-05-24_12:15:24.067", DATE_AND_TIME_FORMAT);
    LocalDateTime startTimeOfVbm = LocalDateTime.parse("2018-05-24_12:00:00.000", DATE_AND_TIME_FORMAT);
    LocalDateTime endTimeOfVbm = LocalDateTime.parse("2018-05-24_12:01:12.434", DATE_AND_TIME_FORMAT);
    LocalDateTime startTimeOfLhm = LocalDateTime.parse("2018-05-24_12:18:20.125", DATE_AND_TIME_FORMAT);
    LocalDateTime endTimeOfLhm = LocalDateTime.parse("2018-05-24_12:19:32.585", DATE_AND_TIME_FORMAT);
    LocalDateTime startTimeOfSvm = LocalDateTime.parse("2018-05-24_12:18:37.735", DATE_AND_TIME_FORMAT);
    LocalDateTime endTimeOfSvm = LocalDateTime.parse("2018-05-24_12:19:50.198", DATE_AND_TIME_FORMAT);
    LocalDateTime startTimeOfKrf = LocalDateTime.parse("2018-05-24_12:03:01.250", DATE_AND_TIME_FORMAT);
    LocalDateTime endTimeOfKrf = LocalDateTime.parse("2018-05-24_12:04:13.889", DATE_AND_TIME_FORMAT);
    LocalDateTime startTimeOfFam = LocalDateTime.parse("2018-05-24_12:13:04.512", DATE_AND_TIME_FORMAT);
    LocalDateTime endTimeOfFam = LocalDateTime.parse("2018-05-24_12:14:17.169", DATE_AND_TIME_FORMAT);
    LocalDateTime startTimeOfSsw = LocalDateTime.parse("2018-05-24_12:16:11.648", DATE_AND_TIME_FORMAT);
    LocalDateTime endTimeOfSsw = LocalDateTime.parse("2018-05-24_12:17:24.354", DATE_AND_TIME_FORMAT);
    LocalDateTime startTimeOfCls = LocalDateTime.parse("2018-05-24_12:09:41.921", DATE_AND_TIME_FORMAT);
    LocalDateTime endTimeOfCls = LocalDateTime.parse("2018-05-24_12:10:54.750", DATE_AND_TIME_FORMAT);
    LocalDateTime startTimeOfSpf = LocalDateTime.parse("2018-05-24_12:12:01.035", DATE_AND_TIME_FORMAT);
    LocalDateTime endTimeOfSpf = LocalDateTime.parse("2018-05-24_12:13:13.883", DATE_AND_TIME_FORMAT);
    LocalDateTime startTimeOfRgh = LocalDateTime.parse("2018-05-24_12:05:14.511", DATE_AND_TIME_FORMAT);
    LocalDateTime endTimeOfRgh = LocalDateTime.parse("2018-05-24_12:06:27.441", DATE_AND_TIME_FORMAT);
    LocalDateTime startTimeOfPgs = LocalDateTime.parse("2018-05-24_12:07:23.645", DATE_AND_TIME_FORMAT);
    LocalDateTime endTimeOfPgs = LocalDateTime.parse("2018-05-24_12:08:36.586", DATE_AND_TIME_FORMAT);
    LocalDateTime startTimeOfCsr = LocalDateTime.parse("2018-05-24_12:03:15.145", DATE_AND_TIME_FORMAT);
    LocalDateTime endTimeOfCsr = LocalDateTime.parse("2018-05-24_12:04:28.095", DATE_AND_TIME_FORMAT);
    LocalDateTime startTimeOfEof = LocalDateTime.parse("2018-05-24_12:17:58.810", DATE_AND_TIME_FORMAT);
    LocalDateTime endTimeOfEof = LocalDateTime.parse("2018-05-24_12:19:11.838", DATE_AND_TIME_FORMAT);
    LocalDateTime startTimeOfBhs = LocalDateTime.parse("2018-05-24_12:14:51.985", DATE_AND_TIME_FORMAT);
    LocalDateTime endTimeOfBhs = LocalDateTime.parse("2018-05-24_12:16:05.164", DATE_AND_TIME_FORMAT);
    LocalDateTime startTimeOfMes = LocalDateTime.parse("2018-05-24_12:04:45.513", DATE_AND_TIME_FORMAT);
    LocalDateTime endTimeOfMes = LocalDateTime.parse("2018-05-24_12:05:58.778", DATE_AND_TIME_FORMAT);
    LocalDateTime startTimeOfLsw = LocalDateTime.parse("2018-05-24_12:06:13.511", DATE_AND_TIME_FORMAT);
    LocalDateTime endTimeOfLsw = LocalDateTime.parse("2018-05-24_12:07:26.834", DATE_AND_TIME_FORMAT);
    LocalDateTime startTimeOfKmh = LocalDateTime.parse("2018-05-24_12:02:51.003", DATE_AND_TIME_FORMAT);
    LocalDateTime endTimeOfKmh = LocalDateTime.parse("2018-05-24_12:04:04.396", DATE_AND_TIME_FORMAT);

    @Test
    @DisplayName("19 riders unsorted")
    void getResultOfFirstStageShouldReturnStringWithRidersSortedWhenRidersUnsorted() {
        String expected = "1. Sebastian Vettel        | FERRARI                   | 01:04.415\n" +
                "2. Daniel Ricciardo        | RED BULL RACING TAG HEUER | 01:12.013\n" +
                "3. Valtteri Bottas         | MERCEDES                  | 01:12.434\n" +
                "4. Lewis Hamilton          | MERCEDES                  | 01:12.460\n" +
                "5. Stoffel Vandoorne       | MCLAREN RENAULT           | 01:12.463\n" +
                "6. Kimi Raikkonen          | FERRARI                   | 01:12.639\n" +
                "7. Fernando Alonso_MCLAREN | MCLAREN RENAULT           | 01:12.657\n" +
                "8. Sergey Sirotkin         | WILLIAMS MERCEDES         | 01:12.706\n" +
                "9. Charles Leclerc         | SAUBER FERRARI            | 01:12.829\n" +
                "10. Sergio Perez           | FORCE INDIA MERCEDES      | 01:12.848\n" +
                "11. Romain Grosjean        | HAAS FERRARI              | 01:12.930\n" +
                "12. Pierre Gasly           | SCUDERIA TORO ROSSO HONDA | 01:12.941\n" +
                "13. Carlos Sainz           | RENAULT                   | 01:12.950\n" +
                "14. Esteban Ocon           | FORCE INDIA MERCEDES      | 01:13.028\n" +
                "15. Nico Hulkenberg        | RENAULT                   | 01:13.065\n" +
                "------------------------------------------------------------------\n" +
                "16. Brendon Hartley        | SCUDERIA TORO ROSSO HONDA | 01:13.179\n" +
                "17. Marcus Ericsson        | SAUBER FERRARI            | 01:13.265\n" +
                "18. Lance Stroll           | WILLIAMS MERCEDES         | 01:13.323\n" +
                "19. Kevin Magnussen        | HAAS FERRARI              | 01:13.393";

        List<Racer> racerList = new ArrayList<Racer>();
        Racer svf = new Racer("SVF", "Sebastian Vettel", "FERRARI", startTimeOfSvf, endTimeOfSvf, Duration.parse("PT1M4.415S"));
        Racer nhr = new Racer("NHR", "Nico Hulkenberg", "RENAULT", startTimeOfNhr, endTimeOfNhr, Duration.parse("PT1M13.065S"));
        Racer drr = new Racer("DRR", "Daniel Ricciardo", "RED BULL RACING TAG HEUER", startTimeOfDrr, endTimeOfDrr, Duration.parse("PT1M12.013S"));
        Racer vbm = new Racer("VBM", "Valtteri Bottas", "MERCEDES", startTimeOfVbm, endTimeOfVbm, Duration.parse("PT1M12.434S"));
        Racer lhm = new Racer("LHM", "Lewis Hamilton", "MERCEDES", startTimeOfLhm, endTimeOfLhm, Duration.parse("PT1M12.46S"));
        Racer svm = new Racer("SVM", "Stoffel Vandoorne", "MCLAREN RENAULT", startTimeOfSvm, endTimeOfSvm, Duration.parse("PT1M12.463S"));
        Racer krf = new Racer("KRF", "Kimi Raikkonen", "FERRARI", startTimeOfKrf, endTimeOfKrf, Duration.parse("PT1M12.639S"));
        Racer fam = new Racer("FAM", "Fernando Alonso_MCLAREN", "MCLAREN RENAULT", startTimeOfFam, endTimeOfFam, Duration.parse("PT1M12.657S"));
        Racer ssw = new Racer("SSW", "Sergey Sirotkin", "WILLIAMS MERCEDES", startTimeOfSsw, endTimeOfSsw, Duration.parse("PT1M12.706S"));
        Racer cls = new Racer("CLS", "Charles Leclerc", "SAUBER FERRARI", startTimeOfCls, endTimeOfCls, Duration.parse("PT1M12.829S"));
        Racer spf = new Racer("SPF", "Sergio Perez", "FORCE INDIA MERCEDES", startTimeOfSpf, endTimeOfSpf, Duration.parse("PT1M12.848S"));
        Racer rgh = new Racer("RGH", "Romain Grosjean", "HAAS FERRARI", startTimeOfRgh, endTimeOfRgh, Duration.parse("PT1M12.93S"));
        Racer pgs = new Racer("PGS", "Pierre Gasly", "SCUDERIA TORO ROSSO HONDA", startTimeOfPgs, endTimeOfPgs, Duration.parse("PT1M12.941S"));
        Racer csr = new Racer("CSR", "Carlos Sainz", "RENAULT", startTimeOfCsr, endTimeOfCsr, Duration.parse("PT1M12.95S"));
        Racer eof = new Racer("EOF", "Esteban Ocon", "FORCE INDIA MERCEDES", startTimeOfEof, endTimeOfEof, Duration.parse("PT1M13.028S"));
        Racer bhs = new Racer("BHS", "Brendon Hartley", "SCUDERIA TORO ROSSO HONDA", startTimeOfBhs, endTimeOfBhs, Duration.parse("PT1M13.179S"));
        Racer mes = new Racer("MES", "Marcus Ericsson", "SAUBER FERRARI", startTimeOfMes, endTimeOfMes, Duration.parse("PT1M13.265S"));
        Racer lsw = new Racer("LSW", "Lance Stroll", "WILLIAMS MERCEDES", startTimeOfLsw, endTimeOfLsw, Duration.parse("PT1M13.323S"));
        Racer kmh = new Racer("KMH", "Kevin Magnussen", "HAAS FERRARI", startTimeOfKmh, endTimeOfKmh, Duration.parse("PT1M13.393S"));

        racerList.add(svf);
        racerList.add(nhr);
        racerList.add(drr);
        racerList.add(vbm);
        racerList.add(lhm);
        racerList.add(svm);
        racerList.add(krf);
        racerList.add(fam);
        racerList.add(ssw);
        racerList.add(cls);
        racerList.add(spf);
        racerList.add(rgh);
        racerList.add(pgs);
        racerList.add(csr);
        racerList.add(eof);
        racerList.add(bhs);
        racerList.add(mes);
        racerList.add(lsw);
        racerList.add(kmh);

        String result = objectForTest.getResultOfFirstStage(racerList);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Riders collection is empty")
    void getResultOfFirstStageShouldReturnExeptionWhenRidersCollectionIsEmpty() {

        List<Racer> racerListForExample = new ArrayList<Racer>();

        assertThrows(IllegalArgumentException.class, () -> objectForTest.getResultOfFirstStage(racerListForExample));
    }
}