package questions.isBipartite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mine {
    public static boolean isBipartite(int[][] graph) {
        List<Integer> hasNode = new ArrayList<>();
        int[] flag = new int[graph.length];
        for (int i = 0; i < graph.length; i++){
            dfs(graph, hasNode, i, flag, 1);
        }
        for (int i = 0; i < graph.length; i++){
            for (int j = 0; j < graph[i].length; j++){
                if ((flag[i] + flag[graph[i][j]])%2 == 0)
                    return false;
            }
        }
        return true;
    }

    public static void dfs(int[][] graph, List<Integer> hasNode, int node, int[] flag, int color){
        if (!hasNode.contains(node)){
            flag[node] = color;
            color++;
            hasNode.add(node);
            for (int i = 0; i < graph[node].length; i++){

                dfs(graph, hasNode, graph[node][i], flag, color);
            }
        }
    }

    public static void main(String[] args) {
//        int[][] graph = {{1,3}, {0,2}, {1,3}, {0,2}};
//        int[][] graph = {{1,2,3}, {0,2}, {0,1,3}, {0,2}};
        int[][] graph = {{1}, {0,3}, {3}, {1,2}};
        System.out.println(isBipartite(graph));;
    }

}
