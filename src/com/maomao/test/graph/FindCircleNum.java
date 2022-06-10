package com.maomao.test.graph;

/**
 * 省份数量
 *
 *  n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
 * 而 isConnected[i][j] = 0 表示二者不直接相连。
 * 返回矩阵中 省份 的数量。
 *
 * 示例 1：
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 *
 * 示例 2：
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 *
 * @author: huida
 * @date: 2021/1/7
 **/
public class FindCircleNum {

    /**
     * 可以把 n 个城市和它们之间的相连关系看成图，城市是图中的节点，相连关系是图中的边，
     * 给定的矩阵 isConnected 即为图的邻接矩阵，省份即为图中的连通分量。
     *
     * 图的深度优先遍历
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        int n = isConnected.length;
        //标识顶点是否被访问
        boolean[] visited = new boolean[n];
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                //若当前顶点 i 未被访问，说明又是一个新的连通域
                res++;
                dfs(i, isConnected, visited);
            }
        }
        return res;
    }

    private void dfs(int i, int[][]isConnected, boolean[] visited) {
        //标记为访问过
        visited[i] = true;
        for (int j=0; j<isConnected.length; j++) {
            //继续寻找联通的城市
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(j, isConnected, visited);
            }
        }

    }
}
