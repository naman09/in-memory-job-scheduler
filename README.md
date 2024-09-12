# in-memory-job-scheduler

## 2 type of Jobs:-
1. Recurrent
2. Non-recurrent

## Efficient Scheduler
One thread iterates over all the jobs to find the job which is ready to be executed.

Adv - except 1 thread, all the threads are doing meaningful work

Dis - job might be ready but it will be executed when iterator reaches to that job. 

## Realtime Scheduler
Each job sleeps till it is time for next run

Adv - job is executed as soon as it is ready.

Dis - all threads at some point will be sleeping, not doing meaningful work. Let say in a thread pool of 10 you
can run atmost 10 jobs. Even though some thread is sleeping, you cannot use it to run 11th job.