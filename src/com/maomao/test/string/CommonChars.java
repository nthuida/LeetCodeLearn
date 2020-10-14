package com.maomao.test.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 *
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 * @author huida
 * @date 2020/10/14
 */
public class CommonChars {

    public List<String> commonChars(String[] A) {
        //26个字符，在每个字符串中出现的最小次数
        int[] minCount = new int[26];
        Arrays.fill(minCount, Integer.MAX_VALUE);
        for (String str : A) {
            //统计每个字符串中字符出现的次数
            int[] min = new int[26];
            for (int i=0; i<str.length(); i++) {
                min[str.charAt(i)-'a']++;
            }
            //获取26个字符在所有字符串中出现次数最小个数
            for (int j=0; j<26; j++) {
                minCount[j] = Math.min(minCount[j], min[j]);
            }
        }
        List<String> res = new ArrayList<>();
        for(int i=0; i<26; i++) {
            for (int j=0; j<minCount[i]; j++) {
                //保存出现的最小字符
                res.add(String.valueOf((char) (i+'a')));
            }
        }

        return res;

    }
}
