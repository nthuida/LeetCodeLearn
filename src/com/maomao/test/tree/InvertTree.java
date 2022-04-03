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
     * 后序遍历，先翻转左右子树,从下往上
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

    /**
     * 前序遍历，从上往下
     * @param root
     * @return
     */
    public TreeNode invertTreeII(TreeNode root) {
        if (root == null) {
            return null;
        }
        //先交换左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //递归翻转左右子树
        invertTreeII(root.left);
        invertTreeII(root.right);
        return root;
    }
}
