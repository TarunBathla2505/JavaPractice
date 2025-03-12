package org.example.collections.queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueExample {

//    Queue -> add, offer, poll, peak, element, remove
//    PriorityQueue(heap) -> Min PriorityQueue or Max PriorityQueue

    public static void main(String[] args) {
        PriorityQueue<Integer> q= new PriorityQueue<>();
        q.add(5);
        q.add(4);
        q.add(3);
        q.add(2);
        q.add(1);

        q.forEach((value) -> System.out.println(value));
        System.out.println("using while loop");
        PriorityQueue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder());
        q2.addAll(q);
        while (!q.isEmpty()){
            int val = q.poll();
            System.out.println(val);
        }

        System.out.println("max heap");
        while (!q2.isEmpty()){
            int val = q2.poll();
            System.out.println(val);
        }

        comparatorVsComparable();
    }

    public static void comparatorVsComparable(){
        int[] arr = new int[]{5,4,3,2,1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        Car[] carArr = new Car[]{new Car("beetle",123),new Car("Porche",145)};
        Arrays.sort(carArr);
        System.out.println(Arrays.toString(carArr));
    }


}

class Car implements Comparable<Car>{
    public String name;
    public int number;

    Car(String name,int number){
        this.name = name;
        this.number = number;
    }

    public String toString(){
        return this.name;
    }


    @Override
    public int compareTo(Car o) {
        return o.number - this.number;
    }


}
