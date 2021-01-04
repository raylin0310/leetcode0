/*
 * @projectName leetcode0
 * @package swordOffer
 * @className swordOffer._51_数组中的逆序对
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */
package swordOffer;

import java.util.Arrays;

/**
 * _51_数组中的逆序对
 * @author lilin
 * @date 2020-9-8 11:42
 */
public class _51_ReversePairs {
	
	/*
	在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

	示例 1:
	
	输入: [7,5,6,4]
	输出: 5
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/bao-li-jie-fa-fen-zhi-si-xiang-shu-zhuang-shu-zu-b/
	 */

	public static int reversePairs(int[] nums) {
		int len = nums.length;

		if (len < 2) {
			return 0;
		}
		int[] copy = Arrays.copyOf(nums, len);

		int[] temp = new int[len];
		return reversePairs(copy, 0, len - 1, temp);

	}

	private static int reversePairs(int[] nums, int left, int right, int[] temp) {
		if (left == right) {
			return 0;
		}

		int mid = left + (right - left) / 2;
		int leftPairs = reversePairs(nums, left, mid, temp);
		int rightPairs = reversePairs(nums, mid + 1, right, temp);

		if (nums[mid] <= nums[mid + 1]) {
			//优化
			return leftPairs + rightPairs;
		}

		int crossPairs = mergeAndCount(nums, left, mid, right, temp);
		return leftPairs + rightPairs + crossPairs;
	}

	private static int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
		for (int i = left; i <= right; i++) {
			temp[i] = nums[i];
		}
		int i = left;
		int j = mid + 1;

		int count = 0;
		for (int k = left; k <= right; k++) {

			if (i > mid) {
				//左侧已经用尽
				nums[k] = temp[j++];
			} else if (j > right) {
				//右侧已经用尽
				nums[k] = temp[i++];
			} else if (temp[i] <= temp[j]) {
				nums[k] = temp[i++];
			} else {
				nums[k] = temp[j++];
				//i大于j，那么i后面的数都大于j
				count += (mid - i + 1);
			}
		}
		return count;
	}

	//在左侧取阅归并的时候统计数字
	private static int mergeAndCount2(int[] nums, int left, int mid, int right, int[] temp) {
		for (int i = left; i <= right; i++) {
			temp[i] = nums[i];
		}
		int i = left;
		int j = mid + 1;

		int count = 0;
		for (int k = left; k <= right; k++) {

			if (i > mid) {
				//左侧已经用尽
				nums[k] = temp[j++];
			} else if (j > right) {
				// 右侧已经用尽，说明当前temp[i]大于右侧所有的元素
				nums[k] = temp[i++];
				count += (right - mid);
			} else if (temp[i] <= temp[j]) {
				nums[k] = temp[i++];
				//i大于j前面的元素
				count += (j - mid - 1);
			} else {
				nums[k] = temp[j++];
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = {7, 5, 6, 4};
		System.out.println(reversePairs(nums));
	}


}
