/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._124_BinaryTreeMaximumPathSum
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 二叉树中的最大路径和
 * @author lilin
 * @date 2020-11-16 11:09
 */
public class _124_BinaryTreeMaximumPathSum {
	/*
	给定一个非空二叉树，返回其最大路径和。

	本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

	示例 1：
	
	输入：[1,2,3]
	
	       1
	      / \
	     2   3
	    |\   |\
	   4  5 6  7
	
	输出：6
	示例2：
	
	输入：[-10,9,20,null,null,15,7]
	
	  -10
	 / \
	 9 20
	  / \
	 15  7
	
	输出：42
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
		思路：自底向上
	 */

	int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		maxGain(root);
		return maxSum;
	}

	public int maxGain(TreeNode node) {
		if (node == null) {
			return 0;
		}

		// 递归计算左右子节点的最大贡献值
		// 只有在最大贡献值大于 0 时，才会选取对应子节点
		int leftGain = Math.max(maxGain(node.left), 0);
		int rightGain = Math.max(maxGain(node.right), 0);

		// 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
		// 这里计算priceNewpath的原因是题目说了‘且不一定经过根节点’，有可能在树的中间来个-9999，那么就分成了两个区域了
		// 所以，这里的每一个node都要计算priceNewpath才行
		int priceNewpath = node.val + leftGain + rightGain;

		// 更新答案
		maxSum = Math.max(maxSum, priceNewpath);

		// 返回节点的最大贡献值
		return node.val + Math.max(leftGain, rightGain);
	}

	public static void main(String[] args) {
		_124_BinaryTreeMaximumPathSum test = new _124_BinaryTreeMaximumPathSum();
		System.out.println(test.maxPathSum(TreeNode.stringToTreeNode("[1,2,3,4,5,6]")));
	}
}
