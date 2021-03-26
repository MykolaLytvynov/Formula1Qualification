package ua.com.foxminded.formula1qualification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public List read(String pathFile) throws IOException {

        cheakFile(pathFile);

        List<String> file = Files.lines(Paths.get(pathFile)).collect(Collectors.toList());
        return file;
    }

    private void cheakFile(String pathFile) throws FileNotFoundException {
        File file = new File(pathFile);

        if (!file.exists()) {
            throw new FileNotFoundException("File " + pathFile + ": not found");
        }

        if (!file.canRead()) {
            throw new FileNotFoundException ("File " + pathFile +": cannot be read");
        }

        if (file.length() == 0) {
            throw new NullPointerException("File " + pathFile + ": is Empty");
        }



    }

}
