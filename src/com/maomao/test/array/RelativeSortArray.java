package com.maomao.test.array;

import java.util.*;

/**
 * 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * @author huida
 * @date 2020/11/18
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int[] res = new int[len1];
        int len2 = arr2.length;
        Set<Integer> set = new HashSet<>();
        for (int a : arr2) {
            set.add(a);
        }
        List<Integer> left = new ArrayList<>();
        for (int b : arr1) {
            if (!set.contains(b)) {
                left.add(b);
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr1) {
            if (set.contains(a)) {
                int count = map.getOrDefault(a, 0);
                count++;
                map.put(a, count);
            }
        }
        int index=0;
        for (int i=0; i<len2; i++) {
            int count = map.get(arr2[i]);
            while (count !=0) {
                res[index++] = arr2[i];
                count--;
            }
        }
        if (left.size() == 0) {
            return res;
        } else {
           Collections.sort(left);
            for (int a : left) {
                res[index++] = a;
            }
            return res;
        }

    }

    public static void main(String[] args) {
        int[] a = {2,3,1,3,2,4,6,7,9,2,19};
        int[] b = {2,1,4,3,9,6};
        int[] c = new RelativeSortArray().relativeSortArray(a, b);
        System.out.println(c);
    }
}
