package com.maomao.test.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 下一个更大元素
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * 找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。
 * 如果不存在，对应位置输出-1。
 *
 * 示例 1:
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 *
 * @Author huida.mao
 * @Date 2019/11/14
 */
public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        //保存nums2下一个更大元素
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<nums2.length; i++) {
            //栈非空，当前元素大于栈顶元素
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                int index = stack.pop();
                //保存结果
                map.put(nums2[index], nums2[i]);
            }
            stack.add(i);
        }
        for (int j=0; j<nums1.length; j++) {
            res[j] = map.getOrDefault(nums1[j], -1);
        }
        return res;
    }

    /**
     * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
     * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，
     * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
     *
     * 示例 1:
     * 输入: [1,2,1]
     * 输出: [2,-1,2]
     * 解释: 第一个 1 的下一个更大的数是 2；
     * 数字 2 找不到下一个更大的数；
     * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        //单调递减栈
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[len];
        Arrays.fill(res, -1);
        //循环数组，2*n
        for (int i=0; i<2*len; i++) {
            //栈不为空，且当前元素大于栈顶元素
            while (!stack.isEmpty() && nums[i%len] > nums[stack.peek()]) {
                //栈顶元素出栈
                int index = stack.pop();
                res[index] = nums[i%len];
            }
            //递减，下标索引入栈
            stack.add(i%len);
        }
        return res;
    }

}
