package activity_log;

import java.util.ArrayList;
import java.util.List;

class ActivityLog implements Logger {
    private List<String> logs = new ArrayList<>();
    public void addLog(String text) {
        logs.add(text);
    }


    @Override
    public ArrayList logAll() {
        return new ArrayList<>(logs);
    }
}
