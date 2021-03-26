package ua.com.foxminded.formula1qualification;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class Constants {

    public static final SimpleDateFormat DATE_AND_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss.SSS");
    public static final String LINE_SPLIT_FOR_FILES_WITH_TIME = "(?<=[A-Z])(?=\\d)";
    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("mm:ss.SSS");

}
