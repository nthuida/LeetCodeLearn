package com.maomao.test.dfs;

import java.util.ArrayList;
import java.util.Arrays;
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
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, track, result, visited);
        return result;
    }

    public void backtrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> result, boolean[] visited) {
        // 触发结束条件
        if (track.size() == nums.length) {
            result.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (visited[i]) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            visited[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, result, visited);
            // 取消选择
            track.removeLast();
            visited[i] = false;
        }

    }

    /**
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     *
     * 示例:
     *
     * 输入: [1,1,2]
     * 输出:
     * [
     *   [1,1,2],
     *   [1,2,1],
     *   [2,1,1]
     * ]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrackII(nums, track, result, visited);
        return result;
    }

    /**
     *
     * 首先，先要给nums进行排序，这样的做目的是方便剪枝
     * 其次，我们已经选择过的不需要再放进去了
     * 接下来，如果当前节点与他的前一个节点一样，并且他的前一个节点已经被遍历过了，那我们也就不需要了。
     *
     * @param nums
     * @param track
     * @param result
     */
    public void backtrackII(int[] nums, LinkedList<Integer> track, List<List<Integer>> result, boolean[] visited) {
        // 触发结束条件
        if (track.size() == nums.length) {
            result.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            //如果当前节点与他的前一个节点一样，且他的前一个节点已经被遍历过了，就剪枝
            // 写 !visited[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if(i>0 && nums[i] == nums[i-1] && !visited[i-1]) {
                continue;
            }
            //做出选择
            track.add(nums[i]);
            visited[i] = true;
            backtrackII(nums,track,result, visited);
            //撤销选择
            track.removeLast();
            visited[i] = false;

        }

    }

}
