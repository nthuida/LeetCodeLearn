package com.maomao.test.linkedlist;

/**
 * 链表排序
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * @author huida
 * @date 2020/7/6
 */
public class SortList {
    /**
     * 归并排序：指的是将两个已经排序的序列合并成一个序列的操作，因此采用分治法解决该问题。
     *
     * 分治法关键有两点:
     * 分割：把当前序列平均分割成两半；
     * 合并：在保持元素顺序的同时将上一步得到的子序列合并到一起
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //中间节点
        ListNode midNode = midNode(head);
        //分割成右边的节点
        ListNode rightHead = midNode.next;
        //左节点最后一个为空
        midNode.next = null;
        //递归
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        //合并
        return mergeTwoLists(left, right);

    }

    /**
     * 中间节点
     * @param head
     * @return
     */
    private ListNode midNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null  && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return  slow;
    }


    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //初始化
        ListNode headNode = new ListNode(0);
        ListNode cur = headNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        //剩余的l1
        while (l1 != null) {
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }
        //剩余的l2
        while (l2 != null) {
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        //去掉头结点
        return headNode.next;
    }

}
