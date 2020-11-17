/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._107_BinaryTreeLevelOrderTraversalII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * _107_BinaryTreeLevelOrderTraversalII
 * @author lilin
 * @date 2020-11-17 20:23
 */
public class _107_BinaryTreeLevelOrderTraversalII {
	/*
	给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

	例如：
	给定二叉树 [3,9,20,null,null,15,7],

	    3
	   / \
	  9  20
	    /  \
	   15   7
	返回其自底向上的层次遍历为：

	[
	  [15,7],
	  [9,20],
	  [3]
	]

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	时间复杂度：O(n)O(n)，其中 nn 是二叉树中的节点个数。每个节点访问一次，结果列表使用链表的结构时，在结果列表头部添加一层节点值的列表的时间复杂度是 O(1)O(1)，因此总时间复杂度是 O(n)O(n)。

	空间复杂度：O(n)O(n)，其中 nn 是二叉树中的节点个数。空间复杂度取决于队列开销，队列中的节点个数不会超过 nn。

	思路：bfs，自底向上层序遍历
	 */

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> res = new LinkedList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);
		while (!deque.isEmpty()) {
			int size = deque.size();
			List<Integer> levels = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode cur = deque.poll();
				levels.add(cur.val);
				if (cur.left != null) {
					deque.offer(cur.left);
				}
				if (cur.right != null) {
					deque.offer(cur.right);
				}
			}
			res.addFirst(levels);
		}
		return res;
	}

	public static List<List<Integer>> levelOrderBottom2(TreeNode root) {
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
			res.add(0, new ArrayList<>());
		}
		res.get(res.size() - level - 1).add(root.val);
		helper(res, root.left, level + 1);
		helper(res, root.right, level + 1);
	}


	public static void main(String[] args) {
		System.out.println(levelOrderBottom2(TreeNode.stringToTreeNode("[3,9,20,null,null,15,7]")));
	}
}
