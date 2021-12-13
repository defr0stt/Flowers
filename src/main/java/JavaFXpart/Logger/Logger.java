package JavaFXpart.Logger;

import java.time.LocalDateTime;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class Logger
{
    public static java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Logger.class.getName());

    public static class MyFormatter extends Formatter {

        @Override
        public String format(LogRecord record)
        {
            LocalDateTime localDateTime = LocalDateTime.now();
            String time = localDateTime.getDayOfMonth() + "-" + localDateTime.getMonthValue() + "-" + localDateTime.getYear() +
                    " " + localDateTime.getHour() + ":" + localDateTime.getMinute() + ":" + localDateTime.getSecond();
            return time + " -- " + record.getLevel() + " : " + record.getMessage() + "\n";
        }
    }
}
