package com.maomao.test.digit;

import java.util.Arrays;

/**
 * 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * @Author huida.mao
 * @Date 2020/1/9
 */
public class CountPrimes {

    public int countPrimes(int n) {
        int count = 0;
        for (int i=2; i<=n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 低效
     * @param n
     * @return
     */
    public boolean isPrime(int n) {
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    int countPrimes1(int n) {
        boolean[] isPrim = new boolean[n];
        // 将数组都初始化为 true
        Arrays.fill(isPrim, true);

        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                // 素数 的倍数不可能是素数了
                for (int j = 2 * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }

        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                count++;
            }
        }
        return count;
    }


}
