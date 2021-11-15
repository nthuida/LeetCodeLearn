package com.maomao.test.tree;

/**
 * 监控二叉树
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * 计算监控树的所有节点所需的最小摄像头数量。
 * @author huida
 * @date 2020/9/22
 */
public class MinCameraCover {
    int res = 0;
    /**
     * @param root
     * @return
     */
    public int minCameraCover(TreeNode root) {
        if (lrd(root) == 0) {
            //待覆盖，需要安装一个
            res++;
        }
        return res;
    }

    /**
     *   后序遍历
     *   0 这个节点待覆盖
     *   1 这个节点已经覆盖
     *   2 这个节点上安装了相机
     * @param treeNode
     * @return
     */
    private int lrd(TreeNode treeNode) {
        if (treeNode == null) {
            //虚节点，设为已覆盖
            return 1;
        }
        int left = lrd(treeNode.left);
        int right= lrd(treeNode.right);

        if (left == 0|| right ==0) {
            //左或右子树没有覆盖，父节点需要安装一个
            res++;
            return 2;
        } else if (left == 2|| right ==2) {
            //子节点安装了
            return 1;
        } else {
            return 0;
        }
    }
}
