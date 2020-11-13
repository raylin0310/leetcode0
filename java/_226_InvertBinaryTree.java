/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._226_InvertBinaryTree
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转二叉树
 * @author lilin
 * @date 2020-11-5 17:53
 */
public class _226_InvertBinaryTree {
	/*
	翻转一棵二叉树。
	 */

	/*
	递归(后续遍历)
	 */

	public static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.left = right;
		root.right = left;
		return root;
	}

	/*
	递归(前续遍历)
    */

	public static TreeNode invertTree2(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}

	/*
	迭代BFS，广度优先搜索
	 */

	public static TreeNode invertTree3(TreeNode root) {
		if (root == null) {
			return root;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur == null) {
				continue;
			}
			TreeNode temp = cur.left;
			cur.left = cur.right;
			cur.right = temp;
			queue.offer(cur.left);
			queue.offer(cur.right);
		}
		return root;
	}

	public static void main(String[] args) {
		System.out.println(_102_BinaryTreeLevelOrderTraversal.levelOrder(invertTree(TreeNode.stringToTreeNode("[4,2,7,1,3,6,9]"))));
	}
}
