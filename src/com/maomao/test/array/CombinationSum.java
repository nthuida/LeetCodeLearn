package com.maomao.test.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * @Author huida.mao
 * @Date 2019/12/20
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //路径
        LinkedList<Integer> track = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        backtrack(candidates, track, result, target, 0);
        return result;
    }

    public void backtrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> result, int residue, int start) {
        //结束条件
        if (residue == 0) {
            result.add(new LinkedList(track));
            return;
        }
        for (int i = start; i < nums.length && residue - nums[i] >= 0; i++) {
            //选择
            track.add(nums[i]);
            //递归
            backtrack(nums, track, result, residue - nums[i], i);
            //取消选择
            track.removeLast();
        }
    }

    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用一次。
     *
     * 说明：
     *
     * 所有数字（包括目标数）都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1:
     *
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     *   [1, 7],
     *   [1, 2, 5],
     *   [2, 6],
     *   [1, 1, 6]
     * ]
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //路径
        LinkedList<Integer> track = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        backtrack2(candidates, track, result, target, 0);
        return result;
    }

    public void backtrack2(int[] nums, LinkedList<Integer> track, List<List<Integer>> result, int residue, int start) {
        //结束条件
        if (residue == 0) {
            result.add(new LinkedList(track));
            return;
        }
        for (int i = start; i < nums.length && residue - nums[i] >= 0; i++) {
            //排好序，防止得到的组合重复
            if (i > start && nums[i-1] == nums[i]) {
                continue;
            }
            //选择
            track.add(nums[i]);
            //递归 区别：i+1 从下一个索引开始
            backtrack(nums, track, result, residue - nums[i], i+1);
            //取消选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        System.out.println(new CombinationSum().combinationSum(nums, 7));
    }
}
