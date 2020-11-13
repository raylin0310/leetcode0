/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._257_BinaryTreePaths
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  二叉树的所有路径
 * @author lilin
 * @date 2020-11-13 11:01
 */
public class _257_BinaryTreePaths {
	/*
	给定一个二叉树，返回所有从根节点到叶子节点的路径。

	说明:叶子节点是指没有子节点的节点。

	示例:

	输入:

	   1
	 /   \
	2     3
	 \
	  5

	输出: ["1->2->5", "1->3"]

	解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/binary-tree-paths
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	递归，DFS，深度优先搜索
	 */

	public static List<String> binaryTreePaths(TreeNode root) {
		ArrayList<String> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		helper(result, root, "");
		return result;
	}

	public static void helper(List<String> res, TreeNode root, String path) {
		if (root.left == null && root.right == null) {
			res.add(path + root.val);
		}
		if (root.left != null) {
			helper(res, root.left, path + root.val + "->");
		}
		if (root.right != null) {
			helper(res, root.right, path + root.val + "->");
		}
	}
	/*
	迭代，BFS，广度优先搜索
	 */

	public static List<String> binaryTreePaths2(TreeNode root) {
		List<String> paths = new ArrayList<>();
		if (root == null) {
			return paths;
		}
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		Queue<String> pathQueue = new LinkedList<>();

		nodeQueue.offer(root);
		pathQueue.offer(Integer.toString(root.val));

		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.poll();
			String path = pathQueue.poll();

			if (node.left == null && node.right == null) {
				paths.add(path);
			} else {
				if (node.left != null) {
					nodeQueue.offer(node.left);
					pathQueue.offer(path + "->" + node.left.val);
				}

				if (node.right != null) {
					nodeQueue.offer(node.right);
					pathQueue.offer(path + "->" + node.right.val);
				}
			}
		}
		return paths;
	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(7);
		root.left = left;
		root.right = right;

		TreeNode leftl = new TreeNode(1);
		TreeNode leftr = new TreeNode(3);

		TreeNode rightl = new TreeNode(6);
		//TreeNode rightr = new TreeNode(9);
		left.left = leftl;
		left.right = leftr;

		right.left = rightl;
		//right.right = rightr;
		/*
				     4
				   /   \
				  2     7
				 / \   / \
				1   3 6   9
		 */
		AU.print(binaryTreePaths(root));
	}
}
