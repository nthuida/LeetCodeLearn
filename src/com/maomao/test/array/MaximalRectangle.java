package com.maomao.test.array;

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
        char[][] a = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(new MaximalRectangle().maximalRectangle(a));
    }
}
