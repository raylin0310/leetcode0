/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._253_MeetingRoomsII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * _253_MeetingRoomsII
 * @author lilin
 * @date 2020-8-13 14:52
 */
public class _253_MeetingRoomsII {
	/*
		题目描述
		给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，
		为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。

		示例 1:

		输入: [[0, 30],[5, 10],[15, 20]]
		输出: 2
		1
		2
		示例 2:

		输入: [[7,10],[2,4]]
		输出: 1
	 */

	public static int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			starts[i] = intervals[i].start;
			ends[i] = intervals[i].end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int res = 0;
		int end = 0;
		for (int i = 0; i < intervals.length; i++) {
			if (starts[i] < ends[end]) {
				res++;
			} else {
				end++;
			}
		}
		return res;
	}

	/*
		思路：按照会议开始时间排序，然后当前区间跟【最早结束(最小堆)】的区间Q去比较，如果当前的开始大于Q的结束，则说明没有冲突，可以用Q的会议室继续开会，
		这时候就把Q的结束时间延长到当前的结束时间(就是接着继续)
	 */

	public static int minMeetingRooms2(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, (a, b) -> a.start - b.start);
		PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, (a, b) -> a.end - b.end);
		heap.offer(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			Interval interval = heap.poll();
			if (intervals[i].start >= interval.end) {
				interval.end = intervals[i].end;
			} else {
				heap.offer(intervals[i]);
			}
			heap.offer(interval);
		}
		return heap.size();
	}

	public static void main(String[] args) {
		/*
		输入: [[0, 30],[5, 10],[15, 20]]
		输出: 2
		1
		2
		示例 2:

		输入: [[7,10],[2,4]]
		输出: 1
		 */
		Interval[] intervals = {
				new Interval(0,10),
				new Interval(5,7),
				new Interval(8,20),
		};
		System.out.println(minMeetingRooms2(intervals));
	}
}
