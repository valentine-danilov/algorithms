package com.epam.leetcode.mergeksortedlists;

import com.epam.leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.epam.leetcode.common.TestUtils.*;
import static org.junit.jupiter.api.Assertions.*;

class MergeKSortedListsSolutionTest {

    MergeKSortedListsSolution solutionJ = new MergeKSortedListsSolution();

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(
                        new ListNode[]{
                                buildLinkedList(1, 4, 5),
                                buildLinkedList(1, 3, 4),
                                buildLinkedList(2, 6)
                        },
                        buildLinkedList(1, 1, 2, 3, 4, 4, 5, 6)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void test(ListNode[] input, ListNode expected) {
        ListNode actual = solutionJ.mergeKLists(input);
        assertEquals(linkedListToString(expected), linkedListToString(actual));
    }

    static ListNode buildLinkedList(Integer... values) {
        ListNode result = null;
        ListNode last = null;
        for (Integer number : values) {
            if (result == null) {
                result = new ListNode(number, null);
                last = result;
            } else {
                last.next = new ListNode(number, null);
                last = last.next;
            }
        }
        return result;
    }

}