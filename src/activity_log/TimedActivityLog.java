package activity_log;

import java.util.*;

class TimedActivityLog implements Logger {
    private ArrayList<String> logs = new ArrayList<>();

    @Override
    public void addLog(Log message) {
        String log = new Date().toString() + message;
        this.logs.add(log);
    }

    @Override
    public ArrayList logAll() {
        return new ArrayList<>(this.logs);
    }
}
