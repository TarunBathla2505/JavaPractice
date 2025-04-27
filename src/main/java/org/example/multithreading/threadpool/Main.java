package org.example.multithreading.threadpool;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4,
                10, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2),
                new MyCustomThreadFactory(), new CustomRejectHandler());

        for(int i=0;i<8;i++){
            Future<String> future = threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                System.out.println("task processed by" + Thread.currentThread().getName());
                return "hehe";
            });

//            future.cancel(true); // to cancel the thread and can return false if not cancel
            System.out.println(future.isCancelled());
            System.out.println(future.isDone()); // returns true if task is done or completed
            try{
                String s = future.get();// wait for completion of task and after task complete it will wait for retrial of result
                System.out.println(s);
            }catch (Exception e) {
                System.out.println("Exception came");
            }
        }
        threadPoolExecutor.shutdown();
    }
}


// we can also use Executors.defaultThreadFactory()
class MyCustomThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setPriority(Thread.NORM_PRIORITY);
        th.setDaemon(false);
        return th;
    }
}

// we can also use predefined one like [ new ThreadPoolExecutor.CallerRunsPolicy() ]
class CustomRejectHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task Rejected: "+ r.toString());
    }
}

/*
Thread pool is a collection of thread also known as worker which are available for submitted tasks
once task completed all threads goes to thread pool and wait for new task
threads can be reused

Advantages
1. thread creation time can be saved
2. performance increase
3. lifecycle overhead can be removed
 */



/*
* Why you have taken corePoolSize as 2, why not 10 or 15 or any other number, what's the logic?
*
* min and max depends on various factors like CPU core, JVM memory, Task Nature(CPU / IO intensive),
*
*/