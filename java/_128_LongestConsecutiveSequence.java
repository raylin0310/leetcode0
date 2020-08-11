/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._128_LongestConsecutiveSequence
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.HashMap;
import java.util.HashSet;

/**
 * _128_LongestConsecutiveSequence
 * @author lilin
 * @date 2020-5-11 18:03
 */
public class _128_LongestConsecutiveSequence {
/*
	给定一个未排序的整数数组，找出最长连续序列的长度。

	要求算法的时间复杂度为O(n)。

	示例:

	输入: [100, 4, 200, 1, 3, 2]
	输出: 4
	解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。

	*/

	public static int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		HashSet<Integer> set = new HashSet<>();
		int res = 0;
		for (int num : nums) {
			set.add(num);
		}
		for (int num : nums) {
			int down = num - 1;
			while (set.contains(down)) {
				set.remove(down);
				down--;
			}
			int up = num + 1;
			while (set.contains(up)) {
				set.remove(up);
				up++;
			}
			res = Math.max(res, up - down - 1);
		}
		return res;
	}

	/**
	 * @link https://leetcode.com/problems/longest-consecutive-sequence/discuss/41055/My-really-simple-Java-O(n)-solution-Accepted
	 */

	public static int longestConsecutive2(int[] num) {
		int res = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int n : num) {
			if (!map.containsKey(n)) {
				int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
				int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
				// sum: length of the sequence n is in
				int sum = left + right + 1;
				map.put(n, sum);

				// keep track of the max length
				res = Math.max(res, sum);

				// extend the length to the boundary(s)
				// of the sequence
				// will do nothing if n has no neighbors
				map.put(n - left, sum);
				map.put(n + right, sum);
			}
			else {
				// duplicates
				continue;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		//int[] nums = {100, 4, 200, 1, 3, 2};
		//int[] nums = {1, 2, 3, 4, 3, 2,1};
		int[] nums = {1, 3, 2, 4};
		System.out.println(longestConsecutive2(nums));
	}

}
