package com.maomao.test.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 直线上最多的点数
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 *
 * 示例 1:
 *
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 *
 * 示例 2:
 *
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 *
 * @author huida
 * @date 2020/9/23
 */
public class MaxPoints {

    /**
     * 固定一点求斜率，然后比较最大值
     * g
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {
        int row = points.length;
        if (row == 0) {
            return 0;
        }
        if (row == 1) {
            return 1;
        }
        int max = 0;
        for (int i=0; i<row-1; i++) {
            int tempMax = 0;
            int repeat = 0;
            //斜率计数
            Map<String, Integer> map = new HashMap<>();
            for (int j=i+1; j<row; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                if (dx == 0 && dy ==0) {
                    //两个点重合，也代表在一条直线上
                    repeat++;
                    continue;
                }
                //最大公约数
                int gcd = gcd(dy, dx);
                if (gcd != 0) {
                    dy /= gcd;
                    dx /= gcd;
                }
                String value = dy + "/" + dx;
                //计数
                map.put(value, map.getOrDefault(value, 0) + 1);
                tempMax = Math.max(tempMax, map.get(value));
            }
            max = Math.max(max, tempMax+1+repeat);
        }
        return max;
    }

    /**
     * 最大公约数
     * @param dy
     * @param dx
     * @return
     */
    private int gcd(int dy, int dx) {
        if (dx == 0){
            return dy;
        }  else {
            return gcd(dx, dy % dx);
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println(new MaxPoints().maxPoints(a));
    }

}
