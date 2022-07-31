public class LinkedList<E> {

    private Node dummyHead; //虚拟头节点，真正的头节点是dummyHead,next ,为了让add操作统一而射之
    private int size;

    public LinkedList() {
        dummyHead = null;
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
