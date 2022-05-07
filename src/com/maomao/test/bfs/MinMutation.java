package com.maomao.test.bfs;

import java.util.*;

/**
 * 最小基因变化
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end
 * 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 *
 * 示例 1：
 * 输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
 * 输出：1
 * 示例 2：
 * 输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * 输出：2
 *
 * @author: huida
 * @date: 2022/5/7
 **/
public class MinMutation {

    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        if (bank.length == 0) {
            return -1;
        }
        //去重
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        //end不在基因库中，直接返回
        if (!bankSet.contains(end)) {
            return -1;
        }
        //保存已访问过的字符串
        Set<String> visited = new HashSet<>();
        char[] chars = new char[]{'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        //变换次数
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                //出队
                String cur = queue.poll();
                //已找到，直接返回
                if (cur.equals(end)) {
                    return step;
                }
                //当前字符串的每一位变为'A', 'C', 'G', 'T'
                for (int j=0; j<cur.length(); j++) {
                    for (char ch : chars) {
                        StringBuilder builder = new StringBuilder(cur);
                        if (builder.charAt(j) != ch) {
                            //改变一个字符
                            builder.setCharAt(j, ch);
                            String str = builder.toString();
                            if (bankSet.contains(str) && !visited.contains(str)) {
                                //包含在基因库，且没有访问过
                                queue.add(str);
                                visited.add(str);
                            }
                        }
                    }
                }
            }
            step++;
        }
        //没找到
        return -1;
    }
}
