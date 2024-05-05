package com.maomao.test.tree;

import java.util.ArrayList;
import java.util.List;

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
     * 中序遍历寻找错误的场景
     * 错误1：出现了两对不满足前小后大，需要交换第一对的第一个元素与第二对的第二个元素。
     * 错误2：只出现一对不满足前小后大，交换这一对元素即可。
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
        if (first == null && pre.val > root.val) {
            //第一个节点
            first = pre;
        }
        if (first != null && pre.val > root.val) {
            //第二个节点
            second = root;
        }
        //更新pre
        pre = root;

        midOrder(root.right);
    }

    public void recoverTreeII(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        midOrder(root,list);
        TreeNode first = null;
        TreeNode second = null;
        for (int i=0; i<list.size()-1; i++) {
            if (list.get(i).val > list.get(i+1).val) {
                if (first == null) {
                    first = list.get(i);
                }
                second = list.get(i+1);
            }
        }
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

    }

    private void midOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        midOrder(root.left, list);
        list.add(root);
        midOrder(root.right, list);
    }


    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, 0);
        return count;
    }

    private void dfs(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (sum == targetSum) {
            count++;
            return;
        }
        if (root.left != null) {
            dfs(root.left, targetSum, sum);
        }

        if (root.right != null) {
            dfs(root.right, targetSum, sum);
        }
    }
}
