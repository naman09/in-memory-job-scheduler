package JobScheduler;
import java.util.ArrayList;
import java.util.List;

public class RealTimeScheduler implements IScheduler {
    List<RecurrentJob> recurrentJobs;
    List<NonRecurrentJob> nonRecurrentJobs;

    RealTimeScheduler() {
        recurrentJobs = new ArrayList<>();
        nonRecurrentJobs = new ArrayList<>();
    }

    void addJob(RecurrentJob recurrentJob) {
        this.recurrentJobs.add(recurrentJob);
    }

    void addJob(NonRecurrentJob nonRecurrentJob) {
        this.nonRecurrentJobs.add(nonRecurrentJob);
    }

    public void run() throws Exception {
        List<Thread> jobThreads = new ArrayList<>();
        for(int i = 0; i < nonRecurrentJobs.size(); i++) {
            NonRecurrentJob job = nonRecurrentJobs.get(i);
            Thread t = new Thread(job::execute);
            jobThreads.add(t);
            t.start();
        }

        for(int i = 0; i < recurrentJobs.size(); i++) {
            RecurrentJob job = recurrentJobs.get(i);
            Thread t = new Thread(() -> {
                while(true) {
                    try {
                        job.execute();
                        Thread.sleep(job.recurAfterDuration);                    
                    } catch (Exception e) {}
                }
            });
            t.start();
        }

        for(int i=0; i < jobThreads.size(); i++) {
            jobThreads.get(i).join();
        }
    }
}
