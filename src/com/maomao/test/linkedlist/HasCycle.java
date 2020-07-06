package com.maomao.test.linkedlist;

import java.util.List;

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
     * 走a+nb步一定是在环入口
     * 第一次相遇时慢指针已经走了nb步
     * a:入环口的长度，b:环的长度
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
            ListNode listNode = head;
            while (listNode != slow) {
                listNode = listNode.next;
                slow = slow.next;
            }
            return listNode;
        } else {
            return null;
        }

    }
}
