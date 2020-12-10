方法一：普通解法，优点是不需要对每一个nums2元素都找到比它大的数，只需要针对nums1里的元素找
```
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length]; 
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums1){
            map.put(i, -1);
        }
        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i])){
                for(int j = i+1; j < nums2.length; j++){
                    if(nums2[j] > nums2[i]) {
                        map.put(nums2[i], nums2[j]);
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
```
方法二：跟官方解法一致
```
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length]; 
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < nums2.length; i++){//当栈非空并且栈顶小于当前元素 就push进map，否则进栈
            while(!stack.empty() && stack.peek()<nums2[i])  map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }

        while(!stack.empty()){
            map.put(stack.pop(), -1);
        }

        for(int i = 0; i < nums1.length; i++){
            res[i] = map.get(nums1[i]);  
        }
        return res;
    }
}
```
方法三：对官方解法进行小的修改：不需要把栈清空并在map里赋值-1，因为不在map里就说明是-1
```
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length]; 
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < nums2.length; i++){//当栈非空并且栈顶小于当前元素 就push进map，否则进栈
            while(!stack.empty() && stack.peek()<nums2[i])  map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }

        for(int i = 0; i < nums1.length; i++){//不需要把栈清空并在map里赋值-1，因为不在map里就说明是-1
            if(map.containsKey(nums1[i])) res[i] = map.get(nums1[i]);
            else res[i] = -1;
            
        }
        return res;
    }
}
```

但是实际运行发现，解法一（普通解法）只用时4ms，但是方法二、三用时5~6ms。。。 神奇


