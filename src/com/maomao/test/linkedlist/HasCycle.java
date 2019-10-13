package com.maomao.test.linkedlist;

/**
 * 给定一个链表，判断链表中是否有环。
 * @author Administrator
 * @date 2019/3/7
 */
public class HasCycle {
    /**
     * 快指针走两步，慢指针走一步，如果有环，肯定会相遇
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
