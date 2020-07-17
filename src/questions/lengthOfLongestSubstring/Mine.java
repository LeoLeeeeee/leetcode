package questions.lengthOfLongestSubstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mine {

    public static int lengthOfLongestSubstring(String s) {
        int size = 0;
        int end = 0;
        List<Character> list = new ArrayList<>();
        list.add('a');
        for (int i = 0; i < s.length(); i++){
            list.remove(0);
            for (int j = end; j < s.length(); j++){
                if (list.contains(s.charAt(j))){
                    break;
                }
                list.add(s.charAt(j));
                end++;
            }
            if (list.size() > size)
                size = list.size();
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }
}
