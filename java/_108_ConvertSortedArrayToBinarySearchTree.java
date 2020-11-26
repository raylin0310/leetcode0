/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._108_ConvertSortedArrayToBinarySearchTree
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 将有序数组转换为二叉搜索树
 * @author lilin
 * @date 2020-11-26 11:21
 */
public class _108_ConvertSortedArrayToBinarySearchTree {
	/*
	将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

	本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。

	示例:

	给定有序数组: [-10,-3,0,5,9],

	一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

	      0
	     / \
	   -3   9
	   /   /
	 -10  5

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return helper(nums, 0, nums.length - 1);
	}

	/*
		时间复杂度：O(n)，其中 nn 是数组的长度。每个数字只访问一次。
		空间复杂度：O(log n)，其中 nn 是数组的长度。空间复杂度不考虑返回值，因此空间复杂度主要取决于递归栈的深度，递归栈的深度是 O(log n)。

		同1382题，贪心算法
	 */

	public static TreeNode helper(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}

		// 总是选择中间位置左边的数字作为根节点
		int mid = (right - left) / 2 + left;

		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, left, mid - 1);
		root.right = helper(nums, mid + 1, right);
		return root;
	}

	public static void main(String[] args) {
		int[] nums = {-10, -3, 0, 5, 9};
		sortedArrayToBST(nums).postorderTraversal();
	}
}
