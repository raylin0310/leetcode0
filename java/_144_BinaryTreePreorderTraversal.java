/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._144_BinaryTreePreorderTraversal
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * @author lilin
 * @date 2020-11-3 16:19
 */
public class _144_BinaryTreePreorderTraversal {
	/*
	给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
	 */

	/*
	递归
	 time : O(n);
     space : O(n);
	 */

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root != null) {
			preorderTraversal(res, root);
		}
		return res;
	}

	public static void preorderTraversal(List<Integer> res, TreeNode root) {
		if (root == null) {
			return;
		}
		res.add(root.val);
		preorderTraversal(res, root.left);
		preorderTraversal(res, root.right);
	}

	/*
	迭代，用stack模拟线程栈
	 */

	public static List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		while (!stack.isEmpty()){
			TreeNode cur = stack.pop();
			if (cur.right!=null){
				stack.push(cur.right);
			}
			if (cur.left!=null){
				stack.push(cur.left);
			}
			res.add(cur.val);
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
		System.out.println(preorderTraversal2(root));
	}
}
