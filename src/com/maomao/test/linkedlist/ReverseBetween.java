package com.maomao.test.linkedlist;

/**
 * 反转链表
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @author huida
 * @date 2020/9/25
 */
public class ReverseBetween {
    // 后驱节点
    ListNode successor = null;

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            //反转前n个元素
            return reverseN(head, n);
        }
        //转化为从1开始的反转
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }


    /**
     * 反转前n个节点
     * @param head
     * @param n
     * @return
     */
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    /**
     * 非递归
     * 思路：1、我们定义两个指针，分别称之为g和p，将g移动到第一个要反转的节点的前面，将p移动到第一个要反转的节点的位置上。
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

        for (int i = 0; i < n - m; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;

            removed.next = g.next;
            g.next = removed;
        }

        return dummyHead.next;
    }

}
