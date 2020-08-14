package com.maomao.test.array;

/**
 * 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 *
 * @author huida
 * @date 2020/8/11
 */
public class Solve {

    /**
     * 所有的不被包围的 O 都直接或间接与边界上的 O 相连
     * 对于每一个边界上的 O，我们以它为起点，标记所有与它直接或间接相连的字母 O；
     * 最后我们遍历这个矩阵，对于每一个字母：
     * 如果该字母被标记过，则该字母为没有被字母 X 包围的字母 O，我们将其还原为字母 O；
     * 如果该字母没有被标记过，则该字母为被字母 X 包围的字母 O，我们将其修改为字母 X。
     *
     * dfs
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                //判断边界
                boolean isEdge = i == 0 || j == 0 || i == row - 1 || j == col - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }

            }
        }
        //重新标记
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (x <0 || x>= board.length || y<0 || y>= board[0].length || board[x][y] != 'O') {
            return;
        }
        //标记
        board[x][y] = 'A';
        //上
        dfs(board, x-1, y);
        //下
        dfs(board, x+1, y);
        //左
        dfs(board, x, y-1);
        //右
        dfs(board, x, y+1);
    }
}
