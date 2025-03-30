package org.example.multithreading.part1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        for main thread
        System.out.println("Thread name: "+Thread.currentThread().getName());

        ThreadByImplements runnableObject = new ThreadByImplements();
        // this will create thread
        Thread thread = new Thread(runnableObject);

        thread.start();
        thread.join(); // this will let main thread wait for thread-0 to complete
        System.out.println("Thread name: "+Thread.currentThread().getName());
        ThreadByExtend threadByExtend = new ThreadByExtend();
        threadByExtend.start();
        threadByExtend.join();
        System.out.println("Thread name: "+Thread.currentThread().getName());
    }
}

class ThreadByExtend extends Thread {
    @Override
    public void run() {
        System.out.println("Thread name: "+Thread.currentThread().getName());
    }
}

class ThreadByImplements implements Runnable {

    @Override
    public void run() {
        System.out.println("thread name:" + Thread.currentThread().getName());
    }
}
