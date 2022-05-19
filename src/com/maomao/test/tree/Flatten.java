package com.maomao.test.tree;

/**
 * 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * @author huida
 * @date 2020/7/23
 */
public class Flatten {

    /**
     * 将左子树插入到右子树的地方
     * 将原来的右子树接到左子树的最右边节点
     * 考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
     * @param root
     */
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                //左子树为空，直接下一个节点
                root = root.right;
            } else {
                TreeNode pre = root.left;
                //找到左子树的最右边节点
                while (pre.right != null) {
                    pre = pre.right;
                }
                //原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                //将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                //下一个节点
                root = root.right;
            }
        }
    }


    /**
     * 后序遍历实现
     * 1、将 root 的左子树和右子树变成链表。
     * 2、将 root 的右子树接到左子树下方，然后将整个左子树作为右子树。
     * @param root
     */
    void flattenII(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        // 左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 将左子树作为右子树
        root.left = null;
        root.right = left;

        // 将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

}
