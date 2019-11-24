package com.maomao.test.tree;

/**
 * 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * @Author huida.mao
 * @Date 2019/10/21
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = length(root.left);
        int right = length(root.right);
        if (left - right > 1 || left - right < -1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int length(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = length(root.left);
        int right = length(root.right);
        return left > right ? left + 1 : right + 1;
    }

}
