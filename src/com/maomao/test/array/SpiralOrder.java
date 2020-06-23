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
    int k = 0;
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length ==0) {
            return new int[]{};
        }
        int row = matrix.length - 1;
        int column = matrix[0].length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        int leftUpRow = 0;
        int leftUpColumn = 0;
        while (leftUpRow <= row && leftUpColumn <= column) {
            print(matrix, leftUpRow++, leftUpColumn++, row--, column--, res);
        }
        return res;
    }

    /**
     * 打印外环矩阵:每次打印四个边
     * @param matrix
     * @param leftUpRow
     * @param leftUpColumn
     * @param rightDownRow
     * @param rightDownColumn
     * @param res
     */
    public void print(int[][] matrix, int leftUpRow, int leftUpColumn, int rightDownRow, int rightDownColumn, int[] res) {
        if (leftUpRow == rightDownRow) {
            //只有一行
            for (int i=leftUpColumn; i<=rightDownColumn; i++) {
                res[k++] = matrix[leftUpRow][i] ;
            }
        } else if (leftUpColumn == rightDownColumn) {
            //只有一列
            for (int i =leftUpRow; i<=rightDownRow; i++) {
                res[k++] = matrix[i][leftUpColumn];
            }
        } else {
            int tempRow = leftUpRow;
            int tempColumn = leftUpColumn;
            //上边
            while (tempColumn != rightDownColumn) {
                res[k++]=matrix[leftUpRow][tempColumn++];
            }
            //右边
            while (tempRow != rightDownRow) {
                res[k++] = matrix[tempRow++][rightDownColumn];
            }
            //下边
            while (tempColumn != leftUpColumn) {
                res[k++] = matrix[rightDownRow][tempColumn--];
            }
            //左边
            while (tempRow != leftUpRow) {
                res[k++] = matrix[tempRow--][leftUpColumn];
            }
        }
    }

    public List<Integer> spiralOrderII(int[][] matrix) {
        if (matrix.length ==0) {
            return new ArrayList<>();
        }
        int row = matrix.length - 1;
        int column = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        int leftUpRow = 0;
        int leftUpColumn = 0;
        while (leftUpRow <= row && leftUpColumn <= column) {
            printII(matrix, leftUpRow++, leftUpColumn++, row--, column--, res);
        }
        return res;
    }

    /**
     * 打印外环矩阵:每次打印四个边
     * @param matrix
     * @param leftUpRow
     * @param leftUpColumn
     * @param rightDownRow
     * @param rightDownColumn
     * @param res
     */
    public void printII(int[][] matrix, int leftUpRow, int leftUpColumn, int rightDownRow, int rightDownColumn,  List<Integer> res) {
        if (leftUpRow == rightDownRow) {
            //只有一行
            for (int i=leftUpColumn; i<=rightDownColumn; i++) {
               res.add(matrix[leftUpRow][i]);
            }
        } else if (leftUpColumn == rightDownColumn) {
            //只有一列
            for (int i =leftUpRow; i<=rightDownRow; i++) {
                res.add(matrix[i][leftUpColumn]);
            }
        } else {
            int tempRow = leftUpRow;
            int tempColumn = leftUpColumn;
            //上边
            while (tempColumn != rightDownColumn) {
                res.add(matrix[leftUpRow][tempColumn++]);
            }
            //右边
            while (tempRow != rightDownRow) {
                res.add(matrix[tempRow++][rightDownColumn]);
            }
            //下边
            while (tempColumn != leftUpColumn) {
                res.add(matrix[rightDownRow][tempColumn--]);
            }
            //左边
            while (tempRow != leftUpRow) {
                res.add(matrix[tempRow--][leftUpColumn]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6 ,7,8}, {9,10,11,12},{13,14,15,16}};
        /*int[] res = new SpiralOrder().spiralOrder(matrix);
        for (int i : res) {
            System.out.println(i);
        }*/
        List<Integer> result = new SpiralOrder().spiralOrderII(matrix);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
