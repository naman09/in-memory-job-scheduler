package JobScheduler;

import java.time.*;

public class RecurrentJob extends Job {
    public Duration recurAfterDuration;
    LocalTime lastRunTime;
    RecurrentJob(Runnable task, Duration recurAfterDuration) {
        super(task);
        this.recurAfterDuration = recurAfterDuration;
        this.lastRunTime = LocalTime.MIN;
    }

    Boolean isReady() {
        return LocalTime.now().isAfter(lastRunTime.plus(recurAfterDuration));
    }
    
    @Override
    public void execute() {
        this.lastRunTime = LocalTime.now();
        super.execute();
    }
}
