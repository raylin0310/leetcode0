/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._111_MinimumDepthOfBinaryTree
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的最小深度
 * @author lilin
 * @date 2020-11-16 10:10
 */
public class _111_MinimumDepthOfBinaryTree {
	/*
	给定一个二叉树，找出其最小深度。

	最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
	
	说明：叶子节点是指没有子节点的节点。

	示例 1：
	
	输入：root = [3,9,20,null,null,15,7]
	输出：2
	示例 2：
	
	输入：root = [2,null,3,null,4,null,5,null,6]
	输出：5

	提示：
	
	树中节点数的范围在 [0, 105] 内
	-1000 <= Node.val <= 1000
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return dfs(root, 1);
	}

	public static int dfs(TreeNode root, int level) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		if (root.left == null && root.right == null) {
			return level;
		}
		return Math.min(dfs(root.left, level + 1), dfs(root.right, level + 1));
	}

	public static int minDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);
		int level = 1;
		while (!deque.isEmpty()) {
			int size = deque.size();
			// 这个size表示这一层的node数量
			for (int i = 0; i < size; i++) {
				TreeNode cur = deque.poll();
				if (cur.right == null && cur.left == null){
					return level;
				}
				if (cur.left!=null){
					deque.offer(cur.left);
				}
				if (cur.right!=null){
					deque.offer(cur.right);
				}
			}
			level++;
		}
		return level;
	}

	public static void main(String[] args) {
		System.out.println(minDepth2(TreeNode.stringToTreeNode("[2,null,3,null,4,null,5,null,6]")));
	}
}
