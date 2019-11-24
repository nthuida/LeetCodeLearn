package com.maomao.test.tree;

/**
 * 路径总和
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * @Author huida.mao
 * @Date 2019/10/21
 */
public class HasPathSum {
    /**
     * 递归
     * 分别递归左右子树找到叶子节点，不是的时候sum减去val
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.right == null && root.left == null && sum == 0) {
            return true;
        }
        return (hasPathSum(root.left, sum) || hasPathSum(root.right, sum));
    }
}
