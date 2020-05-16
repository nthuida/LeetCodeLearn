package com.maomao.test.linkedlist;

/**
 * K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * @author huida
 * @date 2020/5/16
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode headNode = new ListNode(0);
        headNode.next = head;
        ListNode pre = headNode;
        ListNode end = headNode;
        while (end.next != null) {
            for (int i=0; i<k && end != null; i++) {
                //找到每次翻转的最后一个结点
                end = end.next;
            }
            if (end == null) {
                //到达末尾,翻转的个数不够
                break;
            }
            //未翻转的链表头
            ListNode next = end.next;
            //待翻转的尾结点
            end.next = null;
            //待翻转的头结点
            ListNode start = pre.next;
            //从start-end翻转链表
            pre.next = reverseList(start);
            //satrt在翻转的时候已经到了最后，连接已翻转和待翻转链表
            start.next = next;
            pre = start;
            end = start;
        }
        return headNode.next;
    }

    public ListNode reverseList(ListNode head) {
        //链表原地反转
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
