package com.maomao.test.array;

import java.util.*;

/**
 * 课程表
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 * 示例 1:
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 *
 * 示例 2:
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *
 * @author huida
 * @date 2020/5/19
 */
public class CanFinish {

    /**
     *  拓扑排序 判断此课程安排图是否是 有向无环图(DAG)
     * 有向图 中有 入度 和 出度 概念：如果存在一条有向边 A --> B，则这条边给 A 增加了 1 个出度，给 B 增加了 1 个入度
     *
     * 1、统计课程安排图中每个节点的入度，生成 入度表 indegrees。
     * 2、借助一个队列 queue，将所有入度为 0 的节点入队。
     * 3、当 queue 非空时，依次将队首节点出队，将此节点对应所有邻接节点 cur 的入度 −1，即 indegrees[cur] -= 1。当入度 −1后邻接节点 cur 的入度为 0，此时将 cur 入队。
     * 4、在每次 pre 出队时，执行 numCourses--；
     * 若整个课程安排图是有向无环图（即可以安排），则所有节点一定都入队并出队过，即完成拓扑排序。换个角度说，若课程安排图中存在环，一定有节点的入度始终不为 0。
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
            indegrees[cp[0]]++;
            List<Integer> list = mapCourse.get(cp[1]);
            if (list == null) {
                list = new ArrayList<>();
            }
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

    /**
     * 课程表II
     * 现在你总共有 n 门课需要选，记为 0 到 n-1。
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
     * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
     * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
     *
     * 示例 1:
     * 输入: 2, [[1,0]]
     * 输出: [0,1]
     * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
     *
     * 示例 2:
     * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
     * 输出: [0,1,2,3] or [0,2,1,3]
     * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
     *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        //入度表，索引代表课程，值为度
        int[] indegrees = new int[numCourses];
        //课程的关联关系
        Map<Integer, List<Integer>> mapCourse = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        // 初始化入度表、课程关系map
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            List<Integer> list = mapCourse.get(cp[1]);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(cp[0]);
            mapCourse.put(cp[1], list);
        }

        // 把度为0的课程加入队列
        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) {
                queue.add(i);
            }
        }
        // 记录可以学完的课程数量
        int count = 0;
        // 可以学完的课程
        int[] res = new int[numCourses];

        // BFS
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            res[ count++] = pre;
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

        if (count ==  numCourses) {
            return res;
        }

        return new int[0];

    }

    public static void main(String[] args) {
        int[][] a = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(new CanFinish().canFinish(4, a));
        int[] b = new CanFinish().findOrder(4,a);
        for (int i : b) {
            System.out.println(i);
        }
    }
}
