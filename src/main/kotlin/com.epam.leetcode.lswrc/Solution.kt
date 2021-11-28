package com.epam.leetcode.lswrc

import kotlin.math.max
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

fun main() {
    println(lengthOfLongestSubstringV2("blqsearxxxbiwqa"))
}

fun lengthOfLongestSubstringV2(s: String): Int {
    var maxLength = 0
    var localMaxLength = 0
    val characters = mutableMapOf<Int, Int>()
    var startScanIndex = 0

    var i = 0
    s.chars().forEach { char ->
        if (characters[char] == null) {
            localMaxLength++
        } else {
            val lastCharIndex = characters[char]!!
            if (lastCharIndex < startScanIndex) {
                localMaxLength++
            } else {
                localMaxLength = i - lastCharIndex
                startScanIndex = lastCharIndex + 1
            }
        }
        characters[char] = i
        maxLength = Math.max(maxLength, localMaxLength)
        i++
    }

    return maxLength
}