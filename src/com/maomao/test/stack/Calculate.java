package com.maomao.test.stack;

import java.util.Stack;

/**
 * 基本计算器
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。
 *
 * 示例 1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 *
 * @author huida
 * @date 2020/9/9
 */
public class Calculate {

    /**
     * 先把乘除法的值计算出来，最终将所有的运算简化成只有加法。
     * @param s
     * @return
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        //上一个的操作符
        char lastOp = '+';
        int num = 0;
        for (int i=0; i<s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == ' ') {
                continue;
            }
            if (Character.isDigit(temp)) {
                //转化为数字
               num = num*10 + (temp - '0');
            }
            //不是数字，就是字符，或者到达最后一个元素，要保存之前的值
            if (!Character.isDigit(temp)|| i==s.length()-1){
                switch (lastOp) {
                    case '+' :
                        //直接入栈
                        stack.push(num);
                        break;
                    case '-' :
                        stack.push(-num);
                        break;
                    case '*' :
                        int s1 = stack.pop();
                        //算好了，放进去
                        stack.push(s1*num);
                        break;
                    case '/' :
                        int s2 = stack.pop();
                        stack.push(s2/num);
                }
                //更新计算符
                lastOp = temp;
                num = 0;
            }
        }
        //遍历求和
        int sum =0;
        for (int a : stack) {
            sum += a;
        }
        return sum;
    }

    /**
     * 基本计算器
     * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
     *
     * 示例 1：
     * 输入：s = "1 + 1"
     * 输出：2
     * 示例 2：
     * 输入：s = " 2-1 + 2 "
     * 输出：3
     * 示例 3：
     * 输入：s = "(1+(4+5+2)-3)+(6+8)"
     * 输出：23
     *
     * 如果当前是数字，那么更新计算当前数字；
     * 如果当前是操作符+或者-，那么需要更新计算当前计算的结果 res，并把当前数字 num 设为 0，sign 设为正负，重新开始；
     * 如果当前是 ( ，那么说明遇到了右边的表达式，而后面的小括号里的内容需要优先计算，所以要把 res，sign 进栈，更新 res 和 sign 为新的开始；
     * 如果当前是 ) ，那么说明右边的表达式结束，即当前括号里的内容已经计算完毕，所以要把之前的结果出栈，然后计算整个式子的结果；
     * 最后，当所有数字结束的时候，需要把最后的一个 num 也更新到 res 中。
     *
     * @param s
     * @return
     */
    public int calculate1(String s) {
        Stack<Integer> stack = new Stack<>();
        //计算结果
        int res = 0;
        //当前的数字
        int num = 0;
        //运算符
        int sign = 1;
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }
            //计算数字
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '+'){
                res += sign * num;
                num = 0;
                sign = 1;
            } else if (ch == '-') {
                res += sign * num;
                num = 0;
                sign = -1;
            } else if (ch == '(') {
                //保存前面计算的结果和运算符
                stack.push(res);
                stack.push(sign);
                //从新开始
                res = 0;
                sign = 1;
            } else if (ch == ')') {
                //计算当前的结果
                res += sign * num;
                num = 0;
                //运算符
                res *= stack.pop();
                //加上前面的结果
                res += stack.pop();
            }
        }
        //更新最后的结果
        res += sign * num;
        return res;
    }

}
