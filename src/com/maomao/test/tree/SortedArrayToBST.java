package com.maomao.test.tree;

/**
 * 将有序数组转换为二叉搜索树
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @Author huida.mao
 * @Date 2019/10/21
 */
public class SortedArrayToBST {
    /**
     * 递归：已中间元素为根结点，左边的为左子树，右边的为右子树
     * 退出条件：左边比右边的大
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return BST(nums, 0 , nums.length-1);
    }

    public TreeNode BST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = BST(nums, left, mid -1);
        root.right = BST(nums, mid+1, right);
        return root;

    }
}
