package com.maomao.test.array;

import java.util.Arrays;

/**
 * 卡牌分组
 * 给定一副牌，每张牌上都写着一个整数。
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 * 示例 1：
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 *
 * 示例 2：
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 *
 * 示例 3：
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 *
 * 示例 4：
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 *
 * 示例 5：
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 *
 * 提示：
 *
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 *
 * @author huida
 * @date 2020/6/3
 */
public class HasGroupsSizeX {

    /**
     * 先计数，在求最大公约数，如果大于等于2，成立
     * @param deck
     * @return
     */
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length <2) {
            return false;
        }
        int[] count = new int[10000];
        //个数计数
        for (int i : deck) {
            count[i]++;
        }
        int x = count[deck[0]];
        for (int cnt : count) {
            //公约数为1直接返回
            if (cnt == 1) {
                return false;
            }
            if (cnt >1) {
                x = gcd(cnt,x);
                if (x ==1) {
                    return false;
                }
            }
        }
        return x >=2;
    }

    /**
     * 辗转相除法求公约数
     * @param a
     * @param b
     * @return
     */
    private int gcd (int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }

}
