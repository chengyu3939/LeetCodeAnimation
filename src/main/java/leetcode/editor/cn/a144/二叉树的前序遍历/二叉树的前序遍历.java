package leetcode.editor.cn.a144.二叉树的前序遍历;
//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
// 前序遍历 中序遍历 后序遍历

    /*
         1
      2      3
    4   5   6  7

    中序遍历：

     */


//
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 464 👎 0

//144-binary-tree-preorder-traversal
//2020-12-02 23:29:54

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//   Definition for a binary tree node.
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
    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> ls = new ArrayList<>();
//        recurse(root, ls);

        return iterator(root);
//        return ls;
    }

    public void recurse(TreeNode node, List<Integer> list) {

        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.left != null) {
            recurse(node.left, list);
        }
        if (node.right != null) {
            recurse(node.right, list);

        }
    }

    public List<Integer> iterator(TreeNode node) {
        List<Integer> ls = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (node == null) {
            return ls;
        }
        stack.push(node);
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            ls.add(pop.val);
            TreeNode left = pop.left;
            TreeNode right = pop.right;
            if (right != null) {
                stack.push(right);

            }
            if (left != null) {
                stack.push(left);

            }


            //left
            //right


        }
        return ls;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class Main_One44 {
    public static void main(String[] args) {

    }
}