package com.maomao.test.linkedlist;

/**
 * 删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * @Author huida.mao
 * @Date 2019/11/27
 */
public class RemoveNthFromEnd {

    /**
     * 先求长度L，然后删除从列表开头数起的第 (L - n + 1)个结点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        //长度
        int len = 0;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        //删除的前一个节点的位置
        int removeBefore = len -n;
        if (removeBefore == 0) {
            return head.next;
        }
        //删除的前一个节点
        ListNode first = head;
        while (removeBefore > 1) {
            removeBefore--;
            first = first.next;
        }
        first.next = first.next.next;
        return head;
    }

    /**
     * 找到倒数第n+1个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        //防止删除第链表长度的时候，出现空指针
        ListNode temp = new ListNode(0);
        temp.next = head;
        /**
         * 双指针，找到链表的倒数n+1个节点
         * 快指针先走n+1步，然后快慢指针同时走
         * 快指针到达终点时，慢指针即为倒数第n+1个节点
         */
        ListNode fast = temp;
        ListNode slow = temp;
        //第一节点先走n+1步
        for (int i=0; i<=n; i++) {
            fast = fast.next;
        }

        //同时走步
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //删除第n个节点
        slow.next = slow.next.next;
        return temp.next;
    }


}
