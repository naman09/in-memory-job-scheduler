package JobScheduler;

public class NonRecurrentJob extends Job {
    Boolean done;
    
    NonRecurrentJob(Runnable task) {
        super(task);
        this.done = false;
    }

    Boolean isReady() {
        if (this.done) {
            return false;
        }
        return true;
    }

    @Override
    public void execute() {
        this.done = true;
        super.execute();
    }
}

