package com.epam.leetcode.addtwonumbers;

import com.epam.leetcode.common.ListNode;

import java.util.List;

public class AddTwoNumberSolution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            throw new IllegalArgumentException("Lists must not be empty.");
        }
        ListNode currentLeftNode = l1;
        ListNode currentRightNode = l2;

        ListNode lastResultNode = null;
        ListNode root = null;
        int overflow = 0;
        int localSum;
        int localNodeValue;

        while (currentLeftNode != null || currentRightNode != null) {

            if (currentLeftNode != null && currentRightNode == null) {
                localSum = currentLeftNode.val + overflow;
                if (localSum >= 10) {
                    overflow = 1;
                    localNodeValue = localSum % 10;
                } else {
                    overflow = 0;
                    localNodeValue = localSum;
                }

                lastResultNode.next = new ListNode(localNodeValue, null);
                lastResultNode = lastResultNode.next;
                currentLeftNode = currentLeftNode.next;
                continue;
            } else if (currentLeftNode == null) {
                localSum = currentRightNode.val + overflow;
                if (localSum >= 10) {
                    overflow = 1;
                    localNodeValue = localSum % 10;
                } else {
                    overflow = 0;
                    localNodeValue = localSum;
                }
                lastResultNode.next = new ListNode(localNodeValue, null);
                lastResultNode = lastResultNode.next;
                currentRightNode = currentRightNode.next;
                continue;
            }

            localSum = currentLeftNode.val + currentRightNode.val + overflow;

            if (localSum >= 10) {
                overflow = 1;
                localNodeValue = localSum % 10;
            } else {
                overflow = 0;
                localNodeValue = localSum;
            }

            if (root == null) {
                root = new ListNode(localNodeValue, null);
                lastResultNode = root;
            } else {
                lastResultNode.next = new ListNode(localNodeValue, null);
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

