package com.maomao.test.array;

import java.util.*;

/**
 * 两数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 *
 * @Author huida.mao
 * @Date 2019/11/2
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums1) {
            set.add(num);
        }
        Set<Integer> res = new HashSet<>();
        for (Integer num : nums2) {
            if (set.contains(num) ) {
                res.add(num);
            }
        }
        int[] resArr = new int[res.size()];
        int index = 0;
        for (int value : res) {
            resArr[index++] = value;
        }
        return resArr;

    }

    /**
     * 示例 1:
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     *
     * 示例 2:
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     * 说明：
     *
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int i = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Integer num : nums2) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (map.containsKey(num) && (countMap.get(num) <= map.get(num))) {
                result[i++] = num;
            }
        }
        return Arrays.copyOf(result, i);
    }
}
