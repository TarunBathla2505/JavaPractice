package org.example.multithreading.threadpool.predefinedPools;

import java.util.concurrent.*;

public class Main {
//    these are the thread pool already given so that we don't have to create new one
    public static void main(String[] args) {
        Executors.newFixedThreadPool(3); // create pool of exact size 3 mostly used when you know the load on the task
        Executors.newCachedThreadPool(); // create thread pool which creates new thread as needed good for handling burst of short-lived tasks
        Executors.newSingleThreadExecutor(); // create a executor with just one thread
        ExecutorService executorService = Executors.newWorkStealingPool(4);// use Fork-Join mechanism


        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        ForkJoinTask<Integer> submit = forkJoinPool.submit(new ComputeSum(1, 1000));
        try {
            System.out.println(submit.get());

        }catch (Exception e){

        }
    }
}


class ComputeSum extends RecursiveTask<Integer>{
    int start;
    int end;

    ComputeSum(int start,int end){
        this.end = end;
        this.start = start;
    }

    @Override
    protected Integer compute() {
        if(end-start<=4){
            int totalSum = 0;
            for(int i=start;i<=end;i++){
                totalSum+=i;
            }
            return totalSum;
        }else {
            // split the task
            int mid = (start+end)/2;
            ComputeSum computeSumLeft = new ComputeSum(start, mid);
            ComputeSum computeSumRight = new ComputeSum(mid + 1, end);

            return computeSumLeft.fork().join()+computeSumRight.fork().join();
        }
    }
}
