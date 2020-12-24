/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._213_HouseRobberII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 *  打家劫舍 II
 * @see _198_HouseRobber
 * @author lilin
 * @date 2020-12-24 19:58
 */
public class _213_HouseRobberII {
	/*
	你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
	这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

	给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。

	示例1：
	
	输入：nums = [2,3,2]
	输出：3
	解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
	示例 2：
	
	输入：nums = [1,2,3,1]
	输出：4
	解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
	    偷窃到的最高金额 = 1 + 3 = 4 。
	示例 3：
	
	输入：nums = [0]
	输出：0
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/house-robber-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	
	/*

	1、在不偷窃第一个房子的情况下（即 nums[1:]），最大金额是 p1
	2、在不偷窃最后一个房子的情况下（即 nums[:n-1]），最大金额是 p2
	   综合偷窃最大金额： 为以上两种情况的较大值，即 max(p1,p2)
	*/

	public static int rob(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	}

	public static int rob(int[] nums, int lo, int hi) {
		int prevNo = 0;
		int prevYes = 0;
		for (int i = lo; i <= hi; i++) {
			int temp = prevNo;
			prevNo = Math.max(prevNo, prevYes);
			prevYes = nums[i] + temp;
		}
		return Math.max(prevNo, prevYes);
	}

	public static void main(String[] args) {

	}
}
