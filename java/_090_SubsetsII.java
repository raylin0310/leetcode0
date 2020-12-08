/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._090_SubsetsII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集 II
 * @author lilin
 * @date 2020-12-8 11:17
 */
public class _090_SubsetsII {
	/*
	给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

	说明：解集不能包含重复的子集。

	示例:

	输入: [1,2,2]
	输出:
	[
	  [2],
	  [1],
	  [1,2,2],
	  [2,2],
	  [1,2],
	  []
	]

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/subsets-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static List<List<Integer>> subsetsWithDup2(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		helper(res, new ArrayList<>(), nums, 0);
		return res;
	}

	/*
	回溯，看图理解
	https://imgchr.com/i/rpirqK
	 */

	public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
		res.add(new ArrayList<>(list));
		for (int i = index; i < nums.length; i++) {
			if (i != index && nums[i] == nums[i - 1]) {
				continue;
			}
			list.add(nums[i]);
			helper(res, list, nums, i + 1);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 4};
		System.out.println(subsetsWithDup2(nums).toString());
	}
}
