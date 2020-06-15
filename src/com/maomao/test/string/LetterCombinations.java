package com.maomao.test.string;

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

    /**
     * 回溯法
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null ||digits.length() == 0){
            return res;
        }
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        backtrack(res, map, digits, 0, new StringBuilder(""));
        return res;
    }

    public void backtrack(List<String> list, Map<String, String> map, String digits, int depth, StringBuilder str) {
        //退出条件
        if (depth == digits.length()) {
            list.add(str.toString());
            return;
        }
        char ch = digits.charAt(depth);
        String chr = new StringBuffer().append(ch).toString();
        String temp = map.get(chr);
        for (int i=0; i<temp.length(); i++) {
            //选择
            str.append(temp.charAt(i));
            //下一层
            backtrack(list, map, digits, depth+1, str);
            //取消选择
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> res = new LetterCombinations().letterCombinations("23");
        System.out.println(res);
    }
}
