package com.maomao.test.list;

/**
 * 回文链表
 * @Author huida.mao
 * @Date 2019/10/24
 */
public class IsPalindrome {
    /**
     * 请判断一个链表是否为回文链表。
     *
     * 示例 1:
     *
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     *
     * 输入: 1->2->2->1
     * 输出: true
     *
     * 放在数组中，在判断
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
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

    public static void main(String[] args) {
        ListNode node = new ListNode(-12);
        ListNode node1 = new ListNode(-12);
        node.next = node1;
        System.out.println(new IsPalindrome().isPalindrome(node));
    }
}
