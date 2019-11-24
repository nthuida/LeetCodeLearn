package com.maomao.test.linkedlist;

/**
 * 移除链表元素
 *
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @Author huida.mao
 * @Date 2019/10/24
 */
public class RemoveElements {
    /**
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        //新建链表存放结果
        ListNode result = new ListNode(1);
        ListNode a = result;
        while (node != null) {
            if (node.val != val) {
               a.next = new ListNode(node.val);
               a = a.next;
            }
            node = node.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(6);
        ListNode node3= new ListNode(4);
        ListNode node4 = new ListNode(6);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode result = new RemoveElements().removeElements(node, 6);
        System.out.println(result);
    }
}
