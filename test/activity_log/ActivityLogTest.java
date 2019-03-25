package activity_log;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ActivityLogTest {
    @Test
    void shouldLogAllTheLogsInTheActivityLog() {
        ActivityLog activityLog = new ActivityLog();
        String text1 = "The game Started.";
        String text2 = "The Player turn changed";
        activityLog.addLog(text1);
        activityLog.addLog(text2);
        ArrayList actual = activityLog.logAll();
        ArrayList<String> expected = new ArrayList<>();
        expected.add(text1);
        expected.add(text2);
        assertEquals(expected, actual);
    }
}