package com.maomao.test.tree;

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
 * @Author huida.mao
 * @Date 2019/11/6
 */
public class SumOfLeftLeaves {

    /**
     * 递归：1、左子树的和加上右子树的和
     *       2、怎么求左子叶的和：左子树为叶子节点，返回右子树的左叶子和 + 左子叶的值
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //左子树为叶子节点，那么需返回右子树的左叶子和 + 左子叶的值
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return  root.left.val + sumOfLeftLeaves(root.right);
        }

        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
