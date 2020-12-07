package com.maomao.test.array;

/**
 * 翻转矩阵后的得分
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * 返回尽可能高的分数。
 *
 * 示例：
 *
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *
 * @author huida
 * @date 2020/12/7
 */
public class MatrixScore {
    /**
     * 1、每一行的第一位翻转为1；
     * 2、排除第一列翻转，使得1的个数最多
     * @param A
     * @return
     */
    public int matrixScore(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        //每行第一个非0的翻转
        for (int i=0; i<row; i++) {
            if (A[i][0] == 0) {
                for (int j=0; j<col; j++) {
                    A[i][j] = A[i][j] ^ 1;
                }
            }
        }

        int res = 0;
        for (int i=0; i<col;i++) {
            //统计每列1的个数
            int cnt = 0;
            for (int j=0; j<row;j++) {
                cnt += A[j][i];
            }
            // max(cnt, row- cnt) 表示这个位置最多有多少个 1。 1<<(col-i-1) 表示这个位置的1的大小
            res += Math.max(cnt, row-cnt) * (1<<(col-i-1));
        }

        return res;
    }
}
