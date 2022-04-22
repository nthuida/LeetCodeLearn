package com.maomao.test.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 删除无效的括号
 *
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 *
 * 示例 1:
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 *
 * 示例 2:
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 *
 * 示例 3:
 * 输入: ")("
 * 输出: [""]
 *
 * @author huida
 * @date 2020/9/3
 */
public class RemoveInvalidParentheses {


    public List<String> removeInvalidParentheses(String s) {
        //需要删除的左括号数
        int leftDelete = 0;
        //需要删除的右括号数
        int rightDelete = 0;
        //计算最少需要删除的括号数
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftDelete++;
            } else if (c == ')') {
                if (leftDelete > 0 ) {
                    leftDelete--;
                } else {
                    rightDelete++;
                }
            }
        }
        //左括号出现的数量，必须先有左才有右
        int leftCount = 0;
        Set<String> set = new HashSet<>();
        dfs(new StringBuilder(), set, 0, leftCount, leftDelete, rightDelete, s);
        List<String> res = new ArrayList<>();
        res.addAll(set);
        return res;
    }

    private void dfs(StringBuilder stringBuilder, Set<String> set, int index, int leftCount, int leftToDelete, int rightToDelete, String s) {
        //终止条件
        if (index == s.length()) {
            //遍历完成
            if (leftToDelete == 0 && rightToDelete == 0 && leftCount == 0) {
                set.add(stringBuilder.toString());
            }
            return;
        }
        char ch = s.charAt(index);
        if (ch == '(') {
            //删除
            if (leftToDelete > 0) {
                dfs(stringBuilder, set, index+1, leftCount,leftToDelete-1, rightToDelete, s);
            }
            //不删
            stringBuilder.append(ch);
            dfs(stringBuilder, set, index+1, leftCount+1, leftToDelete, rightToDelete, s);
            //取消选择
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        } else if (ch == ')') {
            //删除
            if (rightToDelete > 0) {
                dfs(stringBuilder, set, index+1, leftCount, leftToDelete, rightToDelete-1, s);
            }
            if (leftCount > 0) {
                //不删
                stringBuilder.append(ch);
                dfs(stringBuilder, set, index+1, leftCount-1, leftToDelete, rightToDelete, s);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
        } else {
            //其他符号
            stringBuilder.append(ch);
            dfs(stringBuilder, set, index+1, leftCount, leftToDelete, rightToDelete, s);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

    }
}
