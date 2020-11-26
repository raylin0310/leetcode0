/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._098_ValidateBinarySearchTree
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Stack;

/**
 * 验证二叉搜索树
 * @author lilin
 * @date 2020-11-24 10:46
 */
public class _098_ValidateBinarySearchTree {
	/*
	给定一个二叉树，判断其是否是一个有效的二叉搜索树。

	假设一个二叉搜索树具有如下特征：
	
	节点的左子树只包含小于当前节点的数。
	节点的右子树只包含大于当前节点的数。
	所有左子树和右子树自身必须也是二叉搜索树。
	示例1:
	
	输入:
	    2
	   / \
	  1   3
	输出: true
	示例2:
	
	输入:
	    5
	   / \
	  1   4
	    / \
	   3   6
	输出: false
	解释: 输入为: [5,1,4,null,null,3,6]。
	    根节点的值为 5 ，但是其右子节点值为 4 。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/validate-binary-search-tree
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */



	public static boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root, null, null);
	}

	public static boolean helper(TreeNode root, Integer min, Integer max) {
		if (root == null) {
			return true;
		}
		if (min != null && root.val <= min) {
			return false;
		}
		if (max != null && root.val >= max) {
			return false;
		}
		return helper(root.left, min, root.val) && helper(root.right, root.val, max);
	}

	/*
	还可以用中序遍历，参考
	https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
	 */

	public boolean isValidBST2(TreeNode root) {
		if (root == null) {
			return true;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if(pre != null && root.val <= pre.val) {
				return false;
			}
			pre = root;
			root = root.right;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isValidBST(TreeNode.stringToTreeNode("[5,1,4,null,null,3,6]")));
	}
}
