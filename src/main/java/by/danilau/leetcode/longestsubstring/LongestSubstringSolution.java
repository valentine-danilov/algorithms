package by.danilau.leetcode.longestsubstring;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringSolution {

    public Integer lengthOfLongestSubstringV2(String s) {
        int maxLength = 0;
        int localMaxLength = 0;
        Map<Character, Integer> characters = new HashMap<>();
        int startScanIndex = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (characters.get(c) == null) {
                localMaxLength++;
            } else {
                int lastCharIndex = characters.get(c);
                if (lastCharIndex < startScanIndex) {
                    localMaxLength++;
                } else {
                    localMaxLength = i - lastCharIndex;
                    startScanIndex = lastCharIndex + 1;
                }
            }
            characters.put(c, i);
            maxLength = Math.max(maxLength, localMaxLength);
        }
        return maxLength;
    }
}
