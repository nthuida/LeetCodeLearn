package com.maomao.test.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * @author huida
 * @date 2020/5/15
 */
public class SubarraySum {

    /**
     * 前缀和
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int preSum = 0;
        //key对应前缀和，value对应出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        //前缀和0出现的次数为1；
        map.put(0,1);
        for (int i :nums) {
            //计算前缀和
            preSum += i;
            //preSum-k是想要找的前缀和，计数
            count += map.getOrDefault(preSum-k, 0);
            //保存前缀和对应的次数；
            map.put(preSum, map.getOrDefault(preSum,0)+1);
        }
        return count;
    }
}
