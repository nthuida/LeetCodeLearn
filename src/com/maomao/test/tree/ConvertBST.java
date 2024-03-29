package com.maomao.test.tree;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 */
public class ConvertBST {

    /**
     * 先将右子树转换为累加树；并记录右子树的累加和rightSum;
     * 然后处理根节点，根节点的值 = 根节点值 + rightSum;
     * 然后转化左子树
     * @param root
     * @return
     */
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        //右子树
        convertBST(root.right);
        //累加和
        sum += root.val;
        //根节点
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
