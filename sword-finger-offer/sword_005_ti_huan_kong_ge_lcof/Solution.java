package sword_005_ti_huan_kong_ge_lcof;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 限制：
 * 0 <= s 的长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().replaceSpace("We are happy."));
    }

    public String replaceSpace(String s) {
        char[] newChar = new char[s.length() * 3];
        int endCharIndex = 0;

        for (char c : s.toCharArray()) {
            if (' ' == c) {
                newChar[endCharIndex++] = '%';
                newChar[endCharIndex++] = '2';
                newChar[endCharIndex++] = '0';
            } else {
                newChar[endCharIndex++] = c;
            }
        }
        return new String(newChar, 0, endCharIndex);
    }

}
