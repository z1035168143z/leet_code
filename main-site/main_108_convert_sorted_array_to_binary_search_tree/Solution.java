package main_108_convert_sorted_array_to_binary_search_tree;

import baseDomain.TreeNode;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zrzhao
 * @date 2023/4/14
 */
public class Solution {

    public static void main(String[] args) {
        int[] ints = {-10, -3, 0, 5, 9};
        System.out.println(new Solution().sortedArrayToBST(ints));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return buildTree(0, nums.length - 1, nums);
    }

    private TreeNode buildTree(int beginIndex, int endIndex, int[] nums) {
        if (beginIndex > endIndex) {
            return null;
        }
        int centerIdx = (beginIndex + endIndex) / 2;

        TreeNode treeNode = new TreeNode(nums[centerIdx]);
        treeNode.left = buildTree(beginIndex, centerIdx - 1, nums);
        treeNode.right = buildTree(centerIdx + 1, endIndex, nums);

        return treeNode;
    }

}
