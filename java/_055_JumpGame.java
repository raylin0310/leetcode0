
/**
 * _55_JumpGame
 * @author lilin
 * @date 2020-5-7 14:23
 */
public class _055_JumpGame {
/*
	给定一个非负整数数组，你最初位于数组的第一个位置。

	数组中的每个元素代表你在该位置可以跳跃的最大长度。

	判断你是否能够到达最后一个位置。

	示例 1:

	输入: [2,3,1,1,4]
	输出: true
	解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
	示例 2:

	输入: [3,2,1,0,4]
	输出: false
	解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
*/

	/*
	 * @link  https://leetcode-cn.com/problems/jump-game/solution/55-by-ikaruga/
	 * 不断更新最远位置，在当前节点已经超过最远位置时，说明到达不了了
	 */

	public static boolean canJump(int[] nums) {
		int max = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (i > max) {
				return false;
			}
			max = Math.max(nums[i] + i, max);
			if (max >= n - 1) {
				return true;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = {3, 2, 1, 0, 4};
		System.out.println(canJump(nums));
	}
}
