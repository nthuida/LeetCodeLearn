package com.maomao.test.search.sort;

/**
 * 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * @author huida
 * @date 2020/5/25
 */
public class ReversePairs {


    /**
     *
     * 利用「归并排序」计算逆序对；
     * 分阶段什么都不用做
     * 合并阶段本质上是合并两个排序数组的过程，而每当遇到左子数组当前元素 > 右子数组当前元素时，
     * 意味着 「左子数组当前元素 至 末尾元素」 与 「右子数组当前元素」 构成了若干 「逆序对」
     *
     * @param nums
     * @return
     */
    int count = 0;
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        sort(nums, 0, len - 1);
        return count;
    }


    private void sort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end-start)/2;
            sort(nums, start, mid);
            sort(nums, mid+1, end);
            //合并
            merge(nums, start, mid, end);
        }
    }

    private void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[array.length];
        int index = start;
        int leftBegin = start;
        int rightBegin = mid +1;
        while (leftBegin <= mid && rightBegin<= end) {
            if (array[leftBegin] <= array[rightBegin]) {
                temp[index++] = array[leftBegin++];
            } else {
                //统计逆序对
                count += (mid-leftBegin+1);
                temp[index++] = array[rightBegin++];
            }
        }
        //左边的还有
        while (leftBegin <= mid) {
            temp[index++] = array[leftBegin++];
        }

        //右边的还有
        while (rightBegin <= end) {
            temp[index++] = array[rightBegin++];
        }
        //复制到原数组
        for (int i=start; i<=end; i++) {
            array[i] = temp[i];
        }
    }

}
