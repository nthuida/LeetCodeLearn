package com.maomao.test.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * 示例：
 *
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 *
 * @author huida
 * @date 2020/9/17
 */
public class CountSmaller {

    /**
     * 超时
     * @param nums
     * @return
     */
    public List<Integer> countSmallerII(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int count = 0;
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            res.add(count);
        }

        return res;
    }

    /**
     * 归并排序计算逆序数 + 索引数组
     * 「原始数组」不变，用于比较两个元素的大小，真正位置变化的是「索引数组」的位置；
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        if (len == 0) {
            return list;
        }
        // 索引数组：归并回去的时候，方便知道是哪个下标的元素
        int[] index = new int[len];
        for (int i = 0; i < len; i++) {
            index[i] = i;
        }
        int[] res = new int[len];

        countSmaller(nums, 0, len-1, index, res);
        // 把 int[] 转换成为 List<Integer>
        for (int i = 0; i < len; i++) {
            list.add(res[i]);
        }
        return list;

    }

    private void countSmaller(int[] nums, int left, int right, int[] indexes, int[] res) {
        if (left == right) {
            return ;
        }

        int mid = left + (right - left) / 2;
        //左边
        countSmaller(nums, left, mid, indexes, res);
        //右边
        countSmaller(nums, mid + 1, right, indexes, res);
        //归并排序的优化，如果索引数组有序，则不存在逆序关系，没有必要合并
        if (nums[indexes[mid]] <= nums[indexes[mid + 1]]) {
            return ;
        }
        //横跨区间
        mergeAndCount(nums, left, mid, right, indexes, res);
    }

    private void mergeAndCount(int[] nums, int left, int mid, int right, int[] indexes, int[] res) {
        int[] temp = new int[nums.length];
        for (int i = left; i <= right; i++) {
            temp[i] = indexes[i];
        }
        int i = left;
        int j = mid + 1;

        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                //左边的数组遍历完
                indexes[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                //右边遍历完
                indexes[k] = temp[i];
                i++;
                res[indexes[k]] += (right - mid);
            } else if (nums[temp[i]] <= nums[temp[j]]) {
                //归并
                indexes[k] = temp[i];
                i++;
                res[indexes[k]] += (j - mid - 1);
            } else {
                indexes[k] = temp[j];
                j++;
            }
        }
    }
}
