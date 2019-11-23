package com.maomao.test.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Administrator
 * @date 2019/3/24
 */
public class QueueList<E> {
    private Queue<E> queue = new LinkedList<E>();

    /**
     * 将指定的元素插入此队列，在成功时返回 true，
     * 如果当前没有可用的空间，则抛出 IllegalStateException。
     * @param e
     * @return
     */
    public boolean add(E e){
        return queue.add(e);
    }

    /**
     * 将指定的元素插入此队列（如果立即可行且不会违反容量限制），当使用有容量限制的队列时，
     * 此方法通常要优于 add(E)，后者可能无法插入元素，而只是抛出一个异常。
     * @param e
     * @return
     */
    public boolean offer(E e){
        return queue.offer(e);
    }

    /**
     * 获取但不移除此队列的头；如果此队列为空，则返回 null
     * @return
     */
    public E peek(){
        return queue.peek();
    }

    /**
     * 获取并移除此队列的头，如果此队列为空，则返回 null
     * @return
     */
    public E poll(){
        return queue.poll();
    }

    /**
     * 判空
     * @return
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
