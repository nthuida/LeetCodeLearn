package com.maomao.test.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 分割数组为连续子序列
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 *  
 *
 * 示例 2：
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 *  
 *
 * 示例 3：
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 *
 * @author huida
 * @date 2020/12/4
 */
public class IsPossible {

    public boolean isPossible(int[] nums) {
        //统计数字出现的个数
        Map<Integer, Integer> countNumMap = new HashMap<>();
        for (int num : nums) {
            countNumMap.put(num, countNumMap.getOrDefault(num, 0) + 1);
        }
        //存储以数字i结尾的且符合题意的连续子序列个数
        Map<Integer, Integer>  tailMap = new HashMap<>();
        for (int num : nums) {
            int count = countNumMap.getOrDefault(num, 0);
            if (count <=0) {
                //元素用完跳过
                continue;
            } else if (tailMap.getOrDefault(num-1, 0) >0) {
                //可以接在前面的子序列
                countNumMap.put(num, count-1);
                tailMap.put(num, tailMap.getOrDefault(num,0) +1);
                tailMap.put(num-1, tailMap.get(num-1) -1);
            } else if (countNumMap.getOrDefault(num+1,0) > 0 && countNumMap.getOrDefault(num+2, 0) > 0) {
                countNumMap.put(num, count-1);
                countNumMap.put(num+1, countNumMap.get(num+1)-1);
                countNumMap.put(num+2, countNumMap.get(num+2)-1);
                tailMap.put(num+2, tailMap.getOrDefault(num+2, 0) +1);
            } else {
                return false;
            }
        }
        return true;

    }
}
