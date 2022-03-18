package com.maomao.test.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 删除无效的括号
 *
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 *
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 *
 * 示例 1:
 *
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 * 示例 2:
 *
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 * 示例 3:
 *
 * 输入: ")("
 * 输出: [""]
 *
 * @author huida
 * @date 2020/9/3
 */
public class RemoveInvalidParentheses {

    /**
     * DFS
     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses(String s) {
        //去重
        Set<String> set = new HashSet<>();
        //开始处理的字符串位置
        int index = 0;
        //需要删除的左括号数
        int leftDelete = 0;
        //需要删除的右括号数
        int rightDelete = 0;
        //
        int leftCount = 0;

        //计算删除的括号数
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

        dfs(new StringBuilder(), set, index, leftCount, leftDelete, rightDelete,s);
        List<String> res = new ArrayList<>();
        res.addAll(set);
        return res;
    }

    private void dfs(StringBuilder stringBuilder, Set<String> set, int index, int leftCount, int leftToDelete, int rightToDelete, String s) {
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
                StringBuilder temp = new StringBuilder(stringBuilder);
                dfs(temp, set, index+1, leftCount,leftToDelete-1, rightToDelete, s);
            }
            //不删
            StringBuilder temp = new StringBuilder(stringBuilder);
            temp.append(ch);
            dfs(temp, set, index+1, leftCount+1, leftToDelete, rightToDelete, s);
        } else if (ch == ')') {
            //删除
            if (rightToDelete > 0) {
                StringBuilder temp = new StringBuilder(stringBuilder);
                dfs(temp, set, index+1, leftCount, leftToDelete, rightToDelete-1, s);
            }
            if (leftCount > 0) {
                //不删
                StringBuilder temp = new StringBuilder(stringBuilder);
                temp.append(ch);
                dfs(temp, set, index+1, leftCount-1, leftToDelete, rightToDelete, s);
            }
        } else {
            //其他符号
            StringBuilder temp = new StringBuilder(stringBuilder);
            temp.append(ch);
            dfs(temp, set, index+1, leftCount, leftToDelete, rightToDelete, s);
        }

    }
}
