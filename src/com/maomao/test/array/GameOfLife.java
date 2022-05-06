package com.maomao.test.array;

/**
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：
 * 1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 *
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *
 * 示例：
 *
 * 输入：
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出：
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *
 * @author huida
 * @date 2020/5/16
 */
public class GameOfLife {

    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] update = new int[row][col];

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                int live = 0;
                int dead = 0;
                if ((i-1)>=0 && (j-1) >=0) {
                    if (board[i-1][j-1] == 0) {
                        dead++;
                    } else {
                        live++;
                    }
                }
                if ((i-1)>=0) {
                    if (board[i-1][j] == 0) {
                        dead++;
                    } else {
                        live++;
                    }
                }
                if ((i-1)>=0 && (j+1) <col) {
                    if (board[i-1][j+1] == 0) {
                        dead++;
                    } else {
                        live++;
                    }
                }
                if ((j-1) >=0) {
                    if (board[i][j-1] == 0) {
                        dead++;
                    } else {
                        live++;
                    }
                }
                if ((j+1) <col) {
                    if (board[i][j+1] == 0) {
                        dead++;
                    } else {
                        live++;
                    }
                }
                if ((i+1)<row && (j-1) >=0) {
                    if (board[i+1][j-1] == 0) {
                        dead++;
                    } else {
                        live++;
                    }
                }
                if ((i+1)<row) {
                    if (board[i+1][j] == 0) {
                        dead++;
                    } else {
                        live++;
                    }
                }
                if ((i+1)<row && (j+1) < col) {
                    if (board[i+1][j+1] == 0) {
                        dead++;
                    } else {
                        live++;
                    }
                }
                //判断存活
                if (board[i][j] == 0) {
                    if (live == 3) {
                        update[i][j] = 1;
                    } else {
                        update[i][j] = 0;
                    }
                } else {
                    if (live < 2 || live >3) {
                        update[i][j] = 0;
                    } else {
                        update[i][j] = 1;
                    }
                }

            }
        }
        // 更新
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = update[i][j];
            }
        }
    }

}
