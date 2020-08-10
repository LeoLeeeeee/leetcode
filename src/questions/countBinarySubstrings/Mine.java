package questions.countBinarySubstrings;

import java.util.Stack;

public class Mine {

    public static int countBinarySubstrings(String s) {
        int begin = 0;
        int sum = 0;
        Stack stack = new Stack();
        while(true){
            char c = s.charAt(begin);
            int time = 0;
            while(s.charAt(begin) == c){
                stack.push(s.charAt(begin));
                begin++;
                time++;
                if(begin == s.length())
                    return sum;
            }
            for(int j = 0; j < time; j++){
                if(begin + j < s.length() && s.charAt(begin + j) != c)
                    stack.pop();
                else{
                    sum += j;
                    break;
                }
            }
            if(stack.isEmpty())
                sum += time;
            stack.clear();
        }
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110"));
    }
}
