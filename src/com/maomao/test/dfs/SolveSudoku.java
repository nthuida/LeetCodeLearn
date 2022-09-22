package com.maomao.test.dfs;

/**
 * 解数独
 * 编写一个程序，通过填充空格来解决数独问题。
 * 数独的解法需 遵循如下规则：
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'表示
 *
 * @author: huida
 * @date: 2021/12/13
 **/
public class SolveSudoku {

    /**
     * 对每一个空着的格子穷举 1 到 9，如果遇到不合法的数字则跳过，
     * 如果找到一个合法的数字，则继续穷举下一个空格子。
     * 从第一行开始
     * @param board
     */
    public void solveSudoku(char[][] board) {
        backtrack(0, 0, board);
    }

    private boolean backtrack(int row, int col, char[][] board) {
        //退出条件，到达最后一行
        if (row == 9) {
            return true;
        }
        //到达一行的最后一列，重新开始下一行
        if (col == 9) {
            return backtrack(row+1, 0, board);
        }
        //已填过，继续下一列
        if (board[row][col] != '.') {
            return backtrack(row, col+1, board);
        }
        //开始填
        for(char i = '1'; i<='9'; i++) {
            //不满足条件，继续
            if (!valid(row, col, i, board)) {
                continue;
            }
            board[row][col] = i;
            if (backtrack(row, col+1, board)) {
                //找到一个结果，直接返回
                return true;
            }
            //回溯
            board[row][col] = '.';
        }

        //都不满足
        return false;
    }

    private boolean valid(int row, int col, char val, char[][] board) {
        for (int i=0; i<9; i++) {
            if (board[row][i] == val) {
                //检验列
                return false;
            }
            if (board[i][col] == val) {
                //检查行
                return false;
            }
        }

        // 判断 3 x 3 方框是否存在重复
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for (int i=startRow; i<startRow+3; i++) {
            for (int j=startCol; j<startCol+3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
