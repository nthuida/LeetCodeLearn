package com.maomao.test.linkedlist;

/**
 * 给定一个链表，判断链表中是否有环。
 * @author Administrator
 * @date 2019/3/7
 */
public class HasCycle {
    /**
     * 双指针
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
     * slow = s
     * fast = 2s
     * 2s - s = nb (相遇时，快指针比慢指针刚好多走了n圈）
     *
     * 从head结点到入环点需要走：a+nb， 而slow已经走了nb，那么slow再走a步就是入环点了。
     * 如何知道slow刚好走了a步？从head开始，和slow指针一起走，相遇时刚好就是a步
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
