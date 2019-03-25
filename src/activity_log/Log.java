package activity_log;

import java.util.Objects;

public class Log {
    private String message;
    public Log(String message) {
        this.message = message;
    }

    String getLog() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Log)) return false;
        Log log = (Log) o;
        return Objects.equals(message, log.message);
    }
}
