/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._1382_BalanceBST
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * _1382_BalanceBST
 * @author lilin
 * @date 2020-11-26 14:35
 */
public class _1382_BalanceBST {

	/*
	给你一棵二叉搜索树，请你返回一棵平衡后的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。

	如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是平衡的 。
	
	如果有多种构造方法，请你返回任意一种。

	输入：root = [1,null,2,null,3,null,4,null,null]
	输出：[2,1,3,null,null,null,4]
	解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。

	作者：LeetCode-Solution
	链接：https://leetcode-cn.com/problems/balance-a-binary-search-tree/solution/jiang-er-cha-sou-suo-shu-bian-ping-heng-by-leetcod/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

	 */


	List<Integer> inorderSeq = new ArrayList<Integer>();

	/*
	时间复杂度：获得中序遍历的时间代价是 O(n)；建立平衡二叉树的时建立每个点的时间代价为 O(1)，
			总时间也是 O(n)。故渐进时间复杂度为 O(n)。

	空间复杂度：这里使用了一个数组作为辅助空间，存放中序遍历后的有序序列，故渐进空间复杂度为 O(n)O(n)。

	 */

	public TreeNode balanceBST(TreeNode root) {
		getInorder(root);
		return build(0, inorderSeq.size() - 1);
	}
	//中序遍历，得到顺序的节点值

	public void getInorder(TreeNode o) {
		if (o.left != null) {
			getInorder(o.left);
		}
		inorderSeq.add(o.val);
		if (o.right != null) {
			getInorder(o.right);
		}
	}

	public TreeNode build(int l, int r) {
		int mid = (l + r) >> 1;
		TreeNode o = new TreeNode(inorderSeq.get(mid));
		if (l <= mid - 1) {
			o.left = build(l, mid - 1);
		}
		if (mid + 1 <= r) {
			o.right = build(mid + 1, r);
		}
		return o;
	}
}
