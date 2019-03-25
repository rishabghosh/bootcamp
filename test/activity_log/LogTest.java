package activity_log;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogTest {
    @Test
    void getLog() {
        Log log = new Log("this is a log");
        String actual = log.getLog();
        String expected = "this is a log";

        assertEquals(expected,actual);
    }
}