package com.maomao.test.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * @Author huida.mao
 * @Date 2019/12/20
 */
public class Permute {

    /**
     * 回溯算法框架
     * def backtrack(路径, 选择列表):
     *     if 满足结束条件:
     *         result.add(路径)
     *         return
     *
     *     for 选择 in 选择列表:
     *         做选择
     *         backtrack(路径, 选择列表)
     *         撤销选择
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        //路径
        LinkedList<Integer> track = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, track, result);
        return result;
    }

    public void backtrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> result) {
        // 触发结束条件
        if (track.size() == nums.length) {
            result.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track, result);
            // 取消选择
            track.removeLast();
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Permute().permute(nums));
    }
}
