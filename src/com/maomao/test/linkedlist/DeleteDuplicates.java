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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
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
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode temp = head;
        ListNode pre = null;
        Set<Integer> set = new HashSet<>();
        while (temp != null) {
            if (set.contains(temp.val)) {
                pre.next = temp.next;
                temp = temp.next;
            } else {
                set.add(temp.val);
                pre = temp;
                temp = temp.next;
            }

        }
        return head;
    }

    /**
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中没有重复出现的数字。
     *
     * 示例 1:
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     *
     * 示例 2:
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
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
}
