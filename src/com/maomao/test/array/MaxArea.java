package com.maomao.test.array;

/**
 * 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 示例：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * @author Administrator
 * @date 2020/5/8
 */
public class MaxArea {

    /**
     * 循环比较
     * 复杂度 O(N^2) 超时
     * @param height
     * @return
     */
    public int maxAreaII(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j=i+1; j<height.length; j++) {
                int x = j-i;
                int y = Math.min(height[i],height[j]);
                int area = x*y;
                if (area > max) {
                    max = area;
                }
            }
        }
        return max;
    }


    /**
     * 双指针法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left < right) {
            //从两端开始计算面积
            int area = (right-left) * Math.min(height[left], height[right]);
            max = Math.max(area, max);
            if (height[left] < height[right]) {
                //左边比右边的高度低，只有左移，面积才有可能更大
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

}
