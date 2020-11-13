/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._113_PathSumII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * _113_PathSumII
 * @author lilin
 * @date 2020-11-13 13:56
 */
public class _113_PathSumII {
	/*
	给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

	说明:叶子节点是指没有子节点的节点。
	
	示例:
	给定如下二叉树，以及目标和sum = 22，
	
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \    / \
	        7    2  5   1
	返回:
	
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/path-sum-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		dfs(res, new ArrayList<>(), root, sum);
		return res;
	}

	public static void dfs(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum) {
		path.add(root.val);
		if (root.left == null && root.right == null) {
			if (root.val == sum) {
				res.add(new ArrayList<>(path));
			}
		}
		if (root.left != null) {
			dfs(res, path, root.left, sum - root.val);
		}
		if (root.right != null) {
			dfs(res, path, root.right, sum - root.val);
		}
		//返回上层的时候，把这一层添加的value移除
		path.remove(path.size() - 1);
	}

	public static void main(String[] args) {

		//AU.print(pathSum(TreeNode.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]"), 1));
		AU.print(pathSum(TreeNode.stringToTreeNode("[0,1,1]"), 1));


	}
}
