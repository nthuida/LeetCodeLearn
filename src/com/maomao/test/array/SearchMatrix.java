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
        int col = matrix[0].length;
        int rowTemp = 0;
        for (int i=0; i<row; i++) {
            //找到对应的行数
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

    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列
     *
     * 从整个矩阵的右上角开始枚举，假设当前枚举的数是 x：
     * 如果 x 等于target，则说明我们找到了目标值，返回true；
     * 如果 x小于target，则 x左边的数一定都小于target，我们可以直接排除当前一整行的数；
     * 如果 x 大于target，则 x 下边的数一定都大于target，我们可以直接排除当前一整列的数
     * 复杂度O(m+n)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrixII(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = col-1;
        while (i<row && j>=0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                //左移一列
                j--;
            } else {
                //下移一行
                i++;
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
