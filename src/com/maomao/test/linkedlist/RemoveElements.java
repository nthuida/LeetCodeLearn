package com.maomao.test.linkedlist;

/**
 * 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @Author huida.mao
 * @Date 2019/10/24
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        //虚拟头节点
        ListNode dummyHead = new ListNode(1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        //当前节点的下一节点不为空
        while (cur.next != null) {
            if (cur.next.val != val) {
                cur = cur.next;
            } else {
                cur.next = cur.next.next;
            }
        }
        return dummyHead.next;
    }

}
