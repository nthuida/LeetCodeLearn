package com.maomao.test.dfs;


import com.maomao.test.tree.TreeNode;

/**
 * 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 *
 * @author huida
 * @date 2020/7/1
 */
public class MaxPathSum {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    /**
     *   计算以root为起点的，最大单边路径和
     *   就是在以该节点为根节点的子树中寻找以该节点为起点的一条路径，使得该路径上的节点值之和最大。
     *   在计算过程中，更新最大路径和
     * @param root
     * @return
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //左节点贡献的最大值，大于0，优化为负的情况
        int leftMax = Math.max(dfs(root.left),0);
        //右节点
        int rightMax = Math.max(dfs(root.right),0);
        //路径和
        int pathLen = root.val + leftMax + rightMax;
        //路径和最大值
        max = Math.max(max, pathLen);
        //当前节点的最大单边路径
        return root.val + Math.max(leftMax, rightMax);
    }
}
