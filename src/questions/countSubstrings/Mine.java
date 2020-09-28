package questions.countSubstrings;

/**
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Mine {
    public static int countSubstrings(String s) {
        int size = 0;
        for(int i = 0; i < s.length(); i++){
            int distance = 0;
            while(i-distance >= 0 && i+distance <= s.length()-1){
                if(s.charAt(i-distance) == s.charAt(i+distance)){
                    size++;
                    distance++;
                } else
                    break;
            }
        }
        for(int i = 0; i < s.length()-1; i++){
            int distance = 0;
            while(i-distance >= 0 && i+distance+1 <= s.length()-1){
                if(s.charAt(i-distance) == s.charAt(i+1+distance)){
                    size++;
                    distance++;
                } else
                    break;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
}
