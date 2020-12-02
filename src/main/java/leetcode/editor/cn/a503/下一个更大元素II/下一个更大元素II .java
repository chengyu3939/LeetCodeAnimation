package leetcode.editor.cn.a503.下一个更大元素II;
//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
//一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。 
//
// 示例 1: 
//
// 
//输入: [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 注意: 输入数组的长度不会超过 10000。 
// Related Topics 栈 
// 👍 222 👎 0

//503-next-greater-element-ii
//2020-12-02 11:06:43

// 1,2,1  1 2 1 1 2 1

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {

        //原始数据。
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> mapping = new HashMap<>();

        //
        for (int i = 0; i < (nums.length * 2 - 1); i++) {

            if (stack.empty()){
                stack.push(i%nums.length);
            }else {
                Integer peek = stack.peek();
                if (nums[peek]<nums[i%nums.length]){
                    Integer pop = stack.pop();
                    stack.push(i%nums.length);
                    mapping.put(pop,i% nums.length);
                }

            }

        }


        return null;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


class Main_503 {
    public static void main(String[] args) {

    }
}