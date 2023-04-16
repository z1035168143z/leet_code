package main_3_longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author zrzhao
 * @date 2023/4/16
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution().lengthOfLongestSubstring("abba"));
        System.out.println(new Solution().lengthOfLongestSubstring("zwnigfunjwz"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> charPreIndexMap = new HashMap<>();
        int longestLength = 1;
        int strLeftIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer charPreIndex = charPreIndexMap.get(s.charAt(i));
            if (charPreIndex != null) {
                strLeftIndex = Math.max(strLeftIndex, charPreIndex + 1);
            }

            charPreIndexMap.put(s.charAt(i), i);
            longestLength = Math.max(longestLength, i - strLeftIndex + 1);
        }

        return longestLength;
    }

}
