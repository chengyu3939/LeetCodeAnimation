//package leetcode.editor.cn.a1021.删除最外层的括号;
////有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"
////，"(())()" 和 "(()(()))" 都是有效的括号字符串。
////
//// 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
////
//// 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
////
//// 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
////
////
////
//// 示例 1：
////
//// 输入："(()())(())"
////输出："()()()"
////解释：
////输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
////删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
////
//// 示例 2：
////
//// 输入："(()())(())(()(()))"
////输出："()()()()(())"
////解释：
////输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
////删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
////
////
//// 示例 3：
////
//// 输入："()()"
////输出：""
////解释：
////输入字符串为 "()()"，原语化分解得到 "()" + "()"，
////删除每个部分中的最外层括号后得到 "" + "" = ""。
////
////
////
////
//// 提示：
////
////
//// S.length <= 10000
//// S[i] 为 "(" 或 ")"
//// S 是一个有效括号字符串
////
//// Related Topics 栈
//// 👍 143 👎 0
//
////1021-remove-outermost-parentheses
////2020-11-29 02:37:28
//
//import java.util.List;
//import java.util.Stack;
//
////leetcode submit region begin(Prohibit modification and deletion)
////((()()))
//class Solution {
//    public String removeOuterParentheses(String S) {
//        StringBuilder sb = new StringBuilder();
//
//        Stack<Character> stack = new Stack<>();
//
//
//        StringBuilder tempSb = new StringBuilder();
//        for (char c : S.toCharArray()) {
//            if ('(' == c) {
//                stack.push(c);
//            } else {
//                if (stack.size() > 2) {
//                    tempSb.insert(0, stack.pop()).append(c);
//                } else if (stack.size() == 2) {
//                    String s = tempSb.toString();
//                    tempSb.insert(0, stack.pop()).append(c);
//                    sb.append(tempSb);
//                    tempSb.setLength(0);
//                } else if (stack.size() == 1) {
//                    stack.pop();
//                }
//
//
////                Character pop = stack.pop();
//                //此处
//
////                if (stack.size() != 0) {
////                    sb.append(pop).append(c);
////
////
////                }
//            }
//        }
//
//
//        return sb.toString();
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//
//class Main_1021 {
//    public static void main(String[] args) {
//
//        String s = new Solution().removeOuterParentheses("(()())(())(()(()))");
//        System.out.println(s);
//    }
//}