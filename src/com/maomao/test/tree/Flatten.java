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
}
