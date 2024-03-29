package com.maomao.test.array;

/**
 * 按奇偶排序数组 II
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *
 * @author huida
 * @date 2020/11/12
 */
public class SortArrayByParityII {

    /**
     * 双指针
     * A[i]为偶数 A[j]为奇数
     * @param A
     * @return
     */
    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                //遇到偶数
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }

}
