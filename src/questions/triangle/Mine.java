package questions.triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Number;

public class Mine {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] answer = new int[size][size];
        answer[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++){
            answer[i][0] = answer[i-1][0] + triangle.get(i).get(0);
            answer[i][i] = answer[i-1][i-1] + triangle.get(i).get(i);
            for (int j = 1; j < i; j++)
                answer[i][j] = Math.min(answer[i-1][j-1], answer[i-1][j]) + triangle.get(i).get(j);
        }
        Arrays.sort(answer[size-1]);
        return answer[size-1][0];
    }

    public static void main(String[] args) {
//        List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3));
        List<List<Integer>> triangle = Arrays.asList(Arrays.asList(-1), Arrays.asList(2, 3), Arrays.asList(1, -1, -3));

//        minimumTotal(triangle);
        System.out.println(minimumTotal(triangle));
    }
}
