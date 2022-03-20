package com.maomao.test.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @author huida
 * @date 2020/6/5
 */
public class SpiralOrder {

    /**
     * 从上到右到下再到左遍历
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int upBound = 0;
        int downBound = row-1;
        int leftBound = 0;
        int rightBound = col-1;
        List<Integer> res = new ArrayList<>();

        while (res.size() < col * row) {
            //遍历上
            if (upBound <= downBound) {
                for(int i=leftBound; i<=rightBound; i++) {
                    res.add(matrix[upBound][i]);
                }
                //下移
                upBound++;
            }
            //遍历右
            if (leftBound <= rightBound) {
                for(int i=upBound; i<=downBound; i++) {
                    res.add(matrix[i][rightBound]);
                }
                //左移
                rightBound--;
            }
            //遍历下
            if (upBound <= downBound) {
                for (int i=rightBound; i>=leftBound; i--) {
                    res.add(matrix[downBound][i]);
                }
                //上移
                downBound--;
            }
            //遍历左
            if (leftBound <= rightBound) {
                for (int i=downBound; i>=upBound; i--) {
                    res.add(matrix[i][leftBound]);
                }
                //右移
                leftBound++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6 ,7,8}, {9,10,11,12}};
        List<Integer> result = new SpiralOrder().spiralOrder(matrix);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
