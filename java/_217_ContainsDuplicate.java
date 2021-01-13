import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _217_ContainsDuplicate {
/*
	Given an array of integers, find if the array contains any duplicates.

	Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

	给定一个整数数组，判断是否存在重复元素。

	如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

	Example 1:

	Input: [1,2,3,1]
	Output: true
	Example 2:

	Input: [1,2,3,4]
	Output: false
	Example 3:

	Input: [1,1,1,3,3,4,3,2,4,2]
	Output: true
	*/

	public static boolean containsDuplicate(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				return true;
			}
			map.put(num, 1);
		}
		return false;
	}

	public static boolean containsDuplicate2(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
		System.out.println(containsDuplicate2(nums));
	}
}
