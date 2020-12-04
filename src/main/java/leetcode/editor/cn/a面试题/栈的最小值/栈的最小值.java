package leetcode.editor.cn.a面试题.栈的最小值;
//请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(
//1)。 示例： MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
// minStack.push(-3); minStack.getMin();   --> 返回 -3. minStack.pop(); minStack.top
//();      --> 返回 0. minStack.getMin();   --> 返回 -2. Related Topics 栈 
// 👍 33 👎 0

//面试题 03.02-min-stack-lcci
//2020-11-29 20:43:09

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    private final Stack<Mapping> stack = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {

        if (stack.empty()) {
            stack.push(new Mapping(x, x));
        } else {
            stack.push(new Mapping(x, Math.min(stack.peek().getMin(), x)));
        }

    }

    public void pop() {

        stack.pop();
    }

    public int top() {

        return stack.peek().getCur();
    }

    public int getMin() {

        return stack.peek().getMin();
    }

    class Mapping {
        private int cur;
        private int min;

        public Mapping(int cur, int min) {
            this.cur = cur;
            this.min = min;
        }

        public int getCur() {
            return cur;
        }

        public void setCur(int cur) {
            this.cur = cur;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)


class Main_面试题0302 {
    public static void main(String[] args) {

    }
}