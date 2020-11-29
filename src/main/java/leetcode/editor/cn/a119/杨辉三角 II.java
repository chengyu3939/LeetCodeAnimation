package leetcode.editor.cn.a119;
//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 200 👎 0

//119-pascals-triangle-ii
//2020-11-28 20:43:26

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {

// 28=2*(9-3)+1
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= rowIndex; i++) {
            result.add(toIndex(i, rowIndex));
        }
        return result;
    }

    public static int toIndex(int x, int y) {

        if (x <= 0 || y <= 0) {
            return 0;
        }


        if (x == y) {
            return 1;
        }

        if (x > y) {
            return 0;
        }
        return toIndex(x - 1, y - 1) + toIndex(x, y - 1);

    }

}
//leetcode submit region end(Prohibit modification and deletion)


class Main_119 {
    public static void main(String[] args) {
//       4->[0,1,1,0]
//       5->[0,1,2,1,0]
//        i1 :4 sum:10
//                [0, 1, 2, 3, 4, 4, 3, 2, 1, 0]
//        i1 :4 sum:9
//                [0, 1, 2, 3, 4, 3, 2, 1, 0]

//        System.out.println(generate(10));
//        System.out.println(generate(9));
//[1, 8, 28, 56, 70, 56, 28, 8, 1]

//[1, 8, 28, 56, 70, 56, 28, 8, 1]
        System.out.println(new Solution().getRow(9));

//        System.out.println(toIndex(6, 18));//6188

//        数组的对折//p [a,b,c,d,e,f] ->  [a,b,c,d,e,f,e,d,c,b,a]
        // 存在以下关系  0,1,2,3  ->3,2,1,0  通过栈来反转

        // 1 1 1 1 1 1  每列都相同
        // 1 2 3 4 5 6  每个数字相隔为1             1，1，1， 1，  1，  1
        // 1 3 6 10 15  每个数字相隔为 递增1的数     2，3，4，  5，  6，  7
        // 1 4 10 20 35 56 84                    3，6，10 ，15 ，21 ，28


        //得出规律
        //   给出 x,y 两个坐标

        //得到以下公式

        /*
        f(x,y)=f(x-1,y-1)+f(x,y-1)

        f(2,4)=f(1,3)+f(2,3)
        ----------------------
        f(1,3)=f(0,2)+f(1,2)
        f(2,3)=f(1,2)+f(2,2)
        -----------------------
        f(1,2)=

        --------------------


        f(2,8)=f(1,7)+f(2,7)
        f(3,9)=f(2,8)+f(3,8)
        f(3,9)=f(2,8)+f(3,8)






         */


        //

    }

    public static List<Integer> generate(int sum) {
        List<Integer> result = new ArrayList<>();
        int i = sum % 2 == 0 ? sum / 2 : (sum / 2 + 1) - 1;
        for (int j = 0; j < i; j++) {
            result.add(j);
        }
        return result;
    }

    public static List<Integer> trans(List<Integer> arr) {

        Stack<Integer> stack = new Stack<>();
        for (Integer integer : arr) {
            stack.push(integer);
        }

        if (arr.size() % 2 != 0) {
            stack.pop();
        }


        while (!stack.empty()) {
            arr.add(stack.pop());
        }


        return arr;
    }
}