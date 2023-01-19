package main_92_inary_tree_inorder_traversa;

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
            while (root != null) {
                nodes.add(root);
                root = root.left;
            }
            root = nodes.pop();
            result.add(root.val);
            root = root.right;
        }

        return result;
    }

}
