package JobScheduler;

import java.time.*;
/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws Exception{
        EfficientScheduler sc = new EfficientScheduler();

        sc.addJob(new RecurrentJob(() -> System.out.println("@"), Duration.ofSeconds(3)));
        sc.addJob(new NonRecurrentJob(()-> {
            try {
                System.out.println("working...");
                Thread.sleep(5000);
                System.out.println("fin...");
            } catch(Exception e) {}
        }));
        sc.addJob(new RecurrentJob(() -> System.out.println("*"), Duration.ofSeconds(7)));
        sc.run();


        RealTimeScheduler realTimeSc = new RealTimeScheduler();
        realTimeSc.addJob(new RecurrentJob(() -> System.out.println("@"), Duration.ofSeconds(3)));
        realTimeSc.addJob(new NonRecurrentJob(()-> {
            try {
                System.out.println("working...");
                Thread.sleep(5000);
                System.out.println("fin...");
            } catch(Exception e) {}
        }));
        realTimeSc.addJob(new RecurrentJob(() -> System.out.println("*"), Duration.ofSeconds(7)));
        realTimeSc.run();
    }
}