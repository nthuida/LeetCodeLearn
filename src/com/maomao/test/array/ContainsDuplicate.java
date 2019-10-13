package com.maomao.test.array;

import java.util.*;

/**
 * @author Administrator
 * @date 2019/3/24
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
        System.out.println(new ContainsDuplicate().containsDuplicate(nums));
        List<Integer> num = Arrays.asList(3,1,5,2,9,8,4,10,6,7);
        num.sort(Comparator.reverseOrder()); //reverseOrder倒序
        //Collections.sort(num);
        System.err.println("倒序:"+num);
    }
}
