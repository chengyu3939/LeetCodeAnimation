### 解题思路
感觉第二题比第一题简单一点，由于是circle所以多写一层循环呗。。。
因为stack第一层结束的时候不为空所以多写一层for就ok了

### 代码

```python3
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        stack, r =[],[-1]*n
        for i in range(n):
            while stack and  (nums[stack[-1]] < nums[i]):
                r[stack.pop()] = nums[i]
            stack.append(i)
        for i in range(n):
            while stack and (nums[stack[-1]] < nums[i]):
                r[stack.pop()] = nums[i]
            if not stack:
                break
        return r
```