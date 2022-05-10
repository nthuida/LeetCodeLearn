package com.maomao.test.linkedlist;

/**
 *
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author Administrator
 * @date 2019/4/22
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode headNode = new ListNode(0);
        ListNode cur = headNode;
        //进位
        int plus = 0;
        while (l1 != null && l2 != null) {
            int data =  l1.val + l2.val + plus;
            plus = data/10;
            int mod = data%10;
            ListNode node = new ListNode(mod);
            l1 = l1.next;
            l2 = l2.next;
            cur.next = node;
            cur = cur.next;
        }

        //剩余的l1
        while (l1 != null) {
            int data =  l1.val  + plus;
            plus = data/10;
            int mod = data%10;
            ListNode node = new ListNode(mod);
            l1 = l1.next;
            cur.next = node;
            cur = cur.next;
        }
        //剩余的l2
        while (l2 != null) {
            int data =  l2.val  + plus;
            plus = data/10;
            int mod = data%10;
            ListNode node = new ListNode(mod);
            l2 = l2.next;
            cur.next = node;
            cur = cur.next;
        }

        if (plus ==1) {
            ListNode node = new ListNode(1);
            cur.next = node;

        }

        return headNode.next;
    }

    /**
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。
     * 将这两数相加会返回一个新的链表。你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     *
     * 示例：
     * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 8 -> 0 -> 7
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode reverse1 = reverseList(l1);
        ListNode reverse2 = reverseList(l2);
        ListNode result = addTwoNumbers(reverse1, reverse2);
        return reverseList(result);
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
