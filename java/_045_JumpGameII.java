/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._45_JumpGameII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * _45_JumpGameII
 * @author lilin
 * @date 2020-5-7 14:56
 */
public class _045_JumpGameII {
/*
	给定一个非负整数数组，你最初位于数组的第一个位置。

	数组中的每个元素代表你在该位置可以跳跃的最大长度。

	你的目标是使用最少的跳跃次数到达数组的最后一个位置。

	示例:

	输入: [2,3,1,1,4]
	输出: 2
	解释: 跳到最后一个位置的最小跳跃数是 2。
	从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
*/

	/*
		贪心算法，从右向左，先找到能一步达到end的最左的点，然后重复
	 */

	public static int jump1(int[] nums) {
		int position = nums.length - 1;
		int steps = 0;
		while (position > 0) {
			for (int i = 0; i < position; i++) {
				if (i + nums[i] >= position) {
					position = i;
					steps++;
					break;
				}
			}
		}
		return steps;
	}

	/*
	 * @link https://leetcode-cn.com/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/
	 * 贪心，每走的一步都要走最远
	 *  比如{2, 3, 1, 1, 4}
	 *  第一步的可以走到下标2去，在下标0到2之间能走的最大值，就是下一步的目的地
	 */

	public static int jump2(int[] nums) {
		// end表示这一步的右边界，目的是找到这一步的起点到边界中间下一步能走的最远的下标
		int end = 0;
		int maxPosition = 0;
		int steps = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			//找能跳的最远的
			maxPosition = Math.max(maxPosition, nums[i] + i);
			// i==end的目的是在这一步范围内，我已经遍历完下一次能到的最远的地点
			if (i == end) {
				end = maxPosition;
				steps++;
			}
		}
		return steps;
	}

	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 1, 4};
		System.out.println(jump1(nums));
		System.out.println(jump2(nums));
	}


}

