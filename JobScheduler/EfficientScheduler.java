package JobScheduler;

import java.util.*;

public class EfficientScheduler implements IScheduler{
    List<Job> jobs;

    EfficientScheduler() {
        jobs = new ArrayList<>();
    }

    void addJob(Job job) {
        jobs.add(job);
    }

    public void run() throws Exception {
        List<Thread> threads = new ArrayList<>();
        while(true) {
            for(int i=0;i<jobs.size(); i++) {
                Job job = jobs.get(i);
                if (job.isReady()) {
                    Thread newThread = new Thread(job::execute);
                    newThread.start();
                    threads.add(newThread);
                }
            }
        }
        
        // for(int i=0;i<threads.size();i++) {
        //     Thread thread = threads.get(i);
        //     thread.join();
        // }   
    }
}
