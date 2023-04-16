package main_257_binary_tree_paths;

import baseDomain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * @author zrzhao
 * @date 2023/4/13
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.right = node5;

        List<String> strings = new Solution().binaryTreePaths(node1);

        System.out.println(strings);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, "", paths);

        return paths;
    }

    public void dfs(TreeNode node, String prefix, List<String> paths) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                paths.add(prefix + node.val);
            } else {
                dfs(node.left, prefix + node.val + "->", paths);
                dfs(node.right, prefix + node.val + "->", paths);
            }
        }
    }


}
