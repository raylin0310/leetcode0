import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _169_MajorityElement {
/*
	Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

	You may assume that the array is non-empty and the majority element always exist in the array.

	给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于⌊ n/2 ⌋的元素。

	你可以假设数组是非空的，并且给定的数组总是存在多数元素。


	Example 1:

	Input: [3,2,3]
	Output: 3
	Example 2:

	Input: [2,2,1,1,1,2,2]
	Output: 2
*/

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int mid = nums.length / 2;
		for (int num : nums) {
			Integer count = map.get(num);
			if (count == null) {
				count = 0;
			}
			count++;
			if (count > mid) {
				return num;
			} else {
				map.put(num, count);
			}
		}
		return -1;
	}

	public int majorityElement2(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	/**
	 * 投票法
	 * 如果num等于候选数，票数加一
	 * 如果count为零，说明票数刚好抵消完，重新赋值候选数
	 * 如果num不等于候选数，票数减一
	 *
	 */
	public int majorityElement3(int[] nums) {
		int count = 0;
		int candidate = 0;
		for (int num : nums) {
			if (num == candidate) {
				count++;
			} else if (count == 0) {
				candidate = num;
				count = 1;
			} else {
				count--;
			}
		}
		return candidate;
	}

	/**
	 * simple
	 */

	public int majorityElement4(int[] nums) {
		int count = 0;
		int candidate = 0;
		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			count += (num == candidate) ? 1 : -1;
		}
		return candidate;
	}

	public static void main(String[] args) {
		_169_MajorityElement test = new _169_MajorityElement();
		int[] nums = {1, 2, 1, 1, 1, 2, 2};
		int[] nums2 = {1, 2, 1};
		System.out.println(test.majorityElement3(nums));
	}
}
