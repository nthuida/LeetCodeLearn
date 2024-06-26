package com.maomao.test.linkedlist;

/**
 * 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @author huida
 * @date 2020/6/16
 */
public class SwapPairs {

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        //递归返回子链表的头结点
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    /**
     * 非递归
     * @param head
     * @return
     */
    public ListNode swapPairsII(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //虚拟头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode start = cur.next;
            ListNode end  = cur.next.next;
            //变换位置
            cur.next = end;
            start.next = end.next;
            end.next = start;
            cur = start;
        }
        return dummyHead.next;
    }

}
