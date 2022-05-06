package com.maomao.test.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 将数组拆分成斐波那契序列
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 *
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 *
 * 示例 1：
 *
 * 输入："123456579"
 * 输出：[123,456,579]
 * 示例 2：
 *
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 * 示例 3：
 *
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 * 示例 4：
 *
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 * 示例 5：
 *
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 *
 * @author huida
 * @date 2020/12/8
 */
public class SplitIntoFibonacci {

    /**
     * 回溯
     * @param S
     * @return
     */
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        backtrack(S.toCharArray(), 0, res);
        return res;
    }

    private boolean backtrack(char[] chars, int index, List<Integer> res) {
        //终止条件, 全部截取and找到组合
        if (res.size() >=3 && index == chars.length) {
            return true;
        }
        for (int i=index; i<chars.length; i++) {
            //两位以上的数字，不能以0开头
            if (chars[index] == '0' && i>index) {
                break;
            }
            //字符串转数字
            long num = convert(index, i+1, chars);
            if (num > Integer.MAX_VALUE) {
                break;
            }
            int size = res.size();
            //如果截取的数字大于res中前两个数字的和，说明这次截取的太大，直接终止
            if (size >=2 && num > (res.get(size-1) + res.get(size-2))) {
                break;
            }
            if (size<=1 || (num == res.get(size-1) + res.get(size-2))) {
                res.add((int)num);
                //继续找，找到就返回
                if (backtrack(chars, i+1, res)) {
                   return true;
                }
                //不满足，回溯
                res.remove(res.size()-1);
            }

        }
        return false;

    }

    private long convert(int start, int end, char[] chars) {
        long res = 0;
        for (int i = start; i < end; i++) {
            res = res * 10 + chars[i] - '0';
        }
        return res;
    }
}
