package com.maomao.test.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * @Author huida.mao
 * @Date 2019/12/12
 */
public class GenerateParenthesis {

    /**
     * 回溯算法（深度优先遍历）
     *
     * 左右都有可以使用的括号数量大于 0 的时候，才产生分支；
     * 左边不受右边的限制，只看是否还有左括号可用；
     * 右边除了自己的限制以外，还收到左边的限制，即：右边剩余可以使用的括号数量一定大于左边剩余的数量的时候，才可以“节外生枝”；
     * 在左边和右边剩余的括号数都等于 0 的时候结算。
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        //左右剩余括号数n
        dfs("", n, n, result);
        return result;
    }

    public void dfs (String current, int left, int right, List<String> result) {
        //退出条件
        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }
        //剩余左边大于右边，不符合
        if (left > right) {
            return;
        }
        //左边有剩余
        if (left > 0) {
            dfs(current + '(', left-1, right, result);
        }
        //右边
        if (right > 0) {
            dfs(current + ')', left, right-1, result);
        }

    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }
}
