package com.jq;

public class LinkedList<E> {

    private Node dummyHead; //虚拟头节点，真正的头节点是dummyHead,next ,为了让add操作统一而射之
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 获取链表中元素的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表头添加新的元素e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表的index(0 - based)位置添加新的元素e
     * 注：关键步骤是找到待添加位置的前一个节点
     */
    public void add(int index, E e) {
        // index可以为size，相当于在链表末尾添加元素
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 在链表末尾添加新的元素e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获得链表的第index个位置的元素
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获得链表的第一个元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获得链表的最后一个元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表的第index个位置的元素为e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表是否有元素e
     */
    public boolean contain(E e) {
        Node cur = dummyHead.next;
        while(cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 从链表中删除index位置的元素
     * @return 被删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is Illegal.");
        }

        Node prev = this.dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.e;
    }

    /**
     * 从链表中删除第一个元素
     * @return 返回删除的元素
     */

    public E removeFirst() {
        return remove(0);
    }

    /**
     *  从链表删除最后一个元素
     * @return 返回被删除的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur + " -> ");
        }
        res.append("Null");
        return res.toString();
    }

    /**
     * Node 内部类
     */
    private class Node {
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
