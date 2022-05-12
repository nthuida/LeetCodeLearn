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
        //头插法，将cur后面的元素删除，然后添加到pre的后面
        for (int i = 0; i < n - m; i++) {
            //待插节点
            ListNode next = cur.next;
            //指向后面元素
            cur.next = next.next;
            //头节点插入
            next.next = pre.next;
            pre.next = next;
        }
        return dummyHead.next;
    }

}
