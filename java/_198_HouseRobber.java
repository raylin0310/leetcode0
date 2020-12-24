/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._198_HouseRobber
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 打家劫舍
 * @author lilin
 * @date 2020-12-24 19:32
 */
public class _198_HouseRobber {
	/*
	你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
	影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

	给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

	示例 1：
	
	输入：[1,2,3,1]
	输出：4
	解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
	    偷窃到的最高金额 = 1 + 3 = 4 。
	示例 2：
	
	输入：[2,7,9,3,1]
	输出：12
	解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
	    偷窃到的最高金额 = 2 + 9 + 1 = 12 。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/house-robber
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	     time : O(n)
        space : O(1)
        这个题解讲的不错
        https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-by-leetcode-solution/
	 */

	public static int rob(int[] nums) {
		int prevNo = 0;
		int prevYes = 0;
		for (int num : nums) {
			int temp = prevNo;
			//当前节点不选择偷的情况，前一个节点偷不偷不关心，只需要取前一个节点“钱”的最大值即可
			prevNo = Math.max(prevNo, prevYes);
			//当前节点选择偷，那左右节点就只能选择不偷时的值
			prevYes = num + temp;
		}
		return Math.max(prevNo, prevYes);
	}

	public static void main(String[] args) {
		//int[] nums = {2, 7, 9, 3, 1};
		int[] nums = {2, 1, 1, 2};
		System.out.println(rob(nums));

	}
}
