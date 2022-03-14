/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._145_BinaryTreePostorderTraversal
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * _145_BinaryTreePostorderTraversal
 * @author lilin
 * @date 2020-11-3 16:50
 */
public class _145_BinaryTreePostorderTraversal {
	/*
	二叉树的后序遍历
	 */

	public static List<Integer> postorderTraversal(TreeNode root) {
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
		helper(res, root.right);
		res.add(root.val);
	}

	public static List<Integer> postorderTraversal2(TreeNode root) {
		LinkedList<Integer> res = new LinkedList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			res.addFirst(cur.val);
			if (cur.left != null) {
				stack.push(cur.left);
			}
			if (cur.right != null) {
				stack.push(cur.right);
			}
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
		ArrUtil.print(postorderTraversal2(root));
	}
}
