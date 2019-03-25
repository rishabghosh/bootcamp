package activity_log;

import java.util.ArrayList;
import java.util.List;

class ActivityLog implements Logger {
    private final List<Log> logs = new ArrayList<>();

    @Override
    public void addLog(Log message) {
        this.logs.add(message);
    }

    @Override
    public ArrayList logAll() {
        return new ArrayList<>(this.logs);
    }
}
