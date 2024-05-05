package com.maomao.test.dfs;

import java.util.*;

/**
 * 非递减子序列
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 *
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 示例 2：
 *
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 * @auther: huida
 * @date: 2024/5/4
 */
public class FindSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        traceBack(nums, 0, path, res);
        return res;
    }

    private void traceBack(int[] nums, int start, LinkedList<Integer> track, List<List<Integer>> result) {
        if (track.size() >=2) {
            result.add(new ArrayList<>(track));
        }
        //同层使用过的元素
        Set<Integer> set = new HashSet<>();
        for (int i=start; i<nums.length; i++) {
            if (!track.isEmpty() && nums[i] < track.getLast()) {
                continue;
            }
            if (set.contains(nums[i])) {
                //同层使用过的元素去重，同组合和子集的去重
                continue;
            }
            set.add(nums[i]);
            track.add(nums[i]);
            traceBack(nums, i+1, track, result);
            track.removeLast();
        }
    }



}
