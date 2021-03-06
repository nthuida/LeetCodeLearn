package com.maomao.test.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中第二小的节点
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 *
 * 示例 2:
 *
 * 输入:
 *     2
 *    / \
 *   2   2
 *
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
 *
 * @author huida
 * @date 2020/6/28
 */
public class FindSecondMinimumValue {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        midOrder(root, list);
        long min = (long)Integer.MAX_VALUE + 1;
        long secondMin = (long)Integer.MAX_VALUE + 1;
        for (int i=0; i<list.size(); i++) {
            if (list.get(i) < min) {
                secondMin = min;
                min = list.get(i);
            } else {
                if (list.get(i) <= secondMin && list.get(i) > min) {
                    secondMin = list.get(i);
                }
            }
        }
        return secondMin == (long)Integer.MAX_VALUE + 1 ? -1: (int) secondMin;
    }

    private void midOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            midOrder(root.left, list);
            list.add(root.val);
            midOrder(root.right, list);
        }
    }

    int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
    int count = 0;

    /**
     * 先序遍历整棵树,首先定义 first 和 second 分别接收第一小第二小值,初始化为最大值,count 表示 second 被赋值与否,
     * 如果 count == 0,那么此树为单值二叉树,所以返回 -1 ,如果count 不为 0,那么此树有两个及以上的值,当first < 第二小的值 <= second,count为1并为second赋值;
     *

     * @param root
     * @return
     */
    public int findSecondMinimumValueII(TreeNode root) {
        helper(root);
        return count == 0 ? -1 : second;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val < first) {
            second = first;
            first = root.val;
        } else if (root.val > first && root.val <= second) {
            count++;
            second = root.val;
        }
        helper(root.left);
        helper(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(5);
        root.left = left;
        root.right = right;
        System.out.println(new FindSecondMinimumValue().findSecondMinimumValueII(root));
    }
}
