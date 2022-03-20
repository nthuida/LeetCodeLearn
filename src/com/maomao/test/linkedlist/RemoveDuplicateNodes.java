package com.maomao.test.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 移除重复节点
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 *
 * @author huida
 * @date 2020/7/2
 */
public class RemoveDuplicateNodes {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        ListNode temp = head;
        ListNode result = new ListNode(0);
        ListNode res = result;
        while (temp != null) {
            if (!set.contains(temp.val)) {
                set.add(temp.val);
                res.next = new ListNode(temp.val);
                res = res.next;
            }
            temp = temp.next;
        }
        return result.next;
    }

}
