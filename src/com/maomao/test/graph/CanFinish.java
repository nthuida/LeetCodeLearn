package com.maomao.test.graph;

import java.util.*;

/**
 * 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
 * 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 *
 * 示例 2：
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；
 * 并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 *
 * @author: huida
 * @date: 2022/4/19
 **/
public class CanFinish {

    /**
     * BFS
     * 1、统计课程安排图中每个节点的入度，生成 入度表 indegrees。
     * 2、借助一个队列 queue，将所有入度为 0 的节点入队。
     * 3、当 queue 非空时，依次将队首节点出队，将此节点对应所有邻接节点 cur 的入度 -1，
     * 当邻接节点 cur 的入度为 0，此时将 cur 入队。
     * 4、在每次 出队时，执行 numCourses--；
     * 若整个课程安排图是有向无环图（即可以安排），则所有节点一定都入队并出队过，即完成拓扑排序。
     * 换个角度说，若课程安排图中存在环，一定有节点的入度始终不为 0。
     * 因此，拓扑排序出队次数等于课程个数，返回 numCourses == 0 判断课程是否可以成功安排。
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //入度表，索引代表课程，值为度
        int[] indegrees = new int[numCourses];
        //课程的关联关系
        Map<Integer, List<Integer>> mapCourse = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        // 初始化入度表、课程关系map
        for(int[] cp : prerequisites) {
            //计算入度
            indegrees[cp[0]]++;
            //保存相邻课程的关系
            List<Integer> list = mapCourse.getOrDefault(cp[1], new ArrayList<>());
            list.add(cp[0]);
            mapCourse.put(cp[1], list);
        }
        // 把度为0的课程加入队列
        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) {
                queue.add(i);
            }
        }

        // BFS
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            List<Integer> list = mapCourse.get(pre);
            if (list != null) {
                for(int cur : list) {
                    //出队后，相关课程度减1，如果减1后为0 ，则加入队列
                    if (--indegrees[cur] == 0) {
                        queue.add(cur);
                    }
                }
            }

        }
        return numCourses == 0;
    }
}
