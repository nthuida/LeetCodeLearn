package com.maomao.test.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，
 * 其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
 * 编写一个算法来重建这个队列。注意：总人数少于1100人。
 *
 * 示例
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *

 * @author huida
 * @date 2020/9/2
 */
public class ReconstructQueue {
    /**
     * 解题思路：先排序再插入
     * 1.排序规则：按照先H高度降序，K个数升序排序
     * 2.遍历排序后的数组，根据K插入到K的位置上
     *
     * 优先按身高高的people的k来插入，后序插入节点也不会影响前面已经插入的节点
     *
     *  [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
     *  再一个一个插入。
     *  [7,0]
     *  [7,0], [7,1]
     *  [7,0], [6,1], [7,1]
     *  [5,0], [7,0], [6,1], [7,1]
     *  [5,0], [7,0], [5,2], [6,1], [7,1]
     *  [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        //先H高度降序，在H相等的情况下，K升序
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        List<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }

        return list.toArray(new int[list.size()][2]);
    }

}
