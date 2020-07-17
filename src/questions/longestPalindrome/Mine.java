package questions.longestPalindrome;

public class Mine {

    public static boolean isPalindrome(String s){
        for (int i = 0; i < s.length()/2; i++){
            if (s.charAt(i) != s.charAt(s.length()-i-1))
                return false;
        }
        return true;
    }

    public static String longestPalindrome(String s) {

        int right = s.length();
        int size = 0;
        String ans = "";
        for (int i = 0; i < s.length(); i++){
            while (!isPalindrome(s.substring(i, right))) {
                right--;
            }
            if (right - i > size){
                size = right - i;
                ans = s.substring(i, right);
            }
            right = s.length();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
//        System.out.println(isPalindrome("a"));
//        System.out.println("01234".substring(2,3));
    }
}
