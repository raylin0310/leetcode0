/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._285_InorderSuccessorInBST
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 二叉搜索树中的顺序后继
 * @author lilin
 * @date 2020-12-1 13:50
 */
public class _285_InorderSuccessorInBST {
	/*
	给你一个二叉搜索树和其中的某一个结点，请你找出该结点在树中顺序后继的节点。

	结点 p 的后继是值比 p.val 大的结点中键值最小的结点。
	 */

	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode res = null;
		while (root != null) {
			if (root.val <= p.val) {
				root = root.right;
			} else {
				//这里设置是因为如果p是叶子节点的情况
				res = root;
				root = root.left;
			}
		}
		return res;
	}

}
