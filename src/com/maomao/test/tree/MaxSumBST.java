package com.maomao.test.tree;

/**
 * 二叉搜索子树的最大键值和
 * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 *
 * 二叉搜索树的定义如下：
 * 任意节点的左子树中的键值都 小于 此节点的键值。
 * 任意节点的右子树中的键值都 大于 此节点的键值。
 * 任意节点的左子树和右子树都是二叉搜索树。
 *  
 * 示例 1：
 * 输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
 * 输出：20
 * 解释：键值为 3 的子树是和最大的二叉搜索树。
 *
 * 示例 2：
 * 输入：root = [4,3,null,1,2]
 * 输出：2
 * 解释：键值为 2 的单节点子树是和最大的二叉搜索树。
 *
 * 示例 3：
 * 输入：root = [-4,-2,-5]
 * 输出：0
 * 解释：所有节点键值都为负数，和最大的二叉搜索树为空。
 *
 * 示例 4：
 * 输入：root = [2,1,3]
 * 输出：6
 *
 * @author: huida
 * @date: 2021/11/16
 **/
public class MaxSumBST {

    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        postOrder(root);
        return maxSum;
    }

    /**
     * 后序遍历 返回res[4]的数组
     * res[0] 记录以 root 为根的二叉树是否是 BST，若为 1 则说明是 BST，若为 0 则说明不是 BST；
     * res[1] 记录以 root 为根的二叉树所有节点中的最小值；
     * res[2] 记录以 root 为根的二叉树所有节点中的最大值；
     * res[3] 记录以 root 为根的二叉树所有节点值之和。
     * @param treeNode
     * @return
     */
    private int[] postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return new int[]{1,Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        //递归
        int[] left = postOrder(treeNode.left);
        int[] right = postOrder(treeNode.right);

        int[] res = new int[4];
        //该节点为二叉搜索树
        if (left[0] == 1 && right[0] == 1 && treeNode.val > left[2] && treeNode.val < right[1]) {
            res[0] = 1;
            //避免上面代码return new  int[]{1,Integer.MAX_VALUE,Integer.MIN_VALUE,0};
            //左子树为空或者右子树为空时，直接取左子树最小值时取到 Integer.MAX_VALUE，直接取右子树最大值时取到Integer.MIN_VALUE
            res[1] = Math.min(treeNode.val, left[1]);
            res[2] = Math.max(treeNode.val, right[2]);
            res[3] = left[3] + right[3] + treeNode.val;
            //更新最大值
            maxSum = Math.max(res[3], maxSum);
        }
        return res;
    }
}
