package com.maomao.test.linkedlist;

/**
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author Administrator
 * @date 2019/4/22
 */
public class AddTwoNumbers {
    /**
     * @param l1
     * @param l2
     * @return
     */
    public LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        LinkedListNode headNode = new LinkedListNode(0);
        LinkedListNode cur = headNode;
        //进位
        int plus = 0;
        while (l1 != null && l2 != null) {
            int data =  l1.data + l2.data + plus;
            plus = data/10;
            int mod = data%10;
            LinkedListNode node = new LinkedListNode(mod);
            l1 = l1.next;
            l2 = l2.next;
            cur.next = node;
            cur = cur.next;
        }

        //剩余的l1
        while (l1 != null) {
            int data =  l1.data  + plus;
            plus = data/10;
            int mod = data%10;
            LinkedListNode node = new LinkedListNode(mod);
            l1 = l1.next;
            cur.next = node;
            cur = cur.next;
        }
        //剩余的l2
        while (l2 != null) {
            int data =  l2.data  + plus;
            plus = data/10;
            int mod = data%10;
            LinkedListNode node = new LinkedListNode(mod);
            l2 = l2.next;
            cur.next = node;
            cur = cur.next;
        }

        if (plus ==1) {
            LinkedListNode node = new LinkedListNode(1);
            cur.next = node;

        }

        return headNode.next;
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.addNode(5);

        LinkList linkList1 = new LinkList();
        linkList1.addNode(5);

        LinkedListNode headNode = new AddTwoNumbers().addTwoNumbers(linkList.getHead(), linkList1.getHead());

        linkList.setHead(headNode);
        linkList.printList();
    }
}
