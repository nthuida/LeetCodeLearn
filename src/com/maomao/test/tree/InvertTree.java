package com.maomao.test.tree;

/**
 * 翻转二叉树
 *
 * 翻转一棵二叉树。
 * 示例：
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @Author huida.mao
 * @Date 2019/10/31
 */
public class InvertTree {

    /**
     * 递归
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //翻转左右子树
        TreeNode invertLeftTree = invertTree(root.left);
        TreeNode invertRightTree = invertTree(root.right);
        root.left = invertRightTree;
        root.right = invertLeftTree;
        return root;
    }
}
