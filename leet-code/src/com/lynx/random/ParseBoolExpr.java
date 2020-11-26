package com.lynx.random;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author cheng
 * @Date 2020/10/15
 * <p>
 * 1106. 解析布尔表达式
 * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 * <p>
 * 有效的表达式需遵循以下约定：
 * <p>
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：expression = "!(f)"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：expression = "|(f,t)"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：expression = "&(t,f)"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：expression = "|(&(t,f,t),!(t))"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= expression.length <= 20000
 * expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。
 * expression 是以上述形式给出的有效表达式，表示一个布尔值。
 * <p>
 * https://leetcode-cn.com/problems/parsing-a-boolean-expression/
 */
public class ParseBoolExpr {

    public boolean parseBoolExpr(String expression) {
        if (expression == null) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        int len = expression.length();
        for (int i = 0; i < len; i++) {
            char c = expression.charAt(i);
            if (c == ',') {
                continue;
            }
            if (c == ')') {
                char cur = 'f';
                List<Character> list = new ArrayList<>();
                while (true) {
                    Character pop = stack.pop();
                    if (pop.equals('(')) {
                        Character operator = stack.pop();
                        if (operator.equals('!')) {
                            Character first = list.get(0);
                            if (first.equals('f')) {
                                cur = 't';
                            }
                        } else if (operator.equals('&')) {
                            boolean flag = true;
                            for (Character character : list) {
                                if (character.equals('f')) {
                                    flag = false;
                                }
                            }
                            cur = flag ? 't' : 'f';
                        } else {
                            // |
                            for (Character character : list) {
                                if (character.equals('t')) {
                                    cur = 't';
                                }
                            }
                        }
                        stack.push(cur);
                        break;
                    } else {
                        list.add(pop);
                    }
                }
            } else {
                stack.push(c);
            }
        }

        return stack.peek().equals('t');
    }

    public static void main(String[] args) {
        ParseBoolExpr p = new ParseBoolExpr();
        boolean b = p.parseBoolExpr("|(&(t,f,t),!(t))");
        System.out.println(b);
    }
}
