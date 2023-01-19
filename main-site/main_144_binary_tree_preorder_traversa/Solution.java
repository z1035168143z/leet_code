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
        LinkedList<TreeNode> nodes = new LinkedList<>();
        while (root != null || !nodes.isEmpty()) {
            while (root != null) {
                // 先自己
                result.add(root.val);
                // 右节点加入队列
                if (root.right != null) {
                    nodes.push(root.right);
                }
                // 左节点
                root = root.left;
            }
            // 不为空，存在未记录的右节点
            if (!nodes.isEmpty()) {
                root = nodes.pop();
            }
        }

        return result;
    }

}
