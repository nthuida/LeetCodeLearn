package com.maomao.test.linkedlist;

/**
 * @author Administrator
 * @date 2019/3/6
 */
public class LinkList {
    private ListNode head;

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    /**
     * 插入数据
     * @param data
     */
    public void addNode(int data) {
        ListNode nextNode = new ListNode(data);
        if (head == null) {
            head = nextNode;
            return;
        }
        ListNode temp = head;
        //找到最后一个节点
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(nextNode);
    }

    /**
     * 删除第index个节点
     * @param index
     * @return
     */
    public Boolean deleteNode(int index) {
        if (index < 1 || index > length()) {
            return false;
        }
        if (index == 1) {
            head = head.getNext();
            return true;
        }

        int i = 2;
        ListNode preNode = head;
        ListNode curNode = preNode.getNext();
        while (curNode != null) {
            if (i == index) {
                preNode.setNext(curNode.getNext());
                return true;
            }
            preNode = curNode;
            curNode = curNode.getNext();
            i++;
        }
        return true;
    }


    /**
     * 链表的长度
     * @return
     */
    public int length() {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.getNext();
        }
        return len;
    }

    public void printList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public static void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.getData());
            listNode = listNode.getNext();
        }
    }

    /**
     * 删除指定节点
     * @param node
     */
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        //交换当前节点和下个节点值，然后删除下个节点
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.addNode(1);
        linkList.addNode(3);
        linkList.addNode(9);
        ListNode listNode = linkList.getHead();
        linkList.deleteNode(listNode);
        linkList.printList();
    }
 }
