package ua.com.foxminded.formula1qualification;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Constants {

    public static final DateTimeFormatter DATE_AND_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
    public static final String LINE_SPLIT_FOR_FILES_WITH_TIME = "(?<=[A-Z])(?=\\d)";
    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("mm:ss.SSS");
    public static final String START_OR_END_TIME_PATTERN = "^[A-Z]{3}[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}[_]{1}[0-9]{2}[:]{1}[0-9]{2}[:]{1}[0-9]{2}[.]{1}[0-9]{3}$";
    public static final String SPACE = " ";
    public static final String DASH_CHARACTER = "-";
}
