package com.maomao.test.linkedlist;

/**
 * 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 *
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * @Author huida.mao
 * @Date 2019/10/24
 */
public class IsPalindrome {
    /**
     * 放在数组中，在判断
     * @param head
     * @return
     */
    public boolean isPalindromeII(ListNode head) {
        if (head == null) {
            return true;
        }
        int length = 0;
        ListNode countNode = head;
        while (countNode != null) {
            length++;
            countNode = countNode.next;
        }
        int[] array = new int[length];
        ListNode node = head;
        int k = 0;
        while (node != null) {
            array[k++] = node.val;
            node = node.next;
        }
        for (int i=0, j=length-1; i<=j; i++, j--) {
            if (array[i] == array[j]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 双指针+翻转链表
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        //寻找链表中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //链表长度为奇数
        if (fast != null) {
            slow = slow.next;
        }
        //翻转中间节点的后半部分
        ListNode node = reverse(slow);
        fast = head;
        //比较
        while (node != null) {
           if (node.val != fast.val) {
               return false;
           }
           node = node.next;
           fast = fast.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    
}
