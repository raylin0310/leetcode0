/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._250_CountUnivalueSubtrees
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 同值子树
 * @author lilin
 * @date 2020-11-17 9:51
 */
public class _250_CountUnivalueSubtrees {
	/*
	给定一个二叉树，统计该二叉树数值相同的子树个数。

	同值子树是指该子树的所有节点都拥有相同的数值。

	示例：

	输入: root = [5,1,5,5,5,null,5]

	              5
	             / \
	            1   5
	           / \     \
	          5   5   5
	 */

	/*
	思路：自底向上
	 */

	int res;

	public int countUnivalSubtrees(TreeNode root) {
		res = 0;
		helper(root);
		return res;
	}

	public boolean helper(TreeNode root) {
		if (root == null) {
			return true;
		}

		boolean left = helper(root.left);
		boolean right = helper(root.right);

		if (left && right) {
			if (root.left != null && root.val != root.left.val) {
				return false;
			}
			if (root.right != null && root.val != root.right.val) {
				return false;
			}
			res++;
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		_250_CountUnivalueSubtrees test = new _250_CountUnivalueSubtrees();
		System.out.println(test.countUnivalSubtrees(TreeNode.stringToTreeNode("[5,1,5,5,5,null,5]")));
	}
}
