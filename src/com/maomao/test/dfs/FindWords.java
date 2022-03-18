package com.maomao.test.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词搜索II
 *  给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 示例:
 *
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 *
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 *
 * @author huida
 * @date 2020/9/22
 */
public class FindWords {

    int[][] direction = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        if (board.length == 0 || words.length == 0) {
            return list;
        }
        for (String word : words) {
            if (exist(board,  word)) {
                list.add(word);
            }
        }
        return list;
    }



    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        if (row*col < word.length()) {
            return false;
        }
        boolean[][] visited = new boolean[row][col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                //从(0, 0)开始匹配
                if (dfs(board, i, j, word,0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
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
                if (dfs(board, newX, newY, word, index+1, visited)) {
                    return true;
                }
            }
            //失败的时候回溯
            visited[i][j] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] a = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'}, {'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(new FindWords().findWords(a, words));
    }
}
