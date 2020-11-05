/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._101_SymmetricTree
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 * @author lilin
 * @date 2020-11-5 17:07
 */
public class _101_SymmetricTree {
	/*
	给定一个二叉树，检查它是否是镜像对称的。
	例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
	 */


	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.left == null ^ root.right == null) {
			return false;
		}
		return help2(root.left, root.right);
	}

	/*
	递归方式
	 */

	public static boolean help(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		} else if (p.val == q.val) {
			return help(p.left, q.right) && help(p.right, q.left);
		}
		return false;
	}

	/*
	 迭代方式
	 */

	public static boolean help2(TreeNode u, TreeNode v) {
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(u);
		q.offer(v);
		while (!q.isEmpty()) {
			u = q.poll();
			v = q.poll();
			if (u == null && v == null) {
				continue;
			}
			if ((u == null || v == null) || (u.val != v.val)) {
				return false;
			}

			q.offer(u.left);
			q.offer(v.right);

			q.offer(u.right);
			q.offer(v.left);
		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(2);
		root.left = left;
		root.right = right;

		TreeNode leftl = new TreeNode(3);
		TreeNode leftr = new TreeNode(4);

		TreeNode rightl = new TreeNode(4);
		TreeNode rightr = new TreeNode(3);
		left.left = leftl;
		left.right = leftr;

		right.left = rightl;
		right.right = rightr;
		System.out.println(isSymmetric(root));
	}
}
