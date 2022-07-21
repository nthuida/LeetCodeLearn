package com.maomao.test.search;

/**
 * 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * 算法的时间复杂度应该为 O(log (m+n))
 * @author huida
 * @date 2020/5/25
 */
public class FindMedianSortedArrays {

    /**
     * 二分查找，求二个数组的第K小数
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        if (totalLen % 2 ==1) {
            //总长度为奇数
            double mid = getKth(nums1,0, nums1.length-1, nums2, 0, nums2.length-1, (totalLen)/2 + 1);
            return mid;
        } else {
            double mid1 = getKth(nums1,0, nums1.length-1, nums2, 0, nums2.length-1, (totalLen)/2);
            double mid2 = getKth(nums1,0, nums1.length-1, nums2, 0, nums2.length-1, (totalLen)/2 +1);
            return (mid1+mid2)/2.0;
        }
    }

    /**
     * 第K小数
     * @param nums1
     * @param start1
     * @param end1
     * @param nums2
     * @param start2
     * @param end2
     * @param k，个数，不是索引
     * @return
     */
    public int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //一个数组为空
        if (len1 ==0) {
            return nums2[start2 + k -1];
        }
        if (len2 == 0) {
            return nums1[start1 + k -1];
        }
        //比较，退出
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        //数组前k/2比较，防止数组长度小于k/2
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            //排除nums2的前2/k个元素
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }

    }

}
