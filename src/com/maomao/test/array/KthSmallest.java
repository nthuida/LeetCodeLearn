package com.maomao.test.array;

import java.util.Arrays;

/**
 * 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *
 * @author huida
 * @date 2020/7/2
 */
public class KthSmallest {

    public int kthSmallest(int[][] matrix, int k) {
        int[] nums = new int[matrix.length * matrix.length];
        int i=0;
        for (int j=0; j<matrix.length; j++) {
            for (int m=0; m<matrix.length; m++) {
                nums[i++] = matrix[j][m];
            }
        }
        Arrays.sort(nums);
        return nums[k-1];
    }

}
