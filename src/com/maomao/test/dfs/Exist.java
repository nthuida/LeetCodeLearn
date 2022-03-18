package com.maomao.test.dfs;

/**
 * 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * @author huida
 * @date 2020/7/7
 */
public class Exist {

    private boolean[][] visited;
    int[][] direction = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        if (row*col < word.length()) {
            return false;
        }
        visited = new boolean[row][col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                //从(0, 0)开始匹配
                if (dfs(board, i, j, word,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        //最后一个元素或者只有一个元素{{a}}
        if (index == word.length()-1) {
            return board[i][j] == word.charAt(index);
        }
        if (board[i][j] == word.charAt(index)) {
            visited[i][j] = true;
            //四个方向搜索
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if(newX >= board.length || newX < 0 || newY >= board[0].length || newY < 0 || visited[newX][newY]) {
                    // 满足条件才有搜索的必要
                    continue;
                }
                if (dfs(board, newX, newY, word, index+1)) {
                    return true;
                }
            }
            //失败的时候回溯
            visited[i][j] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] a = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(new Exist().exist(a, word));
    }

}
