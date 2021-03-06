package com.geektech.linear_structure.queue;

import com.geektech.linear_structure.base.ArrayList;

/**
 *  Queue,  date = 4/26 2019 ,  author = chensheng
 *  ADT: 构造器：constructor2个  => O(1)
 *        基本：getSize, isEmpty => O(1)
 *        增加：enQueue(e) => 渐进复杂度最坏情况O(n)-resize,最好情况O(1); 均摊复杂度O(1)
 *        删除：deQueue() => O(n) , TODO...还需改进性能，使用循环队列改进
 *        取出队列的队首元素：getFront()
 *
 *  实现思想：1）基于向量实现的数组队列，其本质还是维护一个静态数组。
 *          2）数组的左边为队首front，数组右边为队尾tail。
 *          3）从front出队，从tail入队
 *
 *  队列的应用：CPU的任务队列、网络数据包队列等
 *
 */
public class ArrayQueue<E> implements Queue<E> {

    private ArrayList<E> arrayList;

    public ArrayQueue(int capacity){
        arrayList = new ArrayList<>(capacity);
    }

    public ArrayQueue(){
        arrayList = new ArrayList<>();
    }


    public int getCapacity(){
        return arrayList.getCapacity();
    }

    @Override
    public int getSize() {
        return arrayList.getSize();
    }

    @Override
    public void enQueue(E e) {
        arrayList.addLast(e);
    }

    @Override
    public E deQueue() {
        return arrayList.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public E getFront() {
        return arrayList.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("queue: front [");
        for(int i = 0; i < arrayList.getSize(); i++){
            str.append(arrayList.get(i));
            if(i != arrayList.getSize()-1)
                str.append(",");
        }
        str.append("] tail");
        return str.toString();
    }


    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i = 0; i < 10; i++){
            queue.enQueue(i);
            System.out.println(queue.toString());
            if(i % 3 == 2){  // 每进队3个元素，就出队1个元素
                queue.deQueue();
                System.out.println(queue.toString());
            }

        }

    }

}
