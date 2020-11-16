/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._110_BalancedBinaryTree
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 平衡二叉树
 * @author lilin
 * @date 2020-11-16 10:44
 */
public class _110_BalancedBinaryTree {
	/*
	给定一个二叉树，判断它是否是高度平衡的二叉树。

	本题中，一棵高度平衡二叉树定义为：

	一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
	输入：root = [3,9,20,null,null,15,7]
	输出：true

	输入：root = [1,2,2,3,3,null,null,4,4]
	输出：false

	输入：root = []
	输出：true
	 */

	public boolean isBalanced(TreeNode root) {
		return height(root) >= 0;
	}

	public int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

	private int height2(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int leftHeight, rightHeight;
		if ((leftHeight = height2(node.left)) == -1
				|| (rightHeight = height2(node.right)) == -1
				|| Math.abs(leftHeight - rightHeight) > 1) {
			//如果左子树返回-1，那么直接返回-1
			return -1;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}

}
