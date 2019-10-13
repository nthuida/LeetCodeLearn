package com.maomao.test.tree;

/**
 * @author Administrator
 * @date 2019/3/5
 */
public class Node {
    private int data;
    private Node left;
    private Node right;
    public Node(int data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
