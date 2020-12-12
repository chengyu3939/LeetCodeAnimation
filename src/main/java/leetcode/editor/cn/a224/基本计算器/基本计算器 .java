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
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 栈 数学 
// 👍 311 👎 0

//224-basic-calculator
//2020-12-08 23:33:13

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {

        char[] chars = s.replaceAll(" ", "").toCharArray();
        Stack<Integer> value = new Stack<>();
        Stack<Character> symbol = new Stack<>();

        //
        String symbols = "+-()";


        for (char aChar : chars) {
            if (symbols.contains(String.valueOf(aChar))) {
                if (')' == aChar) {
                    //遍历去除数据直到渠道（
                    Integer temp = null;
                    while (true) {
                        Character pop = symbol.pop();
                        if ('(' == pop) {
                            break;
                        }
                        if (temp == null) {
                            temp = value.pop();
                        }

                        int b = value.pop();
                        temp = (calc(Integer.valueOf(String.valueOf(temp)), Integer.valueOf(String.valueOf(b)), pop));
                    }
                    value.push(temp);
                } else {
                    symbol.push(aChar);
                }
            } else {
                if (value.size() > 0) {
                    int calc = calc(value.pop(), Integer.valueOf(String.valueOf(aChar)), symbol.pop());
                    value.push(calc);
                } else {
                    value.push(Integer.valueOf(String.valueOf(aChar)));
                }
            }
        }
        //运算
        while (value.size() != 1) {
            int calc = calc(value.pop(), value.pop(), symbol.pop());
            value.push(calc);
        }
        return value.pop();
    }

    private int calc(Integer pop, Integer pop1, Character pop2) {

        if ('-' == pop2) {
            return Math.subtractExact(pop, pop1);
        } else if ('+' == pop2) {
            return Math.addExact(pop, pop1);
        }

        return -1;
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

        System.out.println(new Solution().calculate("2-1 + 2"));
    }
}