package com.leolee.leetcode.editor.cn;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    ListNode(int[] vals, int index) {
        this.val = vals[index];
        if (index != vals.length-1)
            this.next = new ListNode(vals, index+1);
    }
}
