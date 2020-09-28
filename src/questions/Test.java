package questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test {

    public static boolean isValid(String s) {
        Stack stack = new Stack();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else{
                if(s.charAt(i) != map.get(stack.peek()))
                    return false;
                else
                    stack.pop();
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
