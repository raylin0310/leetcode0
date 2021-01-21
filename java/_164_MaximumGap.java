/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._164_MaximumGap
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Arrays;

/**
 * _164_MaximumGap
 * @author lilin
 * @date 2020-5-13 20:21
 */
public class _164_MaximumGap {
/*
	给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。

	如果数组元素个数小于 2，则返回 0。

	示例1:

	输入: [3,6,9,1]
	输出: 3
	解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
	示例2:

	输入: [10]
	输出: 0
	解释: 数组元素个数小于 2，因此返回 0。
	说明:

	你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
	请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。

	*/

	/*
		普通解法，先排序，再遍历找出相邻最大差值，time：O(n)，简单不容易出错

	 * 我们可以很巧妙地设置每个桶的大小：假设所有元素的最大值为max,最小值为min，元素个数是n，
	 * 则最大间距将不小于Math.ceil((max-min)/(n-1))。
	 * 因此，我们设置桶的容量是Math.ceil((max-min)/(n-1))，则桶内的元素的间距肯定不是最大间距，
	 * 我们只需要查看桶间的间距（前一个桶的最大值和后一个桶的最小值的差）的最大值即可。
	 *
	 * 假设 {1, 4, 3, 6};
	 */

	/*
	 time : O(n)
     space : O(n)
	 */

	public static int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}

		int len = nums.length;
		int max = nums[0];
		int min = nums[0];
		for (int j : nums) {
			max = Math.max(max, j);
			min = Math.min(min, j);
		}

		// 每个桶最大的间距 2。因为最大间距将不小于Math.ceil((max-min)/(n-1))。
		// 所以后面在计算最大差值的时候，桶内元素的最大差值肯定不满足条件
		int gap = (int) Math.ceil((double) (max - min) / (len - 1));
		// 桶的个数len-1，即有多少个间距，下面数组的意思是：我们不用保存每个桶的数据，只保存每个桶的最大值和最小值即可，
		// 比如bucketsMin[1]=10，bucketsMin[1]=20，即代表第一个桶最小值为10，最大值为20
		int[] bucketsMin = new int[len - 1];
		int[] bucketsMax = new int[len - 1];
		Arrays.fill(bucketsMax, Integer.MIN_VALUE);
		Arrays.fill(bucketsMin, Integer.MAX_VALUE);
		for (int num : nums) {
			if (num == min || num == max) {
				continue;
			}
			int bucket = (num - min) / gap;
			// 这里只保留每个桶的最大值和最小值
			bucketsMin[bucket] = Math.min(num, bucketsMin[bucket]);
			bucketsMax[bucket] = Math.max(num, bucketsMax[bucket]);
		}

		int res = 0;
		int pre = min;
		for (int i = 0; i < len - 1; i++) {
			if (bucketsMin[i] == Integer.MAX_VALUE && bucketsMax[i] == Integer.MIN_VALUE) {
				continue;
			}
			res = Math.max(res, bucketsMin[i] - pre);
			pre = bucketsMax[i];
		}
		res = Math.max(res, max - pre);
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {1, 4, 3, 6, 8, 12, 20};
		System.out.println(maximumGap(nums));
	}

}
