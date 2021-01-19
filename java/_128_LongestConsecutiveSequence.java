/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._128_LongestConsecutiveSequence
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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

	/*
	遍历，对每个数进行左右分散判断
	 */

	public static int longestConsecutive(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		int res = 0;
		for (int num : nums) {
			set.add(num);
		}
		// num =4
		for (int num : nums) {
			int down = num - 1;
			while (set.contains(down)) {
				/*
				为什么要移除？set包含1,2,3,4,5时，在num=3进行左右分散时，其实已经被num=5的分散给包含了
				 */
				set.remove(down);
				down--;
			}
			int up = num + 1;
			while (set.contains(up)) {
				set.remove(up);
				up++;
			}
			// 如果up和down表示数字，则长度为u-d+1，但是这里up和down都多算了一位，所以应该是u-d+1-2=u-d-1
			res = Math.max(res, up - down - 1);
		}
		return res;
	}
	/*
	  官解，思路同上，但是更优
	  time: O(n)
	  space: O(n)
	 */

	public int longestConsecutive3(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		int res = 0;
		for (int num : set) {
			// 比上面方法优秀的地方，只从最左侧元素进行遍历，这样子就避免了分散遍历必须要进行删除的性能消耗（不删除的话，下一次遇到了就会重复进行判断，实则没必要），
			// 而且最外层循环直接用set，如果nums包含大量重复元素，那么性能将会很好
			if (!set.contains(num - 1)) {
				int currentNum = num;
				int currentStreak = 1;
				while (set.contains(currentNum + 1)) {
					currentNum++;
					currentStreak++;
				}
				res = Math.max(res, currentStreak);
			}
		}
		return res;
	}

	/*
	 * @link https://leetcode.com/problems/longest-consecutive-sequence/discuss/41055/My-really-simple-Java-O(n)-solution-Accepted
	 * 思路很好，但是leetcode提交，用时比上面方法多
	 */

	public static int longestConsecutive2(int[] nums) {
		int res = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
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
				// 为什么要更新边界？考虑1,3,2,0，当n=0时
				map.put(n - left, sum);
				map.put(n + right, sum);
			} else {
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
