package com.maomao.test.array;

/**
 * 加一
 * @Author huida.mao
 * @Date 2019/10/14
 */
public class PlusOne {
    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 示例 1:
     *
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     *
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int sum = 1;
        StringBuilder a = new StringBuilder();
        for (int i = digits.length-1; i>= 0; i--) {
            sum = sum + digits[i];
            a.append(sum%10);
            sum = sum/10;
        }
        if (sum == 1) {
            a.append(sum);
        }
        int[] plusOne = new int[a.length()];
        a.reverse();
        for (int i=0; i<a.length(); i++) {
            plusOne[i] = a.charAt(i) - '0';
        }
        return plusOne;
    }
}
