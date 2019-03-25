package activity_log;

import java.util.ArrayList;

public interface Logger {
    void addLog(String message);
    ArrayList logAll();
}
