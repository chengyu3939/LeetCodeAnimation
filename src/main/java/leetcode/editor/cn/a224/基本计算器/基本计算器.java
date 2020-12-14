package leetcode.editor.cn.a224.基本计算器;
//实现一个基本的计算器来计算一个简单的字符串表达式的值。 
//
// 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格 。 
//
// 示例 1: 
//
// 输入: "1 + 1"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: " 2-1 + 2 "
//输出: 3 
//
// 示例 3: 
//
// 输入: "(1+(4+5+2)-3)+(6+8)"
//输出: 23 
//
// 说明： 
// (1+(4+5+2)-3)+(6+8)

/*
方案思路1
向栈中依次push。遇到一个 ） 则pop 到下一个 （ 并将其组装成表达式。得到结果后将其push。然后继续执行后续操作。最后将结果取出继续运行表达式。




 */


//
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 栈 数学 
// 👍 311 👎 0

//224-basic-calculator
//2020-12-08 23:33:13

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String symbols = "+-()";

    public int calculate(String s) {
        return caculate(s);
//        char[] chars = s.replaceAll(" ", "").toCharArray();
//        Stack<Integer> value = new Stack<>();
//        Stack<Character> symbol = new Stack<>();
//
//        //
//
//
//        for (char aChar : chars) {
//
//            push(value, symbol, aChar);
//        }
//        //运算
//        while (value.size() != 1) {
//            int calc = calc(value.pop(), value.pop(), symbol.pop());
//            value.push(calc);
//        }
//        return value.pop();
    }


    public void push(Stack<Integer> value, Stack<Character> symbol, Character aChar) {
        //判断是否为操作符
        if (symbols.contains(String.valueOf(aChar))) {
            if (')' == aChar) {
                if (symbol.peek() == '(') {
                    symbol.pop();
                    push(value, symbol, aChar);
                } else {
                    Character symbolcur = symbol.pop();
                    Integer pop = value.pop();
                    Integer pop2 = value.pop();
                    int temp = calc(Integer.valueOf(String.valueOf(pop)), Integer.valueOf(String.valueOf(pop2)), symbolcur);
                    push(value, symbol, (char) temp);
                    push(value, symbol, aChar);
                }
            } else if (!symbol.empty()) {
                symbol.push(aChar);
            }
        } else {
            //为数字
            if (value.size() > 2 && !symbol.empty() && symbol.peek() != '(') {
                int calc = calc(value.pop(), Integer.valueOf(String.valueOf(aChar)), symbol.pop());
                push(value, symbol, (char) calc);
            } else {
                value.push(Integer.valueOf(String.valueOf(aChar)));
            }
        }


    }

    private int calc(Integer pop, Integer pop1, Character pop2) {

        if ('-' == pop2) {
            return Math.subtractExact(pop, pop1);
        } else if ('+' == pop2) {
            return Math.addExact(pop, pop1);
        }

        return -1;
    }


    public Integer caculate(String expr) {
        Stack<Character> stack = new Stack<>();
        char[] s = expr.replaceAll(" ", "").toCharArray();
        for (char c : s) {
            if (')' == c) {
                //取出数据直到 （
                List<Character> cs = new ArrayList<>();
                while (stack.peek() != '(') {
                    cs.add(stack.pop());
                }
                Integer calc = calc(cs);
                stack.pop();
                stack.push(Character.highSurrogate(calc));
            } else {
                stack.push(c);
            }
        }
        List<Character> t1 = new ArrayList<>();

        while (!stack.empty()) {
            t1.add(stack.pop());
        }
        return calc(t1);
    }

    /**
     * 简单计算器。无括号
     *
     * @param cal cs
     * @return
     */
    public Integer calc(List<Character> cal) {
        Iterator<Character> iterator = cal.iterator();
        int temp = Integer.parseInt(String.valueOf(iterator.next()));
        while (iterator.hasNext()) {
            Character symbol = iterator.next();
            int value2 = Integer.parseInt(String.valueOf(iterator.next()));
            temp = calc(temp, value2, symbol);
        }

        return temp;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


class Main_224 {
    public static void main(String[] args) {


//        char a = '1';

//        int b= Integer.parseInt(String.valueOf(a));

//        System.out.println(b);
//        String s = "a bc";
//        System.out.println(s.replaceAll(" ", ""));

        List<Character> ls = new ArrayList<>();

        ls.add('1');
        ls.add('+');
        ls.add('3');
        ls.add('-');
        ls.add('6');
        Integer calc = new Solution().calc(ls);

        System.out.println(calc);

        System.out.println(new Solution().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}