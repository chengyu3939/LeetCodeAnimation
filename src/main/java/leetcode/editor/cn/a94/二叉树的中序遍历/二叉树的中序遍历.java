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

        List<Integer> result = new ArrayList<>();

        List<Integer> list = leftIter(root, result);
        return list;
    }

    public List<Integer> leftIter(TreeNode node, List<Integer> list) {
        if (node==null){
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
}
//leetcode submit region end(Prohibit modification and deletion)


class Main_Nine4 {
    public static void main(String[] args) {

    }
}