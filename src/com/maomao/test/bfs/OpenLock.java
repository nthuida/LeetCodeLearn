package com.maomao.test.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 *
 * 示例 1:
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 *
 * 示例 2:
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 *
 * 示例 3:
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 *
 * 示例 4:
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 *
 * @author: huida
 * @date: 2021/11/19
 **/
public class OpenLock {


    /**
     * BFS
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>();
        for (String s : deadends) {
            deadSet.add(s);
        }
        //初始值包含在死亡数组中，直接返回
        if (deadSet.contains("0000")) {
            return -1;
        }
        //记录已访问的数据
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String string = queue.poll();
                //找到返回
                if (string.equals(target)) {
                    return count;
                }
                //相邻的8个字符串
                for (int j=0; j<4; j++) {
                    String plus = plus(string, j);
                    //不在死亡数组和已访问数组
                    if (!deadSet.contains(plus) && !visited.contains(plus)) {
                        queue.add(plus);
                        visited.add(plus);
                    }
                    String minus = minus(string, j);
                    if (!deadSet.contains(minus) && !visited.contains(minus)) {
                        queue.add(minus);
                        visited.add(minus);
                    }

                }
            }
            //次数加1
            count++;
        }

        return -1;

    }

    /**
     * 向上拨动一位
     * @param s
     * @param index
     * @return
     */
    private String plus(String s, int index) {
        char[] chars = s.toCharArray();
        if (chars[index] == '9') {
            chars[index] = '0';
        } else {
            chars[index] += 1;
        }
        return new String(chars);
    }

    /**
     * 向下拨动一位
     * @param s
     * @param index
     * @return
     */
    private String minus(String s, int index) {
        char[] chars = s.toCharArray();
        if (chars[index] == '0') {
            chars[index] = '9';
        } else {
            chars[index] -= 1;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String[] a = {"8888"};
        System.out.println(new OpenLock().openLock(a, "0009"));
    }
}
