package leetcode.editor.cn.a844.比较含退格的字符串;
//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。 
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 输入：S = "ab#c", T = "ad#c"
//输出：true
//解释：S 和 T 都会变成 “ac”。
// 
//
// 示例 2： 
//
// 输入：S = "ab##", T = "c#d#"
//输出：true
//解释：S 和 T 都会变成 “”。
// 
//
// 示例 3： 
//
// 输入：S = "a##c", T = "#a#c"
//输出：true
//解释：S 和 T 都会变成 “c”。
// 
//
// 示例 4： 
//
// 输入：S = "a#c", T = "b"
//输出：false
//解释：S 会变成 “c”，但 T 仍然是 “b”。 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 1 <= T.length <= 200 
// S 和 T 只含有小写字母以及字符 '#'。 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
//
// 
// Related Topics 栈 双指针 
// 👍 242 👎 0

//844-backspace-string-compare
//2020-11-28 23:20:44

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean backspaceCompare(String S, String T) {
        return buildString(S).equals(buildString(T));

    }

    public String buildString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ('#' == c) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length()-1);
                }

            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }


    public boolean backspaceCompare2(String S, String T) {
        Stack<Character> c1 = new Stack<>();
        for (char c : S.toCharArray()) {
            if ('#' == c) {
                if (!c1.empty()) {
                    c1.pop();
                }
            } else {
                c1.push(c);
            }
        }

        StringBuilder k1 = new StringBuilder();
        int lenth = c1.size();
        for (int i = 0; i < lenth; i++) {
            k1.append(c1.pop());
        }

        for (char c : T.toCharArray()) {
            if ('#' == c) {
                if (!c1.empty()) {
                    c1.pop();
                }
            } else {
                c1.push(c);
            }

        }

        StringBuilder k2 = new StringBuilder();
        lenth = c1.size();
        for (int i = 0; i < lenth; i++) {
            k2.append(c1.pop());
        }

        System.out.println(k1 + " " + k2);
        return k1.toString().equals(k2.toString());

    }
}
//class Solution {
//    public boolean backspaceCompare(String S, String T) {
//        return build(S).equals(build(T));
//    }
//
//    public String build(String str) {
//        StringBuffer ret = new StringBuffer();
//        int length = str.length();
//        for (int i = 0; i < length; ++i) {
//            char ch = str.charAt(i);
//            if (ch != '#') {
//                ret.append(ch);
//            } else {
//                if (ret.length() > 0) {
//                    ret.deleteCharAt(ret.length() - 1);
//                }
//            }
//        }
//        return ret.toString();
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)


class Main_844 {
    public static void main(String[] args) {

//        解答失败: 测试用例:"y#fo##f" "y#f#o##f" 测试结果:false 期望结果:true stdout:

        //input_formatted:"abcd"
//        "bbcd"
//        System.out.println(new Solution().backspaceCompare("abcd", "bbcd"));
//        System.out.println(new Solution().buildString("abc#"));
//        System.out.println(new Solution().buildString("#abc#"));
//        System.out.println(new Solution().buildString("a#bc#"));
    }
}