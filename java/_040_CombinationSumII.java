/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._040_CombinationSumII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和 II
 * @author lilin
 * @date 2020-12-11 11:29
 */
public class _040_CombinationSumII {
	/*
	给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。

	candidates中的每个数字在每个组合中只能使用一次。
	
	说明：
	
	所有数字（包括目标数）都是正整数。
	解集不能包含重复的组合。
	示例1:
	
	输入: candidates =[10,1,2,7,6,1,5], target =8,
	所求解集为:
	[
	  [1, 7],
	  [1, 2, 5],
	  [2, 6],
	  [1, 1, 6]
	]
	示例2:
	
	输入: candidates =[2,5,2,1,2], target =5,
	所求解集为:
	[
	 [1,2,2],
	 [5]
	]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/combination-sum-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(candidates);
		dfs(res, new ArrayList<>(), candidates, 0, target);
		return res;
	}

	public static void dfs(List<List<Integer>> res, List<Integer> path, int[] candidates, int start, int target) {
		if (target == 0) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = start; i < candidates.length && target > 0; i++) {
			if (i != start && candidates[i] == candidates[i - 1]) {
				continue;
			}
			path.add(candidates[i]);
			dfs(res, path, candidates, i + 1, target - candidates[i]);
			path.remove(path.size() - 1);

		}
	}

	public static void main(String[] args) {
		int[] nums = {2, 5, 2, 1, 2};
		int target = 5;
		// [[1,2,2],[5]]
		System.out.println(combinationSum2(nums, target).toString());
	}
}
