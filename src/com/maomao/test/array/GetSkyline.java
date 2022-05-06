package com.maomao.test.array;

import java.util.*;

/**
 *  天际线问题
 *
 * 图A中所有建筑物的尺寸记录为：[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] 。
 *
 *
 * 图B中的天际线应该表示为：[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]。
 *
 * @author huida
 * @date 2020/9/23
 */
public class GetSkyline {

    /**
     * 使用扫描线，从左至右扫过。如果遇到左端点，将高度入堆，如果遇到右端点，则将高度从堆中删除。使用 last 变量记录上一个转折点。
     *
     * 技巧
     * 存左上角坐标的时候， 将高度（y）存为负数。存右上角坐标的时候，将高度（y）存为正数。
     *
     * @param buildings
     * @return
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();

        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int[] build : buildings) {
            //插入左节点的高度
            if (!map.containsKey(build[0])) {
                map.put(build[0], new ArrayList<>());
            }
            map.get(build[0]).add(-build[2]);
            //插入右节点的高度
            if (!map.containsKey(build[1])) {
                map.put(build[1], new ArrayList<>());
            }
            map.get(build[1]).add(build[2]);
        }
        //保留当前位置的所有高度 重定义排序：从大到小
        Map<Integer, Integer> heights = new TreeMap<>((o1, o2) -> o2 - o1);
        //保留上一个位置的横坐标及高度
        int[] last = {0, 0};

        for (int key : map.keySet()) {
            List<Integer> yArrays = map.get(key);
            //排序
            Collections.sort(yArrays);

            for (int y : yArrays) {
                //左端点,高度入队
                if (y < 0) {
                    int val = heights.getOrDefault(-y, 0);
                    heights.put(-y, val + 1);
                } else {
                    //右端点移除高度
                    int val = heights.getOrDefault(y, 0);
                    if (val == 1) {
                        heights.remove(y);
                    } else {
                        heights.put(y, val - 1);
                    }
                }
                //获取heights的最大值:就是第一个值
                Integer maxHeight = 0;
                if (!heights.isEmpty()) {
                    maxHeight = heights.keySet().iterator().next();
                }

                //如果当前最大高度不同于上一个高度，说明其为转折点
                if (last[1] != maxHeight) {
                    //更新last，并加入结果集
                    last[0] = key;
                    last[1] = maxHeight;
                    res.add(Arrays.asList(key, maxHeight));
                }
            }
        }

        return res;
    }

}
