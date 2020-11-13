/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._298_BinaryTreeLongestConsecutiveSequence
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 二叉树最长连续序列
 * @author lilin
 * @date 2020-11-13 16:26
 */
public class _298_BinaryTreeLongestConsecutiveSequence {
	/*
	给你一棵指定的二叉树，请你计算它最长连续序列路径的长度。

	该路径，可以是从某个初始结点到树中任意结点，通过「父 - 子」关系连接而产生的任意路径。

	这个最长连续的路径，必须从父结点到子结点，反过来是不可以的。

	示例 1：

	输入:

	   1
	    \
	     3
	    / \
	   2   4
	        \
	         5

	输出: 3

	解析: 当中，最长连续序列是 3-4-5，所以返回结果为 3
	示例 2：

	输入:

	   2
	    \
	     3
	    /
	   2
	  /
	 1

	输出: 2

	解析: 当中，最长连续序列是 2-3。注意，不是 3-2-1，所以返回 2。
	 */

	private int res = 0;

	public int longestConsecutive(TreeNode root) {
		if (root == null) {
			return 0;
		}
		helper(root, 0, root.val);
		return res;
	}

	public void helper(TreeNode root, int max, int target) {
		if (root == null) {
			return;
		}
		if (root.val == target) {
			max++;
		} else {
			max = 1;
		}
		res = Math.max(res, max);
		helper(root.left, max, root.val + 1);
		helper(root.right, max, root.val + 1);
	}

	public static void main(String[] args) {
		_298_BinaryTreeLongestConsecutiveSequence test = new _298_BinaryTreeLongestConsecutiveSequence();
		System.out.println(test.longestConsecutive(TreeNode.stringToTreeNode("[1,2,3,3]")));
	}
}
