package com.epam.leetcode.mergeksortedlists;

import com.epam.leetcode.common.ListNode;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class MergeKSortedListsSolution {

    public ListNode mergeKLists(ListNode[] lists) {
        Map<Integer, Integer> repetitionsMap = new TreeMap<>();
        for (ListNode value : lists) {
            ListNode current = value;
            while (current != null) {
                if (repetitionsMap.containsKey(current.val)) {
                    int amount = repetitionsMap.get(current.val);
                    repetitionsMap.put(current.val, amount + 1);
                } else {
                    repetitionsMap.put(current.val, 1);
                }
                current = current.next;
            }
        }
        ListNode result = null;
        ListNode last = null;
        for (Map.Entry<Integer, Integer> entry : repetitionsMap.entrySet()) {
            int number = entry.getKey();
            int numberOfRepetitions = entry.getValue();
            while (numberOfRepetitions > 0) {
                if (result == null) {
                    result = new ListNode(number, null);
                    last = result;
                } else {
                    last.next = new ListNode(number, null);
                    last = last.next;
                }
                numberOfRepetitions--;
            }
        }
        return result;
    }
}