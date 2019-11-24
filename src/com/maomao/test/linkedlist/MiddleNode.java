package com.maomao.test.linkedlist;

import com.maomao.test.linkedlist.ListNode;

/**
 * 链表的中间节点
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 LinkedListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *
 * @Author huida.mao
 * @Date 2019/10/28
 */
public class MiddleNode {
    /**
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode countNode = head;
        int lengh = 0;
        while (countNode != null) {
            lengh++;
            countNode = countNode.next;
        }
        ListNode resultNode = head;
        int i = 0;
        while (i != lengh/2) {
            resultNode = resultNode.next;
            i++;
        }
        return resultNode;
    }
}
