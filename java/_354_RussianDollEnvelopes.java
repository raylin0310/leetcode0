/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._354_RussianDollEnvelopes
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Arrays;

/**
 * 俄罗斯套娃信封问题
 * @author lilin
 * @date 2020-9-9 14:36
 */
public class _354_RussianDollEnvelopes {
	/*
	给定一些标记了宽度和高度的信封，宽度和高度以整数对形式(w, h)出现。当另一个信封的宽度和高度都比这个信封大的时候，
	这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。

	请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
	
	说明:
	不允许旋转信封。
	
	示例:
	
	输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
	输出: 3 
	解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/russian-doll-envelopes
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public int lengthOfLIS(int[] nums) {
		int[] tail = new int[nums.length];
		tail[0] = nums[0];
		int end = 0;
		for (int i = 1; i < nums.length; i++) {
			int left = 0;
			int right = end + 1;
			while (left < right) {
				int mid = left + (right - left) / 2;
				if (tail[mid] < nums[i]) {
					left = mid + 1;
				} else {
					right = mid;
				}
				tail[left] = nums[i];
				if (left == end + 1) {
					end++;
				}
			}
		}
		end++;
		return end;
	}

	public int lengthOfLIS2(int[] nums) {
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
	//https://leetcode-cn.com/problems/russian-doll-envelopes/solution/zui-chang-di-zeng-zi-xu-lie-kuo-zhan-dao-er-wei-er/
	public int maxEnvelopes(int[][] envelopes) {
		// sort on increasing in first dimension and decreasing in second
		Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
		// extract the second dimension and run LIS
		int[] secondDim = new int[envelopes.length];
		for (int i = 0; i < envelopes.length; ++i) {
			secondDim[i] = envelopes[i][1];
		}
		return _300_LongestIncreasingSubsequence.lengthOfLIS3(secondDim);
	}


	public static void main(String[] args) {

	}
}
