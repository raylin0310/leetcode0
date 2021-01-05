/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._364_NestedListWeightSumII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * _364_NestedListWeightSumII
 * @author lilin
 * @date 2021-1-5 9:59
 */
public class _364_NestedListWeightSumII {
	/*
	这道题是之前那道 Nested List Weight Sum 的拓展，与其不同的是，这里的深度越深，权重越小

	Input: [1,[4,[6]]]
	Output: 17
	Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17.

	叶子节点的权重为1
	 */

	public int depthSumInverse(List<NestedInteger> nestedList) {
		if (nestedList == null) {
			return 0;
		}
		return dfs(nestedList, 0);
	}

	private int dfs(List<NestedInteger> nestedList, int res) {
		List<NestedInteger> nextList = new LinkedList<>();
		for (NestedInteger nest : nestedList) {
			if (nest.isInteger()) {
				res += nest.getInteger();
			} else {
				nextList.addAll(nest.getList());
			}
		}
		// 相当于第一层的数字合传到下一层去，相当于1+1+1，也就是例子的中的1*3，思路太巧妙了
		res += nextList.isEmpty() ? 0 : dfs(nestedList, res);
		return res;
	}

	//bfs
	public int depthSumInverse2(List<NestedInteger> nestedList) {
		if (nestedList == null) {
			return 0;
		}
		int sum = 0;
		int res = 0;
		while (!nestedList.isEmpty()) {
			List<NestedInteger> nextList = new LinkedList<>();
			for (NestedInteger nest : nestedList) {
				if (nest.isInteger()) {
					sum += nest.getInteger();
				} else {
					nextList.addAll(nest.getList());
				}
			}
			res += sum;
			nestedList = nextList;
		}
		return res;
	}

}
