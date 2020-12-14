/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._216_CombinationSumIII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和 III
 * @author lilin
 * @date 2020-12-14 18:18
 */
public class _216_CombinationSumIII {
	/*
	找出所有相加之和为n 的k个数的组合。组合中只允许含有 1 -9 的正整数，并且每种组合中不存在重复的数字。

	说明：
	
	所有数字都是正整数。
	解集不能包含重复的组合。
	示例 1:
	
	输入: k = 3, n = 7
	输出: [[1,2,4]]
	示例 2:
	
	输入: k = 3, n = 9
	输出: [[1,2,6], [1,3,5], [2,3,4]]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/combination-sum-iii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(res, new ArrayList<>(), k, 1, n);
		return res;
	}

	public static void dfs(List<List<Integer>> res, List<Integer> path, int k, int start, int n) {
		if (path.size() == k && n == 0) {
			res.add(new ArrayList<>(path));
			return;
		}
		// 回溯可以通过提前break减少大量的无用递归
		for (int i = start; i <= 9 && n > 0 && path.size() < k; i++) {
			path.add(i);
			dfs(res, path, k, i + 1, n - i);
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		// [[1,2,6], [1,3,5], [2,3,4]]
		System.out.println(combinationSum3(3, 9).toString());
		// [[1,2,3,4,5,6,7,8,9]]
		System.out.println(combinationSum3(9, 45).toString());
	}
}
