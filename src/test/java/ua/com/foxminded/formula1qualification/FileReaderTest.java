package ua.com.foxminded.formula1qualification;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {
    FileReader objectForTest = new FileReader();


    @Test
    @DisplayName("Non-existent file")
    void readShouldReturnExeptionWhenFileWithStartTimeDoesNotExist() {
        assertThrows(FileNotFoundException.class, () -> objectForTest.read("Non-existent-file-with-Start-Time.log"));
    }

    @Test
    @DisplayName("File is Empty")
    void readShouldReturnExeptionWhenFileWithStartTimeIsEmpty() throws IOException {
        File file = new File("src/main/resources/example.txt");
        file.createNewFile();
        assertThrows(IllegalArgumentException.class, () -> objectForTest.read(file.getPath()));
        file.delete();
    }

    @Test
    @DisplayName("File with one line")
    void readShouldReturnCollectionOfOneItemWhenFileWithOneline() throws IOException {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("example");

        File file = new File("src/main/resources/example.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("example");
        fileWriter.close();
        List<String> resultList = objectForTest.read(file.getPath());

        assertEquals(expectedList, resultList);
        file.delete();
    }

    @Test
    @DisplayName("File with multiple lines")
    void readShouldReturnCollectionOfMultipleItemsWhenFileWithMultipleLines() throws IOException {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("line1");
        expectedList.add("line2");

        File file = new File("src/main/resources/example.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("line1\n" + "line2");
        fileWriter.close();
        List<String> resultList = objectForTest.read(file.getPath());

        assertEquals(expectedList, resultList);
        file.delete();
    }

    @Test
    @DisplayName("File with only symbols in one line")
    void readShouldReturnCollectionOfSymbolsWhenFileWithOnlySymbolsInOneLine() throws IOException {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("#$%^");

        File file = new File("src/main/resources/example.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("#$%^");
        fileWriter.close();
        List<String> resultList = objectForTest.read(file.getPath());

        assertEquals(expectedList, resultList);
        file.delete();
    }

    @Test
    @DisplayName("File with only symbols in multiple lines")
    void readShouldReturnCollectionOfSymbolsWhenFileWithOnlySymbolsInMultipleLines() throws IOException {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("@#$");
        expectedList.add("#$%^");

        File file = new File("src/main/resources/example.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("@#$\n" + "#$%^");
        fileWriter.close();
        List<String> resultList = objectForTest.read(file.getPath());

        assertEquals(expectedList, resultList);
        file.delete();
    }

    @Test
    @DisplayName("File with only numbers in one line")
    void readShouldReturnCollectionOfNumbersWhenFileWithOnlyNumbersInOneLine() throws IOException {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("1234");

        File file = new File("src/main/resources/example.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("1234");
        fileWriter.close();
        List<String> resultList = objectForTest.read(file.getPath());

        assertEquals(expectedList, resultList);
        file.delete();
    }

    @Test
    @DisplayName("File with only numbers in multiple line")
    void readShouldReturnCollectionOfNumbersWhenFileWithOnlyNumbersInMultipleLine() throws IOException {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("54");
        expectedList.add("123");
        expectedList.add("1231");


        File file = new File("src/main/resources/example.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("54\n" + "123\n" + "1231");
        fileWriter.close();
        List<String> resultList = objectForTest.read(file.getPath());

        assertEquals(expectedList, resultList);
        file.delete();
    }

}