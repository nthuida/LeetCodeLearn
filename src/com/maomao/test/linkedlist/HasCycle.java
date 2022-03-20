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

    /**
     * 第一次相遇时慢指针走了k步，快指针走了2k步，快指针比慢指针多走n圈
     * 假设相遇点距环的起点的距离为 m，环的起点距头结点 head 的距离为 k - m，
     * 也就是说如果从 head 前进 k - m 步就能到达环起点。
     * 巧的是，如果从相遇点继续前进 k - m 步，也恰好到达环起点：
     *
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (hasCycle) {
            //重新指向头节点
            fast = head;
            while (fast != slow) {
                // 快慢指针同步前进，相交点就是环起点
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        } else {
            return null;
        }

    }
}
