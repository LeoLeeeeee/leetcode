
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1190 👎 0

package com.leolee.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("23"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();
        Map<Integer, char[]> map = new HashMap<>();
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});

        List<String> ret = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrack(map, ret, sb, digits, 0);

        return ret;
    }

    public void backTrack(Map<Integer, char[]> map, List<String> ret, StringBuilder sb, String digits, int index) {
        int num = digits.charAt(index) - '0';
        char[] chars = map.get(num);
        if (index == digits.length()-1) {
            for (char ch : chars) {
                sb.append(ch);
                ret.add(sb.toString());
                sb.deleteCharAt(sb.length()-1);
            }
            return;
        }
        for (char ch : chars) {
            sb.append(ch);
            backTrack(map, ret, sb, digits, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}