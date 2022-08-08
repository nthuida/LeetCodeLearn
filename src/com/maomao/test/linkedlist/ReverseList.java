package com.maomao.test.linkedlist;

/**
 * 反转链表
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @author Administrator
 * @date 2019/3/6
 */
public class ReverseList {
    /**
     * 递归实现 在反转当前节点之前先反转后续节点。
     * 简单的说就是从尾结点开始，逆向反转各个结点的指针域指向
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //如果没有结点或者只有一个结点直接返回Head
        if (head == null || head.next == null) {
            return head;
        }
        //当前结点的下一结点
        ListNode next = head.next;
        //递归结束时reverseHead一定是新链表的头结点
        ListNode reverseHead = reverseList(next);
        //头结点变为尾结点
        head.next = null;
        //当前节点指向前一节点
        next.next = head;
        return reverseHead;
    }

    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            //下一个节点
            ListNode next = cur.next;
            //当前节点指向pre,翻转
            cur.next = prev;
            //pre,cur向前移动
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
