package sword_013_ji_qi_ren_de_yun_dong_fan_wei_lcof;

import javax.sound.midi.Soundbank;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k<= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(2, 3, 1));
    }

    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[] passed = new boolean[m * n];
        passed[0] = true;

        int cnt = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0 || getNum(i) + getNum(j) > k) {
                    continue;
                }
                int currentIndex = i * n + j;
                if (i >= 1) {
                    passed[currentIndex] |= passed[(i - 1) * n + j];
                }
                if (j >= 1) {
                    passed[currentIndex] |= passed[currentIndex - 1];
                }
                cnt += passed[currentIndex] ? 1 : 0;
            }
        }
        return cnt;
    }

    private int getNum(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }

}
