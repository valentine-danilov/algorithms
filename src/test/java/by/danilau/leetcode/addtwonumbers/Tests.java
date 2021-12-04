package by.danilau.leetcode.addtwonumbers;

import by.danilau.leetcode.common.TestUtils;
import by.danilau.leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Tests {

    AddTwoNumberSolution solution = new AddTwoNumberSolution();

    static Stream<Arguments> testCases() {
        return Stream.of(
                // left argument, right argument, expected
                Arguments.of(TestUtils.integerToLinkedList(11), TestUtils.integerToLinkedList(12), TestUtils.integerToLinkedList(23)),
                Arguments.of(TestUtils.integerToLinkedList(1), TestUtils.integerToLinkedList(2), TestUtils.integerToLinkedList(3)),
                Arguments.of(TestUtils.integerToLinkedList(1123), TestUtils.integerToLinkedList(1223), TestUtils.integerToLinkedList(2346)),
                Arguments.of(TestUtils.integerToLinkedList(342), TestUtils.integerToLinkedList(465), TestUtils.integerToLinkedList(807)),
                Arguments.of(TestUtils.integerToLinkedList(1), TestUtils.integerToLinkedList(23), TestUtils.integerToLinkedList(24)),
                Arguments.of(TestUtils.integerToLinkedList(23), TestUtils.integerToLinkedList(1), TestUtils.integerToLinkedList(24)),
                Arguments.of(TestUtils.integerToLinkedList(9999999), TestUtils.integerToLinkedList(9999), TestUtils.integerToLinkedList(10009998))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(ListNode left, ListNode right, ListNode expected) {
        ListNode actual = solution.addTwoNumbers(left, right);
        TestUtils.assertEquals(expected, actual);
    }
}
