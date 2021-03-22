package ua.com.foxminded.formula1qualification;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;


class Q1StageTest {
    Q1Stage startValuesForCharCounterTest;

    @BeforeEach
    void newObjectForCharCounterTest() {
        startValuesForCharCounterTest = new Q1Stage();
    }

    @Test
    @DisplayName("example")
    void getResultQ1Stage() throws IOException {
        assertEquals("", startValuesForCharCounterTest.getResultQ1Stage("start.log", "end.log", "abbreviations.txt"));
    }


}