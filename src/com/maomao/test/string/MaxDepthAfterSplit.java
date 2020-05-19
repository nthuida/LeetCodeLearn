package com.maomao.test.string;

/**
 * 有效括号的嵌套深度
 * 有效括号字符串 定义：对于每个左括号，都能找到与之对应的右括号，反之亦然。
 * 嵌套深度 depth 定义：即有效括号字符串嵌套的层数，depth(A) 表示有效括号字符串 A 的嵌套深度。
 *
 * 示例 1：
 * 输入：seq = "(()())"
 * 输出：[0,1,1,1,1,0]
 *
 * 示例 2：
 * 输入：seq = "()(())()"
 * 输出：[0,0,0,1,1,0,1,1]
 * 解释：本示例答案不唯一。
 * 按此输出 A = "()()", B = "()()", max(depth(A), depth(B)) = 1，它们的深度最小。
 * 像 [1,1,1,0,0,1,1,1]，也是正确结果，其中 A = "()()()", B = "()", max(depth(A), depth(B)) = 1 。
 *
 * @author huida
 * @date 2020/5/19
 */
public class MaxDepthAfterSplit {

    /**
     * 这个「嵌套深度」就是输入字符串，使用栈完成括号匹配，栈中最多连续出现的左括号 ( 的个数。
     * 思路：
     * 连续的 (会造成嵌套深度的增加，因此对于这种要把他们分到不同的组中。
     * @param seq
     * @return
     */
    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        //栈递归深度
        int depth = 0;
        int[] result = new int[len];
        for (int i=0; i<len; i++) {
            if (seq.charAt(i) == '(') {
                //左括号(，深度加1
                depth++;
                //取余，奇数给A
                result[i] = depth%2;
            } else {
                //右括号)
                result[i] = depth%2;
                depth--;
            }
        }
        return result;
    }
}
