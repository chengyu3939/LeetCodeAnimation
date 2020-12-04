### 解题思路
刚开始的时候,我是使用栈的,因为我本身就是从栈的题目点进来的.但是效率实在是太低了1ms,击败百分之12的样子
测了很多次基本都是在1ms
![image.png](https://pic.leetcode-cn.com/1605673655-BPQEmr-image.png)
```java
class Solution {
    public List<String> buildArray(int[] target, int n) {
        Stack<Integer> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (index < target.length) {
                stack.push(i);
                list.add("Push");
            }
            if (index < target.length &&stack.peek() != target[index]) {
                stack.pop();
                list.add("Pop");
            }else {
                index++;
            }

        }
        return list;
    }
}
```
后面把这个题做出来了之后,我就想...这个i基本都要入栈吗...然后有又要比较栈顶
于是把栈全部删除,把栈顶改成i,测试了一下0ms通过了.
而且好像题解没人和我这个一样,所以就分享出来给大家参考一样.

![image.png](https://pic.leetcode-cn.com/1605673944-fWzbpr-image.png)

### 代码

```java
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1, index = 0; i <= n; i++) {
            if (index < target.length) {
                list.add("Push");
            }
            if (index < target.length &&i != target[index]) {
                list.add("Pop");
            }else {
                index++;
            }

        }

        return list;
    }
}
```