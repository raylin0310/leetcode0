/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._254_FactorCombinations
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 因子组合
 * @author lilin
 * @date 2020-12-14 19:45
 */
public class _254_FactorCombinations {
	/*
	整数可以被看作是其因子的乘积。

	例如：
	8 = 2 x 2 x 2;
	  = 2 x 4.

	  请实现一个函数，该函数接收一个整数 n 并返回该整数所有的因子组合。
	 */

	public static List<List<Integer>> getFactors(int n) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(res, new ArrayList<>(), n, 2);
		return res;
	}

	public static void dfs(List<List<Integer>> res, List<Integer> list, int n, int start) {
		if (n == 1 && list.size() > 1) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = start; i <= n; i++) {
			if (n % i == 0) {
				list.add(i);
				dfs(res, list, n / i, i);
				list.remove(list.size() - 1);
			}
		}

	}

	public static void main(String[] args) {
		System.out.println(getFactors(8));
	}


}
