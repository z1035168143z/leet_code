package main_101_symmetric_tree;

import baseDomain.TreeNode;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * @author zrzhao
 * @date 2023/4/14
 */
public class Solution {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

}
