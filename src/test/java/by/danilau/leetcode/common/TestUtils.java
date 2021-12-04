package by.danilau.leetcode.common;

import org.junit.jupiter.api.Assertions;

public class TestUtils {

    public static void assertEquals(ListNode expected, ListNode actual) {
        String expectedAsString = linkedListToStringReverse(expected);
        String actualAsString = linkedListToStringReverse(actual);

        Assertions.assertEquals(expectedAsString, actualAsString);
    }

    public static ListNode integerToLinkedList(int value) {
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

    public static String linkedListToStringReverse(ListNode node) {
        return linkedListToString(node, true);
    }

    public static String linkedListToString(ListNode node) {
        return linkedListToString(node, false);
    }

    public static String linkedListToString(ListNode node, boolean isReverse) {
        StringBuilder intValueAsString = new StringBuilder();
        ListNode lastNode = node;
        while (lastNode.next != null) {
            intValueAsString.append(lastNode.val);
            lastNode = lastNode.next;
        }
        intValueAsString.append(lastNode.val);

        if (isReverse) {
            return intValueAsString.reverse().toString();
        }

        return intValueAsString.toString();
    }
}
