package com.maomao.test.linkedlist;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @author Administrator
 * @date 2019/3/6
 */
public class ReverseList {
    /**
     * 递归实现 在反转当前节点之前先反转后续节点。
     * 简单的说就是从尾结点开始，逆向反转各个结点的指针域指向
     * @param head
     * @return
     */
    public LinkedListNode reverseList(LinkedListNode head) {
        //如果没有结点或者只有一个结点直接返回Head
        if (head == null || head.next == null) {
            return head;
        }
        //当前结点的下一结点
        LinkedListNode next = head.next;
        //头结点变为尾结点
        head.next = null;
        //递归结束时reverseHead一定是新链表的头结点
        LinkedListNode reverseHead = reverseList(next);
        //当前节点指向前一节点
        next.next = head;
        return reverseHead;
    }

    /**
     * 非递归
     * @param head
     * @return
     */
    public LinkedListNode reverseList1(LinkedListNode head) {
        //链表原地反转
        LinkedListNode prev = null;
        while (head != null) {
            LinkedListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }


    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.addNode(1);
        linkList.addNode(9);
        linkList.addNode(2);
        LinkedListNode headNode = new ReverseList().reverseList1(linkList.getHead());
        linkList.setHead(headNode);
        linkList.printList();
    }
}
