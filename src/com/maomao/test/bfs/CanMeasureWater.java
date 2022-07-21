package com.maomao.test.bfs;

import java.util.*;

/**
 * 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 *
 * 示例 1: (From the famous "Die Hard" example)
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 *
 * 示例 2:
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 *
 * @author huida
 * @date 2020/5/29
 */
public class CanMeasureWater {


    /**
     * 关注水的总量，每次增加或减少x、y
     * 1、A倒空；
     * 2、A装满；
     * 3、B倒空；
     * 4、B装满；
     * 5、A倒进B，直到B倒满或者A倒空；
     * 6、B倒进A，直到A倒满或者B倒空；
     * @param x
     * @param y
     * @param z
     * @return
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if (z < 0 || z > x + y) {
            return false;
        }
        //保存总量的状态
        Set<Integer> set = new HashSet<>();
        //水的总量
        Queue<Integer> q = new LinkedList<>();
        //初始化0
        q.offer(0);
        while (!q.isEmpty()) {
            int n = q.poll();
            //加X升水
            if (n + x <= x + y && !set.contains(n + x)) {
                set.add(n+x);
                q.offer(n + x);
            }
            //加Y升水
            if (n + y <= x + y && !set.contains(n + y)) {
                set.add(n + y);
                q.offer(n + y);
            }
            //减X升水
            if (n - x >= 0 && !set.contains(n - x)) {
                set.add(n-x);
                q.offer(n - x);
            }
            //减Y升水
            if (n - y >= 0 && !set.contains(n - y)) {
                set.add(n - y);
                q.offer(n - y);
            }
            if (set.contains(z)) {
                return true;
            }
        }
        return false;
    }

}
