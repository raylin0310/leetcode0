/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._252_MeetingRooms
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * _252_MeetingRooms
 * @author lilin
 * @date 2020-8-13 14:23
 */
public class _252_MeetingRooms {

	/*
	Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

	For example,
	Given [[0, 30],[5, 10],[15, 20]],
	return false.

	思路：查区间是否有重合的题目，先按照start排个序，然后查看是否每个会议的的开始时间都比前一个结束时间大．
	 */

	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(x -> x.start));
		for (int i = 1; i < intervals.length; i++) {
			// 当前区间的start小于前一个区间的end，则重叠
			if (intervals[i].start < intervals[i - 1].end) {
				return false;
			}
		}
		return true;
	}
}
