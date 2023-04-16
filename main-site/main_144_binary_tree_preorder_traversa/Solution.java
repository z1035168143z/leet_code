package main_144_binary_tree_preorder_traversa;

import baseDomain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * @author zzr
 * @date 2023/1/18 18:29
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(new Solution().preorderTraversal(root));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<Object> nodes = new LinkedList<>();
        nodes.push(root);

        while (!nodes.isEmpty()) {
            Object obj = nodes.pop();
            if (obj instanceof Integer) {
                result.add((Integer) obj);
            } else {
                TreeNode treeNode = (TreeNode) obj;
                if (treeNode.right != null) {
                    nodes.push(treeNode.right);
                }
                if (treeNode.left != null) {
                    nodes.push(treeNode.left);
                }
                nodes.push(treeNode.val);
            }
        }

        return result;
    }

}
