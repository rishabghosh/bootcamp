package activity_log;

import java.util.ArrayList;

public interface Logger {
    void addLog(Log message);
    ArrayList logAll();
}
