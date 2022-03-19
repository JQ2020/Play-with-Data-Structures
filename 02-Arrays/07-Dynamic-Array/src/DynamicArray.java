import java.util.Arrays;

/**
 * description: 一个具有基础增删改查功能并且支持泛型的动态数组
 * author: jiangquan
 */

public class DynamicArray<E> {

    E[] data;
    int size;

    @SuppressWarnings("unchecked")
    public DynamicArray(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    //无参构造函数默认数组容量为10
    public DynamicArray() {
        this(10);
    }

    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    //获取数组的元素个数
    public int getSize() {
        return size;
    }

    //数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //将数组空间的容量转换为newCapacity大小，用于实现动态调整数组容量
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }


    //在index位置插入值为e的元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        //当数组已经满了，扩容至当前数组两倍的容量
        if (size == data.length) {
            resize(data.length * 2);
        }

        for (int i = size - 1; i >= index; i-- ) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    //获取index索引位置的元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    //修改index索引位置的元素为e
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    //查找数组中是否含有元素e
    public boolean contain(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中第一个元素值为e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Require index >= 0 and index <= size.");
        }
        E ret = data[index];
        for (int i = index +1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null;
        //如果在size == data.length的时候缩容，可能在边界时反复添加、删除会造成性能影响
        //data.length / 2 != 0 是为了防止创造一个容量为0的数组（实际上并不允许这么做，会报错）
        if(size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }


    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("DynamicArray: size = %d, capacity = %d\n", size, data.length));
        result.append("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i != size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}


