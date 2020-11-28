package leetcode.editor.cn.base;

import java.util.Comparator;
import java.util.Stack;

public abstract class AbstractSingleStack extends Stack<Integer> implements Comparator<Integer> {
    /**
     * 单调栈
     */
    @Override
    public Integer push(Integer item) {
        //单调栈
        if (empty()) {
            super.push(item);
            return item;
        }

        if (compare(item, peek()) > 0) {
            //满足条件
            super.push(item);
        } else {
            Integer pop = pop();
            System.out.println("出栈POP！");
            call(pop, item);
            push(item);
        }
        return item;
    }

    public abstract void call(Integer pop, Integer item);

}
