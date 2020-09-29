package com.maomao.test.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树
 * @author Administrator
 * @date 2019/3/5
 */
public class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(Node node) {
        this.root = node;
    }

    public BinaryTree(int value) {
        Node node = new Node(value);
        this.root = node;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //排序二叉树添加数据
    public Node addNode(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        } else {
            if (value < node.getData()) {
                node.setLeft(addNode(node.getLeft(), value));
            } else {
                node.setRight(addNode(node.getRight(), value));
            }
            return node;
        }
    }

    /**
     * 中序遍历  中序遍历左子树  根节点   中序遍历右子树
     * @param root
     */
    public void midOrder(Node root) {
        if (root != null) {
            midOrder(root.getLeft());
            System.out.println(root.getData());
            midOrder(root.getRight());
        }
    }

    /**
     * 先序遍历  根节点  先序遍历左子树  先序遍历右子树
     * @param root
     */
    public void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.getData());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    /**
     * 后序遍历  后序遍历左子树  后序遍历右子树  根节点
     * @param root
     */
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getData());
        }
    }

    /**
     * 层序遍历  从上到下，从左往右
     * 把根节点放入队列，然后每次从队列取节点打印，如果有子节点，就把子节点放入队列中
     * @param root
     */
    public void layerOeder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.getData());
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
    }

    /**
     * 树的高度
     * @param root
     * @return
     */
    public int getTreeDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getTreeDepth(root.getLeft());
        int rightDepth = getTreeDepth(root.getRight());
        return (leftDepth > rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
    }

    /**
     * 判断是否是平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        int leftDepth = getTreeDepth(root.getLeft());
        int rightDepth = getTreeDepth(root.getRight());
        int diff = leftDepth - rightDepth;
        if (diff > 1 || diff < -1) {
            return false;
        }
        return isBalanced(root.getRight()) && isBalanced(root.getLeft());
    }

    List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);
        }
        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }



    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree(10);
        bTree.addNode(bTree.getRoot(), 5);
        bTree.addNode(bTree.getRoot(), 12);
        bTree.addNode(bTree.getRoot(), 6);
        bTree.addNode(bTree.getRoot(), 1);
        bTree.preOrder(bTree.getRoot());

        bTree.layerOeder(bTree.getRoot());

        System.out.println(bTree.getTreeDepth(bTree.getRoot()));

        System.out.println(bTree.isBalanced(bTree.getRoot()));

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        node1.left = node2;
        root.right = node1;
        System.out.println(new BinaryTree().postorderTraversal(root));
    }
}