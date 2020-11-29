### 解题思路
例如输入索引k = 3, 对应是第 3 + 1 = 4行,得出第4行共有4个值,且每个值为
第一个值为: 1
第二个值为: (n - 1) / 1 = (4 - 1) / 1 = 3
第三个值为: (n - 1) / 1 * (n -2) / 2 = (n - 1)(n - 2)/ (1 * 2) = (4-1)(4-2)/(1*2) = 3
第四个值为: (n - 1) / 1 * (n - 2) / 2 * (n-3)/3 = (n-1)(n-2)(n-3)/(1*2*3) =
         * (4-1)(4-2)(4-3)/(1*2*3) = 1
由此得出规律:
索引为n-1的行为n,且该行共有n个值(n > 1),得出第n行每个值为:
后一个值等于前一个值然后乘以(n - i) / i
即numVal = (n - i) / i * res.get(i - 1)

### 代码

```java
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        int numRows = rowIndex + 1;
        for (int index = 0; index < numRows; index++){
            if (index == 0){
                res.add(1);
            }else {
                long eachValOfRow = (long) res.get(index - 1) * (long) (numRows - index) / index;
                res.add((int) eachValOfRow);
            }
        }
        return res;
    }
}
```