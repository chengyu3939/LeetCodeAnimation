## 解题思路
第一个单调栈存储右侧元素，第二个单调栈存储左侧元素(代码中以倒序nums存在)，为什么这样做可行呢？
因为若x>=stack2[i]，那么x必定为最大元素，此时它左侧的值再右侧存在一个更大的元素(至少x满足这一条件)；若x>=stack1[i]，那么x的下一个更大的元素一定在左侧或者不存在。

### 代码

```python3
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack1 = []
        stack2 = nums[::-1]
        result = [-1]*len(nums)
        for i in range(len(nums)-1, -1, -1):
            x = nums[i]
            if not stack1:
                while stack2 and x >= stack2[-1]:
                    stack2.pop()
                if stack2:
                    result[i] = stack2[-1]
            else:
                while stack1 and x >= stack1[-1]:
                    stack1.pop()
                if stack1:
                    result[i] = stack1[-1]
                else:
                    while stack2 and x >= stack2[-1]:
                        stack2.pop()
                    if stack2:
                        result[i] = stack2[-1]
            stack1.append(x)
        
        return result
```

### 复杂度分析
时间复杂度：O(N)
空间复杂度：O(N)