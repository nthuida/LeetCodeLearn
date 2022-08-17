package com.maomao.test.stack.monotoneStack;

import java.util.Stack;

/**
 * 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 示例:
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * @author huida
 * @date 2020/6/1
 */
public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i=0;i<heights.length;i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j=i; j<heights.length; j++) {
                int width = j-i+1;
                //关键：最小高度
                minHeight = Math.min(minHeight, heights[j]);
                int area = width * minHeight;
                if (area > max) {
                    max = area;
                }
            }
        }
        return max;
    }

    /**
     * 暴力解
     * 枚举以每个柱形为高度的最大矩形的面积。
     * 具体来说是：依次遍历柱形的高度，对于每一个高度分别向两边扩散，
     * 直到边界索引对应的柱形高度小于当前考察的柱形的高度，求出以当前高度为矩形的最大宽度多少。
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        int max = 0;
        for (int i=0;i<heights.length;i++) {
            int high = heights[i];
            //左边界开始索引
            int leftIndex = i;
            //寻找比当前柱形低的索引
            while (leftIndex>0 && heights[leftIndex-1] >= high) {
                leftIndex--;
            }
            //右边界
            int rightIndex = i;
            //寻找比当前柱子低的索引
            while (rightIndex < heights.length-1 && heights[rightIndex+1] >= high) {
                rightIndex++;
            }
            int width = rightIndex-leftIndex+1;
            max = Math.max(max, width*high);
        }
        return max;
    }

    /**
     * 单调栈法
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        int[] newHeight = new int[len+2];
        //数组一头一尾增加两个0，方便计算以头尾两个柱子为高度的矩形面积
        for (int i=0; i<len; i++) {
            newHeight[i+1] = heights[i];
        }
        //单调递增栈
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i=0; i<newHeight.length; i++) {
            //栈不为空，且当前元素的高度小于栈顶元素,则表示以栈顶元素值为高的矩形面积可以确定
            while (!stack.isEmpty() && newHeight[i] < newHeight[stack.peek()]) {
                //当前高度
                int curHeight = newHeight[stack.peek()];
                //出栈
                stack.pop();
                //栈顶元素弹出后，新的栈顶元素就是其左侧边界索引，因为是单调递增
                int leftIndex = stack.peek();
                //右边界是当前索引
                int rightIndex = i;
                //宽度
                int width = rightIndex-leftIndex-1;
                max = Math.max(max, width*curHeight);
            }
            //递增，进栈
            stack.add(i);
        }
        return max;
    }

}
