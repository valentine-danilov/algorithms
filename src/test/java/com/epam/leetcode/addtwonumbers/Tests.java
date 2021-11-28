package com.epam.leetcode.addtwonumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Tests {

    SolutionJ solution = new SolutionJ();

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

    void assertEquals(ListNode expected, ListNode actual) {
        String expectedAsString = linkedListToInteger(expected);
        String actualAsString = linkedListToInteger(actual);

        Assertions.assertEquals(expectedAsString, actualAsString);
    }

    static ListNode integerToLinkedList(int value) {
        ListNode root = null;
        ListNode lastNode = null;
        int remaining = value;
        while (remaining > 0) {
            int nodeValue = remaining % 10;
            remaining /= 10;
            if (root == null) {
                root = new ListNode(nodeValue, null);
                lastNode = root;
            } else {
                lastNode.next = new ListNode(nodeValue, null);
                lastNode = lastNode.next;
            }
        }
        return root;
    }

    static String linkedListToInteger(ListNode node) {
        StringBuilder intValueAsString = new StringBuilder();
        ListNode lastNode = node;
        while (lastNode.next != null) {
            intValueAsString.append(lastNode.val);
            lastNode = lastNode.next;
        }
        intValueAsString.append(lastNode.val);
        return intValueAsString.reverse().toString();
    }

}
