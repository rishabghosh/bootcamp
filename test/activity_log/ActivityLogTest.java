package activity_log;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ActivityLogTest {
    @Test
    void shouldLogAllTheLogsInTheActivityLog() {
        ActivityLog activityLog = new ActivityLog();
        String text1 = "The game Started.";
        String text2 = "The Player turn changed";
        activityLog.addLog(new Log(text1));
        activityLog.addLog(new Log(text2));
        ArrayList actual = activityLog.logAll();
        ArrayList<String> expected = new ArrayList<>(Arrays.asList(text1, text2));
        assertEquals(expected, actual);
    }
}