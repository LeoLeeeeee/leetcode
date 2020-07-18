package questions.isInterleave;

public class Mine {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        boolean[][] ans = new boolean[s1.length()+1][s2.length()+1];
        ans[0][0] = true;
        for (int i = 1; i < ans[0].length; i++){
            ans[0][i] = ans[0][i-1] && s3.charAt(i-1) == s2.charAt(i-1);
        }
        for (int i = 1; i < ans.length; i++){
            ans[i][0] = ans[i-1][0] && s3.charAt(i-1) == s1.charAt(i-1);
        }
        for (int i = 1; i < ans.length; i++){
            for (int j = 1; j < ans[i].length; j++){
                ans[i][j] = (ans[i-1][j] && s3.charAt(i+j-1) == s1.charAt(i-1)) || (ans[i][j-1] && s3.charAt(i+j-1) == s2.charAt(j-1));
            }
        }
        return ans[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        String s4 = "aadbbbaccc";
        System.out.println(isInterleave(s1, s2, s3));
//        System.out.println(isInterleave("a","","a"));
    }
}
