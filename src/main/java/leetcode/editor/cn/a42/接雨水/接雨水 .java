package leetcode.editor.cn.a42.接雨水;
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 
// 👍 1857 👎 0

//42-trapping-rain-water
//2020-12-09 21:43:07

/*
解题思路：
1.找出数组中的最大值下下标位 n
2.从两边向n构建单调递增栈。当入栈的数据不满足入栈要求时。取栈顶值-当前值的差 作为统计范围。




 */

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {


        int sum = 0;
        //找到最大值所在的索引。
        int maxIndex = findMaxIndex(height);


        //从两百年到中间的单调递增
        //left

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < maxIndex; i++) {

            if (stack.empty()) {
                stack.push(height[i]);
            } else if (stack.peek() > height[i]) {
                sum = sum + stack.peek() - height[i];
            } else {
                stack.push(height[i]);
            }
        }

        //清空栈
        stack.setSize(0);
        for (int i = height.length - 1; i > maxIndex; i--) {

            if (stack.empty()) {
                stack.push(height[i]);
            } else if (stack.peek() > height[i]) {
                sum = sum + stack.peek() - height[i];
            } else {
                stack.push(height[i]);
            }

        }


        return sum;
    }

    private int findMaxIndex(int[] height) {

        int maxIndex = 0;

        for (int i = 1; i < height.length; i++) {
            if (height[maxIndex] < height[i]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class Main_42 {
    public static void main(String[] args) {

        System.out.println(new Solution().trap(new int[]{1, 3, 2, 4, 1}));

    }
}