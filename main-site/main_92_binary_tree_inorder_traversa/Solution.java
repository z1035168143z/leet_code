package main_92_binary_tree_inorder_traversa;

import baseDomain.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * @author zzr
 * @date 2023/1/18 18:29
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(new Solution().inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        while (root != null || !nodes.isEmpty()) {
            // 一路向左
            while (root != null) {
                nodes.add(root);
                root = root.left;
            }
            // 到这里，左节点为null或已经遍历过左节点
            root = nodes.pop();
            result.add(root.val);
            // 存入当前节点后，处理右节点
            root = root.right;
        }

        return result;
    }

}
