/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._366_FindLeavesOfBinaryTree
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * _366_FindLeavesOfBinaryTree
 * @author lilin
 * @date 2020-11-17 10:03
 */
public class _366_FindLeavesOfBinaryTree {
	/*
	给你一棵完全二叉树，请按以下要求的顺序收集它的全部节点：

	依次从左到右，每次收集并删除所有的叶子节点
	重复如上过程直到整棵树为空
	示例:
	输入: [1,2,3,4,5]
	      1
	     / \
	    2   3
	   / \
	  4   5
	输出: [[4,5,3],[2],[1]]
	解释:

	删除叶子节点 [4,5,3] ，得到如下树结构：
	1 / 2
	现在删去叶子节点 [2] ，得到如下树结构：
	1
	现在删去叶子节点 [1] ，得到空树：
	[]
	 */
	/*
	我们发现根据子树的高度来分组的

	比如示例中 4, 5, 3高度都是0，2是1，1是2
	思路：自底向上遍历，叶子节点的高度使0，向上递增
	 */

	public static List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		helper(res, root);
		return res;
	}

	private static int helper(List<List<Integer>> res, TreeNode root) {
		if (root == null) {
			return -1;
		}
		int left = helper(res, root.left);
		int right = helper(res, root.right);
		//自底向上，当前node属于哪个level，是由子节点决定的
		int level = Math.max(left, right) + 1;
		if (res.size() == level) {
			res.add(new ArrayList<>());
		}
		res.get(level).add(root.val);
		root.left = null;
		root.right = null;
		return level;
	}

	public static void main(String[] args) {
		System.out.println(findLeaves(TreeNode.stringToTreeNode("[1,2,3,4,5]")));
	}
}
