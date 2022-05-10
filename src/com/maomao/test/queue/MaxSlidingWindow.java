package com.maomao.test.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * @author huida
 * @date 2020/7/29
 */
public class MaxSlidingWindow {

    /**
     * 单调队列
     * 1、遍历给定数组中的元素，如果队列不为空且当前考察元素大于等于队尾元素，则将队尾元素移除。
     * 直到，队列为空或当前考察元素小于新的队尾元素；形成单调递减队列
     * 2、当队首元素的下标小于滑动窗口左侧边界left时，表示队首元素已经不再滑动窗口内，因此将其从队首移除。
     * 3、由于数组下标从0开始，因此当窗口右边界right+1大于等于窗口大小k时，意味着窗口形成。此时，队首元素就是该窗口内的最大值
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        //保存窗口的最大值
        int[] res = new int[len-k+1];
        //因为要在队尾和对头删除元素，所以使用双端队列
        Deque<Integer> deque = new LinkedList<>();
        //遍历右边界
        for (int right=0; right<len; right++) {
            //构造递减队列，如果队尾元素小于等于当前元素，则移除队尾元素，直至为空
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }
            //保存元素的下标，方便比较队首元素是否在窗口內
            deque.addLast(right);
            //窗口左边界
            int left = right-k +1;
            //队首元素的下标超过了边界，移除
            if (deque.peekFirst() < left) {
                deque.pollFirst();
            }
            //窗口已经形成,数组下标从0开始
            if (right + 1 >= k) {
                //保存最大值,最大元素的下标的队首
                res[left] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
