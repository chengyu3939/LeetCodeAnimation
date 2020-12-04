package leetcode.editor.cn.a103.二叉树的锯齿形层次遍历;
//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 300 👎 0

//103-binary-tree-zigzag-level-order-traversal
//2020-11-30 01:36:26

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ls = new ArrayList<>();

        List<TreeNode> nodess = new ArrayList<>();

        nodess.add(root);
        searchL(nodess, ls);
        return ls;
    }

    public void searchL(List<TreeNode> nodes, List<List<Integer>> result) {
        if (nodes==null|| nodes.size()==0){
            return;
        }
        //当前节点的数据
        List<Integer> ls = new ArrayList<>();
        List<TreeNode> curNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            ls.add(node.val);
            if (node.left!=null){
                curNodes.add(node.left);
            }
            if (node.right!=null){
                curNodes.add(node.right);

            }
        }
        result.add(ls);

        searchR(curNodes, result);
    }

    public void searchR(List<TreeNode> nodes, List<List<Integer>> result) {
        if (nodes==null||nodes.size()==0){
            return;
        }
        //当前节点的数据
        List<Integer> ls = new ArrayList<>();
        List<TreeNode> curNodes = new ArrayList<>();
        for (int i = nodes.size() - 1; i >= 0; i--) {
            ls.add(nodes.get(i).val);
            if (nodes.get(i).right!=null){
                curNodes.add(nodes.get(i).right);

            }
            if (nodes.get(i).left!=null){
                curNodes.add(nodes.get(i).left);
            }

        }
        result.add(ls);
        searchL(curNodes, result);
    }

}
//leetcode submit region end(Prohibit modification and deletion)


class Main_One03 {
    public static void main(String[] args) {

    }
}