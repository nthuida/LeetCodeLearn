package com.maomao.test.dfs;

/**
 * 矩阵中的最长递增路径
 * 给定一个整数矩阵，找出最长递增路径的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 *
 * 示例 1:
 *
 * 输入: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 *
 * 示例 2:
 *
 * 输入: nums =
 * [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 *
 * @author huida
 * @date 2020/9/22
 */
public class LongestIncreasingPath {

    int[][] direction = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};

    /**
     * 由于同一个单元格对应的最长递增路径的长度是固定不变的
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        //保存访问过的单元格的最长递增路径
        int[][] visited = new int[row][col];
        int res = 0;
        //遍历求最大值
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                res = Math.max(res, dfs(matrix, i, j,visited));
            }
        }

        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] visited) {
        if (visited[i][j] != 0) {
            //已经计算过
            return visited[i][j];
        }
        //先加1
        ++visited[i][j];
        //上下左右比较得到最大值
        for (int[] dir : direction) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            if (newX >= 0 && newY >=0 && newX < matrix.length && newY < matrix[0].length && matrix[i][j] > matrix[newX][newY] ) {
                //满足条件matrix[i][j] > matrix[newX][newY]，再比较获取最大值
                visited[i][j] = Math.max(visited[i][j], dfs(matrix, newX, newY, visited) + 1);
            }
        }
        return visited[i][j];
    }
}
