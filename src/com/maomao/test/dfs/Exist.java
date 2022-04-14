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

    //定义四个方向
    int[][] direction = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        if (row*col < word.length()) {
            return false;
        }
        boolean[][] visited = new boolean[row][col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                //从第一个相同的元素开始
                //if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word,0, visited)) {
                        return true;
                    }
                //}
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word, int index, boolean[][] visited) {
        //下标索引等于字符的长度，说明已找到，退出
        if (index == word.length()) {
            return true;
        }
        //越界
        if(x >= board.length || x < 0 || y >= board[0].length || y<0) {
            return false;
        }
        //已访问或者不相等
        if (visited[x][y] || board[x][y] != word.charAt(index)) {
            return false;
        }

        visited[x][y] = true;
        //四个方向搜索
        for (int[] direct : direction) {
            int newX = x + direct[0];
            int newY = y + direct[1];
            if (dfs(board, newX, newY, word, index+1, visited)) {
                return true;
            }
        }
        //回溯
        visited[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] a = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(new Exist().exist(a, word));
    }

}
