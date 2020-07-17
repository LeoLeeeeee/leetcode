package questions.minSubArrayLen;

public class Mine {
    public static int minSubArrayLen(int s, int[] nums) {
        int answer = nums.length;
        for (int i = 0; i < nums.length; i++){
            int total = 0;
            int temp = 0;
            for (int j = i; j < nums.length; j++){
                total += nums[j];
                temp++;
                if (total >= s){
                    if (temp < answer)
                        answer = temp;
                    break;
                }
                if (i == 0 && j+1 == nums.length && total<s)
                    answer = 0;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
//        int[] nums = {2,3,1,2,4,3};
        int[] nums = {1,1};
        System.out.println(minSubArrayLen(7, nums));
    }
}
