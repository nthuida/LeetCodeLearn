package com.maomao.test.linkedlist;

/**
 * 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * @author huida
 * @date 2020/7/4
 */
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        //求余
        k = k%len;
        for (int i=0; i<k; i++) {
            ListNode first = head;
            ListNode listNode = head;
            ListNode pre = null;
            while (listNode.next != null) {
                //倒数第二个节点
                pre = listNode;
                listNode = listNode.next;
            }
            //最后一个节点指向头结点
            listNode.next = first;
            //尾节点
            pre.next = null;
            //继续循环
            head = listNode;
        }
        return head;
    }
}
