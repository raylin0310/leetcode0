/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME.TreeNode
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * TreeNode
 * @author lilin
 * @date 2020-11-3 16:20
 */
public class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
