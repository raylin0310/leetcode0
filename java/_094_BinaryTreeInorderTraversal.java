/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._094_BinaryTreeInorderTraversal
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * _094_BinaryTreeInorderTraversal
 * @author lilin
 * @date 2020-11-3 16:42
 */
public class _094_BinaryTreeInorderTraversal {
	/*
	二叉树的中序遍历
	 */

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		helper(res, root);
		return res;
	}

	public static void helper(List<Integer> res, TreeNode root) {
		if (root == null) {
			return;
		}
		helper(res, root.left);
		res.add(root.val);
		helper(res, root.right);
	}


	public static List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			res.add(cur.val);
			cur = cur.right;
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;

		TreeNode leftl = new TreeNode(21);
		TreeNode leftr = new TreeNode(22);

		TreeNode rightl = new TreeNode(31);
		TreeNode rightr = new TreeNode(32);
		left.left = leftl;
		left.right = leftr;

		right.left = rightl;
		right.right = rightr;
		System.out.println(inorderTraversal2(root));
	}
}
