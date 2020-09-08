package com.maomao.test.array;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * @author huida
 * @date 2020/9/8
 */
public class SetZeroes {

    public void setZeroes(int[][] matrix) {

        if (matrix.length == 0) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][]  visited = new boolean[row][col];

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j] ==0 && !visited[i][j]) {
                    //行和列都置为0
                    for (int n=0; n<row; n++) {
                        if (matrix[n][j] != 0) {
                            matrix[n][j] = 0;
                            visited[n][j] = true;
                        }
                    }

                    for (int m=0; m<col; m++) {
                        if (matrix[i][m] != 0) {
                            matrix[i][m] = 0;
                            visited[i][m] = true;
                        }
                    }
                }
            }
        }

    }
}
