package com.maomao.test.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * @author Administrator
 * @date 2019/4/23
 */
public class ThreeSum {
    /**
     * 解题思路：先对数组排序，然后开始遍历，对于数组中的每一个元素，用两指针往中间夹，
     * 直到找出所有的解。时间复杂度 O(n^2).
     * 超时
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
                break;
            }
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[left]);
                    res.add(nums[right]);
                    if (!result.contains(res)) {
                        result.add(res);
                    }
                    //找到，也要+1继续往前找
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    /**
     * 主要优化重复的情况
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0) {
                // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
                break;
            }
            if(k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int left = k+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[k] + nums[left] + nums[right];
                if(sum < 0){
                    //去重
                    while(left < right && nums[left] == nums[++left]) {
                        continue;
                    }
                } else if (sum > 0) {
                    while(left < right && nums[right] == nums[--right]) {
                        continue;
                    }
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[left], nums[right])));
                    //去重
                    while(left < right && nums[left] == nums[++left]) {
                        continue;
                    }
                    while(left < right && nums[right] == nums[--right]) {
                        continue;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        List<List<Integer>> result = new ThreeSum().threeSum(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }

    }
}
