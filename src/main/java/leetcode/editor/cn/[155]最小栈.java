package leetcode.editor.cn;//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 735 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    class Node {
        private int value;
        private int minValue;

        public Node(int value, int minValue) {
            this.value = value;
            this.minValue = minValue;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getMinValue() {
            return minValue;
        }

        public void setMinValue(int minValue) {
            this.minValue = minValue;
        }
    }
    //保持栈的特性 先进后出
    //记录数据的顺序

    //栈+有序链表

    Stack<Node> stack = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {


    }

    public void push(int x) {
        int minvalue;
        if (stack.size()==0) {
            minvalue = x;
        } else {
            int beforeMin = stack.peek().getMinValue();
            minvalue = Math.min(x, beforeMin);
        }
        stack.push(new Node(x, minvalue));
    }

    public void pop() {

        stack.pop();
    }

    public int top() {

        return stack.peek().getValue();
    }

    public int getMin() {

        return stack.peek().getMinValue();
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
