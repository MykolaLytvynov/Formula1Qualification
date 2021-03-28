package ua.com.foxminded.formula1qualification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ua.com.foxminded.formula1qualification.Constants.DATE_AND_TIME_FORMAT;

class ResultOfFirstStageFormatterTest {

    ResultOfFirstStageFormatter startValuesForGetResultOfFirstStageTest;

    @BeforeEach
    void newObjectForGetResultOfFirstStageTest() {
        startValuesForGetResultOfFirstStageTest = new ResultOfFirstStageFormatter();
    }

    @Test
    @DisplayName("19 riders unsorted")
    void getResultOfFirstStageShouldReturnStringWithRidersSortedWhenRidersUnsorted() {

        List<Racer> racerListForExample = new ArrayList<Racer>();

        Racer svf = new Racer("SVF", "Sebastian Vettel", "FERRARI", LocalDateTime.parse("2018-05-24_12:02:58.917", DATE_AND_TIME_FORMAT), LocalDateTime.parse("2018-05-24_12:04:03.332", DATE_AND_TIME_FORMAT), Duration.parse("PT1M4.415S"));
        Racer nhr = new Racer("NHR", "Nico Hulkenberg", "RENAULT", LocalDateTime.parse("2018-05-24_12:02:49.914", DATE_AND_TIME_FORMAT), LocalDateTime.parse("2018-05-24_12:04:02.979", DATE_AND_TIME_FORMAT), Duration.parse("PT1M13.065S"));
        Racer drr = new Racer("DRR", "Daniel Ricciardo", "RED BULL RACING TAG HEUER", LocalDateTime.parse("2018-05-24_12:14:12.054", DATE_AND_TIME_FORMAT), LocalDateTime.parse("2018-05-24_12:15:24.067", DATE_AND_TIME_FORMAT), Duration.parse("PT1M12.013S"));
        Racer vbm = new Racer("VBM", "Valtteri Bottas", "MERCEDES", LocalDateTime.parse("2018-05-24_12:00:00.000", DATE_AND_TIME_FORMAT), LocalDateTime.parse("2018-05-24_12:01:12.434", DATE_AND_TIME_FORMAT), Duration.parse("PT1M12.434S"));
        Racer lhm = new Racer("LHM", "Lewis Hamilton", "MERCEDES", LocalDateTime.parse("2018-05-24_12:18:20.125", DATE_AND_TIME_FORMAT), LocalDateTime.parse("2018-05-24_12:19:32.585", DATE_AND_TIME_FORMAT), Duration.parse("PT1M12.46S"));
        Racer svm = new Racer("SVM", "Stoffel Vandoorne", "MCLAREN RENAULT", LocalDateTime.parse("2018-05-24_12:18:37.735", DATE_AND_TIME_FORMAT), LocalDateTime.parse("2018-05-24_12:19:50.198", DATE_AND_TIME_FORMAT), Duration.parse("PT1M12.463S"));
        Racer krf = new Racer("KRF", "Kimi Raikkonen", "FERRARI", LocalDateTime.parse("2018-05-24_12:03:01.250", DATE_AND_TIME_FORMAT), LocalDateTime.parse("2018-05-24_12:04:13.889", DATE_AND_TIME_FORMAT), Duration.parse("PT1M12.639S"));
        Racer fam = new Racer("FAM", "Fernando Alonso_MCLAREN", "MCLAREN RENAULT", LocalDateTime.parse("2018-05-24_12:13:04.512", DATE_AND_TIME_FORMAT), LocalDateTime.parse("2018-05-24_12:14:17.169", DATE_AND_TIME_FORMAT), Duration.parse("PT1M12.657S"));
        Racer ssw = new Racer("SSW", "Sergey Sirotkin", "WILLIAMS MERCEDES", LocalDateTime.parse("2018-05-24_12:16:11.648", DATE_AND_TIME_FORMAT), LocalDateTime.parse("2018-05-24_12:17:24.354", DATE_AND_TIME_FORMAT), Duration.parse("PT1M12.706S"));
        Racer cls = new Racer("CLS", "Charles Leclerc", "SAUBER FERRARI", LocalDateTime.parse("2018-05-24_12:09:41.921", DATE_AND_TIME_FORMAT), LocalDateTime.parse("2018-05-24_12:10:54.750", DATE_AND_TIME_FORMAT), Duration.parse("PT1M12.829S"));
        Racer spf = new Racer("SPF", "Sergio Perez", "FORCE INDIA MERCEDES", LocalDateTime.parse("2018-05-24_12:12:01.035", DATE_AND_TIME_FORMAT), LocalDateTime.parse("2018-05-24_12:13:13.883", DATE_AND_TIME_FORMAT), Duration.parse("PT1M12.848S"));
        Racer rgh = new Racer("RGH", "Romain Grosjean", "HAAS FERRARI", LocalDateTime.parse("2018-05-24_12:05:14.511", DATE_AND_TIME_FORMAT), LocalDateTime.parse("2018-05-24_12:06:27.441", DATE_AND_TIME_FORMAT), Duration.parse("PT1M12.93S"));
        Racer pgs = new Racer("PGS", "Pierre Gasly", "SCUDERIA TORO ROSSO HONDA", LocalDateTime.parse("2018-05-24_12:07:23.645", DATE_AND_TIME_FORMAT), LocalDateTime.parse("2018-05-24_12:08:36.586", DATE_AND_TIME_FORMAT), Duration.parse("PT1M12.941S"));
        Racer csr = new Racer("CSR", "Carlos Sainz", "RENAULT", LocalDateTime.parse("2018-05-24_12:03:15.145", DATE_AND_TIME_FORMAT), LocalDateTime.parse("2018-05-24_12:04:28.095", DATE_AND_TIME_FORMAT), Duration.parse("PT1M12.95S"));
        Racer eof = new Racer("EOF", "Esteban Ocon", "FORCE INDIA MERCEDES", LocalDateTime.parse("2018-05-24_12:17:58.810", DATE_AND_TIME_FORMAT), LocalDateTime.parse("2018-05-24_12:19:11.838", DATE_AND_TIME_FORMAT), Duration.parse("PT1M13.028S"));
        Racer bhs = new Racer("BHS", "Brendon Hartley", "SCUDERIA TORO ROSSO HONDA", LocalDateTime.parse("2018-05-24_12:14:51.985", DATE_AND_TIME_FORMAT), LocalDateTime.parse("2018-05-24_12:16:05.164", DATE_AND_TIME_FORMAT), Duration.parse("PT1M13.179S"));
        Racer mes = new Racer("MES", "Marcus Ericsson", "SAUBER FERRARI", LocalDateTime.parse("2018-05-24_12:04:45.513", DATE_AND_TIME_FORMAT), LocalDateTime.parse("2018-05-24_12:05:58.778", DATE_AND_TIME_FORMAT), Duration.parse("PT1M13.265S"));
        Racer lsw = new Racer("LSW", "Lance Stroll", "WILLIAMS MERCEDES", LocalDateTime.parse("2018-05-24_12:06:13.511", DATE_AND_TIME_FORMAT), LocalDateTime.parse("2018-05-24_12:07:26.834", DATE_AND_TIME_FORMAT), Duration.parse("PT1M13.323S"));
        Racer kmh = new Racer("KMH", "Kevin Magnussen", "HAAS FERRARI", LocalDateTime.parse("2018-05-24_12:02:51.003", DATE_AND_TIME_FORMAT), LocalDateTime.parse("2018-05-24_12:04:04.396", DATE_AND_TIME_FORMAT), Duration.parse("PT1M13.393S"));

        racerListForExample.add(svf);
        racerListForExample.add(nhr);
        racerListForExample.add(drr);
        racerListForExample.add(vbm);
        racerListForExample.add(lhm);
        racerListForExample.add(svm);
        racerListForExample.add(krf);
        racerListForExample.add(fam);
        racerListForExample.add(ssw);
        racerListForExample.add(cls);
        racerListForExample.add(spf);
        racerListForExample.add(rgh);
        racerListForExample.add(pgs);
        racerListForExample.add(csr);
        racerListForExample.add(eof);
        racerListForExample.add(bhs);
        racerListForExample.add(mes);
        racerListForExample.add(lsw);
        racerListForExample.add(kmh);

        assertEquals("1. Sebastian Vettel        | FERRARI                   | 01:04.415\n" +
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
                "19. Kevin Magnussen        | HAAS FERRARI              | 01:13.393", startValuesForGetResultOfFirstStageTest.getResultOfFirstStage(racerListForExample));
    }

    @Test
    @DisplayName("Riders collection is empty")
    void getResultOfFirstStageShouldReturnExeptionWhenRidersCollectionIsEmpty() {

        List<Racer> racerListForExample = new ArrayList<Racer>();

        assertThrows(NullPointerException.class, () -> startValuesForGetResultOfFirstStageTest.getResultOfFirstStage(racerListForExample));
    }
}