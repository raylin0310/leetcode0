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
				//root.val > p.val
				res = root;
				root = root.left;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(inorderSuccessor(TreeNode.stringToTreeNode("[100,50,60,30,40,70,80,20]"), new TreeNode(20)).val);
	}

}
