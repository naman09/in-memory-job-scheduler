package JobScheduler;

import java.util.UUID;

public abstract class Job {

    String jobId;
    Runnable task;

    Job(Runnable task) {
        this.task = task;
        jobId = UUID.randomUUID().toString();
    }

    public void execute() {
        System.out.println("starting job: " + this.jobId);
        this.task.run();
        System.out.println("finished job: " + this.jobId);

    }

    abstract Boolean isReady();
}
