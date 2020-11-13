/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._112_PathSum
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 路径总和
 * @author lilin
 * @date 2020-11-13 13:42
 */
public class _112_PathSum {
	/*
	给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

	说明:叶子节点是指没有子节点的节点。
	
	示例:
	给定如下二叉树，以及目标和 sum = 22，
	
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \      \
	        7    2      1
	返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/path-sum
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	*/
	/*
		DFS
	 */

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return sum == root.val;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

	public boolean hasPathSum2(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		Queue<TreeNode> queNode = new LinkedList<TreeNode>();
		Queue<Integer> queVal = new LinkedList<Integer>();
		queNode.offer(root);
		queVal.offer(root.val);
		while (!queNode.isEmpty()) {
			TreeNode cur = queNode.poll();
			int num = queVal.poll();
			if (cur.left == null && cur.right == null) {
				if (num == sum) {
					return true;
				}
				continue;
			}
			if (cur.left != null) {
				queNode.offer(cur.left);
				queVal.offer(cur.left.val + num);
			}
			if (cur.right != null) {
				queNode.offer(cur.right);
				queVal.offer(cur.right.val + num);
			}
		}
		return false;
	}

	public static void main(String[] args) {

	}
}
