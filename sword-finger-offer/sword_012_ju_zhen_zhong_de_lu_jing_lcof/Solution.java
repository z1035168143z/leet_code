package sword_012_ju_zhen_zhong_de_lu_jing_lcof;

import java.util.Arrays;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
//        System.out.println(
//            new Solution().exist(
//                new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
//                "ABCCED")
//        );
        System.out.println(
            new Solution().exist(
                new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}},
                "ABCESEEEFS")
        );
//        System.out.println(
//            new Solution().exist(
//                new char[][]{{'a', 'b'}, {'c', 'd'}},
//                "abcd")
//        );
    }

    public boolean exist(char[][] board, String word) {
        char first = word.charAt(0);
        boolean theWay;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != first) {
                    continue;
                }
                theWay = findTheWay(board, word, i, j, 0);
                if (theWay) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean findTheWay(char[][] board, String word, int row, int column, int wordCharIndex) {
        if (row < 0 || row >= board.length) {
            return false;
        }
        if (column < 0 || column >= board[0].length) {
            return false;
        }
        char curChar = word.charAt(wordCharIndex);

        if (board[row][column] != curChar) {
            return false;
        }

        // 最后一个字符也匹配上了
        if (wordCharIndex == word.length() - 1) {
            return true;
        }
        board[row][column] = '\0';
        wordCharIndex = wordCharIndex + 1;

        boolean findRst = findTheWay(board, word, row - 1, column, wordCharIndex) ||
                            findTheWay(board, word, row + 1, column, wordCharIndex) ||
                            findTheWay(board, word, row, column + 1, wordCharIndex) ||
                            findTheWay(board, word, row, column - 1, wordCharIndex);
        board[row][column] = curChar;
        return findRst;
    }

}
