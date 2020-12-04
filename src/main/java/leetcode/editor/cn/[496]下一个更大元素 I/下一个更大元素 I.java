//给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个
//比其大的值。 
//
// nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。 
//
// 
//
// 示例 1: 
//
// 输入: nums1 = [4,1,2],
//      nums2 = [1,3,4,2].
//  入站排序
//  ||  ||
//  |2|  ||
//  |4|  |2|
//  |3|  |4|
//  |1|  |1|


//输出: [-1,3,-1]
//解释:
//    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
//    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
//    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。 
//
// 示例 2: 
//
// 输入: nums1 = [2,4], nums2 = [1,2,3,4].

//2,3   1,3,2,4
//4,4
//输出: [3,-1]
//解释:
//    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
//    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
// 
//
// 
//
// 提示： 
//
// 
// nums1和nums2中所有元素是唯一的。 
// nums1和nums2 的数组大小都不超过1000。 
// 
// Related Topics 栈 
// 👍 312 👎 0

//496-next-greater-element-i
//2020-11-26 23:46:50

import leetcode.editor.cn.base.DownSingleStack;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        Stack<Integer> stack = new DownSingleStack() {
            @Override
            public void call(Integer pop, Integer obj) {
                hashMap.put(pop, obj);
            }

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        for (int i : nums2) {
            stack.push(i);
        }


        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            if (hashMap.get(nums1[i]) != null) {
                result[i] = hashMap.get(nums1[i]);

            } else {
                result[i] = -1;
            }
        }

        return result;
    }
}


/**
 * 暴力法。
 */
class Solution2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int temp = 0;
            for (int j : nums2) {

                if (temp != -1 && nums1[i] == j) {
                    temp = -1;
                }

                if (temp == -1) {
                    if (j > nums1[i]) {
                        temp = j;
                    }
                }

            }
            result[i] = temp;

        }

        return result;
        //

//
//        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class test {
    public static void main(String[] args) {
//        int[] ints = new Solution2().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
//        System.out.println(Arrays.toString(ints));
////        [4,1,2] [1,3,4,2]
//        int[] ints2 = new Solution().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
//        System.out.println(Arrays.toString(ints2));

StringBuilder stringBuilder=new StringBuilder();
stringBuilder.append('a').append('b').append('b');
char temp=stringBuilder.charAt(stringBuilder.length()-1);
char temp2=stringBuilder.charAt(stringBuilder.length()-2);

if (temp==temp2){
    stringBuilder.deleteCharAt(stringBuilder.length()-2);
    stringBuilder.insert(stringBuilder.length()-2,temp2);
}

        System.out.println(stringBuilder.toString());

        //测试单调栈
//        Stack<Integer> stack = new singleStack() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        };
//
//        stack.push(1);
//        stack.push(3);
//        stack.push(4);
//        stack.push(2);
//        System.out.println(stack);

    }
}