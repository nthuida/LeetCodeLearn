package com.maomao.test.array;

import java.util.Stack;

/**
 * 最大矩形
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 *
 * @author huida
 * @date 2020/7/7
 */
public class MaximalRectangle {

    /**
     * 求出每一行的高度，转化为柱形图，然后求柱状图中最大的矩形
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int max = 0;
        for (int i=0; i<matrix.length; i++) {
            //计算每行1的高度
            for (int j=0; j< matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] +=1;
                } else {
                    heights[j] = 0;
                }
            }
            max = Math.max(max, largestRectangleArea(heights));
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] newHeight = new int[len+2];
        //数组一头一尾增加两个0，方便计算以头尾两个柱子为高度的矩形面积
        for (int i=0; i<len; i++) {
            newHeight[i+1] = heights[i];
        }
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

    public static void main(String[] args) {
        char[][] a = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(new MaximalRectangle().maximalRectangle(a));
    }
}
