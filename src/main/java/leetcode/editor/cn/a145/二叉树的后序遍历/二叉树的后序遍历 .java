package leetcode.editor.cn.a145.二叉树的后序遍历;
//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 486 👎 0

//145-binary-tree-postorder-traversal
//2020-12-08 18:02:35

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//*Definition for a binary tree node.
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

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return iterator(root);
    }

    public List<Integer> recurse(TreeNode root, List<Integer> result) {

        if (root != null) {
            recurse(root.left, result);
            recurse(root.right, result);
            result.add(root.val);
        }
        return result;
    }

    /**
     * 后置遍历：迭代
     * 取出顶节点。将其放入栈
     *
     *
     *
     * @param root
     * @return
     */

    public List<Integer> iterator(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        Stack<Integer> value = new Stack<>();
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            value.add(pop.val);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }

        }


        while (!value.empty()) {
            result.add(value.pop());
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


class Main_145 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(5)), new TreeNode(3));

        List<Integer> iterator = new Solution().postorderTraversal(treeNode);
        System.out.println(iterator);
    }
}