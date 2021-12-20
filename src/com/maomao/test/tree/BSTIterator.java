package com.maomao.test.tree;

import java.util.Stack;

/**
 * 二叉搜索树迭代器
 * @author: huida
 * @date: 2021/12/20
 **/
public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();

    private void pushLeftBranch(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public BSTIterator(TreeNode root) {
        pushLeftBranch(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        int val = node.val;
        pushLeftBranch(node.right);
        return val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
