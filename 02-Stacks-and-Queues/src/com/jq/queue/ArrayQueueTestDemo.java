package com.jq.queue;

public class ArrayQueueTestDemo {
    public static void main(String[] args) {

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);

            // 每入队三个元素，出队一个元素
            if(i % 3 == 2){
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }
    }
}
