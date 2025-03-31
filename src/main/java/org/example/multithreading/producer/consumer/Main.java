package org.example.multithreading.producer.consumer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedResource sr = new SharedResource(2);
        Thread producerThread = new Thread(()->{
            for (int i = 0; i <= 6 ; i++) {
                try {
                    sr.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread consumerThread = new Thread(()->{
            for (int i = 0; i <= 6 ; i++) {
                try {
                    sr.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producerThread.start();
        consumerThread.start();

    }
}
