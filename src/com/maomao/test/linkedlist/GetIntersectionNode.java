package com.maomao.test.linkedlist;

/**
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 * @Author huida.mao
 * @Date 2019/10/24
 */
public class GetIntersectionNode {

    /**
     * 双指针法
     *
     * 创建两个指针 pA 和 pB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。
     * 当 pA 到达链表的尾部时，将它重定位到链表 B 的头结点;
     * 类似的，当 pB 到达链表的尾部时，将它重定位到链表 A 的头结点。
     * 若在某一时刻 pA 和 pB 相遇，则 pA的pB交点 为相交结点。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       if (headA == null || headB == null) {
           return null;
       }
       ListNode a = headA;
       ListNode b = headB;
       while (a != b) {
           if (a == null) {
               //如果走到 A 链表末尾，转到 B 链表
               a = headB;
           } else {
               a = a.next;
           }
           if (b == null) {
               //如果走到 B 链表末尾，转到 A 链表
               b = headA;
           } else {
               b = b.next;
           }
       }
       return  a;
    }

}
