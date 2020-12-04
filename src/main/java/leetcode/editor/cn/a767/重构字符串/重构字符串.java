package leetcode.editor.cn.a767.重构字符串;
//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。 
//
// 若可行，输出任意可行的结果。若不可行，返回空字符串。 
//
// 示例 1: 
//
// 
//输入: S = "aab"
//输出: "aba"
// 
//
// 示例 2: 
//
// 
//输入: S = "aaab"
//输出: ""
// 
//
// 注意: 
//
// 
// S 只包含小写字母并且长度在[1, 500]区间内。 
// 
// Related Topics 堆 贪心算法 排序 字符串 
// 👍 242 👎 0

//767-reorganize-string
//2020-12-01 00:37:11

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reorganizeString(String S) {

        // Stack<Character> stack=new Stack<>();

        Map<Character, Integer> maps = new HashMap<>();

        for (char c : S.toCharArray()) {
            int count = maps.get(c) == null ? 0 : maps.get(c);
            maps.put(c, ++count);
        }

        StringBuilder sb = new StringBuilder();
        int oneCount = 0;
        while (true) {

            int curCount = 0;

            if (oneCount > 1) {
                return "";
            }

            for (char c : maps.keySet()) {
                if (maps.get(c) != 0) {
                    sb.append(c);
                    if (maps.get(c) > 1) {
                        maps.put(c, maps.get(c) - 1);
                    } else {
                        maps.put(c, 0);
                    }
                    curCount++;
                }

            }
            if (curCount == 0) {
                break;
            }
            if (curCount == 1) {
                oneCount++;
            }


        }
        if (sb.length() <= 1) {
            return sb.toString();
        }
        //最后字符串换位置
        char temp = sb.charAt(sb.length() - 1);
        char temp2 = sb.charAt(sb.length() - 2);
        if (temp == temp2) {
            sb.deleteCharAt(sb.length() - 2);
            sb.insert(sb.length() - 2, temp2);
        }
        return sb.toString();
    }

}

//leetcode submit region end(Prohibit modification and deletion)


class Main_Seven67 {
    public static void main(String[] args) {
        System.out.println(new Solution().reorganizeString("vvvlo"));
    }
}