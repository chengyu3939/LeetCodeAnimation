package leetcode.editor.cn.a51.N皇后;
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 688 👎 0

//51-n-queens
//2020-12-10 10:58:11

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class QueueCondition {
    List<Integer> xdy;//x-y
    List<Integer> xay;//x+y
    List<Integer> list;

    public QueueCondition() {
        this.xay = new ArrayList<>();
        this.xdy = new ArrayList<>();
        this.list = new ArrayList<>();
    }

    public boolean fit(Integer cur) {
        if (xdy.contains(this.xdy.size() - cur)) {
            return false;
        }

        if (xay.contains(this.xdy.size() + cur)) {
            return false;
        }

        return !list.contains(cur);

    }


    public QueueCondition copyAndAddCur(Integer cur) {
        QueueCondition queueCondition = new QueueCondition();
        queueCondition.xdy = new ArrayList<>(this.xdy);
        queueCondition.xdy.add(this.xdy.size() - cur);
        queueCondition.xay = new ArrayList<>(this.xay);
        queueCondition.xay.add(this.xay.size() + cur);
        queueCondition.list = new ArrayList<>(this.list);
        queueCondition.list.add(cur);

        return queueCondition;

    }
}

class Solution {


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        List<QueueCondition> result = new ArrayList<>();

        iterator(new QueueCondition(), n, result);


        for (QueueCondition queueCondition : result) {
            List<String> ls=new ArrayList<>();
            for (Integer integer : queueCondition.list) {
                char[] c=new char[n];
                Arrays.fill(c,'.');
                c[integer]='Q';
                ls.add(new String(c));
            }

            results.add(ls);


        }


//
//        for (QueueCondition integers : result) {
//            List<String> list = new ArrayList<>();
//            StringBuilder stringBuilder = new StringBuilder();
//            for (Integer integer : integers.list) {
//                stringBuilder.setLength(0);
//                for (int i = 0; i < n; i++) {
//                    if (i == integer) {
//                        stringBuilder.append("Q");
//                    } else {
//                        stringBuilder.append(".");
//                    }
//                }
//                list.add(stringBuilder.toString());
//            }
//            results.add(list);
//        }
        return results;
    }


    public void iterator(QueueCondition condition, Integer max, List<QueueCondition> result) {
        //计算当前map数
        for (int i = 0; i < max; i++) {
            if (condition.fit(i)) {
                QueueCondition queueCondition = condition.copyAndAddCur(i);
                if (queueCondition.list.size() == max) {
                    result.add(queueCondition);
                    return;
                }
                iterator(queueCondition, max, result);
            }
        }


    }

}
//leetcode submit region end(Prohibit modification and deletion)


class Main_51 {
    public static void main(String[] args) {
        List<List<String>> lists = new Solution().solveNQueens(80);

        for (List<String> list : lists) {
            System.out.println();
            for (String s : list) {
                System.out.println(s);
            }
        }
        System.out.println(new Solution().solveNQueens(8).size());
    }
}