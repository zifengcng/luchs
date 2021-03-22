package com.lynx.explore.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wbc
 * @date 2020/7/20 11:19
 * 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * <p>
 * 上图是一个部分填充的有效的数独。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 * https://leetcode-cn.com/explore/learn/card/hash-table/206/practical-application-design-the-key/822/
 */
public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board[0] == null) {
            return false;
        }

        int y = board.length;
        int x = board[0].length;

        if (x % 3 != 0 || y % 3 != 0) {
            return false;
        }

        // y,x -> key
        Map<Map<Integer, Integer>, Set<Character>> sudoMap = new HashMap<>();
        Map<Integer, Set<Character>> xMap = new HashMap<>();
        Map<Integer, Set<Character>> yMap = new HashMap<>();

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (yMap.containsKey(i)) {
                    Set<Character> nums = yMap.get(j);
                    if (nums.contains(board[i][j])) {
                        return false;
                    }
                    nums.add(board[i][j]);
                } else {
                    Set<Character> nums = new HashSet<>();
                    nums.add(board[i][j]);
                    yMap.put(i, nums);
                }

                if (xMap.containsKey(j)) {
                    Set<Character> nums = xMap.get(j);
                    if (nums.contains(board[i][j])) {
                        return false;
                    }
                    nums.add(board[i][j]);
                } else {
                    Set<Character> nums = new HashSet<>();
                    nums.add(board[i][j]);
                    xMap.put(j, nums);
                }

                Map<Integer, Integer> map = new HashMap<>();
                map.put(i / 3, j / 3);
                if (sudoMap.containsKey(map)) {
                    Set<Character> nums = sudoMap.get(map);
                    if (nums.contains(board[i][j])) {
                        return false;
                    }
                    nums.add(board[i][j]);
                } else {
                    Set<Character> nums = new HashSet<>();
                    nums.add(board[i][j]);
                    sudoMap.put(map, nums);
                }
            }
        }

        return true;
    }
}
