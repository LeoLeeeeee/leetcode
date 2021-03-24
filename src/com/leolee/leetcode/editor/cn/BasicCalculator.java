
//实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 数学 
// 👍 397 👎 0

package com.leolee.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new BasicCalculator().new Solution();
//        int a = -+-3;
//        System.out.println(a);
        String s = "0";
        System.out.println(solution.calculate(s));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }
            stack.push(ch);
            if (stack.peek() == ')') {
                int popCh = stack.pop();
                while (popCh != '(') {
                    sb.append((char) popCh);
                    popCh = stack.pop();
                }
                sb.deleteCharAt(0).reverse();
                String temp = "" +simpleCalculate(sb.toString());
                for (int j = 0; j < temp.length(); j++) {
                    stack.push(temp.charAt(j));
                }
                sb.delete(0, sb.length());
            }

        }
        sb.delete(0, sb.length());
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return simpleCalculate(sb.reverse().toString());
    }
    public int simpleCalculate(String s) {
        int length = s.length();
        List<Integer> variables = new ArrayList<>();
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < length; i++) {
            char ch = s.charAt(i);
            char prev = s.charAt(i-1);
            if ((ch < '0' || ch > '9') && ('0' <= prev && prev <= '9')) {
                int count = 0;
                int j = 0;
                for (j = 0; sb.charAt(j) < '0' || sb.charAt(j) > '9'; j++) {
                    if (sb.charAt(j) == '-') {
                        count++;
                    }
                }
                if (count%2 == 0) {
                    sb.replace(0, j, "");
                } else {
                    sb.replace(0, j, "-");
                }
                variables.add(Integer.parseInt(sb.toString()));
                sb.delete(0, sb.length());
            }
            sb.append(ch);
        }
        int count = 0;
        int j = 0;
        for (j = 0; sb.charAt(j) < '0' || sb.charAt(j) > '9'; j++) {
            if (sb.charAt(j) == '-') {
                count++;
            }
        }
        if (count%2 == 0) {
            sb.replace(0, j, "");
        } else {
            sb.replace(0, j, "-");
        }
        variables.add(Integer.parseInt(sb.toString()));
        for (Integer variable : variables) {
            sum += variable;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}