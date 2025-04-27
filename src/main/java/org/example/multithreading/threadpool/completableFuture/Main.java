package org.example.multithreading.threadpool.completableFuture;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4,
                10, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2));
        // future chaining by using thenApply by same thread which executed above async operation
        // by using thenApplyAsync the new chained lambda will be executed by some other thread
        for (int i = 0; i < 1000; i++) {
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                System.out.println("doing something by : "+Thread.currentThread().getName());
                return "done by : " + Thread.currentThread().getName();
            }).thenApply((s)->{
                System.out.println("doing something else");
                System.out.println(s);
                return s;
            }).thenApplyAsync((s)->{
                System.out.println("done by other thread"+Thread.currentThread().getName());
                return "done by other thread"+Thread.currentThread().getName();
            }).thenCompose((s)-> CompletableFuture.supplyAsync(()-> "something"));
            try{
//                System.out.println(future.get());
            }catch (Exception e){

            }
        }
        try{
            Thread.currentThread().join();
        }catch (Exception e){

        }
    }
}
