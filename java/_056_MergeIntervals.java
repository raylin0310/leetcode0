/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._56_MergeIntervals
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * _56_MergeIntervals
 * @author lilin
 * @date 2020-8-13 13:44
 */
public class _056_MergeIntervals {

	/*
	 给出一个区间的集合，请合并所有重叠的区间。

	 示例 1:

	 输入: [[1,3],[2,6],[8,10],[15,18]]
	 输出: [[1,6],[8,10],[15,18]]
	 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
	 示例2:

	 输入: [[1,4],[4,5]]
	 输出: [[1,5]]
	 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

	 来源：力扣（LeetCode）
	 链接：https://leetcode-cn.com/problems/merge-intervals
	 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	 */

	public static List<Interval> merge(List<Interval> list) {
		list.sort(Comparator.comparingInt(a -> a.start));
		//上一个区间的start和end
		int start = list.get(0).start;
		int end = list.get(0).end;
		List<Interval> res = new ArrayList<>();
		for (Interval interval : list) {
			if (interval.start <= end) {
				end = Math.max(end, interval.end);
			} else {
				// 把上一次的放进res，当前的区级赋值给start、end
				res.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		//最后一次
		res.add(new Interval(start, end));
		return res;
	}


	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		//   输入: [[1,3],[2,6],[8,10],[15,18]]
		//	 输出: [[1,6],[8,10],[15,18]]
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(4, 6));
		intervals.add(new Interval(5, 10));
		intervals.add(new Interval(15, 18));
		List<Interval> insert = merge(intervals);
		for (Interval interval : insert) {
			System.out.print(interval.start + "\t");
			System.out.print(interval.end);
			System.out.println();
		}
	}


}
