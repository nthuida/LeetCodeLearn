package com.maomao.test.linkedlist;

/**
 * @author Administrator
 * @date 2019/3/6
 */
public class LinkList {
    private LinkedListNode head;

    public LinkedListNode getHead() {
        return head;
    }

    public void setHead(LinkedListNode head) {
        this.head = head;
    }

    /**
     * 插入数据
     * @param data
     */
    public void addNode(int data) {
        LinkedListNode nextNode = new LinkedListNode(data);
        if (head == null) {
            head = nextNode;
            return;
        }
        LinkedListNode temp = head;
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
        LinkedListNode preNode = head;
        LinkedListNode curNode = preNode.getNext();
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
        LinkedListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.getNext();
        }
        return len;
    }

    public void printList() {
        LinkedListNode temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public static void printList(LinkedListNode linkedListNode) {
        while (linkedListNode != null) {
            System.out.println(linkedListNode.getData());
            linkedListNode = linkedListNode.getNext();
        }
    }

    /**
     * 删除指定节点
     * @param node
     */
    public void deleteNode(LinkedListNode node) {
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
        LinkedListNode linkedListNode = linkList.getHead();
        linkList.deleteNode(linkedListNode);
        linkList.printList();
    }
 }
