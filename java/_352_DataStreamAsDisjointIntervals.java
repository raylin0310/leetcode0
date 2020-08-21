/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._352_DataStreamAsDisjointIntervals
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * _352_DataStreamAsDisjointIntervals
 * @author lilin
 * @date 2020-8-21 10:21
 */
public class _352_DataStreamAsDisjointIntervals {

	/*
		给定一个非负整数的数据流输入 a1，a2，…，an，…，将到目前为止看到的数字总结为不相交的区间列表。

		例如，假设数据流中的整数为 1，3，7，2，6，…，每次的总结为：

		[1, 1]
		[1, 1], [3, 3]
		[1, 1], [3, 3], [7, 7]
		[1, 3], [7, 7]
		[1, 3], [6, 7]


		进阶：
		如果有很多合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办?

		来源：力扣（LeetCode）
		链接：https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals
		著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	TreeMap<Integer, Interval> treeMap;

	/** Initialize your data structure here. */
	public _352_DataStreamAsDisjointIntervals() {
		treeMap = new TreeMap<>();
	}

	public void addNum(int val) {
		if (treeMap.containsKey(val)) {
			return;
		}
		// 1，3，7，2，6
		Integer lowerKey = treeMap.lowerKey(val);
		Integer higherKey = treeMap.higherKey(val);
		if (lowerKey != null && higherKey != null && val - 1 == treeMap.get(lowerKey).end &&
				val + 1 == treeMap.get(higherKey).start) {
			treeMap.get(lowerKey).end = treeMap.get(higherKey).end;
			treeMap.remove(higherKey);
		} else if (lowerKey != null && val <= treeMap.get(lowerKey).end + 1) {
			treeMap.get(lowerKey).end = Math.max(val, treeMap.get(lowerKey).end);
		} else if (higherKey != null && treeMap.get(higherKey).start - 1 == val) {
			//因为key是Interval的最小值
			treeMap.put(val, new Interval(val, treeMap.get(higherKey).end));
			treeMap.remove(higherKey);
		} else {
			treeMap.put(val, new Interval(val, val));
		}

	}

	public List<Interval> getIntervals() {
		return new ArrayList<>(treeMap.values());
	}

	public static void main(String[] args) {
		_352_DataStreamAsDisjointIntervals test = new _352_DataStreamAsDisjointIntervals();
		int[] nums = {1, 10, 20, 7, 4, 5};
		for (int num : nums) {
			test.addNum(num);
		}
		List<Interval> intervals = test.getIntervals();
		for (Interval interval : intervals) {
			System.out.print("[" + interval.start + ", " + interval.end + "], ");
		}
	}
}
