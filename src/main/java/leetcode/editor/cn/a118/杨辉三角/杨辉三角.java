package leetcode.editor.cn.a118.杨辉三角;
//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 379 👎 0

//118-pascals-triangle
//2020-11-28 20:22:24

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate2(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) { //y
            List<Integer> origin = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                origin.add(toIndex(j, i));
            }
            result.add(origin);
        }
        return result;
    }

    public int toIndex(int x, int y) {

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

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> origin = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        origin.add(1);
        result.add(origin);

        for (int i = 0; i < numRows - 1; i++) {
            origin = generate(origin);
            result.add(origin);
        }

        return result;
    }

    public List<Integer> generate(List<Integer> original) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i < original.size(); i++) {
            list.add(original.get(i) + original.get(i - 1));
        }
        list.add(1);


        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class Main_118 {
    public static void main(String[] args) {

        List<List<Integer>> generate = new Solution().generate2(5);
        for (int i = 0; i < generate.size(); i++) {
            System.out.println(i + 1 + "  " + generate.get(i));
        }

        //0 1 2 3 4 5


    }
}