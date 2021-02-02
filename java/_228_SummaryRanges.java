/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._228_SummaryRanges
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 汇总区间
 * @author lilin
 * @date 2020-9-1 16:02
 */
public class _228_SummaryRanges {
	/*
	给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。

	示例 1:

	输入: [0,1,2,4,5,7]
	输出: ["0->2","4->5","7"]
	解释: 0,1,2 可组成一个连续的区间;4,5 可组成一个连续的区间。
	示例 2:

	输入: [0,2,3,4,6,8,9]
	输出: ["0","2->4","6","8->9"]
	解释: 2,3,4 可组成一个连续的区间;8,9 可组成一个连续的区间。

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/summary-ranges
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int num = nums[i];
			while (i < n - 1 && nums[i] + 1 == nums[i + 1]) {
				i++;
			}
			if (num != nums[i]) {
				res.add(num + "->" + nums[i]);
			} else {
				res.add(num + "");
			}
		}
		return res;
	}

	public static List<String> summaryRanges2(int[] nums) {
		List<String> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int si = i;
			int num = nums[i];
			while (i < n - 1 && (nums[i] + 1) == nums[i + 1]) {
				i++;
			}
			if (i != si) {
				res.add(num + "->" + nums[i]);
			} else {
				res.add(num + "");
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {0, 2, 3, 4, 6, 8, 9};
		AU.print(summaryRanges(nums));
	}
}
