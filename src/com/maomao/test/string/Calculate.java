package com.maomao.test.string;

import java.util.Stack;

/**
 * 基本计算器
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
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
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        //上一个的操作符
        char lastOp = '+';
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            char temp = s.charAt(i);
            if (Character.isDigit(temp)) {
                //转化为数字
                int tempNum = temp - '0';
                while(++i < s.length() && Character.isDigit(s.charAt(i))){
                    tempNum = tempNum * 10 + (s.charAt(i) - '0');
                }
                //回退到非数字
                i--;
                if (lastOp == '+') {
                    //直接入栈
                    stack.push(tempNum);
                } else if (lastOp == '-') {
                    stack.push(-tempNum);
                } else if(lastOp == '*') {
                    int s1 = stack.pop();
                    //算好了，放进去
                    stack.push(s1*tempNum);
                } else {
                    int s1 = stack.pop();
                    stack.push(s1/tempNum);
                }

            } else {
                lastOp = temp;
            }
        }
        //遍历求和
        int sum =0;
        for (int a : stack) {
            sum += a;
        }
        return sum;
    }

    public static void main(String[] args) {
        String a = "3+2*2";
        System.out.println(new Calculate().calculate(a));
    }
}
