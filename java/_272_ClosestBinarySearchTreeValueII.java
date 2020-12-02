/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._272_ClosestBinarySearchTreeValueII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * _272_ClosestBinarySearchTreeValueII
 * @author lilin
 * @date 2020-12-2 11:08
 */
public class _272_ClosestBinarySearchTreeValueII {
	/*
	给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的 k 个值。

	注意：
	给定的目标值 target 是一个浮点数
	你可以默认 k 值永远是有效的，即 k ≤ 总结点数
	题目保证该二叉搜索树中只会存在一种 k 个值集合最接近目标值

	示例：
	输入: root = [4,2,5,1,3]，目标值 = 3.714286，且 k = 2

	    4
	   / \
	  2   5
	 / \
	1   3

	输出: [4,3]

	拓展：
	假设该二叉搜索树是平衡的，请问您是否能在小于 O(n)（n 为总结点数）的时间复杂度内解决该问题呢？
	 */

	public static List<Integer> closestKValues(TreeNode root, double target, int k) {
		LinkedList<Integer> res = new LinkedList<>();
		helper(res, root, target, k);
		return res;
	}

	/*
	中序遍历+滑动窗口思想，保证res里的node是顺序的，[peekFirst......target......root]，比较peekFirst、root和target大小即可
	即比较头尾的差距
	time : O(n) space : O(n)
	 */

	private static void helper(LinkedList<Integer> res, TreeNode root, double target, int k) {
		if (root == null) {
			return;
		}
		helper(res, root.left, target, k);

		//在res.add(root.val)之前做判断
		if (res.size() == k) {
			if (Math.abs(target - root.val) < Math.abs(target - res.peekFirst())) {
				res.removeFirst();
			} else {
				return;
			}
		}
		res.add(root.val);
		helper(res, root.right, target, k);
	}

	/*
	迭代版中序遍历
	 */

	public static List<Integer> closestKValues2(TreeNode root, double target, int k) {
		LinkedList<Integer> res = new LinkedList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> queue = new LinkedList<>();
		TreeNode cur = root;
		while (cur != null || !queue.isEmpty()) {
			while (cur != null) {
				queue.push(cur);
				cur = cur.left;
			}
			TreeNode cur1 = queue.pop();
			//在res.add(root.val)之前做判断
			if (res.size() == k) {
				if (Math.abs(target - cur1.val) < Math.abs(target - res.peekFirst())) {
					res.removeFirst();
				} else {
					continue;
				}
			}
			res.add(cur1.val);
			cur = cur1.right;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(closestKValues(TreeNode.stringToTreeNode("[100,50,200,40,51]"), 40,3));
		System.out.println(closestKValues2(TreeNode.stringToTreeNode("[100,50,200,40,51]"), 40,3));
	}
}
