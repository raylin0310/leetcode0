/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._199_BinaryTreeRightSideView
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右视图
 * @author lilin
 * @date 2020-11-24 10:37
 */
public class _199_BinaryTreeRightSideView {
	/*
	给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

	示例:
	
	输入:[1,2,3,null,5,null,4]
	输出:[1, 3, 4]
	解释:
	
	   1            <---
	 /   \
	2     3         <---
	 \     \
	  5     4       <---
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if (i == 0) {
					res.add(cur.val);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
				if (cur.left != null) {
					queue.offer(cur.left);
				}
			}
		}
		return res;
	}


	public List<Integer> rightSideView2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		dfs(res, root, 0);
		return res;
	}

	private void dfs(List<Integer> res, TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if (res.size() == level) {
			res.add(root.val);
		}
		dfs(res, root.right, level + 1);
		dfs(res, root.left, level + 1);
	}

	public static void main(String[] args) {

	}
}
