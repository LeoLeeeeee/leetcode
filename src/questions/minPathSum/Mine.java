package questions.minPathSum;


/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Mine {
    public static int minPathSum(int[][] grid) {
        int[][] ans = new int[grid.length][grid[0].length];
        ans[0][0] = grid[0][0];
        for (int i = 1; i < ans.length; i++) {
            ans[i][0] = ans[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            ans[0][i] = ans[0][i-1] + grid[0][i];
        }
        if (grid.length > 1 && grid[0].length > 1){
            for (int i = 1; i < ans.length; i++){
                for (int j = 1; j < ans[i].length; j++){
                    ans[i][j] = Math.min(ans[i-1][j], ans[i][j-1]) + grid[i][j];
                }
            }
        }
        return ans[ans.length-1][ans[0].length-1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}
