package com.maomao.test.tree;

/**
 * 最长同值路径
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 * 2
 *
 * 示例 2:
 *
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 * 2
 *
 * @author huida
 * @date 2020/6/29
 */
public class LongestUnivaluePath {
    int res = 0;

    /**
     * 节点的最长同值路径 = 左节点单侧最长路径值 + 右节点单侧最长路径值
     * @param root
     * @return
     */
    public int longestUnivaluePath(TreeNode root) {
        arrowLength(root);
        return res;
    }

    /**
     * 返回以该节点为根节点的单侧最长同值路径
     * @param node
     * @return
     */
    public int arrowLength(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //左节点单侧最长路径
        int subLeft = arrowLength(node.left);
        //右节点单侧最长路径
        int subRight = arrowLength(node.right);
        //当前节点左侧最长同值路径
        int left = 0;
        //当前节点右侧最长同值路径
        int right=0;
        if (node.left!=null && node.left.val == node.val) {
            left += subLeft +1;
        }
        if (node.right!=null && node.right.val == node.val) {
            right += subRight +1;
        }
        //当前节点最长同值路径值
        res = Math.max(res, left+right);
        //返回该节点的最长单侧同值路径
        return Math.max(left, right);

    }
}
