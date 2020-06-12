package com.maomao.test.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * @author huida
 * @date 2020/6/12
 */
public class Convert {

    /**
     * 整体的思路是遍历字符串，遍历过程中将每行都看成新的字符串构成字符串数组，最后再将该数组拼接起来
     * 从上往下，从左往右
     * res[i] += c： 把每个字符 c 填入对应行 i
     * i += flag： 更新当前字符 c 对应的行索引；
     * flag = - flag： 在达到 Z 字形转折点时，执行反向。
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            //直接返回
            return s;
        }
        //存放每行的字符串
        List<StringBuffer> list = new ArrayList<>();
        for(int i=0; i<numRows; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            list.add(stringBuffer);
        }
        int row = 0;
        //是否拐点
        int flag = -1;
        for (char ch : s.toCharArray()) {
            list.get(row).append(ch);
            if (row ==0 || row == numRows-1) {
                //到达Z的头或者底
                flag = -flag;
            }
            row += flag;
        }
        StringBuffer res = new StringBuffer();
        for (StringBuffer stringBuffer : list) {
            res.append(stringBuffer);
        }
        return res.toString();
    }
}
