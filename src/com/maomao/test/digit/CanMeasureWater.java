package com.maomao.test.digit;

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
     * 广度优先搜索
     * 定义有序整数对 (a, b) 表示当前 A 和 B 两个水壶的水量，
     * @param x
     * @param y
     * @param z
     * @return
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return x == z || y == z;
        }
        //保存水壶的水量
        Queue<List<Integer>> queue = new LinkedList<>();
        //判断状态去重
        Set<List<Integer>> set = new HashSet<>();
        //起点，都为空(0,0)
        List<Integer> list = Arrays.asList(0, 0);
        queue.offer(list);
        set.add(list);

        while (!queue.isEmpty()) {
            List<Integer> temp = queue.poll();
            //a的水量
            int cur_x = temp.get(0);
            //b的水量
            int cur_y = temp.get(1);
            if (z == cur_x || z == cur_y || z == cur_x + cur_y) {
                return true;
            }
            //1、给x加满水
            List<Integer> condition1 = Arrays.asList(x, cur_y);
            if (!set.contains(condition1)) {
                set.add(condition1);
                queue.offer(condition1);
            }
            //2、给y加满水
            List<Integer> condition2 = Arrays.asList(cur_x, y);
            if (!set.contains(condition2)) {
                set.add(condition2);
                queue.offer(condition2);
            }
            //3、清空x的水
            List<Integer> condition3 = Arrays.asList(0, cur_y);
            if (!set.contains(condition3)) {
                set.add(condition3);
                queue.offer(condition3);
            }
            //4、清空y的水
            List<Integer> condition4 = Arrays.asList(cur_x, 0);
            if (!set.contains(condition4)) {
                set.add(condition4);
                queue.offer(condition4);
            }
            //5、x给y倒水
            List<Integer> condition5 = (cur_x + cur_y >= y) ?
                    Arrays.asList(cur_x + cur_y - y, y) :
                    Arrays.asList(0, cur_x + cur_y);
            if (!set.contains(condition5)) {
                set.add(condition5);
                queue.offer(condition5);
            }
            //6、y给x倒水
            List<Integer> condition6 = (cur_x + cur_y >= x) ?
                    Arrays.asList(x, cur_x + cur_y - x) :
                    Arrays.asList(cur_x + cur_y, 0);
            if (!set.contains(condition6)) {
                set.add(condition6);
                queue.offer(condition6);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CanMeasureWater().canMeasureWater(2,6,5));
    }
}
