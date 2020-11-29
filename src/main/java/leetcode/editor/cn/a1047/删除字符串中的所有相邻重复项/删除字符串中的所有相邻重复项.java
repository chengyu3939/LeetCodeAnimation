package leetcode.editor.cn.a1047.删除字符串中的所有相邻重复项;
//给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。 
//
// 在 S 上反复执行重复项删除操作，直到无法继续删除。 
//
// 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。 
//
// 
//
// 示例： 
//
// 输入："abbaca"
//输出："ca"
//解释：
//例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
//只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 20000 
// S 仅由小写英文字母组成。 
// 
// Related Topics 栈 
// 👍 103 👎 0

//1047-remove-all-adjacent-duplicates-in-string
//2020-11-29 16:46:13

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicates(String S) {

        StringBuilder stringBuilder = new StringBuilder();

        for (char c : S.toCharArray()) {
            if (stringBuilder.length() == 0) {

                stringBuilder.append(c);
            } else {

                char last = stringBuilder.charAt(stringBuilder.length() - 1);
                if (last == c) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                } else {
                    stringBuilder.append(c);
                }

            }
        }
        return stringBuilder.toString();
    }
}

    class Solution2 {
        public String removeDuplicates(String S) {

            Stack<Character> stack = new Stack<>();


            for (char c : S.toCharArray()) {
                if (stack.empty()) {
                    stack.push(c);
                } else {
                    if (c == stack.peek()) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }

            }
            StringBuilder stringBuilder = new StringBuilder();
            int length = stack.size();
            Stack<Character> news = new Stack<>();

            for (int i = 0; i < length; i++) {
                news.push(stack.pop());
            }

            for (int i = 0; i < length; i++) {
                stringBuilder.append(news.pop());
            }


            return stringBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    class Main_1047 {
        public static void main(String[] args) {

            System.out.println(new Solution().removeDuplicates("abbaca"));
        }
    }