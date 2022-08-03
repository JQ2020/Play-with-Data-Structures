package com.jq.queue.demo;

import com.jq.queue.Queue;

/**
 * 由于之前的链表结构只有在头节点插入或者删除时间复杂度为（1），在尾部进行插入和删除都是O（N）
 * 所以不适合直接拿来当成链表的底层结构，需要改造一下
 * 方案：新增tail记录尾节点，此时，在尾节点进行删除操作还是一样O(N),但是插入元素只要O(1)
 * 所以，在head处为队尾，tail处为队尾。
 * 需要注意的是链表为空的情况
 */
public class LinkedListQueue<E> implements Queue<E> {

    private Node head; //头节点
    private Node tail; //尾节点
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 入队需要从尾节点
     * @param e 入队元素e
     */
    @Override
    public void enqueue(E e) {
        // 队列为空的情况
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if (head == null) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        // 如果一开始对内只有一个元素,此时队内为空，需要维护下tail
        if (head == null) {
            tail = null;
        }
        size --;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
