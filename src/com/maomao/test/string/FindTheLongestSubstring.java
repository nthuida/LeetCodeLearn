package com.maomao.test.string;

import java.util.Arrays;

/**
 * 每个元音包含偶数次的最长子字符串
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，
 * 在子字符串中都恰好出现了偶数次。
 *
 * 示例 1：
 * 输入：s = "eleetminicoworoep"
 * 输出：13
 * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
 *
 * 示例 2：
 * 输入：s = "leetcodeisgreat"
 * 输出：5
 * 解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
 *
 * 示例 3：
 * 输入：s = "bcbcbc"
 * 输出：6
 * 解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
 *
 * @author huida
 * @date 2020/5/20
 */
public class FindTheLongestSubstring {

    /**
     * 思路
     * aeiou每个元音用一个bit一共5个bit，32种奇偶次数组合状态，比如10101可以表示aiu出现奇数次数
     * oe则出现偶数次数，每当遍历一个字符，就可以改变当前的aeiou出现的奇偶次数，也即是改变状态
     * 显然，如果两次出现了同样的状态，假设第一次出现在i处
     * 第二次出现在j处，那么i+1-j之间的字符串肯定是满足aeiou出现均为偶数次数的
     * 因为只有经历了偶数个aeiou，才能回到之前的状态，为了使得合理的字符串最长
     * 那么第一次出现此状态时，就需要记录到下标，然后下次遇到相同状态，计算最大长度
     * @param s
     * @return
     */
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        //5个元音字母，就是00000-11111，2^5种情况，或者叫状态
        int[] pos = new int[1 << 5];
        //用-1填充是怕00000这种情况，避免混淆
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            /*-------------开始----------------*/
            //在这里主要是用当前字符去更新上一个子串的状态，因为当前这个字符可能是元音字符或者不是
            //用异或的原因就是，我们只关心奇偶性，异或相同为0，不同为1，那么只要将上一个状态对应位与
            //1 << （0-4）一下就可以了。也就是第一次来是奇数，那么第二次就是偶数，第三次是奇数...
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            /*--------------结束---------------*/
            //得到一个新的状态值，如果这个状态值作索引对应位置的值大于0，
            //那么就说明第一次出现该值的位置到当前位置所对应的字符串就是当前
            //符合要求的子串，这是因为如果在i的位置和j的位置对应的状态值相等，
            //那么这两个子串的奇偶性肯定相等,既然奇偶性相同了，那么中间范围对应的子串就是我们要求的
            //同时我们要和之前符合要求的子串比较一下长度，因为我们要取最长的。
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                //pos只存放每一个状态值第一个出现的位置。
                pos[status] = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "ell";
        System.out.println(new FindTheLongestSubstring().findTheLongestSubstring(s));
    }
}
