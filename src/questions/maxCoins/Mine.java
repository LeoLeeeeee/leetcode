package questions.maxCoins;

/**
 * 312.戳气球
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Mine {

    public static int maxCoins(int[] nums) {
        int[][] ans = new int[nums.length+2][nums.length+2];
        int[] numsPlus = new int[nums.length+2];
        numsPlus[0] = numsPlus[numsPlus.length-1] = 1;
        for (int i = 1; i < numsPlus.length-1; i++)
            numsPlus[i] = nums[i-1];
        for (int i = 2; i < ans.length; i++){
            for (int j = 0; j < ans.length-i; j++){
                for (int k = 1; k < i; k++){
                    int maxAns = numsPlus[j]*numsPlus[j+k]*numsPlus[j+i] + ans[j][j+k] + ans[j+k][j+i];
                    if (maxAns > ans[j][j+i])
                        ans[j][j+i] = maxAns;
                }
            }

        }
        return ans[0][ans.length-1];
    }

    public static void main(String[] args) {
        int[] nums= {3,1,5,8};
        System.out.println(maxCoins(nums));
    }
}
