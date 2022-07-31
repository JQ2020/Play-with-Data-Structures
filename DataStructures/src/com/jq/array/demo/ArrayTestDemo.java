package com.jq.array.demo;

import com.jq.array.DynamicArray;

//测试动态数组类
public class ArrayTestDemo {

    public static void main(String[] args) {

        DynamicArray<Integer> arr = new DynamicArray<>();
        for(int i = 0 ; i < 10 ; i ++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
    }
}
