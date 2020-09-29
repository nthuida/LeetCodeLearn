package com.maomao.test.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * @author huida
 * @date 2020/9/29
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        //把链表存储到线性表中，然后用双指针依次从头尾取元素
        List<ListNode> listNode = new ArrayList<>();
        while (head != null) {
            listNode.add(head);
            head = head.next;
        }
        int i=0, j = listNode.size()-1;
        while (i<j) {
            //首尾相连
            listNode.get(i).next = listNode.get(j);
            i++;
            //偶数个
            if (i == j) {
                break;
            }
            listNode.get(j).next = listNode.get(i);
            j--;
        }
        //最后一个元素
        listNode.get(i).next = null;
    }
}
