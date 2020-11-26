/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._103_BinaryTreeZigzagLevelOrderTraversal
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的锯齿形层次遍历
 * @author lilin
 * @date 2020-11-24 10:10
 */
public class _103_BinaryTreeZigzagLevelOrderTraversal {
	/*
	给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

	例如：
	给定二叉树[3,9,20,null,null,15,7],
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	返回锯齿形层次遍历如下：
	
	[
	  [3],
	  [20,9],
	  [15,7]
	]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);
		boolean isOrderLeft = true;
		while (!deque.isEmpty()) {
			LinkedList<Integer> levels = new LinkedList<>();
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = deque.poll();
				if (isOrderLeft) {
					levels.add(cur.val);
				} else {
					levels.addFirst(cur.val);
				}
				if (cur.left != null) {
					deque.offer(cur.left);
				}
				if (cur.right != null) {
					deque.offer(cur.right);
				}
			}
			res.add(levels);
			isOrderLeft = !isOrderLeft;
		}
		return res;
	}


	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(root, res, 0);
		return res;
	}

	private void dfs(TreeNode curr, List<List<Integer>> res, int level) {
		if (curr == null) {
			return;
		}

		if (res.size() <= level) {
			List<Integer> newLevel = new LinkedList<>();
			res.add(newLevel);
		}

		List<Integer> collection = res.get(level);
		if (level % 2 == 0) {
			collection.add(curr.val);
		} else {
			collection.add(0, curr.val);
		}

		dfs(curr.left, res, level + 1);
		dfs(curr.right, res, level + 1);
	}

	public static void main(String[] args) {
		System.out.println(zigzagLevelOrder(TreeNode.stringToTreeNode("[3,9,20,null,null,15,7]")));
	}

}
