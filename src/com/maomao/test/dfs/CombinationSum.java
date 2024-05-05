package com.maomao.test.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
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
        backtrack(candidates, track, result, target, 0, 0);
        return result;
    }

    public void backtrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> result, int target, int start, int sum) {
        //结束条件
        if (sum == target) {
            result.add(new LinkedList(track));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            //选择
            track.add(nums[i]);
            sum += nums[i];
            //递归
            backtrack(nums, track, result, target, i, sum);
            sum -= nums[i];
            //取消选择
            track.removeLast();
        }
    }

    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
     * candidates 中的每个数字在每个组合中只能使用一次。
     * 说明：
     * 所有数字（包括目标数）都是正整数。
     * 解集不能包含重复的组合。 
     *
     * 示例 1:
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
        backtrack2(candidates, track, result, target, 0, 0);
        return result;
    }

    public void backtrack2(int[] nums, LinkedList<Integer> track, List<List<Integer>> result, int target, int start, int sum) {
        //结束条件
        if (target == sum) {
            result.add(new LinkedList(track));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            //排好序，防止得到的组合重复，同层使用过的元素去重
            if (i > start && nums[i-1] == nums[i]) {
                continue;
            }
            //选择
            track.add(nums[i]);
            sum += nums[i];
            //递归 区别：i+1 从下一个索引开始
            backtrack2(nums, track, result, target, i+1, sum);
            //取消选择
            sum -= nums[i];
            track.removeLast();
        }
    }

    /**
     * 找出所有相加之和为 n 的k个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     *
     * 说明：
     * 所有数字都是正整数。
     * 解集不能包含重复的组合。 
     *
     * 示例 1:
     * 输入: k = 3, n = 7
     * 输出: [[1,2,4]]
     *
     * 示例 2:
     * 输入: k = 3, n = 9
     * 输出: [[1,2,6], [1,3,5], [2,3,4]]
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack3(res, 1, 0, k, n, track);
        return res;
    }

    private void backtrack3(List<List<Integer>> res, int start, int sum, int k, int n, LinkedList<Integer> track) {
        //终止条件
        if (track.size() == k && n==sum) {
            res.add(new ArrayList<>(track));
            return;
        }

        //剪枝
        if (sum > n) {
            return;
        }

        // 不重复，要从上一个选择之后的下一个值开始
        for (int i=start; i<=9; i++) {
            //选择
            track.add(i);
            sum += i;
            //递归
            backtrack3(res, i+1, sum, k, n, track);
            //回溯
            sum -= i;
            track.removeLast();
        }
    }
}
