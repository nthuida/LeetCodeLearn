package com.maomao.test.array;

import java.util.Arrays;

/**
 * 使数组唯一的最小增量
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * 示例 1:
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 *
 * 示例 2:
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 *
 * 提示：
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 *
 * @author huida
 * @date 2020/6/3
 */
public class MinIncrementForUnique {

    /**
     * 先排序，再依次遍历数组元素，若当前元素小于等于它前一个元素，则将其变为前一个数 +1。
     * @param A
     * @return
     */
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for (int i=1; i<A.length; i++) {
            if (A[i] <= A[i-1]) {
                int temp = A[i];
                A[i] = A[i-1] + 1;
                count += (A[i] - temp);
            }
        }
        return count;
    }
}
