package com.maomao.test.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 为运算表达式设计优先级
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。
 * 有效的运算符号包含 +, - 以及 * 。
 *
 * 示例 1:
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * 示例 2:
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * @author: huida
 * @date: 2021/12/16
 **/
public class DiffWaysToCompute {

    /**
     * 分治思想
     * 1、明确函数定义，diffWaysToCompute 函数可以计算出输入算式的所有组合结果。
     * 2、分，给某一个运算符左右加括号，将一个表达式分解成两个子表达式。
     * 3、治，用 diffWaysToCompute 递归计算左右两个子表达式的所有结果。
     * 4、用子表达式（子问题）的结果推导原表达式（原问题）的结果。
     * @param expression
     * @return
     */
    public List<Integer> diffWaysToCompute(String expression) {
        if  (expression == null || expression.length()==0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                //以运算符分割成两个字符串，递归计算
                List<Integer> left = diffWaysToCompute(expression.substring(0,i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                //合并
                for (int a: left) {
                    for (int b: right) {
                        if (ch == '+') {
                            res.add(a+b);
                        } else if (ch == '-') {
                            res.add(a-b);
                        } else {
                            res.add(a*b);
                        }
                    }
                }
            }

        }
        //为空，说明分割到最后一个数字
        if (res.size() == 0) {
            res.add(Integer.parseInt(expression));
        }
        return res;
    }
}
