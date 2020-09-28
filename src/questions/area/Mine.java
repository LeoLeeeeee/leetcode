package questions.area;

/**
 * 130. 被围绕的区域
 *
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Mine {
    public static void solve(char[][] board){
        if (board.length == 0)
            return;
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O')
                DFS(board, 0, i);
            if (board[board.length-1][i] == 'O')
                DFS(board, board.length-1, i);
        }
        for (int i = 1; i < board.length-1; i++) {
            if (board[i][0] == 'O')
                DFS(board, i, 0);
            if (board[i][board[0].length-1] == 'O')
                DFS(board, i, board[0].length-1);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                switch (board[i][j]){
                    case 'O': board[i][j] = 'X'; break;
                    case 'T': board[i][j] = 'O'; break;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void DFS(char[][] board, int x, int y){
        board[x][y] = 'T';
        if (x >= 1 && board[x-1][y] == 'O')
            DFS(board, x-1, y);
        if (y >= 1 && board[x][y-1] == 'O')
            DFS(board, x, y-1);
        if (x < board.length-1 && board[x+1][y] == 'O')
            DFS(board, x+1, y);
        if (y < board[0].length-1 && board[x][y+1] == 'O')
            DFS(board, x, y+1);
    }

    public static void main(String[] args) {
        char[][] board = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
        solve(board);
    }
}
