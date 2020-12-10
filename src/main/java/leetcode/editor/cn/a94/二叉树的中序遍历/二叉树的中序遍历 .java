package leetcode.editor.cn.a94.二叉树的中序遍历;
//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
//输出：[2,1]
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
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 790 👎 0

//94-binary-tree-inorder-traversal
//2020-11-30 00:42:25

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
// * Definition for a binary tree node.
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
    public List<Integer> inorderTraversal(TreeNode root) {
        return iterator(root);
    }

    public List<Integer> leftIter(TreeNode node, List<Integer> list) {
        if (node == null) {
            return list;
        }
        if (node.left != null) {
            leftIter(node.left, list);
        }
        list.add(node.val);

        if (node.right != null) {
            leftIter(node.right, list);
        }
        return list;
    }

    public List<Integer> iterator(TreeNode node) {
        List<Integer> ls = new ArrayList<>();
        if (node == null) {
            return ls;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        while (!stack.empty() || cur != null) {
            if (cur.left != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                ls.add(cur.val);
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur = null;
                    //循环遍历。直到找到包含有节点的段
                    while (!stack.empty()) {
                        TreeNode pop = stack.pop();
                        ls.add(pop.val);
                        if (pop.right != null) {
                            cur = pop.right;
                            break;
                        }
                    }
                }
            }
        }
        return ls;
    }

    /**
     * jiedian2
     *
     * @param node
     * @return
     */
    public List<Integer> iterator2(TreeNode node) {


        return null;


    }
}
//leetcode submit region end(Prohibit modification and deletion)


class Main_Nine4 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(5)), new TreeNode(3));

        List<Integer> iterator = new Solution().iterator(treeNode);
        System.out.println(iterator);
    }
}