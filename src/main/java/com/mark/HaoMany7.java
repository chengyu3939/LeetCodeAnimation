package com.mark;

public class HaoMany7 {
    public static void main(String[] args) {


        System.out.println(new HaoMany7().count(9));
        System.out.println(new HaoMany7().count(99));
        System.out.println(new HaoMany7().count(999));
        System.out.println(new HaoMany7().count(9999));
        System.out.println(new HaoMany7().count(99999));
        System.out.println(new HaoMany7().count(999999));

    }


    public Integer number(Integer num) {
        // xxxx
        // 4444


        // 0 1 2 3 4 5 6 7 8 9
        // 0 1 2 3 4 5 6 7 8 9
        // 0 1 2 3 4 5 6 7 8 9
        // 0 1 2 3 4 5 6 7 8 9

        // 0 1 2 3 4 5 6 7 8 9
        // 0 1 2 3 4 5 6 7 8 9

        //排列组合后 N*10；

        // 9999*1/9+999*1/9+99*1/9+1
        //=1111+111+11+1 =
        /*
        1111
         111
          11
           1
           ----
           1234
         */


        return null;
    }

    public Integer count(Integer number) {

        int count = 0;
        for (int i = 0; i <= number; i++) {


            if (String.valueOf(i).contains("7")) {
                count++;
            }
        }


        System.out.println( "num :"+number +" count:"+ count+"  other " +(number-count+1) +"  ");
        return count;
    }
}
