package org.example.multithreading.producer.consumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private Queue<Integer> sharedBuffer;
    private int bufferSize;

    public SharedResource(int bufferSize){
        sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int item) throws InterruptedException {
        while(sharedBuffer.size() == bufferSize){
            System.out.println("buffer is full, producer in waiting state");
            wait();
        }
        sharedBuffer.add(item);
        notify();
    }

    public synchronized int consume() throws InterruptedException {
        while(sharedBuffer.isEmpty()){
            System.out.println("buffer is empty, consumer is waiting");
            wait();
        }
        int item = sharedBuffer.poll();
        notify();
        return item;
    }
}
