package com.maomao.test.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * @auther: huida
 * @date: 2024/4/24
 */
public class FourSum {

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<nums.length-3; i++) {
            //剪枝 需要nums[i] > 0 解决数组是[-4, -3, -2, -1]，target是-10
            if (nums[i] > 0 && nums[i] > target) {
                break;
            }
            //num[i]去重
            if (i>0 && nums[i-1] == nums[i]) {
                continue;
            }
            for (int j=i+1; j<nums.length-2; j++) {

                //num[j]去重 j > i+1  解决[2,2,2,2,2] 8 重复
                if (j > i+1 && nums[j-1] == nums[j]) {
                    continue;
                }
                int left = j+1;
                int right = nums.length-1;
                while (left < right) {
                    if (nums[i]+ nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        List<Integer> list = Arrays.asList(nums[i], nums[j],nums[left], nums[right]);
                        res.add(list);
                        left++;
                        right--;
                        //left 和 right去重
                        while (left < right && nums[left] == nums[left-1]) {
                            left++;
                        }
                        while (left <right && nums[right] == nums[right+1]) {
                            right--;
                        }

                    }
                }

            }
        }
        return res;
    }
}
