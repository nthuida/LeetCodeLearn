package com.maomao.test.array;

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

    public static void main(String[] args) {
        int[] a = {2,1,5,6,2,3};
        System.out.println(new LargestRectangleArea().largestRectangleArea(a));
    }
}
