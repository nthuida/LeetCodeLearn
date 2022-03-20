package com.maomao.test.linkedlist;

/**
 * 分割链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * @author huida
 * @date 2020/9/25
 */
public class Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        ListNode low = head;
        while (low != null) {
            if (low.val < x) {
                ListNode listNode = new ListNode(low.val);
                cur.next = listNode;
                cur = cur.next;
            }
            low = low.next;
        }

        ListNode high = head;
        while (high != null) {
            if (high.val >= x) {
                ListNode listNode = new ListNode(high.val);
                cur.next = listNode;
                cur = cur.next;
            }
            high = high.next;
        }
        return res.next;
    }
}
