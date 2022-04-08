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
     * 解题思路：先对数组排序，然后固定一个数，使用两指针往中间夹，直到找出所有的解。
     * 时间复杂度 O(n^2).
     * 主要优化重复的情况
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0) {
                //如果当前数字大于0，则三数之和一定大于0，所以结束循环
                break;
            }
            //去重
            if(k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int left = k+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[k] + nums[left] + nums[right];
                if(sum < 0){
                    left++;
                    //去重
                    while(left < right && nums[left-1] == nums[left]) {
                        left++;
                    }

                } else if (sum > 0) {
                    right--;
                    while(left < right && nums[right+1] == nums[right]) {
                        right--;
                    }
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[left], nums[right])));
                    left++;
                    right--;
                    //去重
                    while(left < right && nums[left-1] == nums[left]) {
                        left++;
                    }
                    while(left < right && nums[right+1] == nums[right]) {
                        right--;
                    }
                    left++;
                    right--;
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
