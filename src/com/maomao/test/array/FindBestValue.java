package com.maomao.test.array;

/**
 * 转变数组后最接近目标值的数组和
 *
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 
 * value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 *
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 * 请注意，答案不一定是 arr 中的数字。
 *
 * 示例 1：
 * 输入：arr = [4,9,3], target = 10
 * 输出：3
 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 *
 *  示例 2：
 * 输入：arr = [2,3,5], target = 10
 * 输出：5
 *
 * 示例 3：
 * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
 * 输出：11361
 *
 * @author huida
 * @date 2020/7/2
 */
public class FindBestValue {

    /**
     * value的起始值不可能小于均值 target/len(arr)。value 小于均值，sum 也会始终小于 target，
     * value从均值开始递增计算sum， 最接近 target 的值必在 sum 从小于 target 向大于 target 转变时
     *
     * @param arr
     * @param target
     * @return
     */
    public int findBestValue(int[] arr, int target) {
        int sum = 0;
        int max = 0;
        for (int i : arr) {
            sum += i;
            if (i>max) {
                max = i;
            }
        }
        if (sum <= target) {
            //和sum小于target，无论value取多大最终的和一定小于target，返回最大值
            return max;
        }
        //均值，枚举的起点
        int aver = target/arr.length;
        sum = getSum(arr, aver);
        while (sum < target) {
            int tempSum = getSum(arr, aver+1);
            if (tempSum >= target) {
                //判断哪个更接近
                if (target - sum > tempSum - target) {
                    return aver+1;
                } else {
                    return aver;
                }
            }
            sum = tempSum;
            aver++;
        }
        return 0;
    }

    private int getSum(int[] arr, int value) {
        int sum = 0;
        for (int i: arr) {
            sum += i>value ? value : i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {4,9,3};
        System.out.println(new FindBestValue().findBestValue(a, 10));
    }
}
