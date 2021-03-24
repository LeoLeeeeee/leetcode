
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1646 👎 0

package com.leolee.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        generate(list, sb, n, 0);
        return list;
    }
    public void generate(List<String> list, StringBuilder sb, int n, int num) {
        if (n == 0 && num == 0) {
            list.add(sb.toString());
            return;
        }

        //生成"("
        if (n > 0) {
            sb.append('(');
            generate(list, sb, n-1, num+1);
            sb.deleteCharAt(sb.length()-1);
        }

        //生成")"
        if (num > 0) {
            sb.append(')');
            generate(list, sb, n, num-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}