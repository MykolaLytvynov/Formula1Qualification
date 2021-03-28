package ua.com.foxminded.formula1qualification;

import org.junit.jupiter.api.BeforeEach;
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
    FileReader startValuesForRead;

    @BeforeEach
    void newObjectForReadTest() {
        startValuesForRead = new FileReader();
    }

    @Test
    @DisplayName("Non-existent file")
    void readShouldReturnExeptionWhenFileWithStartTimeDoesNotExist() {
        assertThrows(FileNotFoundException.class, () -> startValuesForRead.read("Non-existent-file-with-Start-Time.log"));
    }

    @Test
    @DisplayName("File is Empty")
    void readShouldReturnExeptionWhenFileWithStartTimeIsEmpty() throws IOException {
        File file = new File("src/main/resources/example.txt");
        file.createNewFile();
        assertThrows(NullPointerException.class, () -> startValuesForRead.read(file.getPath()));
        file.delete();
    }

    @Test
    @DisplayName("File with one line")
    void readShouldReturnCollectionOfOneItemWhenFileWithOneline() throws IOException {
        File file = new File("src/main/resources/example.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("example");
        fileWriter.close();
        List<String> listForExample = new ArrayList<>();
        listForExample.add("example");
        assertEquals(listForExample, startValuesForRead.read(file.getPath()));
        file.delete();
    }

    @Test
    @DisplayName("File with multiple lines")
    void readShouldReturnCollectionOfMultipleItemsWhenFileWithMultipleLines() throws IOException {
        File file = new File("src/main/resources/example.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("line1\n" + "line2");
        fileWriter.close();
        List<String> listForExample = new ArrayList<>();
        listForExample.add("line1");
        listForExample.add("line2");
        assertEquals(listForExample, startValuesForRead.read(file.getPath()));
        file.delete();
    }

    @Test
    @DisplayName("File with only symbols in one line")
    void readShouldReturnCollectionOfSymbolsWhenFileWithOnlySymbolsInOneLine() throws IOException {
        File file = new File("src/main/resources/example.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("#$%^");
        fileWriter.close();
        List<String> listForExample = new ArrayList<>();
        listForExample.add("#$%^");
        assertEquals(listForExample, startValuesForRead.read(file.getPath()));
        file.delete();
    }

    @Test
    @DisplayName("File with only symbols in multiple lines")
    void readShouldReturnCollectionOfSymbolsWhenFileWithOnlySymbolsInMultipleLines() throws IOException {
        File file = new File("src/main/resources/example.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("@#$\n" + "#$%^");
        fileWriter.close();
        List<String> listForExample = new ArrayList<>();
        listForExample.add("@#$");
        listForExample.add("#$%^");
        assertEquals(listForExample, startValuesForRead.read(file.getPath()));
        file.delete();
    }

    @Test
    @DisplayName("File with only numbers in one line")
    void readShouldReturnCollectionOfNumbersWhenFileWithOnlyNumbersInOneLine() throws IOException {
        File file = new File("src/main/resources/example.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("1234");
        fileWriter.close();
        List<String> listForExample = new ArrayList<>();
        listForExample.add("1234");
        assertEquals(listForExample, startValuesForRead.read(file.getPath()));
        file.delete();
    }

    @Test
    @DisplayName("File with only numbers in multiple line")
    void readShouldReturnCollectionOfNumbersWhenFileWithOnlyNumbersInMultipleLine() throws IOException {
        File file = new File("src/main/resources/example.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("54\n" + "123\n" + "1231");
        fileWriter.close();
        List<String> listForExample = new ArrayList<>();
        listForExample.add("54");
        listForExample.add("123");
        listForExample.add("1231");
        assertEquals(listForExample, startValuesForRead.read(file.getPath()));
        file.delete();
    }

}