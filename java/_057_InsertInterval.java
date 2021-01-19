/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._57_InsertInterval
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * _57_InsertInterval
 * @author lilin
 * @date 2020-8-13 10:59
 */
public class _057_InsertInterval {

	/*
	 给出一个无重叠的 ，按照区间起始端点排序的区间列表。

	 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

	 示例1：

	 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
	 输出：[[1,5],[6,9]]
	 示例2：

	 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
	 输出：[[1,2],[3,10],[12,16]]
	 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10]重叠。


	 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。

	 来源：力扣（LeetCode）
	 链接：https://leetcode-cn.com/problems/insert-interval
	 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	 */

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (newInterval == null) {
			return intervals;
		}
		List<Interval> res = new ArrayList<>();
		int i = 0;
		while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
			res.add(intervals.get(i++));
		}
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
			newInterval.end = Math.max(newInterval.end, intervals.get(i++).end);
		}
		res.add(newInterval);
		while (i < intervals.size()) {
			res.add(intervals.get(i++));
		}
		return res;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(10, 12));
		List<Interval> insert = insert(intervals, new Interval(4, 8));
		for (Interval interval : insert) {
			System.out.print(interval.start + "\t");
			System.out.print(interval.end);
			System.out.println();
		}
	}

	static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

}


