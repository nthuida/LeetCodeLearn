package com.maomao.test.array;

/**
 * 搜索二维矩阵
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 *
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 * @author huida
 * @date 2020/9/24
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return false;
        }
        int rowTemp = 0;
        for (int i=0; i<row; i++) {
            if (target <= matrix[i][col-1]) {
                rowTemp = i;
                break;
            }
        }

        for (int j=0; j<col; j++) {
            if (matrix[rowTemp][j] == target) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{}};
        //int[][] a = {{1,   3,  5,  7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(new SearchMatrix().searchMatrix(a, 13));
    }
}
