package leetcode.editor.cn;//使用队列实现栈的下列操作：
//
// 
// push(x) -- 元素 x 入栈 
// pop() -- 移除栈顶元素 
// top() -- 获取栈顶元素 
// empty() -- 返回栈是否为空 
// 
//
// 注意: 
//
// 
// 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合
//法的。 
// 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
// 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。 
//  2,3,5,2,4

/*

4,2
5,4,2
2,5,4
4,2,5


    4
    4,2
    4,2,5
    4,2,5,3
    4,2,5,3,2



 */

// Related Topics 栈 设计 
// 👍 240 👎 0


import java.util.ArrayDeque;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class MyStack {

    Queue<Integer> queue = new ArrayDeque<Integer>();

    /**
     * Initialize your data structure here.
     */
    public MyStack() {


    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {

        int size = queue.size();
        queue.add(x);
        for (int i = 0; i < size ; i++) {
            Integer poll = queue.poll();
            queue.offer(poll);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {

        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {

        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {

        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)
