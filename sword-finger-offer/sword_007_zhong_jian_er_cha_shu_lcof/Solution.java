package sword_007_zhong_jian_er_cha_shu_lcof;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 *           3
 *          / \
 *         9  20
 *           /  \
 *          15   7
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode treeNode = new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 存储中序遍历的节点位置，用于计算 以当前节点为根节点时左子树与右子树的数量
        Map<Integer, Integer> inorderIndexMap = new HashMap<>((int) (inorder.length / .75f) + 1);
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return bringBack2Tree(preorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderIndexMap);
    }

    /**
     * 重建成树
     *
     * @param preorder          前序遍历结果
     * @param preorderBegin     当前子树在前序遍历中的起点 暨 当前子树的根节点
     * @param preorderEnd       当前子树在前序遍历中的终点
     * @param inorderBegin      当前子树在中序遍历中的起点
     * @param inorderEnd        当前子树在中序遍历中的终点
     * @param inorderIndexMap   每个节点在中序遍历中的位置
     * @return
     */
    private TreeNode bringBack2Tree(int[] preorder, int preorderBegin, int preorderEnd, int inorderBegin, int inorderEnd, Map<Integer, Integer> inorderIndexMap) {
        // 如果前序遍历的起点大于了终点，说明没有节点了  下方寻找左树可知   起始节点+1 <= 起始节点+左子节点数量才是还有
        if (preorderBegin > preorderEnd) {
            return null;
        }
        // 当前子树的根节点
        TreeNode root = new TreeNode(preorder[preorderBegin]);
        // 如果前序遍历的起点等于了终点，说明只有这么一个节点  下方寻找左树可知   起始节点+1 = 起始节点+左子节点数量说明节点只有一个左子树
        if (preorderBegin != preorderEnd) {
            // 获取到根节点在中序的位置，确定左子树节点与右子树节点的数量
            int rootIndex = inorderIndexMap.get(root.val);
            // 左子树节点数量
            int leftNodeNum = rootIndex - inorderBegin;
            // 右子树节点数量
            int rightNodeNum = inorderEnd - rootIndex;
            /*
                preorderBegin + 1               前序遍历中挨着根节点的就是左节点
                preorderBegin + leftNodeNum     前序遍历会先遍历所有左节点再去遍历右节点，所以根节点后leftNodeNum个都是左子树的节点
                inorderBegin                    中序比那里中根节点左边都是左树  第  inorderBegin ~ rootIndex - 1 个都是
                rootIndex - 1                   同上
             */
            TreeNode left = bringBack2Tree(preorder, preorderBegin + 1, preorderBegin + leftNodeNum, inorderBegin, rootIndex - 1, inorderIndexMap);
            /*
                preorderEnd - rightNodeNum + 1  前序遍历为【根节点，【左节点】，【右节点】】 右子树也是第一个为根节点
                preorderEnd                     前序最后一个即为右子树最后一个节点
                rootIndex + 1                   中序遍历根节点右边都是右树 第  rootIndex + 1 ~ inorderEnd 个都是
                inorderEnd                      同上
             */
            TreeNode right = bringBack2Tree(preorder, preorderEnd - rightNodeNum + 1, preorderEnd, rootIndex + 1, inorderEnd, inorderIndexMap);
            root.left = left;
            root.right = right;
        }
        return root;
    }

}
