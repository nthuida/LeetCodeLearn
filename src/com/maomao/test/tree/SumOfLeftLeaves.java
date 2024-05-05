package com.maomao.test.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 左子叶之和
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * @Author huida
 * @Date 2019/11/6
 */
public class SumOfLeftLeaves {

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root);
        return sum;
    }

    /**
     * 先序遍历，找到左子叶，累加求和
     * @param root
     */
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        //判断左子叶
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        traverse(root.left);
        traverse(root.right);

    }


    public int sumOfLeftLeavesII(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leave = 0;
        //过节点的父节点来判断其左孩子是不是左叶子
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leave = root.left.val;
        }

        int left = sumOfLeftLeavesII(root.left);
        int right = sumOfLeftLeavesII(root.right);

        return leave + left + right;
    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int left = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    left = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return left;
    }
}
