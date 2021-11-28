package com.epam.leetcode.addtwonumbers;

import java.util.List;

public class SolutionJ {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            throw new IllegalArgumentException("Lists must not be empty.");
        }
        ListNode currentLeftNode = l1;
        ListNode currentRightNode = l2;

        ListNode lastResultNode = null;
        ListNode root = null;
        int overflow = 0;

        while (currentLeftNode != null || currentRightNode != null) {

            if (currentLeftNode != null && currentRightNode == null) {
                int sum = currentLeftNode.val + overflow;
                int result;
                if (sum >= 10) {
                    overflow = 1;
                    result = sum % 10;
                } else {
                    overflow = 0;
                    result = sum;
                }

                lastResultNode.next = new ListNode(result, null);
                lastResultNode = lastResultNode.next;
                currentLeftNode = currentLeftNode.next;
                continue;
            } else if (currentLeftNode == null) {
                int sum = currentRightNode.val + overflow;
                int result;
                if (sum >= 10) {
                    overflow = 1;
                    result = sum % 10;
                } else {
                    overflow = 0;
                    result = sum;
                }
                lastResultNode.next = new ListNode(result, null);
                lastResultNode = lastResultNode.next;
                currentRightNode = currentRightNode.next;
                continue;
            }

            int left = currentLeftNode.val;
            int right = currentRightNode.val;
            int sum = left + right + overflow;
            int result;

            if (sum >= 10) {
                overflow = 1;
                result = sum % 10;
            } else {
                overflow = 0;
                result = sum;
            }

            if (root == null) {
                root = new ListNode(result, null);
                lastResultNode = root;
            } else {
                lastResultNode.next = new ListNode(result, null);
                lastResultNode = lastResultNode.next;
            }

            currentLeftNode = currentLeftNode.next;
            currentRightNode = currentRightNode.next;
        }

        if (overflow != 0) {
            lastResultNode.next = new ListNode(overflow, null);
        }

        return root;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

