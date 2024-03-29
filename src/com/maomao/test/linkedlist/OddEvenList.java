package com.maomao.test.linkedlist;

/**
 * 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 *
 * 示例 2:
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 *
 * 说明:
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * @author huida
 * @date 2020/9/11
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        //奇数节点开始位置
        ListNode odd = head;
        //偶数节点开始位置
        ListNode even = head.next;
        //偶数链表的头结点
        ListNode evenHead = head.next;
        while (even != null && even.next != null) {
            //奇数节点的下一个节点指向偶数节点的下一个节点
            odd.next = even.next;
            //向前移动
            odd = odd.next;
            //偶数节点的下个节点指向奇数节点的下一个节点
            even.next = odd.next;
            //向前移动
            even = even.next;
        }
        //奇数链表的尾节点，连接偶数链表的头结点
        odd.next = evenHead;
        return head;
    }
}
