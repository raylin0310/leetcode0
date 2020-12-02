/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._270_ClosestBinarySearchTreeValue
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 最接近的二叉搜索树值
 * @author lilin
 * @date 2020-12-2 10:26
 */
public class _270_ClosestBinarySearchTreeValue {
	/*
	给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。

	注意：

	给定的目标值 target 是一个浮点数
	题目保证在该二叉搜索树中只会存在一个最接近目标值的数
	示例：

	输入: root = [4,2,5,1,3]，目标值 target = 3.714286

	    4
	   / \
	  2   5
	 / \
	1   3

	输出: 4

	思路：二分，当前节点比target大就往左边搜（因为右边的差距更大），当前节点比target小(或者相等)就往右搜（因为左边的差距更大）。

	同285题的题解
	 */

	public static int closestValue2(TreeNode root, double target) {
		int res = root.val;
		while (root != null) {
			System.out.println(root.val);
			if (Math.abs(target - root.val) < Math.abs(target - res)) {
				res = root.val;
			}
			root = root.val > target ? root.left : root.right;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(closestValue2(TreeNode.stringToTreeNode("[100,50,200,40,51]"), 50));
	}
}
