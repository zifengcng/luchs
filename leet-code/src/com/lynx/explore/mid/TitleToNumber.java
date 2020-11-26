package com.lynx.explore.mid;

/**
 * @Author cheng
 * @Date 2020/8/21
 * Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1:
 * <p>
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: "ZY"
 * 输出: 701
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xweb76/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class TitleToNumber {

    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();

        int res = 0;
        for (char c : chars) {
            res *= 26;
            res += c - 'A' + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        TitleToNumber title = new TitleToNumber();
        System.out.println(title.titleToNumber("AB"));
        System.out.println(title.titleToNumber("A"));
        System.out.println(title.titleToNumber("B"));
        System.out.println(title.titleToNumber("AAA"));
        System.out.println(title.titleToNumber("BA"));
    }
}
