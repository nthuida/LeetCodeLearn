package com.maomao.test.greedy;


/**
 *
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * 示例 1:
 * 输入: N = 10
 * 输出: 9
 *
 * 示例 2:
 * 输入: N = 1234
 * 输出: 1234
 *
 * 示例 3:
 * 输入: N = 332
 * 输出: 299
 *
 *  @author huida
 *  @date 2020/5/15
 */
public class MonotoneIncreasingDigits {

    /**
     * 贪心算法，高位尽可能不变，如果不满足n[i]<n[i+1]，则n[i]-1,后面的都设为9
     * n    = 2333332
     * res  = 2299999
     * @param N
     * @return
     */
    public int monotoneIncreasingDigitsII(int N) {
        int maxIndex = -1;
        int max = -1;
        char[] chars = (N + "").toCharArray();
        for (int i=0; i<chars.length-1; i++) {
            if (chars[i] > max) {
                //多个值相等情况下，取最前面那个
                max = chars[i];
                maxIndex = i;
            }
            if (chars[i] > chars[i+1]) {
                //递增序列最后一个值减1
                chars[maxIndex] -=1;
                for (int j=maxIndex+1; j<chars.length; j++) {
                    //后面的值都设置为9
                    chars[j] = '9';
                }
            }

        }
        return Integer.parseInt(new String(chars));

    }


    public static void main(String[] args) {
        System.out.println(new MonotoneIncreasingDigits().monotoneIncreasingDigitsII(1234));
    }
}
