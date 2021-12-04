package com.epam.leetcode.addtwonumbers;

import com.epam.leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.epam.leetcode.common.TestUtils.assertEquals;
import static com.epam.leetcode.common.TestUtils.integerToLinkedList;

public class Tests {

    AddTwoNumberSolution solution = new AddTwoNumberSolution();

    static Stream<Arguments> testCases() {
        return Stream.of(
                // left argument, right argument, expected
                Arguments.of(integerToLinkedList(11), integerToLinkedList(12), integerToLinkedList(23)),
                Arguments.of(integerToLinkedList(1), integerToLinkedList(2), integerToLinkedList(3)),
                Arguments.of(integerToLinkedList(1123), integerToLinkedList(1223), integerToLinkedList(2346)),
                Arguments.of(integerToLinkedList(342), integerToLinkedList(465), integerToLinkedList(807)),
                Arguments.of(integerToLinkedList(1), integerToLinkedList(23), integerToLinkedList(24)),
                Arguments.of(integerToLinkedList(23), integerToLinkedList(1), integerToLinkedList(24)),
                Arguments.of(integerToLinkedList(9999999), integerToLinkedList(9999), integerToLinkedList(10009998))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(ListNode left, ListNode right, ListNode expected) {
        ListNode actual = solution.addTwoNumbers(left, right);
        assertEquals(expected, actual);
    }
}
