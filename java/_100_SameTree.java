/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._100_SameTree
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * _100_SameTree
 * @author lilin
 * @date 2020-11-5 15:33
 */
public class _100_SameTree {
	/*
	给定两个二叉树，编写一个函数来检验它们是否相同。

    如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

    树的框架题解：https://leetcode-cn.com/problems/same-tree/solution/xie-shu-suan-fa-de-tao-lu-kuang-jia-by-wei-lai-bu-/
	 */

	/*
	深度优先搜索
	 */

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		} else if (p.val != q.val) {
			return false;
		} else {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
	}

	/*
	广度优先搜索
	 */

	public static boolean isSameTree2(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		}
		Queue<TreeNode> queue1 = new LinkedList<>();
		Queue<TreeNode> queue2 = new LinkedList<>();
		queue1.offer(p);
		queue2.offer(q);
		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			TreeNode node1 = queue1.poll();
			TreeNode node2 = queue2.poll();
			if (node1.val != node2.val) {
				return false;
			}
			TreeNode left1 = node1.left, right1 = node1.right, left2 = node2.left, right2 = node2.right;
			//异或等于 （left1 == nil && left2 != nil) || (left1 != nil && left2 == nil)
			if (left1 == null ^ left2 == null) {
				return false;
			}
			if (right1 == null ^ right2 == null) {
				return false;
			}
			if (left1 != null) {
				queue1.offer(left1);
			}
			if (right1 != null) {
				queue1.offer(right1);
			}
			if (left2 != null) {
				queue2.offer(left2);
			}
			if (right2 != null) {
				queue2.offer(right2);
			}
		}
		return queue1.isEmpty() && queue2.isEmpty();
	}



	public static void main(String[] args) {

	}
}
