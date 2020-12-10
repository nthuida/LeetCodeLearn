package com.maomao.test.array;

import java.util.Arrays;

/**
 * 三角形的最大周长
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 * 示例 1：
 * 输入：[2,1,2]
 * 输出：5
 *
 * 示例 2：
 * 输入：[1,2,1]
 * 输出：0
 *
 * 示例 3：
 * 输入：[3,2,3,4]
 * 输出：10
 *
 * 示例 4：
 * 输入：[3,6,2,3]
 * 输出：8
 *
 * @author huida
 * @date 2020/12/10
 */
public class LargestPerimeter {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i=A.length-1; i>=2; i--) {
            //因为排序 a<=b<=c, 则a+c>b, b+c >a, 只需判断是否a+b>c
            if (A[i-1] + A[i-2] > A[i]) {
                //A[i-1] + A[i-2]小于A[i]，那么前面的数更小，所以没必要往前找了
                return A[i-1] + A[i-2] + A[i];
            }
        }
        return 0;
    }
}
