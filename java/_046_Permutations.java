/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._046_Permutations
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * @author lilin
 * @date 2020-12-14 19:59
 */
public class _046_Permutations {
	/*
	给定一个 没有重复 数字的序列，返回其所有可能的全排列。

	示例:

	输入: [1,2,3]
	输出:
	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	]

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/permutations
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(res, new ArrayList<>(), nums);
		return res;
	}

	/*
	 time : O(n! * n) space : O(n);
	 */

	public static void dfs(List<List<Integer>> res, List<Integer> path, int[] nums) {
		if (path.size() == nums.length) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			// O(n)，可以用boolean[] used = new boolean[nums.length]，来判断有没有被使用过
			if (path.contains(nums[i])) {
				continue;
			}
			path.add(nums[i]);
			dfs(res, path, nums);
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		System.out.println(permute(nums));
	}
}
