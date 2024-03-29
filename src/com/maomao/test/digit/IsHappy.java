package com.maomao.test.digit;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，
 * 那么这个数就是快乐数。
 *
 * 示例: 
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *

 * @Author huida.mao
 * @Date 2020/1/8
 */
public class IsHappy {

    public boolean isHappy(int n) {
        //判断重复
        Set<Integer> set = new HashSet<>();
        while (n!=1 && !set.contains(n)) {
            set.add(n);
            n = compute(n);
        }
        return n==1;
    }

    public int compute(int n) {
        int result = 0;
        while (n > 0) {
            int a = n%10;
            result += a * a;
            n = n/10;
        }
        return result;
    }

}
