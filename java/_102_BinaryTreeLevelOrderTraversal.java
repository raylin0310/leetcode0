/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._102_BinaryTreeLevelOrderTraversal
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * _102_BinaryTreeLevelOrderTraversal
 * @author lilin
 * @date 2020-11-5 10:37
 */
public class _102_BinaryTreeLevelOrderTraversal {
	/*
	二叉树的层序遍历
	 */

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		helper(res, root, 0);
		return res;
	}

	public static void helper(List<List<Integer>> res, TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if (level >= res.size()) {
			res.add(new ArrayList<>());
		}
		res.get(level).add(root.val);
		helper(res, root.left, level + 1);
		helper(res, root.right, level + 1);
	}

	/*
	广度优先搜索
	time: O(n)
	space:O(n)
	 */

	public static List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				// 这里只循环queue开始时的数量，即这一层的数量
				TreeNode cur = queue.poll();
				// 下面加入的是下一层的节点
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
				list.add(cur.val);
			}
			res.add(list);
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

		ArrUtil.print(levelOrder2(root));
	}


}
