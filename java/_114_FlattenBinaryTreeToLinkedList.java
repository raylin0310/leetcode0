/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._114_FlattenBinaryTreeToLinkedList
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树展开为链表
 * @author lilin
 * @date 2020-12-3 10:25
 */
public class _114_FlattenBinaryTreeToLinkedList {
	/*
	给定一个二叉树，原地将它展开为一个单链表。

	例如，给定二叉树
	
	    1
	   / \
	  2   5
	 / \   \
	3   4   6
	将其展开为：
	
	1
	 \
	  2
	   \
	    3
	     \
	      4
	       \
	        5
	         \
	          6
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	time : O(n)
    space : O(n)
	 */

	public static void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
			if (!stack.isEmpty()) {
				cur.right = stack.peek();
			}
			cur.left = null;
		}
	}

	public void flatten3(TreeNode root) {
		if (root == null) {
			return;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		TreeNode prev = null;
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			if (prev != null) {
				prev.left = null;
				prev.right = curr;
			}
			TreeNode left = curr.left, right = curr.right;
			if (right != null) {
				stack.push(right);
			}
			if (left != null) {
				stack.push(left);
			}
			prev = curr;
		}
	}

	/*
	https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/er-cha-shu-zhan-kai-wei-lian-biao-by-leetcode-solu/
	官方动画
	 */

	public static void flatten2(TreeNode root) {
		TreeNode curr = root;
		while (curr != null) {
			if (curr.left != null) {
				TreeNode next = curr.left;
				TreeNode predecessor = next;
				while (predecessor.right != null) {
					predecessor = predecessor.right;
				}
				predecessor.right = curr.right;
				curr.left = null;
				curr.right = next;
			}
			curr = curr.right;
		}
	}


	public static void main(String[] args) {
		flatten(TreeNode.stringToTreeNode("[1,2,5]"));
	}
}
