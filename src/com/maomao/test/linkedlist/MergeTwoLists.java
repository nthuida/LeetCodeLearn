package com.maomao.test.linkedlist;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @author Administrator
 * @date 2019/3/7
 */
public class MergeTwoLists {
    /**
     * 两两比较，放入一个新的链表
     * @param l1
     * @param l2
     * @return
     */
    public LinkedListNode mergeTwoLists(LinkedListNode l1, LinkedListNode l2) {
        //初始化
        LinkedListNode headNode = new LinkedListNode(0);
        LinkedListNode cur = headNode;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
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

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.addNode(1);
        linkList.addNode(3);
        linkList.addNode(7);

        LinkList linkList1 = new LinkList();
        linkList1.addNode(1);
        linkList1.addNode(2);
        linkList1.addNode(3);
        linkList1.addNode(6);
        LinkedListNode headNode = new MergeTwoLists().mergeTwoLists(linkList.getHead(), linkList1.getHead());
        linkList.setHead(headNode);
        linkList.printList();
    }
}
