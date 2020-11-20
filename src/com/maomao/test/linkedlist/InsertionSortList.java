package com.maomao.test.linkedlist;

/**
 * 对链表进行插入排序
 *
 * 插入排序算法：
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 *
 * 示例 1：
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 示例 2：
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * @author huida
 * @date 2020/11/20
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        //有序链表的最后一个节点
        ListNode lastSort = head;
        //待插入的节点
        ListNode cur = head.next;
        while (cur != null) {
            if (lastSort.val <= cur.val) {
                //有序
                lastSort = lastSort.next;
            } else {
                //从头开始寻找待插入位置,pre待插入的前一个位置
                ListNode pre = temp;
                while (pre.next.val < cur.val) {
                    pre = pre.next;
                }
                //改变位置，插入
                lastSort.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            //下一个节点
            cur = lastSort.next;
        }

        return temp.next;
    }
}
