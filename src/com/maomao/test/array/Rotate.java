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

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        new Rotate().rotate1(nums, 2);
        for (int i=0; i<nums.length;i++) {
            System.out.println(nums[i]);
        }

    }
}
