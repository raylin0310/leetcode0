
/**
 * _080_RemoveDuplicatesfromSortedArrayII
 * @author lilin
 * @date 2020-3-5 14:28
 */
public class _080_RemoveDuplicatesfromSortedArrayII {
/*
	Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

	Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

	Example 1:

	Given nums = [1,1,1,2,2,3],

	Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

	It doesn't matter what you leave beyond the returned length.
	Example 2:

	Given nums = [0,0,1,1,1,1,2,3,3],

	Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

	It doesn't matter what values are set beyond the returned length.
*/

	// {1,1,1,2,2,3};
	// {1,1,2,2,2,3};

	public int removeDuplicates(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}
		// j表示下一步将要放置的index，也就是新数组的长度
		int j = 2;
		for (int i = 2; i < nums.length; i++) {
			if (nums[j - 2] != nums[i]) {
				nums[j++] = nums[i];
			}
		}
		return j;
	}

	public int removeDuplicates2(int[] nums) {
		int i = 0;
		for (int n : nums) {
			if (i < 2 || n > nums[i - 2]) {
				nums[i++] = n;
			}
		}
		return i;
	}

	public static void main(String[] args) {
		//int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3, 3, 3, 4};
		int[] nums = {1, 1, 1, 2, 2, 3};
		int n = new _080_RemoveDuplicatesfromSortedArrayII().removeDuplicates2(nums);
		System.out.println("n: " + n);
		for (int i = 0; i < n; i++) {
			System.out.print(nums[i] + "\t");
		}
	}
}
