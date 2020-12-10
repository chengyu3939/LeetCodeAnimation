package leetcode.editor.cn.螺旋遍历矩阵数组;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> iterator(int[][] arr) {

        List<Integer> result = new ArrayList<>();
//        得到x，y的最大值
        int x = arr[0].length; //横
        int y = arr.length; //纵
//        for (arr)
/*
//   13   14  15  16
   9    10  11  12
   5    6   7   8
   1    2   3   4



 */
        //遍历次数
        int times = (Math.min(x, y) / 2) + (Math.min(x, y) % 2 == 0 ? 0 : 1);


        for (int i = 0; i < times; i++) {
            //最下 y 不变 x 递增
            for (int j = i; j < x - i; j++) {
                result.add(arr[i][j]);
            }

            //最右 x不变 y递增
            for (int j = i + 1; j < y - i; j++) {

                result.add(arr[j][x - i - 1]);
            }


            for (int j = x - i - 1-1 ; j > i; j--) {

                result.add(arr[y - i - 1][j]);
            }

            //最左

            for (int j = y - i - 1; j > i; j--) {

                result.add(arr[j][i]);
            }


        }


        return result;
    }


    public static void main(String[] args) {

        System.out.println(new Solution().iterator(new int[][]{{1, 2, 3, 4,21}, {5, 6, 7, 8,22}, {9, 10, 11, 12,23}}));


    }
}
