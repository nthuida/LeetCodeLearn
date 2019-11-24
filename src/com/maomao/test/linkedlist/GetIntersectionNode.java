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
     * 当 pA 到达链表的尾部时，将它重定位到链表 B 的头结点; 类似的，当 pB 到达链表的尾部时，将它重定位到链表 A 的头结点。
     * 若在某一时刻 pA 和 pB 相遇，则 pA的pB交点 为相交结点。
     *
     * 分析：两个链表: A={1,3,5,7,9,11} 和 B={2,4,9,11}，相交于结点 9。
     * 由于 B.length (=4) < A.length (=6)，pB 比 pA 少经过 2 个结点，会先到达尾部。将 pB 重定向到 A 的头结点，
     * pA 重定向到 B 的头结点后，pB 要比 pA 多走 2 个结点。因此，它们会同时到达交点。
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
               a = headB;
           } else {
               a = a.next;
           }

           if (b == null) {
               b = headA;
           } else {
               b = b.next;
           }
       }
       return  a;
    }

}
