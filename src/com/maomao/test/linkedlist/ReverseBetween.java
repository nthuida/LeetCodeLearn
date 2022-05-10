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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        //反转链表的的前一个节点
        ListNode pre = dummyHead;
        for (int i=0; i<m-1; i++) {
            pre = pre.next;
        }
        //反转链表的第一个节点
        ListNode cur = pre.next;
        //头插法，先将 curr 的下一个节点记录为 next；
        //执行操作 ①：把 curr 的下一个节点指向 next 的下一个节点；
        //执行操作 ②：把 next 的下一个节点指向 pre 的下一个节点；
        //执行操作 ③：把 pre 的下一个节点指向 next
        for (int i = 0; i < n - m; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyHead.next;
    }

}
