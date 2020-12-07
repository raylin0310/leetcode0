/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._314_BinaryTreeVerticalOrderTraversal
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的垂直遍历
 * @author lilin
 * @date 2020-12-7 11:33
 */
public class _314_BinaryTreeVerticalOrderTraversal {
	/*
	给定一个二叉树，返回其结点 垂直方向（从上到下，逐列）遍历的值。

	如果两个结点在同一行和列，那么顺序则为 从左到右。

	示例:
	示例 1：

	输入: [3,9,20,null,null,15,7]

	   3
	  /\
	 /  \
	9   20
	    /\
	   /  \
	  15   7

              |
      . _ * _ * _ 0 _ . _ *
     -2  -1   0   1   2   3

	输出:

	[
	  [9],
	  [3,15],
	  [20],
	  [7]
	]
	思路: 先找出最左和最右的index，设置root的index为0
	然后设置两个关联队列，root的初始index为-min，然后迭代root
	 */

	private int min = 0;
	private int max = 0;

	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		helper(root, 0);
		for (int i = min; i <= max; i++) {
			res.add(new ArrayList<>());
		}

		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> index = new LinkedList<>();
		index.offer(-min);
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			int idx = index.poll();
			res.get(idx).add(cur.val);
			if (cur.left != null) {
				queue.offer(cur.left);
				index.offer(idx - 1);
			}
			if (cur.right != null) {
				queue.offer(cur.right);
				index.offer(idx + 1);
			}
		}
		return res;
	}

	private void helper(TreeNode root, int idx) {
		if (root == null) {
			return;
		}
		min = Math.min(min, idx);
		max = Math.max(max, idx);
		helper(root.left, idx - 1);
		helper(root.right, idx + 1);
	}

	public static void main(String[] args) {
		_314_BinaryTreeVerticalOrderTraversal test = new _314_BinaryTreeVerticalOrderTraversal();
		System.out.println(test.verticalOrder(TreeNode.stringToTreeNode("[3,9,20,null,null,15,7]")).toString());
		System.out.println("max：" + test.max);
		System.out.println("min：" + test.min);
	}
}
