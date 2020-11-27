/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._230_KthSmallestElementInABST
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉搜索树中第K小的元素
 * @author lilin
 * @date 2020-11-27 13:52
 */
public class _230_KthSmallestElementInABST {
	/*
	给定一个二叉搜索树，编写一个函数kthSmallest来查找其中第k个最小的元素。

	说明：
	你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
	
	示例 1:
	
	输入: root = [3,1,4,null,2], k = 1
	   3
	  / \
	 1   4
	  \
	  2
	输出: 1
	示例 2:
	
	输入: root = [5,3,6,2,4,null,null,1], k = 3
	       5
	      / \
	     3   6
	    / \
	   2   4
	  /
	 1
	输出: 3
	进阶：
	如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化kthSmallest函数？
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int kthSmallest(TreeNode root, int k) {
		if (k == 0) {
			return -1;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		TreeNode cur = root;
		while (cur != null || !deque.isEmpty()) {
			while (cur != null) {
				deque.push(cur);
				cur = cur.left;
			}
			cur = deque.pop();

			if (--k == 0) {
				return cur.val;
			}
			//这里还可以加上一步，当k==0时，直接return
			cur = cur.right;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(kthSmallest(TreeNode.stringToTreeNode("[3,1,4,null,2]"), 1));
	}
}
