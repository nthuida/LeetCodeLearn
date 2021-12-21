package com.maomao.test.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 * 示例 1：
 * 输入:
 *
 *   5
 *  /  \
 * 2   -3
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 *
 * 示例 2：
 * 输入：
 *
 *   5
 *  /  \
 * 2   -5
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 *
 * @author: huida
 * @date: 2021/12/21
 **/
public class FindFrequentTreeSum {
    //和对应次数
    Map<Integer, Integer> sumToCount = new HashMap<>();
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        sum(root);
        List<Integer> list = new ArrayList<>();
        for (int val : sumToCount.keySet()) {
            if (sumToCount.get(val) == max) {
                list.add(val);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //后序遍历求和
        int left = sum(root.left);
        int right = sum(root.right);
        int sum = left + right + root.val;
        int val = sumToCount.getOrDefault(sum, 0)+1;
        //最大值
        max = Math.max(max, val);
        //计数
        sumToCount.put(sum, val);
        return sum;
    }
}
