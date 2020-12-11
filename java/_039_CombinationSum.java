/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._039_CombinationSum
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 * @author lilin
 * @date 2020-12-9 11:46
 */
public class _039_CombinationSum {
	/*
	给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

	candidates 中的数字可以无限制重复被选取。

	说明：

	所有数字（包括 target）都是正整数。
	解集不能包含重复的组合。
	示例 1：

	输入：candidates = [2,3,6,7], target = 7,
	所求解集为：
	[
	  [7],
	  [2,2,3]
	]
	示例 2：

	输入：candidates = [2,3,5], target = 8,
	所求解集为：
	[
	  [2,2,2,2],
	  [2,3,3],
	  [3,5]
	]

	提示：

	1 <= candidates.length <= 30
	1 <= candidates[i] <= 200
	candidate 中的每个元素都是独一无二的。
	1 <= target <= 500
	 */

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(res, new ArrayList<>(), candidates, 0, target);
		return res;
	}

	public static void dfs(List<List<Integer>> res, List<Integer> path, int[] candidates, int start, int target) {
		if (target == 0) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = start; i < candidates.length && target > 0; i++) {
			path.add(candidates[i]);
			dfs(res, path, candidates, i, target - candidates[i]);
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] nums = {2, 3, 5};
		int target = 8;
		System.out.println(combinationSum(nums, target).toString());
	}
}
