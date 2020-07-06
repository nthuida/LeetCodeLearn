package com.maomao.test.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 *
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 *
 * @author huida
 * @date 2020/7/6
 */
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        midOrder(root, list);
        return list.get(k-1);
    }

    public void midOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            midOrder(root.left, list);
            list.add(root.val);
            midOrder(root.right, list);
        }
    }
}
