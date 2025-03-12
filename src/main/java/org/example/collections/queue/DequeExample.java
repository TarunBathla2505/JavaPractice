package org.example.collections.queue;

import java.util.ArrayDeque;

public class DequeExample {
//  addFirst, offerFirst, addLast, offerLast, removeFirst, pollFirst, removeLast, pollLast, getFirst, peekFirst, getLast, peekLast
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        arrayDeque.addFirst(1);
        arrayDeque.addFirst(4);
        arrayDeque.addLast(6);
        arrayDeque.addLast(9);
        System.out.println(arrayDeque);

        arrayDeque.offerFirst(11);
        arrayDeque.offerLast(15);

        System.out.println(arrayDeque);

        arrayDeque.removeFirst();
        arrayDeque.pollLast();
        System.out.println(arrayDeque);
        System.out.println(arrayDeque.peekFirst());
        System.out.println(arrayDeque.getLast());
    }
}
