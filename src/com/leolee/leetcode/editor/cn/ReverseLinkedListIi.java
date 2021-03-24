
//给你单链表的头节点 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 
// 👍 780 👎 0

package com.leolee.leetcode.editor.cn;
class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        int[] vals = {3};
        ListNode head = new ListNode(vals, 0);
        head = solution.reverseBetween(head, 1, 1);
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head;
        int i = 0;
        for (; i < left-2; i++) {
            temp = temp.next;
        }
        ListNode preTail = temp;

        ListNode reverseTail = temp.next;
        if (left == 1)
            reverseTail = temp;
        ListNode reversePre = reverseTail;
        ListNode reverseTemp = reversePre.next;
        ListNode reverseNext;
        int length = right - left;
        for (int j = 0; j < length; j++) {
            reverseNext = reverseTemp.next;
            reverseTemp.next = reversePre;
            reversePre = reverseTemp;
            reverseTemp = reverseNext;

        }
        if (left != 1)
            preTail.next = reversePre;
        reverseTail.next = reverseTemp;
        if (left == 1)
            return reversePre;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}