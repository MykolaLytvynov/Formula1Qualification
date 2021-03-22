package ua.com.foxminded.formula1qualification;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFiles {

    public Stream readFilesWithTimes(String pathFile) throws IOException {

        List<CharSequence> listForCheckFormat = Files.lines(Paths.get(pathFile)).collect(Collectors.toList());
        checkTimeValidate(listForCheckFormat);

        Stream<String> file = Files.lines(Paths.get(pathFile));
        return file;
    }


    public Stream readFilesWithAbbreviations(String pathFile) throws IOException {

        List<String> listForCheckFormat = Files.lines(Paths.get(pathFile)).collect(Collectors.toList());
        checkAbbreviationsValidate(listForCheckFormat);

        Stream<String> file = Files.lines(Paths.get(pathFile));
        return file;
    }

    private void checkTimeValidate(List<CharSequence> listForCheckFormat) {

        Pattern format = Pattern.compile("^[A-Z]{3}[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}[_]{1}[0-9]{2}[:]{1}[0-9]{2}[:]{1}[0-9]{2}[.]{1}[0-9]{3}$");

        for (CharSequence line : listForCheckFormat) {
            Matcher m = format.matcher(line);
            if (!m.matches()) {
                throw new IllegalArgumentException("Format Times : does not match");
            }
        }

    }

    private void checkAbbreviationsValidate(List<String> listForCheckFormat) {

        for (String line : listForCheckFormat) {
            String[] arrayForCheck = line.split("_");
            if (arrayForCheck.length != 3) {
                throw new IllegalArgumentException("Format Abbreviations : does not match");
            }
        }
    }

}
