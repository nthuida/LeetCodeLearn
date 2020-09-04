package com.maomao.test.digit;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例：
 *
 * 输入：4
 * 输出：[
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *  
 * 提示：
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 * @author huida
 * @date 2020/9/3
 */
public class SolveNQueens {


    /**
     * 回溯
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        //初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        solve(res, chess, 0);
        return res;
    }

    private void solve(List<List<String>> res, char[][] chess, int row) {
        //退出条件，到达最后一行
        if (row == chess.length) {
            //转为list
            res.add(construct(chess));
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            //判断
            if (valid(chess, row, col)) {
                chess[row][col] = 'Q';
                //下一行
                solve(res, chess, row + 1);
                //回溯
                chess[row][col] = '.';
            }
        }
    }


    private boolean valid(char[][] chess, int row, int col) {
        //判断当前坐标位置的上面有没有皇后
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的右上角有没有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的左上角有没有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> construct(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            path.add(new String(chess[i]));
        }
        return path;
    }

    public static void main(String[] args) {
        List<List<String>> res = new SolveNQueens().solveNQueens(4);
        System.out.println(res);
    }

}
