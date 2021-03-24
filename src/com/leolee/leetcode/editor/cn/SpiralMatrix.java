
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 693 👎 0

package com.leolee.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(solution.spiralOrder(matrix));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] dests = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int width = matrix[0].length;
        int height = matrix.length;
        int length = width * height;
        boolean bool = true;
        int flag = 0;
        List<Integer> ret = new ArrayList<>();
        int x = 0, y = -1;
        int i = 0;
        while (i < length) {
            int[] dest = dests[flag % 4];
            if (bool) {
                for (int j = 0; j < width; j++) {
                    y += dest[1];
                    ret.add(matrix[x][y]);
                    i++;
                }
                bool = false;
                height--;
            } else {
                for (int j = 0; j < height; j++) {
                    x += dest[0];
                    ret.add(matrix[x][y]);
                    i++;
                }
                bool = true;
                width--;
            }
            flag++;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}