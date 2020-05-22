package com.maomao.test.array;

/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * @author Administrator
 * @date 2019/3/24
 */
public class Rotate {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        for (int i=0; i<k; i++) {
           int temp = nums[len-1];
           for (int j = len-1; j>0; j--) {
               //往前移动一位
               nums[j] = nums[j-1];
           }
           nums[0] = temp;
        }
    }

    /**
     * 分别逆序两个子序列，在全部逆序
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        reverse(nums, 0, len-k-1);
        reverse(nums, len-k, len-1);
        reverse(nums, 0, len-1);
    }

    /**
     * 数组逆序
     * @param nums
     * @param low
     * @param high
     */
    public void reverse(int[] nums, int low, int high) {
        for (; low < high; low++, high--) {
            int temp = nums[high];
            nums[high] = nums[low];
            nums[low] = temp;
        }
    }

    /**
     *  旋转矩阵
     *  给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
     *
     *  示例 1:
     * 给定 matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     *
     * 示例 2:
     * 给定 matrix =
     * [
     *   [ 5, 1, 9,11],
     *   [ 2, 4, 8,10],
     *   [13, 3, 6, 7],
     *   [15,14,12,16]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [15,13, 2, 5],
     *   [14, 3, 4, 1],
     *   [12, 6, 8, 9],
     *   [16, 7,10,11]
     * ]
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] rotateMatrix = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                rotateMatrix[j][n-1-i] = matrix[i][j];
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                matrix[i][j] = rotateMatrix[i][j];
            }
        }
    }

    /**
     * 先由对角线 [1, 5, 9] 为轴进行翻转,于是数组变成了:
     * [1,4,7]
     * [2,5,8]
     * [3,6,9]
     *
     * 再对每一行以中点进行翻转，就得到了
     * [7,4,1]
     * [8,5,2]
     * [9,6,3]
     * @param matrix
     */
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        // 先以对角线（左上-右下）为轴进行翻转
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 再对每一行以中点进行翻转
        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        new Rotate().rotate1(nums, 2);
        for (int i=0; i<nums.length;i++) {
            System.out.println(nums[i]);
        }

    }
}
