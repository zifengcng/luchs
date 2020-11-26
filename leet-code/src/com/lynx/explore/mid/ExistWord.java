package com.lynx.explore.mid;

/**
 * @Author cheng
 * @Date 2020/8/20
 * 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 * <p>
 * 提示：
 * <p>
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvkwe2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ExistWord {

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, m, n, i, j, 0, visited, chars)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int m, int n, int i, int j, int index, boolean[][] visited, char[] chars) {
        if (index >= chars.length) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return false;
        }
        if (chars[index] != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean res = dfs(board, m, n, i - 1, j, index + 1, visited, chars)
                || dfs(board, m, n, i + 1, j, index + 1, visited, chars)
                || dfs(board, m, n, i, j - 1, index + 1, visited, chars)
                || dfs(board, m, n, i, j + 1, index + 1, visited, chars);
        visited[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        ExistWord existWord = new ExistWord();
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}};
        boolean exist = existWord.exist(board, "ABCESEEEFS");
        System.out.println(exist);
    }
}
