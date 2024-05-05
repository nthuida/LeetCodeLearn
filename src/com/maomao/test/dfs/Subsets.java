package com.maomao.test.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * @author huida
 * @date 2020/7/4
 */
public class Subsets {
    /**
     * 回溯
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        backTrack(0, nums, res, list);
        return res;
    }

    private void backTrack(int start, int[] nums, List<List<Integer>> res, LinkedList<Integer> list) {
        res.add(new LinkedList<>(list));
        for (int i=start; i<nums.length; i++) {
            list.add(nums[i]);
            //回溯
            backTrack(i+1, nums, res, list);
            //撤销
            list.removeLast();
        }
    }
}
