import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * S001_Two_Sum
 * @author lilin
 * @date 2020-2-18 10:52
 */
public class _001_TwoSum {
/*
	Given an array of integers, return indices of the two numbers such that they add up to a specific target.

	You may assume that each input would have exactly one solution, and you may not use the same element twice.

			Example:

	Given nums = [2, 7, 11, 15], target = 9,

	Because nums[0] + nums[1] = 2 + 7 = 9,
			return [0, 1].

	time: O(n)
	space: O(n)
*/

	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return new int[]{-1, -1};
		}
		int[] res = {-1, -1};
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				res[0] = map.get(target - nums[i]);
				res[1] = i;
				return res;
			}
			map.put(nums[i], i);
		}
		return res;
	}

	public static void main(String[] args) {
		_001_TwoSum test = new _001_TwoSum();
		int[] array = {2, 7, 11, 15};
		int target = 9;
		System.out.println(Arrays.toString(test.twoSum(array, target)));
	}
}


