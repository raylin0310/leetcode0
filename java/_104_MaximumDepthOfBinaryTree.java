/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._104_MaximumDepthOfBinaryTree
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的最大深度
 * @author lilin
 * @date 2020-11-16 10:34
 */
public class _104_MaximumDepthOfBinaryTree {
	/*
	给定一个二叉树，找出其最大深度。

	二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
	
	说明:叶子节点是指没有子节点的节点。
	
	示例：
	给定二叉树 [3,9,20,null,null,15,7]，
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	返回它的最大深度3 。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return dfs(root, 1);
	}

	public static int dfs(TreeNode root, int level) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		if (root.left == null && root.right == null) {
			return level;
		}
		return Math.max(dfs(root.left, level + 1), dfs(root.right, level + 1));
	}

	public static int dfs2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(dfs2(root.left), dfs2(root.right)) + 1;
	}

	public static int maxDepth3(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);
		int level = 0;
		while (!deque.isEmpty()) {
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = deque.poll();
				if (cur.left != null) {
					deque.offer(cur.left);
				}
				if (cur.right != null) {
					deque.offer(cur.right);
				}
			}
			level++;
		}
		return level;
	}

	public static void main(String[] args) {

	}
}
