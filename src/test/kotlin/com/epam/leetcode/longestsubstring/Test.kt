package com.epam.leetcode.longestsubstring

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class Test {
    @ParameterizedTest
    @CsvSource(
        value = [
            "abcabcbb,3",
            "bbbbb,1",
            "'',0",
            "dvdf,3",
            "au,2",
            "pwwkew,3",
            "abba,2",
            "abcde,5"
        ],
    )
    fun test(input: String, expected: Int) {
        val s = LongestSubstringSolution()
        Assertions.assertEquals(expected, s.lengthOfLongestSubstringV2(input))
    }

}