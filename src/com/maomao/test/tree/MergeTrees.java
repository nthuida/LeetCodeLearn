package com.maomao.test.tree;

/**
 * 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
 * 否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 *
 * @author huida
 * @date 2020/6/24
 */
public class MergeTrees {

    /**
     * 前序遍历
     * 两棵树同时进行前序遍历，并将对应的节点进行合并
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 1.合并当前节点
        // t1没有，而t2有的节点，直接返回t2
        if (t1 == null) {
            return t2;
        }
        // t1有，而t2没有的节点，t1不变，直接返回
        if (t2 == null) {
            return t1;
        }
        // t1和t2都有的节点，节点值相加，更新t1的值
        t1.val += t2.val;

        // 2.递归合并左子树和右子树
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }

    /**
     * 后序遍历实现
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTreesII(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode left = mergeTrees(root1.left, root2.left);
        TreeNode right = mergeTrees(root1.right, root2.right);

        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = left;
        root.right = right;
        return root;

    }
}
