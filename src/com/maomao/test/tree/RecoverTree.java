package com.maomao.test.tree;

/**
 * 恢复二叉搜索树
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1：
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 *
 * 示例 2：
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 *
 * @author: huida
 * @date: 2021/12/10
 **/
public class RecoverTree {

    /**
     * 比较前后访问的节点值，prev 保存上一个访问的节点，当前访问的是 root 节点。
     * 每访问一个节点，如果prev.val>=root.val，就找到了一对“错误对”。
     *
     * @param root
     */

    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        midOrder(root);
        //交换
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    private void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrder(root.left);
        if (first == null && pre.val >= root.val) {
            //第一个节点
            first = pre;
        }

        if (first != null && pre.val >= root.val) {
            //第二个节点
            second = root;
        }

        //更新pre
        pre = root;

        midOrder(root.right);
    }
}
