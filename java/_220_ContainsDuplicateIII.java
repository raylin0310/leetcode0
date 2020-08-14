import java.util.TreeSet;

public class _220_ContainsDuplicateIII {
/*
	Given an array of integers,
	find out whether there are two distinct indices i and j in the array
	such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference
	between i and j is at most k.

	给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
	使得nums [i] 和nums [j]的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。

	Example 1:
	Input: nums = [1,2,3,1], k = 3, t = 0
	Output: true

	Example 2:
	Input: nums = [1,0,1,1], k = 1, t = 2
	Output: true

	Example 3:
	Input: nums = [1,5,9,1,5,9], k = 2, t = 3
	Output: false
*/

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = Math.max(i - k, 0); j < i; j++) {
				if (Math.abs((long) nums[i] - (long) nums[j]) <= t) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 *    t = 5
	 *    curNum = 20,searchNum [15,25]
	 *
	 *    -----15-----20-----25------
	 *
	 */

	public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
		TreeSet<Long> set = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			Long floor = set.floor((long) nums[i] + t);
			if (floor != null && floor >= nums[i]) {
				return true;
			}
			Long ceiling = set.ceiling((long) nums[i] - t);
			if (ceiling != null && ceiling <= nums[i]) {
				return true;
			}
			set.add((long) nums[i]);
			if (set.size() > k) {
				set.remove((long) nums[i - k]);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		_220_ContainsDuplicateIII test = new _220_ContainsDuplicateIII();
		int[] nums = {1, 0, 1, 1};
		int k = 1;
		int t = 2;

		int[] nums2 = {-1, 2147483647};
		int k2 = 1;
		int t2 = 2147483647;
		System.out.println(test.containsNearbyAlmostDuplicate2(nums, k, t));
		System.out.println(test.containsNearbyAlmostDuplicate2(nums2, k2, t2));

	}
}
