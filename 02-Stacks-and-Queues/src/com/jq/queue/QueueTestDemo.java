package com.jq.queue;

public class QueueTestDemo {
    public static void main(String[] args) {

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
        }

        for (int i = arrayQueue.getSize(); i > 0; i--) {
            arrayQueue.dequeue();
            System.out.println(arrayQueue);
        }
    }
}
