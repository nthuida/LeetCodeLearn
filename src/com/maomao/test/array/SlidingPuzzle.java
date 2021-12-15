package com.maomao.test.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 滑动谜题
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 *
 * 示例：
 *
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 * 移动 5 次: [[1,2,3],[4,5,0]]
 *
 * @author: huida
 * @date: 2021/12/15
 **/
public class SlidingPuzzle {

    /**
     * BFS 把二维矩阵转为一维
     * @param board
     * @return
     */
    public int slidingPuzzle(int[][] board) {
        //目标
        String target = "123450";
        //二维转一维，作为起点字符串
        StringBuffer buffer = new StringBuffer();
        for (int i=0; i<2; i++) {
            for (int j=0; j<3; j++) {
                buffer.append(board[i][j]);
            }
        }
        String start = buffer.toString();
        Queue<String> queue = new LinkedList<>();
        //记录重复字符串
        Set<String> visited = new HashSet<>();
        //次数
        int step = 0;
        // 记录一维字符串的相邻索引
        int[][] neighbor = new int[][]{
                {1, 3},
                {0, 4, 2},
                {1, 5},
                {0, 4},
                {3, 1, 5},
                {4, 2}
        };
        //BFS框架
        queue.add(start);
        visited.add(start);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String str = queue.poll();
                if (target.equals(str)) {
                    return step;
                }
                int index = 0;
                //找到0的索引
                while(str.charAt(index) != '0') {
                    index++;
                }
                //相邻索引，移动替换
                for (int j : neighbor[index]) {
                    //移动
                    String s = swap(str, index , j);
                    if (!visited.contains(s)) {
                        queue.add(s);
                        visited.add(s);
                    }
                }
            }
            step++;
        }

        return -1;
    }

    private String swap(String s, int i, int j) {
        char[] ch = s.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }
}
