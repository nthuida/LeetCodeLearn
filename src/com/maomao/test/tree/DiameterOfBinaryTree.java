package com.maomao.test.tree;

/**
 * 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * @author huida
 * @date 2020/6/1
 */
public class DiameterOfBinaryTree {
    int ans = 0;

    /**
     * 二叉树的直径，就是每个节点左右子树深度之和的最大值
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getTreeDepth(root);
        return ans;
    }

    /**
     * 求树的深度
     * @param root
     * @return
     */
    public int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getTreeDepth(root.left);
        int rightDepth = getTreeDepth(root.right);
        int myDepth = leftDepth + rightDepth;
        //更新直径
        ans = Math.max(ans, myDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
