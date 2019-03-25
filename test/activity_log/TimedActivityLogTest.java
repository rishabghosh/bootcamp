package activity_log;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TimedActivityLogTest {
    @Test
    void logAllMethodShouldLogAllTheLogsWithTimeStampOfSecondPrecision() {
        TimedActivityLog timedActivityLog = new TimedActivityLog();
        String text1 = "This is some text";
        String text2 = "This is some more text";
        timedActivityLog.addLog(new Log(text1));
        timedActivityLog.addLog(new Log(text2));
        ArrayList actual = timedActivityLog.logAll();
        ArrayList<String> expected = new ArrayList<>(Arrays.asList(text1, text2));
        assertEquals(expected, actual);
    }
}