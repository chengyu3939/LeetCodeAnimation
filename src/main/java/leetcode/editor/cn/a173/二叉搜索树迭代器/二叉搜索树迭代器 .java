package leetcode.editor.cn.a173.二叉搜索树迭代器;
//实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。 
//
// 调用 next() 将返回二叉搜索树中的下一个最小的数。 
//
// 
//
// 示例： 
//
// 
//
// BSTIterator iterator = new BSTIterator(root);
//iterator.next();    // 返回 3
//iterator.next();    // 返回 7
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 9
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 15
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 20
//iterator.hasNext(); // 返回 false 
//
// 
//
// 提示： 
//
// 
// next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。 
// 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。 
// 
// Related Topics 栈 树 设计 
// 👍 292 👎 0

//173-binary-search-tree-iterator
//2020-12-08 20:57:57

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BSTIterator {

    TreeNode cur;

    Stack<TreeNode> h = new Stack<>();

    public BSTIterator(TreeNode root) {

        cur = root;
        //遍历找到最小的节点
        while (true) {
            if (cur.left != null) {
                h.push(cur);
                cur = cur.left;
            } else {
                break;
            }
        }


    }

    public int next() {
        int value = cur.val;
        // 遍历树
        if (cur.right != null) {

            cur = cur.right;
            while (true) {
                if (cur.left != null) {
                    h.push(cur);
                    cur = cur.left;
                } else {
                    break;
                }
            }

        } else {
            if (h.empty()) {
                return -1;
            }
            cur = h.pop();
        }

        return value;
    }

    public boolean hasNext() {

        if (cur.right != null || !h.empty()) {
            return true;
        }

        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)


class Main_173 {
    public static void main(String[] args) {

    }
}