package com.maomao.test.linkedlist;

/**
 * 反转链表
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @author huida
 * @date 2020/9/25
 */
public class ReverseBetween {

    /**
     * 非递归
     * 1、定义两个指针g和p，将g移动到第一个要反转的节点的前面，将p移动到第一个要反转的节点的位置上。
     * 2、将p后面的元素删除，然后添加到g的后面。也即头插法
     * 3、根据m和n重复步骤2
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetweenII(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        int step = 0;
        while (step < m - 1) {
            g = g.next;
            p = p.next;
            step ++;
        }
        //头节点插入
        for (int i = 0; i < n - m; i++) {
            //待插节点
            ListNode removed = p.next;
            p.next = p.next.next;

            removed.next = g.next;
            g.next = removed;
        }
        return dummyHead.next;
    }

}
