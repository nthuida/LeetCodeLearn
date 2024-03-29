package com.maomao.test.dfs;

/**
 * 划分为k个相等的子集
 * 给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 * 示例 1：
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *
 * @author: huida
 * @date: 2021/12/3
 **/
public class CanPartitionKSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) {
            return false;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum/k;
        boolean[] used = new boolean[nums.length];
        return backtrack(nums, k, 0, target, 0, used);
    }


    public boolean backtrack(int[] num, int k, int start, int target, int bucket, boolean[] used) {
        //结束条件，剩余的子集个数为0
        if (k == 0) {
            return true;
        }
        if (bucket == target) {
            // 装满了当前桶，递归穷举下一个桶的选择
            // 让下一个桶从 nums[0] 开始选数字
            return backtrack(num, k-1, 0, target, 0, used);
        }
        for (int i=start; i<num.length; i++) {
            if (used[i]) {
                continue;
            }
            if (num[i] + bucket > target) {
                //剪枝
                continue;
            }
            //选择
            bucket += num[i];
            used[i] = true;
            // 有一个结果就返回
            if (backtrack(num, k, i+1, target, bucket, used)) {
                return true;
            }
            //撤销选择
            used[i] = false;
            bucket -= num[i];
        }
        return false;
    }
}
