package testCucumber.support;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static String getTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyyhhmmss"));
    }
}