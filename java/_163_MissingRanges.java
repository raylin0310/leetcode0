/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._163_MissingRanges
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 缺失区间
 * @author lilin
 * @date 2020-9-1 16:34
 */
public class _163_MissingRanges {

	/*
	Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

	For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
	 */

	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<>();
		long alower = lower, aupper = upper;
		for (int num : nums) {
			if (num == alower) {
				alower++;
			} else if (alower < num) {
				if (alower + 1 == num) {
					res.add(String.valueOf(alower));
				} else {
					res.add(alower + "->" + (num - 1));
				}
				alower = (long) num + 1;
			}else if (alower > num){
				// 还没到起点
				continue;
			}
		}
		if (alower == aupper) {
			res.add(String.valueOf(alower));
		} else if (alower < aupper) {
			res.add(alower + "->" + aupper);
		}
		return res;
	}




	public static List<String> findMissingRanges2(int[] nums, int lower, int upper) {
		List<String> ranges = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			ranges.add(range(lower, upper));
			return ranges;
		}
		if (lower < nums[0]) {
			ranges.add(range(lower, nums[0] - 1));
		}
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] + 1 < nums[i + 1]) {
				ranges.add(range(nums[i] + 1, nums[i + 1] - 1));
			}
		}
		if (nums[nums.length - 1] < upper) {
			ranges.add(range(nums[nums.length - 1] + 1, upper));
		}
		return ranges;
	}

	private static String range(int lower, int upper) {
		if (lower == upper) {
			return Integer.toString(lower);
		}
		return lower + "->" + upper;
	}


	public static void main(String[] args) {
		int[] nums = {0, 1, 6, 50, 75};
		AU.print(findMissingRanges(nums, -10, 99));
	}
}
