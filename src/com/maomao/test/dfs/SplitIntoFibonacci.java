package com.maomao.test.dfs;
import java.util.LinkedList;
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

    public List<Integer> splitIntoFibonacci(String num) {
        LinkedList<Integer> res = new LinkedList<>();
        backtrack(num, 0, res);
        return res;
    }

    private boolean backtrack(String num, int index, LinkedList<Integer> res) {
        //终止条件
        if (res.size() >=3 && index == num.length()) {
            return valid(res);
        }
        for (int i=index; i<num.length(); i++) {
            //前导0， 剪枝
            if (num.charAt(index) == '0' && i>index) {
                return false;
            }
            long number = Long.parseLong(num.substring(index, i+1));
            //剪枝
            if (number > Integer.MAX_VALUE) {
                return false;
            }
            //如果截取的数字大于res中前两个数字的和，剪枝
            if (res.size() >=2 && number > (res.get(res.size()-1) + res.get(res.size()-2))) {
                return false;
            }
            res.add((int)number);
            //两数相加不符合，剪枝
            if (res.size()>=3) {
                if (!valid(res)) {
                    res.removeLast();
                    continue;
                }
            }
            //找到就返回
            if (backtrack(num, i+1, res)) {
               return true;
            }
            res.removeLast();
        }
        return false;
    }

    private boolean valid(LinkedList<Integer> list) {
        Integer first = list.get(list.size()-3);
        Integer second = list.get(list.size()-2);
        Integer third = list.get(list.size()-1);
        long sum = first + second;
        if (sum == (long)third) {
            return true;
        }
        return false;
    }


}
