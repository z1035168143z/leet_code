package sword_006_cong_wei_dao_tou_da_yin_lian_biao_lcof;

import java.util.Arrays;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().reversePrint(new ListNode(2))));
    }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        ListNode tmpNode = head;
        int nodeLen = 0;
        while (tmpNode != null) {
            nodeLen++;
            tmpNode = tmpNode.next;
        }

        int[] ints = new int[nodeLen];
        while (head != null) {
            ints[--nodeLen] = head.val;
            head = head.next;
        }
        return ints;
    }

}
