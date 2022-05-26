package com.maomao.test.prefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 和可被 K 整除的子数组
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 * 示例：
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 * @author huida
 * @date 2020/5/27
 */
public class SubarraysDivByK {

    /**
     * 前缀和
     * (sum[j]-sum[i]) mod k = 0;
     * sum[i] mod k = sum[j] mod k;
     * @param nums
     * @param k
     * @return
     */
    public int subarraysDivByK(int[] nums, int k) {
        int preSum = 0;
        int count = 0;
        //key为前缀和sum[i]%k的值，value对应出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        //前缀和0 mod k 等于0， 出现1次
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            //前缀和为负，转为正数
            int key = (preSum % k + k) % k;
            count += map.getOrDefault(key, 0);
            //次数加1
            map.put(key, map.getOrDefault(key, 0) +1);
        }
        return count;
    }

}
