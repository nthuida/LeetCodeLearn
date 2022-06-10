package com.maomao.test.array;

import java.util.Stack;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
 *
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * @author huida
 * @date 2020/5/12
 */
public class Trap {

    /**
     * 关键：在一个位置能容下的雨水量等于它左右两边柱子最大高度的最小值减去它的高度
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int sum = 0;
        //按列求，最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }
            int maxRight = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > maxRight) {
                    maxRight = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(maxLeft, maxRight);
            //只有较小的一端大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 动态规划
     * 定义状态：maxLeft[i]i左边列的做大值、maxRight[i]i右边列的最大值
     * 转移方程：maxLeft[i] = max(maxLeft[i-1], height[i-1])
     *         maxRight[i] = max(maxRight[i+1], height[i+1])
     * @param height
     * @return
     */
    public int trapII(int[] height){
        //左边列的最大值
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        for (int i=1; i<height.length-1; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }
        for (int j=height.length-2; j>=1; j--) {
            maxRight[j] = Math.max(maxRight[j+1], height[j+1]);
        }
        int sum = 0;
        for (int i=1; i<height.length-1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 单调栈
     * 只有产生凹陷的地方才能存储雨水, 那么高度一定是先减后增，所以可用单调栈
     * @param height
     * @return
     */
    public int trapIII(int[] height){
        int len = height.length;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<len; i++) {
            //栈不为空，且当前元素大于栈顶元素
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                //栈顶元素出栈
                int top = stack.pop();
                //栈里至少需要一个元素，即需要一个左墙
                if (!stack.isEmpty()) {
                    //宽度
                    int width = i-stack.peek()-1;
                    //左右两边取最小值
                    int min = Math.min(height[stack.peek()], height[i]);
                    res += (min - height[top]) * width;
                }
            }
            //递减，下标索引入栈
            stack.add(i);
        }
        return res;
    }
}
