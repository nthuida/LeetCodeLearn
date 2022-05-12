package com.maomao.test.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计「优美子数组」
 * 给你一个整数数组 nums 和一个整数 k。
 * 如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目。
 *
 * 示例 1：
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 *
 * 示例 2：
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 *
 * 示例 3：
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *
 * @author huida
 * @date 2020/5/19
 */
public class NumberOfSubarrays {

    /**
     * 前缀和
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int preSum = 0;
        //key对应前缀和，value对应出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        //前缀和0出现的次数为1；
        map.put(0,1);
        for (int i :nums) {
            //计算前缀和
            if (i%2 ==1) {
                preSum += 1;
            }
            //preSum-k是想要找的前缀和，计数
            count += map.getOrDefault(preSum-k, 0);
            //保存前缀和对应的次数；
            map.put(preSum, map.getOrDefault(preSum,0)+1);
        }
        return count;
    }

}
