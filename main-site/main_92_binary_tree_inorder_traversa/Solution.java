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
        if (root == null) {
            return result;
        }
        Deque<Object> dequeue = new LinkedList<>();
        dequeue.offer(root);

        while (!dequeue.isEmpty()) {
            Object node = dequeue.pop();
            if (node instanceof Integer) {
                result.add((Integer) node);
            } else {
                TreeNode treeNode = (TreeNode) node;
                if (treeNode.right != null) {
                    dequeue.push(treeNode.right);
                }
                dequeue.push(treeNode.val);
                if (treeNode.left != null) {
                    dequeue.push(treeNode.left);
                }
            }
        }

        return result;
    }

}
