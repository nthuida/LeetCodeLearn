package com.maomao.test.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * @author Administrator
 * @date 2019/3/7
 */
public class DeleteDuplicates {
    /**
     * 时间复杂度：O(n)  链表已排序
     * @param head
     * @return
     */
    public LinkedListNode deleteDuplicates(LinkedListNode head) {
        LinkedListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.data == current.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    /**
     * set判断元素是否存在，前置节点来去重
     * 时间复杂度：O(n)  链表未排序
     * @param head
     * @return
     */
    public LinkedListNode deleteDuplicates1(LinkedListNode head) {
        LinkedListNode temp = head;
        LinkedListNode pre = null;
        Set<Integer> set = new HashSet<>();
        while (temp != null) {
            if (set.contains(temp.data)) {
                pre.next = temp.next;
                temp = temp.next;
            } else {
                set.add(temp.data);
                pre = temp;
                temp = temp.next;

            }

        }
        return head;
    }

    /**
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     *
     * 示例 1:
     *
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     *
     * 示例 2:
     *
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        Map<Integer, Integer> map = new HashMap<>();
        while (temp != null) {
            int val = temp.val;
            map.put(val, map.getOrDefault(val, 0) + 1);
            temp = temp.next;
        }
        ListNode cur = head;
        //新建链表存放结果
        ListNode result = new ListNode(1);
        ListNode a = result;
        while (cur != null) {
            if (map.get(cur.val) ==1 ) {
                a.next = new ListNode(cur.val);
                a = a.next;
            }
            cur = cur.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.addNode(1);
        linkList.addNode(1);
        linkList.addNode(2);
        linkList.addNode(3);
        linkList.addNode(3);

        LinkedListNode headNode = new DeleteDuplicates().deleteDuplicates(linkList.getHead());
        linkList.setHead(headNode);
        linkList.printList();

        LinkList linkList1 = new LinkList();
        linkList1.addNode(1);
        linkList1.addNode(6);
        linkList1.addNode(2);
        linkList1.addNode(3);
        linkList1.addNode(3);
        linkList1.addNode(1);

        LinkedListNode headNode1 = new DeleteDuplicates().deleteDuplicates1(linkList1.getHead());
        linkList.setHead(headNode1);
        linkList.printList();
    }
}
