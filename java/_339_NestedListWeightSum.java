/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._339_NestedListWeightSum
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  嵌套列表权重和
 * @author lilin
 * @date 2021-1-5 9:50
 */
public class _339_NestedListWeightSum {
	/*
	给定一个嵌套的整数列表，
	请返回该列表按深度加权后所有整数的总和。
	每个元素要么是整数，要么是列表。
	同时，列表中元素同样也可以是整数或者是另一个列表。
	1
	2
	3
	4
	示例
	输入: [[1,1],2,[1,1]]
	输出: 10
	解释: 因为列表中有四个深度为 2 的 1 ，和一个深度为 1 的 2。 4*(2*1)+1*2=10

	输入: [1,[4,[6]]]
	输出: 27
	解释: 一个深度为 1 的 1，一个深度为 2 的 4，一个深度为 3 的 6。所以，1 + 2*4 + 3*6 = 27。
	 */

	// DFS
	public int depthSum(List<NestedInteger> nestedList) {
		if (nestedList == null) {
			return 0;
		}
		return helper(nestedList, 1);
	}

	public int helper(List<NestedInteger> nestedList, int depth) {
		int res = 0;
		for (NestedInteger nest : nestedList) {
			if (nest.isInteger()) {
				res += nest.getInteger() * depth;
			} else {
				res += helper(nest.getList(), depth + 1);
			}
		}
		return res;
	}

	// BFS
	public int depthSum2(List<NestedInteger> nestedList) {
		if (nestedList == null) {
			return 0;
		}
		int depth = 1;
		int res = 0;

		Queue<NestedInteger> queue = new LinkedList<>(nestedList);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				NestedInteger nest = queue.poll();
				if (nest.isInteger()) {
					res += nest.getInteger() * depth;
				} else {
					queue.addAll(nest.getList());
				}
			}
			depth++;
		}
		return res;
	}
}
