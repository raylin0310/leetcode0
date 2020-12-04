/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._094_BinaryTreeInorderTraversal
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * _094_BinaryTreeInorderTraversal
 * @author lilin
 * @date 2020-11-3 16:42
 */
public class _094_BinaryTreeInorderTraversal {
	/*
	二叉树的中序遍历
	 */

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		helper(res, root);
		return res;
	}

	public static void helper(List<Integer> res, TreeNode root) {
		if (root == null) {
			return;
		}
		helper(res, root.left);
		res.add(root.val);
		helper(res, root.right);
	}


	public static List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			res.add(cur.val);
			cur = cur.right;
		}
		return res;
	}

	/*
	画图打debug跟一下理清逻辑
	 */

	public static List<Integer> inorderTraversal3(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		TreeNode predecessor = null;

		while (root != null) {
			if (root.left != null) {
				// predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
				predecessor = root.left;
				while (predecessor.right != null && predecessor.right != root) {
					predecessor = predecessor.right;
				}
				// 让 predecessor 的右指针指向 root，继续遍历左子树
				if (predecessor.right == null) {
					predecessor.right = root;
					root = root.left;
				} else {
					// 说明左子树已经访问完了，我们需要断开链接
					res.add(root.val);
					predecessor.right = null;
					root = root.right;
				}
			} else {
				// 如果没有左孩子，则直接访问右孩子
				res.add(root.val);
				// 这里的right就是predecessor node，顺序后继节点
				root = root.right;
			}
		}
		return res;
	}

	public static void main(String[] args) {

		System.out.println(inorderTraversal3(TreeNode.stringToTreeNode("[1,2,null,4,5]")));
	}
}
