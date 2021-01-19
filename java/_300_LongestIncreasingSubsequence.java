/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._300_LongestIncreasingSubsequence
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 最长上升子序列
 * @author lilin
 * @date 2020-9-9 10:44
 */
public class _300_LongestIncreasingSubsequence {

	/*
	给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
	
	子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

	示例 1：
	
	输入：nums = [10,9,2,5,3,7,101,18]
	输出：4
	解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
	示例 2：
	
	输入：nums = [0,1,0,3,2,3]
	输出：4
	示例 3：
	
	输入：nums = [7,7,7,7,7,7,7]
	输出：1
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
		time: O(n^2)，space: O(n)
	 */

	public static int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	//time： O(nlogn); space：O(n)  不明白。。简单看下官解就行，思路就是贪心算法
	public static int lengthOfLIS3(int[] nums) {
		int len = nums.length;
		if (len <= 1) {
			return len;
		}

		// tail 数组的定义：长度为 i + 1 的上升子序列的末尾最小是几
		int[] tail = new int[len];
		// 遍历第 1 个数，直接放在有序数组 tail 的开头
		tail[0] = nums[0];

		// end 表示有序数组 tail 的最后一个已经赋值元素的索引
		int end = 0;

		for (int i = 1; i < len; i++) {
			int left = 0;
			// 这里，因为当前遍历的数，有可能比有序数组 tail 数组实际有效的末尾的那个元素还大
			// 【逻辑 1】因此 end + 1 应该落在候选区间里
			int right = end + 1;
			while (left < right) {
				int mid = left + (right - left) / 2;
				if (tail[mid] < nums[i]) {
					// 中位数肯定不是要找的数，把它写在分支的前面
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			// 因为 【逻辑 1】，因此一定能找到第 1 个大于等于 nums[i] 的元素
			// 因此，无需再单独判断，直接更新即可
			tail[left] = nums[i];

			// 但是 end 的值，需要更新，当前仅当更新位置在当前 end 的下一位
			if (left == end + 1) {
				end++;
			}
			printArray(nums[i], tail);

		}
		// 此时 end 是有序数组 tail 最后一个元素的索引
		// 题目要求返回的是长度，因此 +1 后返回
		end++;
		return end;
	}

	// 调试方法，以观察是否运行正确
	private static void printArray(int num, int[] tail) {
		System.out.print("当前数字：" + num);
		System.out.print("\t当前 tail 数组：");
		int len = tail.length;
		for (int i = 0; i < len; i++) {
			if (tail[i] == 0) {
				break;
			}
			System.out.print(tail[i] + ", ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] nums = {10, 9, 2, 5, 1, 3, 7, 101, 18};
		System.out.println(lengthOfLIS3(nums));
	}
}
