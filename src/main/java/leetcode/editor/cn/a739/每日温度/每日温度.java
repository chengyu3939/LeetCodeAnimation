package leetcode.editor.cn.a739.每日温度;
//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
// 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表 
// 👍 579 👎 0

//739-daily-temperatures
//2020-11-28 15:41:58

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] T) {

        Stack<Integer> stack = new Stack<>();

        Map<Integer, Integer> result = new HashMap<>();
        Arrays.stream(T).forEach(i -> {

            if (stack.empty()) {
                stack.push(i);
            } else if (stack.peek() < i) {
                Integer pop = stack.pop();
                int count = result.get(pop) == null ? 0 : result.get(pop);
                result.put(pop, count + 1);
                stack.push(i);
            }

        });

        int[] arr = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            arr[i] = result.get(T[i]) == null ? 0 : result.get(T[i]);
        }

        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class Main_739 {
    public static void main(String[] args) {

        int[] ints = new Solution().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ints));
    }
}