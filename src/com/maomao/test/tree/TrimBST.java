package com.maomao.test.tree;

/**
 * 修剪二叉搜索树
 * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。
 * 你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
 *
 * 示例 1:
 *
 * 输入:
 *     1
 *    / \
 *   0   2
 *
 *   L = 1
 *   R = 2
 *
 * 输出:
 *     1
 *       \
 *        2
 *
 *
 * 示例 2:
 *
 * 输入:
 *     3
 *    / \
 *   0   4
 *    \
 *     2
 *    /
 *   1
 *
 *   L = 1
 *   R = 3
 *
 * 输出:
 *       3
 *      /
 *    2
 *   /
 *  1
 *
 * @author huida
 * @date 2020/6/28
 */
public class TrimBST {

    /**
     * 如果根结点太小，说明根结点及其左子树都应该剪掉，因此直接返回右子树的修剪结果。
     * 如果根结点太大，说明根结点及其右子树都应该剪掉，因此直接返回左子树的修剪结果。
     * 如果根结点没问题，则递归地修剪左子结点和右子结点。
     * 如果结点为空，说明无需修剪，直接返回空即可。
     * 左右子结点都修剪完后，返回自身。
     *
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {

        if(root == null) {
            return null;
        }
        if(root.val < L)  {
            //左子树偏小
            return trimBST(root.right, L, R);
        }
        if(root.val > R) {
            //右子树偏大
            return trimBST(root.left, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;

    }
}
