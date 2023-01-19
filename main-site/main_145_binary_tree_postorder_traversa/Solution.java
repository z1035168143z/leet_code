package main_145_binary_tree_postorder_traversa;

import baseDomain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 *
 * @author zzr
 * @date 2023/1/18 18:29
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(new Solution().postorderTraversal(root));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        TreeNode preNode = null;
        while (root != null || !nodes.isEmpty()) {
            while (root != null) {
                nodes.push(root);
                root = root.left;
            }
            // 到这里，当前节点左节点已经为null
            root = nodes.pop();
            // 左右节点均为null了，可以记录当前节点 || 当前节点的右节点已经记录了
            if (root.right == null || preNode == root.right) {
                result.add(root.val);
                preNode = root;
                root = null;
            } else {
                // 当前节点入栈，需要先处理右节点
                nodes.push(root);
                root = root.right;
            }
        }

        return result;
    }

}

