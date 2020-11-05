/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._226_InvertBinaryTree
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 翻转二叉树
 * @author lilin
 * @date 2020-11-5 17:53
 */
public class _226_InvertBinaryTree {

	public static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		if (root.left == null && root.right == null) {
			return root;
		}
		TreeNode l = root.left;
		TreeNode r = root.right;
		root.left = r;
		root.right = l;
		help(l, r);
		return root;
	}

	public static void help(TreeNode p, TreeNode q) {
		if (p == null && q == null){
			return;
		}
		TreeNode pl = p.left;
		TreeNode pr = p.left;

		TreeNode ql = q.left;
		TreeNode qr = q.left;

		p.left = qr;
		p.right = ql;
		q.left = pr;
		q.right = pl;
		help(pl,qr);
		help(pr,ql);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(7);
		root.left = left;
		root.right = right;

		TreeNode leftl = new TreeNode(1);
		TreeNode leftr = new TreeNode(3);

		TreeNode rightl = new TreeNode(6);
		TreeNode rightr = new TreeNode(9);
		left.left = leftl;
		left.right = leftr;

		right.left = rightl;
		right.right = rightr;
		System.out.println(invertTree(root));
	}
}
