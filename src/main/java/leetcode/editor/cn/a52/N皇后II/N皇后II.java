package leetcode.editor.cn.a52.N皇后II;
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N
//-1 步，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 215 👎 0

//52-n-queens-ii
//2020-12-12 17:48:06

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalNQueens(int n) {


        List<Integer> tar = new ArrayList<>();
        List<Integer> xli = new ArrayList<>();
        List<Integer> yli = new ArrayList<>();


        AtomicInteger atomicInteger = new AtomicInteger();
        recurse(n, tar, xli, yli, atomicInteger);


        return atomicInteger.get();
    }


    public void recurse(int n, List<Integer> tar, List<Integer> xli, List<Integer> yli, AtomicInteger count) {
        if (tar.size() == n) {

            count.incrementAndGet();
            System.out.println(tar);
        } else {
            for (int i = 0; i < n; i++) {
                int value = tar.size();
                if (tar.contains(i)) {
                    continue;
                }
                if (xli.contains(value - i)) {
                    continue;
                }
                if (yli.contains(value + i)) {
                    continue;
                }
                //将当前位置添加
                tar.add(i);
                xli.add(tar.size() - i);
                yli.add(tar.size() + i);
                recurse(n, tar, xli, yli, count);
                if (value > 0) {
                    tar.remove(value - 1);
                    xli.remove(value - 1);
                    yli.remove(value - 1);
                }


            }

        }


    }

}
//leetcode submit region end(Prohibit modification and deletion)


class Main_52 {
    public static void main(String[] args) {
        System.out.println(new Solution().totalNQueens(8));
    }
}