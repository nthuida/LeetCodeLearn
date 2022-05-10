package com.maomao.test.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * @author huida
 * @date 2020/6/15
 */
public class LetterCombinations {

    String[] phone = {"", "", "abc","def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    /**
     * 回溯算法
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        backtrack(res, digits, 0, new StringBuilder());
        return res;
    }

    public void backtrack(List<String> list, String digits, int depth, StringBuilder str) {
        //退出条件
        if (depth == digits.length()) {
            list.add(str.toString());
            return;
        }
        //电话号码
        char ch = digits.charAt(depth);
        //号码对应的字母
        String num = phone[ch - '0'];
        for (int i=0; i<num.length(); i++) {
            //选择
            str.append(num.charAt(i));
            //下一层
            backtrack(list, digits, depth+1, str);
            //取消选择
            str.deleteCharAt(str.length() - 1);
        }
    }
}
