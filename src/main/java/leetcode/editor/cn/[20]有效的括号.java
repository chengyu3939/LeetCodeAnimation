package leetcode.editor.cn;//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 2006 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> pair = new HashMap<>();
        pair.put('[', ']');
        pair.put('{', '}');
        pair.put('(', ')');
        Set<Character> characters = pair.keySet();
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (!characters.contains(aChar)) {
                //此处为结尾符号
                if (stack.size()==0){
                    return false;
                }
                Character pop = stack.pop();
                if (!pair.get(pop).equals(aChar)) {
                    return false;
                }
                continue;
            }
            stack.push(aChar);
        }
        return stack.size() == 0;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
