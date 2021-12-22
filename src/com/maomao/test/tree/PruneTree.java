package com.maomao.test.tree;

/**
 * 二叉树减枝
 * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 *
 * 示例 1：
 * 输入：root = [1,null,0,0,1]
 * 输出：[1,null,0,null,1]
 * 解释：
 * 只有红色节点满足条件“所有不包含 1 的子树”。 右图为返回的答案。
 * 示例 2：
 * 输入：root = [1,0,1,0,0,0,1]
 * 输出：[1,null,1,null,1]
 *
 * @author: huida
 * @date: 2021/12/22
 **/
public class PruneTree {

    public TreeNode pruneTree(TreeNode root) {
        return contain(root) ? root : null;
    }

    /**
     * 递归，判断以 node 为根的子树中是否包含 1，
     * 其不包含 1 当且仅当以 node 的左右孩子为根的子树均不包含 1，并且 node 节点本身的值也不为 1。
     * @param root
     * @return
     */
    private boolean contain(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean left = contain(root.left);
        boolean right = contain(root.right);
        if (!left) {
            root.left = null;
        }
        if (!right) {
            root.right = null;
        }

        return root.val == 1 || left || right;

    }
}
