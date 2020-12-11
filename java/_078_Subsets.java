/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._078_Subsets
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * @author lilin
 * @date 2020-12-8 10:16
 */
public class _078_Subsets {
	/*
	给定一组不含重复元素的整数数组nums，返回该数组所有可能的子集（幂集）。
	
	说明：解集不能包含重复的子集。
	
	示例:
	
	输入: nums = [1,2,3]
	输出:
	[
	  [3],
	 [1],
	 [2],
	 [1,2,3],
	 [1,3],
	 [2,3],
	 [1,2],
	 []
	]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/subsets
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	思路：回溯
		 */

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		dfs(res, new ArrayList<>(), nums, 0);
		return res;
	}

	/*
	这个图解比较清晰：https://leetcode-cn.com/problems/subsets/solution/c-zong-jie-liao-hui-su-wen-ti-lei-xing-dai-ni-gao-/
	接这个图：https://imgchr.com/i/rS0bV0
	 */

	private static void dfs(List<List<Integer>> list, List<Integer> path, int[] nums, int start) {
		list.add(new ArrayList<>(path));
		// 这里的意思，是以num[i]为首元素去递归后面的元素，
		for (int i = start; i < nums.length; i++) {
			path.add(nums[i]);
			dfs(list, path, nums, i + 1);
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		// [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
		System.out.println(subsets(nums).toString());
	}


}
