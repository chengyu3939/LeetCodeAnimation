萌新刚开始学习刷题，写了个最简单的无脑遍历方法，根本没有用栈
### 解题
因为对nums1每个元素都要求解，所以基本所有代码都在遍历nums1的循环中
对当前要求解的nums1中的nums1[i]，先找到其在nums2对应的元素的下标，然后再以下标为起点遍历nums2数组，找到大于nums1[i]的数，赋给y，考虑到可能没有解，把y初始化为1
顺便把自己在本地IDE的测试用的main函数也贴上来
萌新刚开始学Java，希望能快速写出符合题目要求的解吧
### 代码
```Java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] ans = new int[l1];
        for (int i = 0;i<l1;i++){
            int x = -1;
            for(int j = i;j<l2;j++){
                if(nums1[i]==nums2[j]){
                    x = j;
                    break;
                }
            }
            int y = -1;
            int n2 = nums2[x];
            for(int k = x+1;k<l2;k++){
                if(nums2[k]>n2){
                    y = nums2[k];
                    break;
                }
            }
            ans[i] = y;
        }
        return ans;
    }
    public static void main(String args[]){
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        Solution test = new Solution();
        System.out.println(test.nextGreaterElement(nums1,nums2));
    }
}
```
