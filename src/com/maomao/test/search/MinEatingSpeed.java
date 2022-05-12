package com.maomao.test.search;

/**
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。
 * 如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * 示例 1：
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 *
 * 示例 2：
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 *
 * @author: huida
 * @date: 2021/12/17
 **/
public class MinEatingSpeed {

    public int minEatingSpeed(int[] piles, int h) {
        //最小速度
        int low = 1;
        //最大速度
        int high = 0;
        for (int i : piles) {
            if (i > high) {
                high = i;
            }
        }
        //二分查找左边界
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (count(piles, mid) <= h) {
                //收缩右边边界
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    /**
     * 计算时间
     * @param piles
     * @param speed
     * @return
     */
    private int count(int[] piles, int speed) {
        int sum = 0;
        for (int i : piles) {
            sum += i/speed;
            if (i % speed != 0) {
                sum++;
            }
        }
        return sum;
    }

}
