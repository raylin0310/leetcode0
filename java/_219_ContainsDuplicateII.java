import java.util.HashMap;
import java.util.Map;

public class _219_ContainsDuplicateII {
/*
	Given an array of integers and an integer k,
	find out whether there are two distinct indices i and j in the array
	such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

	给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，
	使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。


	Example 1:

	Input: nums = [1,2,3,1], k = 3
	Output: true
	Example 2:

	Input: nums = [1,0,1,1], k = 1
	Output: true
	Example 3:

	Input: nums = [1,2,3,1,2,3], k = 2
	Output: false
*/

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		// map换成set一样
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k) {
				return true;
			}
			map.put(nums[i], i);
			// 减少内存占用
			if (map.size() > k) {
				map.remove(nums[i - k]);
			}
		}
		return false;
	}

	/*
	 * 线性搜索，维护一个最大宽度为k的滑动窗口，在这个窗口内搜索
	 * https://leetcode-cn.com/problems/contains-duplicate-ii/solution/cun-zai-zhong-fu-yuan-su-ii-by-leetcode/
	 */

	public boolean containsNearbyDuplicate2(int[] nums, int k) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = Math.max(i - k, 0); j < i; j++) {
				if (nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		_219_ContainsDuplicateII test = new _219_ContainsDuplicateII();
		int[] nums = {1, 2, 3, 1, 2, 3};
		int k = 2;
		System.out.println(test.containsNearbyDuplicate(nums, k));
	}
}
