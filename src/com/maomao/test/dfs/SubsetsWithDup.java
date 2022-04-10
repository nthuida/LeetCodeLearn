package com.maomao.test.dfs;

import java.util.*;

/**
 * 子集
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * @author huida
 * @date 2020/9/25
 */
public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.sort(nums);
        backTrack(0, nums, res, list);
        return res;
    }
    private void backTrack(int start, int[] nums, List<List<Integer>> res, LinkedList<Integer> list) {
        res.add(new LinkedList<>(list));
        for (int i=start; i<nums.length; i++) {
            // 剪枝逻辑，值相同的相邻树枝，只遍历第一条
            if (i>start && nums[i-1] == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            //回溯
            backTrack(i+1, nums, res, list);
            //撤销
            list.removeLast();
        }
    }
}
